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
import org.eclipse.emf.ecore.EObject
import allElementTypes.NonRoot
import org.junit.jupiter.api.BeforeEach

class ChangeDescription2InsertEReferenceTest extends ChangeDescription2ChangeTransformationTest {
	
	private static Root UPR;
	private static final NonRoot NR1 = aet.NonRoot();
	private static final NonRoot NR2 = aet.NonRoot();
	private static final NonRoot NR3 = aet.NonRoot();
	private static final NonRoot NR4 = aet.NonRoot();
	private static final NonRoot NR5 = aet.NonRoot(); 
	
	@Test
	def void testInsert_Containment_Single() {
		testInsertInContainmentEReference(0,-1)
		testInsertInContainmentEReference(1,-1)
		testInsertInContainmentEReference(0, 0)
		testInsertInContainmentEReference(1, 1)
		testInsertInContainmentEReference(4,-1)
	}
	
	@Test
	def void testInsert_NonContainment_Single() {
		testInsertInEReference(0,-1)
		testInsertInEReference(1,-1)
		testInsertInEReference(0, 0)
		testInsertInEReference(1, 1)
		testInsertInEReference(4,-1)
	}
	
	@BeforeEach
	def void prepareComplexTest(){
		UPR = getUniquePersistedRoot()
		NR1.id = 1.toString()
		NR2.id = 2.toString()
		NR3.id = 3.toString()
		NR4.id = 4.toString()
		NR5.id = 5.toString()	
	}
	
	def void assertFiveNonRoots_NonContainment(List<EChange> result, int i1, int i2, int i3, int i4, int i5)	{
		result
			.assertChangeCount(5)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR1, i1, false, false)
			.assertChangeCount(4)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR2, i2, false, false)
			.assertChangeCount(3)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR3, i3, false, false)
			.assertChangeCount(2)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR4, i4, false, false)
			.assertChangeCount(1)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR5, i5, false, false)
			.assertChangeCount(0)
	}	
	def void assertFiveNonRoots_Containment(List<EChange> result, int i1, int i2, int i3, int i4, int i5)	{
		result
			.assertChangeCount(15)
			.assertCreateAndInsertNonRoot(UPR, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, NR1, i1, false)
			.assertReplaceSingleValuedEAttribute(NR1, IDENTIFIED__ID, null, NR1.id, false, false)
			.assertChangeCount(12)
			.assertCreateAndInsertNonRoot(UPR, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, NR2, i2, false)
			.assertReplaceSingleValuedEAttribute(NR2, IDENTIFIED__ID, null, NR2.id, false, false)
			.assertChangeCount(9)
			.assertCreateAndInsertNonRoot(UPR, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, NR3, i3, false)
			.assertReplaceSingleValuedEAttribute(NR3, IDENTIFIED__ID, null, NR3.id, false, false)
			.assertChangeCount(6)
			.assertCreateAndInsertNonRoot(UPR, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, NR4, i4, false)
			.assertReplaceSingleValuedEAttribute(NR4, IDENTIFIED__ID, null, NR4.id, false, false)
			.assertChangeCount(3)
			.assertCreateAndInsertNonRoot(UPR, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, NR5, i5, false)
			.assertReplaceSingleValuedEAttribute(NR5, IDENTIFIED__ID, null, NR5.id, false, false)
			.assertChangeCount(0)
	}	
	
	def void nonContainmentHelper_addAllAsContainment(){
		UPR => [
			multiValuedContainmentEReference.add(0, NR1)
			multiValuedContainmentEReference.add(0, NR2)
			multiValuedContainmentEReference.add(0, NR3)
			multiValuedContainmentEReference.add(0, NR4)
			multiValuedContainmentEReference.add(0, NR5)
		]		
	}

	@Test
	def void testInsert_NonContainment_MultipleAtOnce_0() {
		nonContainmentHelper_addAllAsContainment()
		val ArrayList<NonRoot> li = new ArrayList<NonRoot>();
		li.addAll(NR1, NR2, NR3, NR4, NR5)		
		val List<EChange> result = UPR.record [
			multiValuedNonContainmentEReference.addAll(0, li)
		]
		assertFiveNonRoots_NonContainment(result, -1, -1, -1, -1, -1)					
	}
	@Test
	def void testInsert_NonContainment_MultipleAtOnce_1() {
		nonContainmentHelper_addAllAsContainment()
		val ArrayList<NonRoot> li = new ArrayList<NonRoot>();
		li.addAll(NR2, NR3, NR4)	
		val List<EChange> result = UPR.record [
			multiValuedNonContainmentEReference.add(0, NR1)
			multiValuedNonContainmentEReference.addAll(1, li)
			multiValuedNonContainmentEReference.add(4, NR5)
		]		
		assertFiveNonRoots_NonContainment(result, -1, -1, -1, -1, -1)			
	}	
	@Test
	def void testInsert_NonContainment_MultipleAtOnce_2() {
		nonContainmentHelper_addAllAsContainment()
		val ArrayList<NonRoot> li = new ArrayList<NonRoot>();
		li.addAll(NR1, NR2, NR3)	
		val ArrayList<NonRoot> li2 = new ArrayList<NonRoot>();
		li2.addAll(NR4, NR5)	
		val List<EChange> result = UPR.record [
			multiValuedNonContainmentEReference.addAll(0, li)
			multiValuedNonContainmentEReference.addAll(1, li2)
		]		
		assertFiveNonRoots_NonContainment(result, -1, -1, -1, 1, 2)	
	}
		
	@Test
	def void testInsert_Containment_MultipleAtOnce_0() {
		val ArrayList<NonRoot> li = new ArrayList<NonRoot>();
		li.addAll(NR1, NR2, NR3, NR4, NR5)	
		val List<EChange> result = UPR.record [
			multiValuedContainmentEReference.addAll(0, li)
		]	
		assertFiveNonRoots_Containment(result, -1, -1, -1, -1, -1)					
	}
	@Test
	def void testInsert_Containment_MultipleAtOnce_1() {
		val ArrayList<NonRoot> li = new ArrayList<NonRoot>();
		li.addAll(NR2, NR3, NR4)	
		val List<EChange> result = UPR.record [
			multiValuedContainmentEReference.add(0, NR1)
			multiValuedContainmentEReference.addAll(1, li)
			multiValuedContainmentEReference.add(4, NR5)
		]		
		assertFiveNonRoots_Containment(result, -1, -1, -1, -1, -1)			
	}
	@Test
	def void testInsert_Containment_MultipleAtOnce_2() {
		val ArrayList<NonRoot> li = new ArrayList<NonRoot>();
		li.addAll(NR1, NR2, NR3)	
		val ArrayList<NonRoot> li2 = new ArrayList<NonRoot>();
		li2.addAll(NR4, NR5)	
		val List<EChange> result = UPR.record [
			multiValuedContainmentEReference.addAll(0, li)
			multiValuedContainmentEReference.addAll(1, li2)
		]		
		assertFiveNonRoots_Containment(result, -1, -1, -1, 1, 2)	
	}
	/* d1 = removeAt(4)
	 * d2 = removeAt(4)
	 * (A,B,C,D,E) -> d1 + d2 -> (A,B,C)
	 * (A,B,C,D,E) ->    d1   -> (A,B,C,E)
	 * (A,B,C,D,E) ->    d2   -> (A,B,C,E)
	 * 
	 * d1 = removeAt(4) -> remove(-2)
	 * d2 = removeAt(4) -> remove(-1)
	 * (A,B,C,D,E) -> d1 + d2 -> (A,B,C)
	 * (A,B,C,D,E) ->    d1   -> (A,B,C,E)
	 * (A,B,C,D,E) ->    d2   -> (A,B,C,D)
	 * 
	 * 
	 * d1 = insert(4)
	 * d2 = removeAt(5)
	 * (A,B,C,D,E) -> d1 + d2 -> (A,B,C)
	 * (A,B,C,D,E) ->    d1   -> (A,B,C,E)
	 * (A,B,C,D,E) ->    d2   -> (A,B,C,E)
	 * 
	 * d1 = insert(4,D)
	 * d2 = removeAt(5) -> remove(-1)
	 * (A,B,C,E) -> d1 + d2 -> (A,B,C,D)
	 * (A,B,C,E) ->    d1   -> (A,B,C,D,E)
	 * (A,B,C,E) ->    d2   -> error 
	 * 
	 * d1 = insert(4,D)
	 * d2 = removeAt(5) -> remove(-1)
	 * (A,B,C,E) -> d1 + d2 -> (A,B,C,D)
	 * (A,B,C,E) ->    d1   -> (A,B,C,D,E)
	 * (A,B,C,E) ->    d2   -> error
	 */
	
	@Test
	def void testWithDeletion(){
		nonContainmentHelper_addAllAsContainment()
		val ArrayList<NonRoot> li = new ArrayList<NonRoot>();
		li.addAll(NR1, NR2, NR3, NR4, NR5)		
		val List<EChange> result = UPR.record [
			multiValuedNonContainmentEReference.addAll(0, li)
		]
		val List<EChange> newResult = myremove(result, 2)
		newResult
			.assertChangeCount(4)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR1, -1, false, false)
			.assertChangeCount(3)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR2, -1, false, false)
			.assertChangeCount(2)
//			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR3, -1, false, false)
//			.assertChangeCount(2)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR4, -1, false, false)
			.assertChangeCount(1)
			.assertInsertEReference(UPR, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, NR5, -1, false, false)
			.assertChangeCount(0)
	}
	
	def ArrayList<EChange> myremove(List<EChange> org, int index) {
		val ArrayList<EChange> ret = new ArrayList<EChange>();
		org.forEach[x, i| if(i !== index){ret.add(x)}]
		return ret;		
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

	def private testInsertInContainmentEReference(int insertAt, int expectedIndex) {
		// prepare
		uniquePersistedRoot
		
		// test
		val nonRoot = aet.NonRoot
		val result = uniquePersistedRoot.record [
			multiValuedContainmentEReference.add(insertAt, nonRoot)
		]

		// assert
		result.assertChangeCount(3)
			.assertCreateAndInsertNonRoot(uniquePersistedRoot, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, nonRoot, expectedIndex, false)
			.assertReplaceSingleValuedEAttribute(nonRoot, IDENTIFIED__ID, null, nonRoot.id, false, false)
			.assertEmpty
	}

	def private testInsertInEReference(int insertAt, int expectedIndex) {
		// prepare
		val nonRoot = aet.NonRoot
		uniquePersistedRoot => [
			multiValuedContainmentEReference.add(0, nonRoot)
		]

		// test			
		val result = uniquePersistedRoot.record [
			multiValuedNonContainmentEReference.add(insertAt, nonRoot)			
		]

		// assert
		result.assertChangeCount(1)
			.assertInsertEReference(uniquePersistedRoot, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot, expectedIndex, false, false)
			.assertEmpty
	}

}
