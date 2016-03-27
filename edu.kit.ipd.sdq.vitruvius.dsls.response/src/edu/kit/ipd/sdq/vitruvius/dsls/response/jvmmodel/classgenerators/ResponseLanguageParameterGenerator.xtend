package edu.kit.ipd.sdq.vitruvius.dsls.response.jvmmodel.classgenerators

import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.emf.ecore.EObject
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.CorrespondingModelElementSpecification
import java.util.ArrayList
import org.eclipse.xtext.common.types.JvmTypeReference
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.UserInteracting
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.TransformationResult
import edu.kit.ipd.sdq.vitruvius.dsls.mirbase.mirBase.NamedJavaElement
import edu.kit.ipd.sdq.vitruvius.dsls.mirbase.mirBase.ModelElement
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.EChange
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Trigger
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteModelElementChange
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.helper.EChangeHelper.*;
import java.util.List
import edu.kit.ipd.sdq.vitruvius.dsls.response.api.runtime.ResponseExecutionState

class ResponseLanguageParameterGenerator {
	package static val CHANGE_PARAMETER_NAME = "change";
	package static val BLACKBOARD_PARAMETER_NAME = "blackboard";
	package static val TRANSFORMATION_RESULT_PARAMETER_NAME = "transformationResult";
	package static val USER_INTERACTING_PARAMETER_NAME = "userInteracting";
	package static val RESPONSE_EXECUTION_STATE_PARAMETER_NAME = "responseExecutionState";
	
	protected extension static JvmTypeReferenceBuilder _typeReferenceBuilder;
	protected extension edu.kit.ipd.sdq.vitruvius.dsls.response.jvmmodel.JvmTypesBuilderWithoutAssociations _typesBuilder;	
	
	new (JvmTypeReferenceBuilder typeReferenceBuilder, edu.kit.ipd.sdq.vitruvius.dsls.response.jvmmodel.JvmTypesBuilderWithoutAssociations typesBuilder) {
		_typeReferenceBuilder = typeReferenceBuilder;
		_typesBuilder = typesBuilder;
	}
	
	protected def JvmFormalParameter generateModelElementParameter(EObject parameterContext, CorrespondingModelElementSpecification elementSpecification) {
		if (elementSpecification?.elementType?.element != null) {
			return parameterContext.generateParameter(elementSpecification.name, elementSpecification.elementType.element.instanceClass);
		}	
		return null;
	}
	
	protected def JvmFormalParameter generateResponseExecutionStateParameter(EObject parameterContext) {
		return generateParameter(parameterContext, RESPONSE_EXECUTION_STATE_PARAMETER_NAME, ResponseExecutionState);
	}
	
	protected def JvmFormalParameter generateBlackboardParameter(EObject parameterContext) {
		return generateParameter(parameterContext, BLACKBOARD_PARAMETER_NAME, Blackboard);
	}
	
	protected def JvmFormalParameter generateTransformationResultParameter(EObject parameterContext) {
		return generateParameter(parameterContext, TRANSFORMATION_RESULT_PARAMETER_NAME, TransformationResult);
	}
	
	protected def JvmFormalParameter generateUserInteractingParameter(EObject parameterContext) {
		return generateParameter(parameterContext, USER_INTERACTING_PARAMETER_NAME, UserInteracting);
	}
	
	protected def generateParameter(EObject context, String parameterName, JvmTypeReference parameterType) {
		if (parameterType == null) {
			return null;
		}
		return context.toParameter(parameterName, parameterType);
	}
	
	protected def generateParameter(EObject context, String parameterName, Class<?> parameterClass, String... typeParameterClassNames) {
		if (parameterClass == null) {
			return null;
		}
		val typeParameters = new ArrayList<JvmTypeReference>(typeParameterClassNames.size);
		for (typeParameterClassName : typeParameterClassNames.filter[!nullOrEmpty]) {
			typeParameters.add(typeRef(typeParameterClassName));
		}		
		val changeType = typeRef(parameterClass, typeParameters);
		return context.toParameter(parameterName, changeType);
	}
	
	protected def Iterable<JvmFormalParameter> generateMethodInputParameters(EObject contextObject, Iterable<ModelElement> modelElements, Iterable<NamedJavaElement> javaElements) {
		return modelElements.map[generateParameter(contextObject, it.name, it.element.instanceClass)] + javaElements.map[toParameter(contextObject, it.name, it.type)];
	}
	
	protected def JvmFormalParameter generateUntypedChangeParameter(EObject parameterContext) {
		return parameterContext.generateParameter(CHANGE_PARAMETER_NAME, EChange);
	}
	
	protected def JvmFormalParameter generateChangeParameter(EObject parameterContext, Trigger trigger) {
		var List<String> changeTypeParameters = <String>newArrayList;
		if (trigger instanceof ConcreteModelElementChange) {
			changeTypeParameters = #[getGenericTypeParameterFQNOfChange(trigger)]			
		}
		val changeParameter = parameterContext.generateParameter(CHANGE_PARAMETER_NAME, trigger.generateEChangeInstanceClass(), changeTypeParameters);
		if (changeParameter != null) {
			return changeParameter;
		}
	}
}
							