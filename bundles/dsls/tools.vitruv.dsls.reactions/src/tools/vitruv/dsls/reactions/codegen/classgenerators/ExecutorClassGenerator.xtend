package tools.vitruv.dsls.reactions.codegen.classgenerators

import org.eclipse.xtext.common.types.JvmGenericType
import tools.vitruv.dsls.reactions.codegen.classgenerators.ClassGenerator
import org.eclipse.xtext.common.types.JvmVisibility
import tools.vitruv.dsls.reactions.language.toplevelelements.ReactionsSegment
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionsExecutor
import tools.vitruv.extensions.dslsruntime.reactions.RoutinesFacadesProvider
import tools.vitruv.extensions.dslsruntime.reactions.structure.ReactionsImportPath
import static extension tools.vitruv.dsls.reactions.codegen.helper.ClassNamesGenerators.*
import tools.vitruv.dsls.reactions.codegen.typesbuilder.TypesBuilderExtensionProvider
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsLanguageHelper.*;
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsImportsHelper.*;
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsElementsCompletionChecker.isReferenceable
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsElementsCompletionChecker.isComplete

class ExecutorClassGenerator extends ClassGenerator {
	final ReactionsSegment reactionsSegment;
	var JvmGenericType generatedClass;
	
	new(ReactionsSegment reactionsSegment, TypesBuilderExtensionProvider typesBuilderExtensionProvider) {
		super(typesBuilderExtensionProvider)
		if (!reactionsSegment.isReferenceable) {
			throw new IllegalArgumentException("incomplete");
		}
		this.reactionsSegment = reactionsSegment;
	}
	
	override generateEmptyClass() {
		generatedClass = reactionsSegment.toClass(reactionsSegment.executorClassNameGenerator.qualifiedName) [
			visibility = JvmVisibility.DEFAULT;
		];
	}

	override generateBody() {
		generatedClass => [
			superTypes += typeRef(AbstractReactionsExecutor);
			members += reactionsSegment.toConstructor() [
				body = '''
				super(new ┬źreactionsSegment.fromDomain.domainProviderForReference.canonicalNameForReference┬╗().getDomain(), 
					new ┬źreactionsSegment.toDomain.domainProviderForReference.canonicalNameForReference┬╗().getDomain());'''
			]

			// create routines facades provider:
			members += reactionsSegment.toMethod("createRoutinesFacadesProvider", typeRef(RoutinesFacadesProvider)) [
				visibility = JvmVisibility.PROTECTED;
				body = '''
					return new ┬źreactionsSegment.routinesFacadesProviderClassNameGenerator.qualifiedName┬╗();
				'''
			]

			// register all reactions, including imported and overridden reactions:
			members += reactionsSegment.toMethod("setup", typeRef(Void.TYPE)) [
				visibility = JvmVisibility.PROTECTED;
				body = '''
					┬źFOR reactionEntry : reactionsSegment.includedReactions.entrySet.filter[key.isReferenceable]┬╗
						┬źval reaction = reactionEntry.key┬╗
						┬źval reactionsImportPath = reactionEntry.value┬╗
						┬źval reactionsNameGenerator = reaction.reactionClassNameGenerator┬╗
						this.addReaction(new ┬źreactionsNameGenerator.qualifiedName┬╗(this.getRoutinesFacadesProvider().getRoutinesFacade(┬ź
							┬╗┬źReactionsImportPath┬╗.fromPathString("┬źreactionsImportPath.pathString┬╗"))));
					┬źENDFOR┬╗
				'''
			]
		]
	}
}