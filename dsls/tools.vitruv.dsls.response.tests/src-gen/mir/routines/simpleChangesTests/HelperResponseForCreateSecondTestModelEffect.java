package mir.routines.simpleChangesTests;

import allElementTypes.Root;
import allElementTypes.impl.AllElementTypesFactoryImpl;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.root.InsertRootEObject;

import java.io.IOException;
import mir.routines.simpleChangesTests.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class HelperResponseForCreateSecondTestModelEffect extends AbstractEffectRealization {
  public HelperResponseForCreateSecondTestModelEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final InsertRootEObject<Root> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private InsertRootEObject<Root> change;
  
  private EObject getElement0(final InsertRootEObject<Root> change, final Root newRoot) {
    return newRoot;
  }
  
  private EObject getElement1(final InsertRootEObject<Root> change, final Root newRoot) {
    Root _newValue = change.getNewValue();
    return _newValue;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine HelperResponseForCreateSecondTestModelEffect with input:");
    getLogger().debug("   InsertRootEObject: " + this.change);
    
    Root newRoot = AllElementTypesFactoryImpl.eINSTANCE.createRoot();
    initializeCreateElementState(newRoot);
    
    addCorrespondenceBetween(getElement0(change, newRoot), getElement1(change, newRoot), "");
    preprocessElementStates();
    new mir.routines.simpleChangesTests.HelperResponseForCreateSecondTestModelEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, newRoot);
    postprocessElementStates();
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.simpleChangesTests.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final InsertRootEObject<Root> change, final Root newRoot) {
      Root _newValue = change.getNewValue();
      String _id = _newValue.getId();
      newRoot.setId(_id);
      Root _newValue_1 = change.getNewValue();
      this.persistProjectRelative(_newValue_1, newRoot, "model/EachTestModelTarget");
    }
  }
}