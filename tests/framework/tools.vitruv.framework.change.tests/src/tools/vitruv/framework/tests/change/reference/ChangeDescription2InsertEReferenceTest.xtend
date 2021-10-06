package tools.vitruv.framework.tests.change.reference

import static allElementTypes.AllElementTypesPackage.Literals.*

import static extension tools.vitruv.framework.tests.change.util.AtomicEChangeAssertHelper.*
import static extension tools.vitruv.framework.tests.change.util.CompoundEChangeAssertHelper.*
import org.junit.jupiter.api.Test
import static extension tools.vitruv.testutils.metamodels.AllElementTypesCreators.*
import tools.vitruv.framework.tests.change.ChangeDescription2ChangeTransformationTest
import allElementTypes.Root
import java.util.List
import tools.vitruv.framework.change.echange.EChange


import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.MatcherAssert.assertThat
//import static org.junit.jupiter.api.Assertions.assertEquals
import static tools.vitruv.testutils.matchers.ModelMatchers.*
import org.eclipse.emf.common.util.BasicEList
import java.util.ArrayList
import static org.junit.Assert.assertEquals

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
	def void dirkTest0() {
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
			multiValuedNonContainmentEReference.add(1, nonRoot2)
			multiValuedNonContainmentEReference.add(2, nonRoot3)
		]		
//		assertThat(result, instanceOf(List))
//		result.forEach[x| assertThat(x, instanceOf(EChange))]
//		println(result.class.toString())
//		val int ff = result.size()				
//		val newResult = myremove(result, 2)
//		assertThat(newResult, instanceOf(List))
//		newResult.forEach[x| assertThat(x, instanceOf(EChange))]
//		val int ff2 = newResult.size()
//		assertEquals(2, newResult.size())		
		result
			.assertChangeCount(3)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot1, 0, false, false)
			.assertChangeCount(2)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot2, 1, false, false)
			.assertChangeCount(1)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot3, 2, false, false)
			.assertChangeCount(0)			
	}
	
	@Test
	def void dirkTest_remove_A() {
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
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot1, 0, false, false)
			.assertChangeCount(0)	
	}
	
	@Test
	def void dirkTest_remove_B() {
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

		println("dirkTest_remove_B")
		println("result.size() = " + result.size())
		println("newResult.size() = " + newResult.size())
		
		newResult
			.assertChangeCount(1)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot2, 1, false, false)
			.assertChangeCount(0)	
	}
	
	@Test
	def void dirkTest_remove_B_different_Index() {
		// Dieser Test schlägt fehl.
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

		println("dirkTest_remove_B")
		println("result.size() = " + result.size())
		println("newResult.size() = " + newResult.size())
		
		newResult
			.assertChangeCount(1)
			.assertInsertEReference(upr, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot2, 0, false, false)
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
