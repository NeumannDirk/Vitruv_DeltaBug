package edu.kit.ipd.sdq.vitruvius.dsls.mapping.tests.generated.testinfrastructure

import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.Change2CommandTransforming
import java.util.List
import mir.responses.responsesPcm_mockupToUml_mockup.testPCM2UMLChild.ExecutorPcm_mockupToUml_mockup
import mir.responses.responsesUml_mockupToPcm_mockup.testPCM2UMLChild.ExecutorUml_mockupToPcm_mockup
import edu.kit.ipd.sdq.vitruvius.framework.change2commandtransformingprovider.AbstractChange2CommandTransformingProviding
import mir.responses.AbstractChange2CommandTransformingPcm_mockupToUml_mockup
import mir.responses.AbstractChange2CommandTransformingUml_mockupToPcm_mockup

class TestPCM2UMLChildChange2CommandTransformingProviding extends AbstractChange2CommandTransformingProviding {
	new() {
		val List<Change2CommandTransforming> change2CommandTransformings = #[
			new AbstractChange2CommandTransformingPcm_mockupToUml_mockup() {
				override protected setup() {
					this.addResponseExecutor(
						new ExecutorPcm_mockupToUml_mockup(userInteracting))
				}
			},
			new AbstractChange2CommandTransformingUml_mockupToPcm_mockup() {
				override protected setup() {
					this.addResponseExecutor(
						new ExecutorUml_mockupToPcm_mockup(userInteracting))
				}				
			}
		]
		change2CommandTransformings.forEach[addChange2CommandTransforming];
	}
}
