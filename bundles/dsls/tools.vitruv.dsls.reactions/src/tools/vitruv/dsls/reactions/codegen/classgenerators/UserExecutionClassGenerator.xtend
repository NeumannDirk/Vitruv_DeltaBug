package tools.vitruv.dsls.reactions.codegen.classgenerators

import tools.vitruv.dsls.reactions.codegen.classgenerators.ClassGenerator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmVisibility
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving
import org.eclipse.xtext.common.types.JvmOperation
import tools.vitruv.dsls.reactions.language.toplevelelements.CodeBlock
import tools.vitruv.dsls.reactions.language.Taggable
import tools.vitruv.dsls.reactions.language.ExistingElementReference
import org.eclipse.xtext.common.types.JvmTypeReference
import tools.vitruv.dsls.reactions.language.toplevelelements.RoutineCallBlock
import tools.vitruv.dsls.reactions.language.MatcherCheckStatement
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization
import tools.vitruv.dsls.reactions.language.RetrieveModelElement
import tools.vitruv.dsls.reactions.codegen.helper.AccessibleElement
import tools.vitruv.dsls.reactions.codegen.typesbuilder.TypesBuilderExtensionProvider
import org.eclipse.xtext.common.types.JvmGenericType
import tools.vitruv.dsls.reactions.language.ExecuteActionStatement
import static tools.vitruv.dsls.reactions.codegen.ReactionsLanguageConstants.*
import tools.vitruv.dsls.reactions.language.RetrieveOrRequireAbscenceOfModelElement

class UserExecutionClassGenerator extends ClassGenerator {
	val EObject objectMappedToClass;
	val String qualifiedClassName;
	var counterGetTagMethods = 1
	var counterGetElementMethods = 1
	var counterGetRetrieveTagMethods = 1
	var counterCallRoutineMethods = 1
	var counterExecuteActionMethods = 1
	var counterCheckMatcherPreconditionMethods = 1
	var counterGetCorrespondenceSource = 1
	var JvmGenericType generatedClass
	
	new(TypesBuilderExtensionProvider typesBuilderExtensionProvider, EObject objectMappedToClass,
		String qualifiedClassName) {
		super(typesBuilderExtensionProvider)
		this.objectMappedToClass = objectMappedToClass;
		this.qualifiedClassName = qualifiedClassName;
	}

	def String getQualifiedClassName() {
		return qualifiedClassName;
	}

	override generateEmptyClass() {
		this.generatedClass = objectMappedToClass.toClass(qualifiedClassName) [
			visibility = JvmVisibility.PRIVATE
			static = true
		]
		return generatedClass;
	}

	override generateBody() {
		generatedClass => [
			superTypes += typeRef(AbstractRepairRoutineRealization.UserExecution)
			members += generateConstructor()
			members += generatedMethods
		]
	}

	def private generateConstructor() {
		objectMappedToClass.toConstructor() [
			val reactionExecutionStateParameter = generateReactionExecutionStateParameter()
			val calledByParameter = generateParameter("calledBy", typeRef(CallHierarchyHaving))
			parameters += reactionExecutionStateParameter
			parameters += calledByParameter
			body = '''
				super(??parameters.get(0).name??);
			'''
		]
	}

	protected def JvmOperation generateUpdateElementMethod(String elementName, CodeBlock codeBlock,
		Iterable<AccessibleElement> accessibleElements) {
		val code = codeBlock.code;
		return codeBlock.getOrGenerateMethod("update" + elementName?.toFirstUpper + "Element", typeRef(Void.TYPE)) [
			parameters += generateAccessibleElementsParameters(accessibleElements);
			body = code;
		]
	}

	protected def JvmOperation generateMethodGetRetrieveTag(Taggable taggable,
		Iterable<AccessibleElement> accessibleElements) {
		val methodName = "getRetrieveTag" + counterGetRetrieveTagMethods++;

		return taggable.tag?.getOrGenerateMethod(methodName, typeRef(String)) [
			parameters += generateAccessibleElementsParameters(accessibleElements);
			body = taggable.tag.code;
		];
	}

	protected def JvmOperation generateMethodGetCreateTag(Taggable taggable,
		Iterable<AccessibleElement> accessibleElements) {
		val methodName = "getTag" + counterGetTagMethods++;

		return taggable.tag?.getOrGenerateMethod(methodName, typeRef(String)) [
			parameters += generateAccessibleElementsParameters(accessibleElements);
			body = taggable.tag.code;
		];
	}

	protected def generateMethodCorrespondencePrecondition(RetrieveOrRequireAbscenceOfModelElement elementRetrieve, String name,
		Iterable<AccessibleElement> accessibleElements) {
		val methodName = "getCorrespondingModelElementsPrecondition" + (elementRetrieve.retrieveOrRequireAbscenceMethodSuffix?: counterGetCorrespondenceSource++);
		return elementRetrieve.precondition?.getOrGenerateMethod(methodName, typeRef(Boolean.TYPE)) [
			val elementParameter = generateModelElementParameter(elementRetrieve.elementType, name?: RETRIEVAL_PRECONDITION_METHOD_TARGET);
			parameters += generateAccessibleElementsParameters(accessibleElements);
			parameters += elementParameter;
			body = elementRetrieve.precondition.code;
		];
	}

	protected def generateMethodGetCorrespondenceSource(RetrieveOrRequireAbscenceOfModelElement elementRetrieve,
		Iterable<AccessibleElement> accessibleElements) {
		val methodName = "getCorrepondenceSource" + (elementRetrieve.retrieveOrRequireAbscenceMethodSuffix?: counterGetCorrespondenceSource++);

		val correspondenceSourceBlock = elementRetrieve.correspondenceSource;
		return correspondenceSourceBlock?.getOrGenerateMethod(methodName, typeRef(EObject)) [
			parameters += generateAccessibleElementsParameters(accessibleElements);
			body = correspondenceSourceBlock.code;
		];
	}

	protected def generateMethodGetElement(ExistingElementReference reference,
		Iterable<AccessibleElement> accessibleElements, JvmTypeReference expectedType) {
		val methodName = "getElement" + counterGetElementMethods++;

		return reference?.getOrGenerateMethod(methodName, expectedType) [
			parameters += generateAccessibleElementsParameters(accessibleElements);
			val correspondenceSourceBlock = reference?.code;
			body = correspondenceSourceBlock;
		];
	}

	protected def JvmOperation generateMethodMatcherPrecondition(MatcherCheckStatement checkStatement,
		Iterable<AccessibleElement> accessibleElements) {
		val methodName = "checkMatcherPrecondition" + counterCheckMatcherPreconditionMethods++;
		return checkStatement.getOrGenerateMethod(methodName, typeRef(Boolean.TYPE)) [
			parameters += generateAccessibleElementsParameters(accessibleElements);
			body = checkStatement.code;
		];
	}

	protected def JvmOperation generateMethodExecuteAction(ExecuteActionStatement executeAction,
		Iterable<AccessibleElement> accessibleElements, JvmTypeReference facadeClassTypeReference) {
		val methodName = "executeAction" + counterExecuteActionMethods++;
		return generateExecutionMethod(executeAction, methodName, accessibleElements, facadeClassTypeReference)
	}

	protected def JvmOperation generateMethodCallRoutine(RoutineCallBlock routineCall,
		Iterable<AccessibleElement> accessibleElements, JvmTypeReference facadeClassTypeReference) {
		val methodName = "callRoutine" + counterCallRoutineMethods++;
		return generateExecutionMethod(routineCall, methodName, accessibleElements, facadeClassTypeReference)
	}

	private def JvmOperation generateExecutionMethod(CodeBlock codeBlock, String methodName,
		Iterable<AccessibleElement> accessibleElements, JvmTypeReference facadeClassTypeReference) {
		if (codeBlock === null) {
			return null;
		}
		return codeBlock?.getOrGenerateMethod(methodName, typeRef(Void.TYPE)) [
			parameters += generateAccessibleElementsParameters(accessibleElements);
			val facadeParam = toParameter(REACTION_USER_EXECUTION_ROUTINE_CALL_FACADE_PARAMETER_NAME,
				facadeClassTypeReference);
			facadeParam.annotations += annotationRef(Extension);
			parameters += facadeParam
			body = codeBlock.code;
		]
	}
	
	protected def dispatch getRetrieveOrRequireAbscenceMethodSuffix(RetrieveOrRequireAbscenceOfModelElement statement) {
		null
	}
	
	protected def dispatch getRetrieveOrRequireAbscenceMethodSuffix(RetrieveModelElement statement) {
		if (statement.name.nullOrEmpty) {
			return null
		} else {
			return statement.name.toFirstUpper
		}
	}
}
