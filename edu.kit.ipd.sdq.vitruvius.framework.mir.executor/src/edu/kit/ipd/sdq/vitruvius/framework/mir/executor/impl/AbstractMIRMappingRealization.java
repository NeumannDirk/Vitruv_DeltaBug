package edu.kit.ipd.sdq.vitruvius.framework.mir.executor.impl;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.api.MappedCorrespondenceInstance;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.helpers.EclipseHelper;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.helpers.MIRMappingHelper;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.interfaces.MIRMappingRealization;
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.EMFCommandBridge;

/**
 * {@link AbstractMIRMappingRealization} is extended by the code generated from
 * the intermediate language.
 * <p>
 * A mapping is instantiated for two model instances.
 * 
 * @author Dominik Werle
 *
 */
public abstract class AbstractMIRMappingRealization implements MIRMappingRealization {
	private final static Logger LOGGER = Logger.getLogger(AbstractMIRMappingRealization.class);

	/**
	 * Returns the {@link EClass} mapped by this mapping.
	 * 
	 * @return the {@link EClass} mapped by this mapping
	 */
	protected abstract EClass getMappedEClass();

	/**
	 * Check if the conditions of the mapping hold for the given {@link EObject}
	 * .
	 * 
	 * @param eObject
	 *            the object to check
	 * @return true if the mapping holds for the given object.
	 */
	protected abstract boolean checkConditions(EObject eObject, Blackboard blackboard);

	/**
	 * Ensure that the postconditions ("where") still hold for the mapping.
	 * <p>
	 * The given {@link EChange} can be used to select the conditions that have
	 * to be checked.
	 * 
	 * @param eObject
	 *            the {@link EObject} that has been changed
	 * @param target
	 *            the {@link EObject} that <code>eObject</code> is corresponding
	 *            to
	 * @param eChange
	 *            the change that was applied
	 * @return
	 */
	protected abstract List<Command> restorePostConditions(EObject eObject, EObject target, EChange change);

	/**
	 * Creates a corresponding object for <code>eObject</code> and a
	 * correspondence in the mapped meta model and registers it
	 */
	protected abstract List<Command> createCorresponding(EObject eObject, Blackboard blackboard);

	/**
	 * Deletes the corresponding object (and its children) and the
	 * correspondence.
	 * 
	 * @param eObject
	 * @param correspondenceInstance
	 */
	protected List<Command> deleteCorresponding(EObject eObject, EObject target, Blackboard blackboard) {
		// TODO: implement
		
		List<Command> result = new ArrayList<Command>();

		result.add(EMFCommandBridge.createCommand(() -> {
			EcoreUtil.delete(target);
		}));
		
		throw new UnsupportedOperationException("Not implemented");

		//return result;
	}

	/**
	 * Returns {@link EObject EObjects} that are possibly affected by this
	 * change.
	 * 
	 * @param eChange
	 * @return
	 */
	protected Collection<EObject> getCandidates(EChange eChange) {
		final EClass mappedEClass = getMappedEClass();
		Collection<EObject> affectedObjects = MIRMappingHelper.getAllAffectedObjects(eChange);
		return toList(filter(affectedObjects, p -> p.eClass().equals(mappedEClass)));
	}

	private MappedCorrespondenceInstance getMappedCorrespondenceInstanceFromBlackboard(Blackboard blackboard) {
		// TODO: implement
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<Command> applyEChange(EChange eChange, Blackboard blackboard) {
		MappedCorrespondenceInstance correspondenceInstance = getMappedCorrespondenceInstanceFromBlackboard(blackboard);

		/*
		 * TODO: change to create candidates (EObject, PotentialTransition(new,
		 * still, remove), Mapping) in AbstractMIRChange2CommandTransforming.
		 */
		Collection<EObject> candidates = getCandidates(eChange);
		List<Command> result = new ArrayList<Command>();

		for (EObject candidate : candidates) {
			LOGGER.trace("Checking candidate " + candidate.toString());

			boolean mappedBefore = correspondenceInstance.checkIfMappedBy(candidate, this);
			boolean mappedAfter = checkConditions(candidate, blackboard);

			EObject mappingTarget = null;
			final Collection<EObject> affectedEObjects = new HashSet<EObject>();

			if (mappedBefore) {
				mappingTarget = Objects.requireNonNull(correspondenceInstance.getMappingTarget(candidate, this));

				if (!mappedAfter) {
					result.addAll(deleteCorresponding(candidate, mappingTarget, blackboard));
				}
			}

			if (!mappedBefore && mappedAfter) {
				List<Command> createCorrespondingCommands = createCorresponding(candidate, blackboard);
				affectedEObjects.addAll(
						createCorrespondingCommands.stream()
							.flatMap(it -> (Stream<EObject>)
								(it.getAffectedObjects().stream()
								   .filter(object -> object instanceof EObject)))
							.collect(Collectors.toList()));
				result.addAll(createCorrespondingCommands);
				mappingTarget = Objects.requireNonNull(correspondenceInstance.getMappingTarget(candidate, this));
			}

			if (mappedAfter) {
				result.addAll(restorePostConditions(candidate, mappingTarget, eChange));
			}

			result.addAll(handleNonContainedEObjects(affectedEObjects));
		}

		return result;
	}

	/**
	 * Asks the user and creates new resources for EObjects in <code>affectedEObjects</code>
	 * that do not have a container.
	 */
	private List<Command> handleNonContainedEObjects(Collection<EObject> affectedEObjects) {
		if (affectedEObjects.isEmpty()) 
			return Collections.emptyList();
		
		final List<Command> result = new ArrayList<Command>();
		
		for (final EObject eObject : affectedEObjects) {
			if (eObject.eContainer() == null) {
				Runnable saveRunnable = () -> EclipseHelper.askAndSaveResource(eObject);
				result.add(EMFCommandBridge.createCommand(saveRunnable));
			}
		}
		
		return result;
	}
}
