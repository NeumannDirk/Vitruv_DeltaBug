package mir.responses.responses5_1ToJava.pcm2java;

import edu.kit.ipd.sdq.vitruvius.extensions.dslsruntime.response.AbstractResponseRealization;
import edu.kit.ipd.sdq.vitruvius.framework.change.echange.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.reference.InsertEReference;
import edu.kit.ipd.sdq.vitruvius.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;

@SuppressWarnings("all")
class AddedAssemblyContextToComposedStructureResponse extends AbstractResponseRealization {
  public AddedAssemblyContextToComposedStructureResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return InsertEReference.class;
  }
  
  private boolean checkChangeProperties(final InsertEReference<ComposedStructure, AssemblyContext> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof ComposedStructure)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("assemblyContexts__ComposedStructure")) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof InsertEReference<?, ?>)) {
    	return false;
    }
    InsertEReference typedChange = (InsertEReference)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    InsertEReference<ComposedStructure, AssemblyContext> typedChange = (InsertEReference<ComposedStructure, AssemblyContext>)change;
    mir.routines.pcm2java.AddedAssemblyContextToComposedStructureEffect effect = new mir.routines.pcm2java.AddedAssemblyContextToComposedStructureEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}