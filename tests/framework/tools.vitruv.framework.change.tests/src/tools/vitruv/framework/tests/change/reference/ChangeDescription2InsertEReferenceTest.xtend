package tools.vitruv.framework.tests.change.reference

import allElementTypes.Root
import java.util.ArrayList
import java.util.List
import org.junit.jupiter.api.Test
import tools.vitruv.framework.change.echange.EChange
import tools.vitruv.framework.tests.change.ChangeDescription2ChangeTransformationTest

import static allElementTypes.AllElementTypesPackage.Literals.*
import static tools.vitruv.testutils.metamodels.AllElementTypesCreators.*

import static extension tools.vitruv.framework.tests.change.util.AtomicEChangeAssertHelper.*
import static extension tools.vitruv.framework.tests.change.util.CompoundEChangeAssertHelper.*

class ChangeDescription2InsertEReferenceTest extends ChangeDescription2ChangeTransformationTest {

	@Test
	def void testInsertEReferenceNonContainment() {
		testInsertInEReference(0)
	}

	@Test
	def void testMultipleInsertEReferenceNonContainment() {
		testInsertInEReference(0)
		testInsertInEReference(1)
		testInsertInEReference(2)
		testInsertInEReference(1)
	}

	def ArrayList<EChange> myremove(List<EChange> org, int index) {
		val ArrayList<EChange> ret = new ArrayList<EChange>();
		org.forEach[x, i| if(i !== index){ret.add(x)}]
		return ret;		
	}

	@Test
	def void minusEins_3OhneLoeschen() {
		val Root upr = getUniquePersistedRoot()
		val nonRoot1 = aet.NonRoot()
		nonRoot1.id = 1.toString()
		val nonRoot2 = aet.NonRoot()
		nonRoot2.id = 2.toString()
		val nonRoot3 = aet.NonRoot()
		nonRoot3.id = 3.toString()
		upr => [
			multiValuedContainmentEReference.add(0, nonRoot1)
			multiValuedContainmentEReference.add(0, nonRoot2)
			multiValuedContainmentEReference.add(0, nonRoot3)
		]		
		val List<EChange> result = upr.record [
			multiValuedNonContainmentEReference.add(0, nonRoot1)
			multiValuedNonContainmentEReference.add(1, nonRoot2)
			multiValuedNonContainmentEReference.add(2, nonRoot3)
		]		
		result			
			.assertChangeCount(3)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot1, -1, false, false)
			.assertChangeCount(2)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot2, -1, false, false)
			.assertChangeCount(1)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot3, -1, false, false)
			.assertChangeCount(0)			
	}
	
	@Test
	def void minusEins_2Loesche2() {
		val Root upr = getUniquePersistedRoot()
		val nonRoot1 = aet.NonRoot()
		val nonRoot2 = aet.NonRoot()	
		upr => [
			multiValuedContainmentEReference.add(0, nonRoot1)
			multiValuedContainmentEReference.add(1, nonRoot2)
		]		
		val List<EChange> result = upr.record [
			multiValuedNonContainmentEReference.add(0, nonRoot1)
			multiValuedNonContainmentEReference.add(1, nonRoot2)
		]		
			
		val newResult = myremove(result, 1)

		println("dirkTest_remove_A")
		println("result.size() = " + result.size())
		println("newResult.size() = " + newResult.size())
		
		newResult
			.assertChangeCount(1)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot1, -1, false, false)
			.assertChangeCount(0)		
		val EChange e = newResult.get(0);		
	}
	
	@Test
	def void minusEins_2Loesche1() {
		val Root upr = getUniquePersistedRoot()
		val nonRoot1 = aet.NonRoot()
		val nonRoot2 = aet.NonRoot()	
		upr => [
			multiValuedContainmentEReference.add(0, nonRoot1)
			multiValuedContainmentEReference.add(1, nonRoot2)
		]		
		val List<EChange> result = upr.record [
			multiValuedNonContainmentEReference.add(0, nonRoot1)
			multiValuedNonContainmentEReference.add(1, nonRoot2)
		]		
			
		val newResult = myremove(result, 0)

		println("dirkTest_remove_A")
		println("result.size() = " + result.size())
		println("newResult.size() = " + newResult.size())
		
		newResult
			.assertChangeCount(1)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot2, -1, false, false)
			.assertChangeCount(0)		
		val EChange e = newResult.get(0);		
	}
	
	
	@Test
	def void minusEins_3MittlersAmAnfang() {
		val Root upr = getUniquePersistedRoot()
		val nonRoot1 = aet.NonRoot()
		val nonRoot2 = aet.NonRoot()
		val nonRoot3 = aet.NonRoot()		
		upr => [
			multiValuedContainmentEReference.add(0, nonRoot1)
			multiValuedContainmentEReference.add(1, nonRoot2)
			multiValuedContainmentEReference.add(2, nonRoot3)
		]		
		val List<EChange> result = upr.record [
			multiValuedNonContainmentEReference.add(0, nonRoot1)
			multiValuedNonContainmentEReference.add(0, nonRoot2)
			multiValuedNonContainmentEReference.add(2, nonRoot3)
		]		
		result			
			.assertChangeCount(3)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot1, -1, false, false)
			.assertChangeCount(2)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot2, 0, false, false)
			.assertChangeCount(1)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot3, -1, false, false)
			.assertChangeCount(0)			
	}

	@Test
	def void testInsertEReferenceContainment() {
		testInsertInContainmentEReference(0)
	}

	@Test
	def void testMultipleInsertEReferenceContainment() {
		testInsertInContainmentEReference(0)
		testInsertInContainmentEReference(1)
		testInsertInContainmentEReference(2)
		testInsertInContainmentEReference(1)
	}	

	def private testInsertInContainmentEReference(int expectedIndex) {
		// prepare
		uniquePersistedRoot
		
		// test
		val nonRoot = aet.NonRoot
		val result = uniquePersistedRoot.record [
			multiValuedContainmentEReference.add(expectedIndex, nonRoot)
		]

		// assert
		result.assertChangeCount(3)
			.assertCreateAndInsertNonRoot(uniquePersistedRoot, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, nonRoot, expectedIndex, false)
			.assertReplaceSingleValuedEAttribute(nonRoot, IDENTIFIED__ID, null, nonRoot.id, false, false)
			.assertEmpty
	}

	def private testInsertInEReference(int expectedIndex) {
		// prepare
		val nonRoot = aet.NonRoot
		uniquePersistedRoot => [
			multiValuedContainmentEReference.add(expectedIndex, nonRoot)
		]

		// test			
		val result = uniquePersistedRoot.record [
			multiValuedNonContainmentEReference.add(expectedIndex, nonRoot)			
		]

		// assert
		result.assertChangeCount(1)
			.assertInsertEReference(uniquePersistedRoot, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot, expectedIndex, false, false)
			.assertEmpty
	}

}
