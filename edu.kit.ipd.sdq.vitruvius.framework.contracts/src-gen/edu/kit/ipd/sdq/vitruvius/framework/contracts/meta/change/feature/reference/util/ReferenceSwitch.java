/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.util;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AdditiveEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AtomicEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectAddedEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectSubtractedEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.SubtractiveEChange;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeatureEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.UpdateMultiValuedFeatureEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.UpdateSingleValuedFeatureEChange;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.InsertInListEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.PermuteListEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.RemoveFromListEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.UpdateSingleListEntryEChange;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.ReferencePackage
 * @generated
 */
public class ReferenceSwitch<T1> extends Switch<T1> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ReferencePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferenceSwitch() {
        if (modelPackage == null) {
            modelPackage = ReferencePackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T1 doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case ReferencePackage.UPDATE_REFERENCE_ECHANGE: {
                UpdateReferenceEChange<?> updateReferenceEChange = (UpdateReferenceEChange<?>)theEObject;
                T1 result = caseUpdateReferenceEChange(updateReferenceEChange);
                if (result == null) result = caseFeatureEChange(updateReferenceEChange);
                if (result == null) result = caseAtomicEChange(updateReferenceEChange);
                if (result == null) result = caseEChange(updateReferenceEChange);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ReferencePackage.ADDITIVE_REFERENCE_ECHANGE: {
                AdditiveReferenceEChange<?, ?> additiveReferenceEChange = (AdditiveReferenceEChange<?, ?>)theEObject;
                T1 result = caseAdditiveReferenceEChange(additiveReferenceEChange);
                if (result == null) result = caseEObjectAddedEChange(additiveReferenceEChange);
                if (result == null) result = caseUpdateReferenceEChange(additiveReferenceEChange);
                if (result == null) result = caseAdditiveEChange(additiveReferenceEChange);
                if (result == null) result = caseFeatureEChange(additiveReferenceEChange);
                if (result == null) result = caseAtomicEChange(additiveReferenceEChange);
                if (result == null) result = caseEChange(additiveReferenceEChange);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ReferencePackage.SUBTRACTIVE_REFERENCE_ECHANGE: {
                SubtractiveReferenceEChange<?, ?> subtractiveReferenceEChange = (SubtractiveReferenceEChange<?, ?>)theEObject;
                T1 result = caseSubtractiveReferenceEChange(subtractiveReferenceEChange);
                if (result == null) result = caseEObjectSubtractedEChange(subtractiveReferenceEChange);
                if (result == null) result = caseUpdateReferenceEChange(subtractiveReferenceEChange);
                if (result == null) result = caseSubtractiveEChange(subtractiveReferenceEChange);
                if (result == null) result = caseFeatureEChange(subtractiveReferenceEChange);
                if (result == null) result = caseAtomicEChange(subtractiveReferenceEChange);
                if (result == null) result = caseEChange(subtractiveReferenceEChange);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ReferencePackage.REPLACE_SINGLE_VALUED_EREFERENCE: {
                ReplaceSingleValuedEReference<?, ?> replaceSingleValuedEReference = (ReplaceSingleValuedEReference<?, ?>)theEObject;
                T1 result = caseReplaceSingleValuedEReference(replaceSingleValuedEReference);
                if (result == null) result = caseUpdateSingleValuedFeatureEChange(replaceSingleValuedEReference);
                if (result == null) result = caseSubtractiveReferenceEChange(replaceSingleValuedEReference);
                if (result == null) result = caseAdditiveReferenceEChange(replaceSingleValuedEReference);
                if (result == null) result = caseEObjectSubtractedEChange(replaceSingleValuedEReference);
                if (result == null) result = caseUpdateReferenceEChange(replaceSingleValuedEReference);
                if (result == null) result = caseEObjectAddedEChange(replaceSingleValuedEReference);
                if (result == null) result = caseSubtractiveEChange(replaceSingleValuedEReference);
                if (result == null) result = caseFeatureEChange(replaceSingleValuedEReference);
                if (result == null) result = caseAdditiveEChange(replaceSingleValuedEReference);
                if (result == null) result = caseAtomicEChange(replaceSingleValuedEReference);
                if (result == null) result = caseEChange(replaceSingleValuedEReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ReferencePackage.INSERT_EREFERENCE: {
                InsertEReference<?, ?> insertEReference = (InsertEReference<?, ?>)theEObject;
                T1 result = caseInsertEReference(insertEReference);
                if (result == null) result = caseInsertInListEChange(insertEReference);
                if (result == null) result = caseAdditiveReferenceEChange(insertEReference);
                if (result == null) result = caseUpdateSingleListEntryEChange(insertEReference);
                if (result == null) result = caseEObjectAddedEChange(insertEReference);
                if (result == null) result = caseUpdateReferenceEChange(insertEReference);
                if (result == null) result = caseUpdateMultiValuedFeatureEChange(insertEReference);
                if (result == null) result = caseAdditiveEChange(insertEReference);
                if (result == null) result = caseFeatureEChange(insertEReference);
                if (result == null) result = caseAtomicEChange(insertEReference);
                if (result == null) result = caseEChange(insertEReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ReferencePackage.REMOVE_EREFERENCE: {
                RemoveEReference<?, ?> removeEReference = (RemoveEReference<?, ?>)theEObject;
                T1 result = caseRemoveEReference(removeEReference);
                if (result == null) result = caseRemoveFromListEChange(removeEReference);
                if (result == null) result = caseSubtractiveReferenceEChange(removeEReference);
                if (result == null) result = caseUpdateSingleListEntryEChange(removeEReference);
                if (result == null) result = caseEObjectSubtractedEChange(removeEReference);
                if (result == null) result = caseUpdateReferenceEChange(removeEReference);
                if (result == null) result = caseUpdateMultiValuedFeatureEChange(removeEReference);
                if (result == null) result = caseSubtractiveEChange(removeEReference);
                if (result == null) result = caseFeatureEChange(removeEReference);
                if (result == null) result = caseAtomicEChange(removeEReference);
                if (result == null) result = caseEChange(removeEReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ReferencePackage.PERMUTE_EREFERENCES: {
                PermuteEReferences<?> permuteEReferences = (PermuteEReferences<?>)theEObject;
                T1 result = casePermuteEReferences(permuteEReferences);
                if (result == null) result = casePermuteListEChange(permuteEReferences);
                if (result == null) result = caseUpdateReferenceEChange(permuteEReferences);
                if (result == null) result = caseUpdateMultiValuedFeatureEChange(permuteEReferences);
                if (result == null) result = caseFeatureEChange(permuteEReferences);
                if (result == null) result = caseAtomicEChange(permuteEReferences);
                if (result == null) result = caseEChange(permuteEReferences);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Reference EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Reference EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject> T1 caseUpdateReferenceEChange(UpdateReferenceEChange<A> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Additive Reference EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Additive Reference EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject, T extends EObject> T1 caseAdditiveReferenceEChange(AdditiveReferenceEChange<A, T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Subtractive Reference EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Subtractive Reference EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject, T extends EObject> T1 caseSubtractiveReferenceEChange(SubtractiveReferenceEChange<A, T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Replace Single Valued EReference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Replace Single Valued EReference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject, T extends EObject> T1 caseReplaceSingleValuedEReference(ReplaceSingleValuedEReference<A, T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Insert EReference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Insert EReference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject, T extends EObject> T1 caseInsertEReference(InsertEReference<A, T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Remove EReference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Remove EReference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject, T extends EObject> T1 caseRemoveEReference(RemoveEReference<A, T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Permute EReferences</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Permute EReferences</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject> T1 casePermuteEReferences(PermuteEReferences<A> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseEChange(EChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Atomic EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Atomic EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseAtomicEChange(AtomicEChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <A extends EObject, F extends EStructuralFeature> T1 caseFeatureEChange(FeatureEChange<A, F> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Additive EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Additive EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T extends Object> T1 caseAdditiveEChange(AdditiveEChange<T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject Added EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject Added EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T extends EObject> T1 caseEObjectAddedEChange(EObjectAddedEChange<T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Subtractive EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Subtractive EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T extends Object> T1 caseSubtractiveEChange(SubtractiveEChange<T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject Subtracted EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject Subtracted EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T extends EObject> T1 caseEObjectSubtractedEChange(EObjectSubtractedEChange<T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Single Valued Feature EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Single Valued Feature EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseUpdateSingleValuedFeatureEChange(UpdateSingleValuedFeatureEChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Multi Valued Feature EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Multi Valued Feature EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseUpdateMultiValuedFeatureEChange(UpdateMultiValuedFeatureEChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Single List Entry EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Single List Entry EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseUpdateSingleListEntryEChange(UpdateSingleListEntryEChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Insert In List EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Insert In List EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseInsertInListEChange(InsertInListEChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Remove From List EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Remove From List EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseRemoveFromListEChange(RemoveFromListEChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Permute List EChange</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Permute List EChange</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 casePermuteListEChange(PermuteListEChange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T1 defaultCase(EObject object) {
        return null;
    }

} //ReferenceSwitch
