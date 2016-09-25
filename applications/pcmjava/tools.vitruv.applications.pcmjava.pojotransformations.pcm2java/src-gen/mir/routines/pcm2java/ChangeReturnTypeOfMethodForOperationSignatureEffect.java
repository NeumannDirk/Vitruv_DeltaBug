package mir.routines.pcm2java;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.members.InterfaceMethod;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationSignature;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class ChangeReturnTypeOfMethodForOperationSignatureEffect extends AbstractEffectRealization {
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
    }
    
    public EObject getCorrepondenceSourceInterfaceMethod(final OperationSignature operationSignature) {
      return operationSignature;
    }
  }
  
  private ChangeReturnTypeOfMethodForOperationSignatureEffect.EffectUserExecution userExecution;
  
  public ChangeReturnTypeOfMethodForOperationSignatureEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final OperationSignature operationSignature) {
    super(responseExecutionState, calledBy);
    				this.userExecution = new mir.routines.pcm2java.ChangeReturnTypeOfMethodForOperationSignatureEffect.EffectUserExecution(getExecutionState(), this);
    				this.operationSignature = operationSignature;
  }
  
  private OperationSignature operationSignature;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine ChangeReturnTypeOfMethodForOperationSignatureEffect with input:");
    getLogger().debug("   OperationSignature: " + this.operationSignature);
    
    InterfaceMethod interfaceMethod = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceInterfaceMethod(operationSignature), // correspondence source supplier
    	InterfaceMethod.class,
    	(InterfaceMethod _element) -> true, // correspondence precondition checker
    	null);
    if (interfaceMethod == null) {
    	return;
    }
    initializeRetrieveElementState(interfaceMethod);
    preprocessElementStates();
    new mir.routines.pcm2java.ChangeReturnTypeOfMethodForOperationSignatureEffect.CallRoutinesUserExecution(getExecutionState(), this).executeUserOperations(
    	operationSignature, interfaceMethod);
    postprocessElementStates();
  }
  
  private static class CallRoutinesUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public CallRoutinesUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    public void executeUserOperations(final OperationSignature operationSignature, final InterfaceMethod interfaceMethod) {
      DataType _returnType__OperationSignature = operationSignature.getReturnType__OperationSignature();
      this.effectFacade.changeInterfaceMethodReturnType(interfaceMethod, _returnType__OperationSignature);
    }
  }
}
