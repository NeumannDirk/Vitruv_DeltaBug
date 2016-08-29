package edu.kit.ipd.sdq.vitruvius.framework.changes.changeprocessor

import edu.kit.ipd.sdq.vitruvius.framework.changes.changedescription.ConcreteChange
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceModel

interface ChangeProcessor {
	def ChangeProcessorResult transformChange(ConcreteChange change, CorrespondenceModel correspondenceModel);
}