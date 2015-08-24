package edu.kit.ipd.sdq.vitruvius.framework.run.changesynchronizer;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceInstance;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.EMFChangeResult;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.ModelInstance;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.ModelProviding;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.SynchronisationListener;
import edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.datatypes.TUID;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Pair;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Triple;

/**
 * The VitruviusResourceManipulatingJob is an eclipse job. Its task is to save the changed models. A
 * own job is used since it is not always possible to save or manipulate elements using the same
 * thread that calls {@link ChangeSynchronizerImpl} ::synchronizeChange (e.g. when the manipulation is
 * caused during a build).
 *
 */
class VitruviusResourceManipulatingJob extends Job {

    private static final Logger logger = Logger.getLogger(VitruviusResourceManipulatingJob.class.getSimpleName());

    private ConcurrentLinkedQueue<EMFChangeResult> emfChangeResultQueue;
    private ModelProviding modelProviding;
    private final Set<SynchronisationListener> synchronisationListeners;

    public VitruviusResourceManipulatingJob(final ModelProviding modelProviding,
            final Set<SynchronisationListener> synchronisationListeners) {
        super(VitruviusResourceManipulatingJob.class.getSimpleName());

        this.modelProviding = modelProviding;
        this.emfChangeResultQueue = new ConcurrentLinkedQueue<EMFChangeResult>();
        this.synchronisationListeners = synchronisationListeners;
    }

    @Override
    protected IStatus run(final IProgressMonitor monitor) {
        setPriority(SHORT);
        while (!this.emfChangeResultQueue.isEmpty()) {
            EMFChangeResult emfChangeResult = this.emfChangeResultQueue.poll();
            boolean exceptionOccured = true;
            try {
                // TODO: Check wheather we need a deleteModelInstanceOriginal in VSUM.
                // Here we usually do not need it because we usually delete JaMoPP resource that are
                // renamed. Hence we do not need to remove the correspondence models etc.However the
                // question is what happens if we delete, e.g. a PCM instance.
                for (VURI vuriToDelete : emfChangeResult.getExistingObjectsToDelete()) {
                    ModelInstance mi = this.modelProviding.getAndLoadModelInstanceOriginal(vuriToDelete);
                    Resource resource = mi.getResource();
                    try {
                        resource.delete(null);
                    } catch (IOException e) {
                        throw new RuntimeException("Could not delete VURI: " + vuriToDelete + ". Exception: " + e);
                    }
                }

                for (VURI changedVURI : emfChangeResult.getExistingObjectsToSave()) {
                    // same same
                    this.modelProviding.saveModelInstanceOriginal(changedVURI);
                }

                for (Pair<EObject, VURI> createdEObjectVURIPair : emfChangeResult.getNewRootObjectsToSave()) {
                    ModelInstance mi = this.modelProviding
                            .getAndLoadModelInstanceOriginal(createdEObjectVURIPair.getSecond());
                    Resource resource = mi.getResource();
                    // clear the resource first
                    resource.getContents().clear();
                    resource.getContents().add(createdEObjectVURIPair.getFirst());
                    // get old tuid
                    this.modelProviding.saveModelInstanceOriginal(mi.getURI());
                    // get root
                    // calculate new TUID for root
                    // update TUID for root
                }

                // update correspondenceInstances
                removeOldCorrespondences(emfChangeResult.getCorrespondencesToDelete());
                addNewCorrespondences(emfChangeResult.getNewCorrespondences());
                updateExistingCorrespondence(emfChangeResult.getCorrespondencesToUpdate());
                exceptionOccured = false;
            } finally {
                if (emfChangeResult.isLastChangeResultInList() || exceptionOccured) {
                    logger.info("emfChangeResult.isLastChangeResultInList() = true");
                    for (SynchronisationListener syncListener : this.synchronisationListeners) {
                        syncListener.syncFinished();
                    }
                }
            }
        }

        return Status.OK_STATUS;
    }

    private void removeOldCorrespondences(final Set<Pair<CorrespondenceInstance, TUID>> correspondencesToDelete) {
        for (final Pair<CorrespondenceInstance, TUID> pair : correspondencesToDelete) {
            CorrespondenceInstance correspondenceInstance = pair.getFirst();
            correspondenceInstance.removeDirectAndChildrenCorrespondencesOnBothSides(pair.getSecond());
        }
    }

    private void addNewCorrespondences(final Set<Triple<CorrespondenceInstance, EObject, EObject>> newCorrespondences) {
        for (final Triple<CorrespondenceInstance, EObject, EObject> triple : newCorrespondences) {
            CorrespondenceInstance correspondenceInstance = triple.getFirst();
            correspondenceInstance.createAndAddEObjectCorrespondence(triple.getSecond(), triple.getThird());
        }
    }

    private void updateExistingCorrespondence(
            final Set<Triple<CorrespondenceInstance, TUID, EObject>> correspondencesToUpdate) {
        for (final Triple<CorrespondenceInstance, TUID, EObject> quadruple : correspondencesToUpdate) {
            CorrespondenceInstance correspondenceInstance = quadruple.getFirst();
            correspondenceInstance.update(quadruple.getSecond(), quadruple.getThird());
        }
    }

    public void addEMFChangeResult(final EMFChangeResult emfChangeResult) {
        this.emfChangeResultQueue.add(emfChangeResult);
    }

    public void runSynchron() {
        run(new NullProgressMonitor());
    }

}