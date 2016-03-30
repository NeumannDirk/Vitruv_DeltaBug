package edu.kit.ipd.sdq.vitruvius.dsls.mapping.tests.generated.testinfrastructure

import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.Change2CommandTransforming
import java.util.List
import edu.kit.ipd.sdq.vitruvius.framework.change2commandtransformingprovider.AbstractChange2CommandTransformingProviding
import mir.responses.responsesAllElementTypesToAllElementTypes2.defaultMapping.ExecutorAllElementTypesToAllElementTypes2
import mir.responses.responsesAllElementTypes2ToAllElementTypes.defaultMapping.ExecutorAllElementTypes2ToAllElementTypes
import mir.responses.AbstractChange2CommandTransformingAllElementTypes2ToAllElementTypes
import mir.responses.AbstractChange2CommandTransformingAllElementTypesToAllElementTypes2

class TestDefaultMappingChange2CommandTransformingProviding extends AbstractChange2CommandTransformingProviding {
	new() {
		val List<Change2CommandTransforming> change2CommandTransformings = #[
			new AbstractChange2CommandTransformingAllElementTypes2ToAllElementTypes() {
				override protected setup() {
					this.addResponseExecutor(
						new ExecutorAllElementTypes2ToAllElementTypes(userInteracting));
				}
			},
			new AbstractChange2CommandTransformingAllElementTypesToAllElementTypes2() {
				override protected setup() {
					this.addResponseExecutor(
						new ExecutorAllElementTypesToAllElementTypes2(userInteracting));
				}				
			}
		]
		change2CommandTransformings.forEach[addChange2CommandTransforming];
	}
}
