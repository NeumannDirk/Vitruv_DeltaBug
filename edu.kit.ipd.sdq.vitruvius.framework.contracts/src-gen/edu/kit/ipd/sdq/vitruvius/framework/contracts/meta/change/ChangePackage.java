/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.ChangeFactory
 * @model kind="package"
 * @generated
 */
public interface ChangePackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "change";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://edu.kit.ipd.sdq.vitruvius/Change/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "change";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ChangePackage eINSTANCE = edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl.init();

    /**
     * The meta object id for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EChangeImpl <em>EChange</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EChangeImpl
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getEChange()
     * @generated
     */
    int ECHANGE = 0;

    /**
     * The number of structural features of the '<em>EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ECHANGE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ECHANGE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AtomicEChangeImpl <em>Atomic EChange</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AtomicEChangeImpl
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getAtomicEChange()
     * @generated
     */
    int ATOMIC_ECHANGE = 1;

    /**
     * The number of structural features of the '<em>Atomic EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATOMIC_ECHANGE_FEATURE_COUNT = ECHANGE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Atomic EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATOMIC_ECHANGE_OPERATION_COUNT = ECHANGE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AdditiveEChangeImpl <em>Additive EChange</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AdditiveEChangeImpl
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getAdditiveEChange()
     * @generated
     */
    int ADDITIVE_ECHANGE = 2;

    /**
     * The number of structural features of the '<em>Additive EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADDITIVE_ECHANGE_FEATURE_COUNT = ATOMIC_ECHANGE_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get New Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADDITIVE_ECHANGE___GET_NEW_VALUE = ATOMIC_ECHANGE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Additive EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADDITIVE_ECHANGE_OPERATION_COUNT = ATOMIC_ECHANGE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.SubtractiveEChangeImpl <em>Subtractive EChange</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.SubtractiveEChangeImpl
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getSubtractiveEChange()
     * @generated
     */
    int SUBTRACTIVE_ECHANGE = 3;

    /**
     * The number of structural features of the '<em>Subtractive EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBTRACTIVE_ECHANGE_FEATURE_COUNT = ATOMIC_ECHANGE_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Old Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBTRACTIVE_ECHANGE___GET_OLD_VALUE = ATOMIC_ECHANGE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Subtractive EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUBTRACTIVE_ECHANGE_OPERATION_COUNT = ATOMIC_ECHANGE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectAddedEChangeImpl <em>EObject Added EChange</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectAddedEChangeImpl
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getEObjectAddedEChange()
     * @generated
     */
    int EOBJECT_ADDED_ECHANGE = 4;

    /**
     * The feature id for the '<em><b>New Value</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_ADDED_ECHANGE__NEW_VALUE = ADDITIVE_ECHANGE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Is Create</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_ADDED_ECHANGE__IS_CREATE = ADDITIVE_ECHANGE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>EObject Added EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_ADDED_ECHANGE_FEATURE_COUNT = ADDITIVE_ECHANGE_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Get New Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_ADDED_ECHANGE___GET_NEW_VALUE = ADDITIVE_ECHANGE___GET_NEW_VALUE;

    /**
     * The number of operations of the '<em>EObject Added EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_ADDED_ECHANGE_OPERATION_COUNT = ADDITIVE_ECHANGE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectSubtractedEChangeImpl <em>EObject Subtracted EChange</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectSubtractedEChangeImpl
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getEObjectSubtractedEChange()
     * @generated
     */
    int EOBJECT_SUBTRACTED_ECHANGE = 5;

    /**
     * The feature id for the '<em><b>Old Value</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_SUBTRACTED_ECHANGE__OLD_VALUE = SUBTRACTIVE_ECHANGE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Is Delete</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_SUBTRACTED_ECHANGE__IS_DELETE = SUBTRACTIVE_ECHANGE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>EObject Subtracted EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_SUBTRACTED_ECHANGE_FEATURE_COUNT = SUBTRACTIVE_ECHANGE_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Get Old Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_SUBTRACTED_ECHANGE___GET_OLD_VALUE = SUBTRACTIVE_ECHANGE___GET_OLD_VALUE;

    /**
     * The number of operations of the '<em>EObject Subtracted EChange</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_SUBTRACTED_ECHANGE_OPERATION_COUNT = SUBTRACTIVE_ECHANGE_OPERATION_COUNT + 0;


    /**
     * Returns the meta object for class '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EChange <em>EChange</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EChange</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EChange
     * @generated
     */
    EClass getEChange();

    /**
     * Returns the meta object for class '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AtomicEChange <em>Atomic EChange</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Atomic EChange</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AtomicEChange
     * @generated
     */
    EClass getAtomicEChange();

    /**
     * Returns the meta object for class '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AdditiveEChange <em>Additive EChange</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Additive EChange</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AdditiveEChange
     * @generated
     */
    EClass getAdditiveEChange();

    /**
     * Returns the meta object for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AdditiveEChange#getNewValue() <em>Get New Value</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get New Value</em>' operation.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AdditiveEChange#getNewValue()
     * @generated
     */
    EOperation getAdditiveEChange__GetNewValue();

    /**
     * Returns the meta object for class '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.SubtractiveEChange <em>Subtractive EChange</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Subtractive EChange</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.SubtractiveEChange
     * @generated
     */
    EClass getSubtractiveEChange();

    /**
     * Returns the meta object for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.SubtractiveEChange#getOldValue() <em>Get Old Value</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Old Value</em>' operation.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.SubtractiveEChange#getOldValue()
     * @generated
     */
    EOperation getSubtractiveEChange__GetOldValue();

    /**
     * Returns the meta object for class '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectAddedEChange <em>EObject Added EChange</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EObject Added EChange</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectAddedEChange
     * @generated
     */
    EClass getEObjectAddedEChange();

    /**
     * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectAddedEChange#getNewValue <em>New Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>New Value</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectAddedEChange#getNewValue()
     * @see #getEObjectAddedEChange()
     * @generated
     */
    EReference getEObjectAddedEChange_NewValue();

    /**
     * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectAddedEChange#isIsCreate <em>Is Create</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Create</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectAddedEChange#isIsCreate()
     * @see #getEObjectAddedEChange()
     * @generated
     */
    EAttribute getEObjectAddedEChange_IsCreate();

    /**
     * Returns the meta object for class '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectSubtractedEChange <em>EObject Subtracted EChange</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EObject Subtracted EChange</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectSubtractedEChange
     * @generated
     */
    EClass getEObjectSubtractedEChange();

    /**
     * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectSubtractedEChange#getOldValue <em>Old Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Old Value</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectSubtractedEChange#getOldValue()
     * @see #getEObjectSubtractedEChange()
     * @generated
     */
    EReference getEObjectSubtractedEChange_OldValue();

    /**
     * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectSubtractedEChange#isIsDelete <em>Is Delete</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Delete</em>'.
     * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EObjectSubtractedEChange#isIsDelete()
     * @see #getEObjectSubtractedEChange()
     * @generated
     */
    EAttribute getEObjectSubtractedEChange_IsDelete();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ChangeFactory getChangeFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EChangeImpl <em>EChange</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EChangeImpl
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getEChange()
         * @generated
         */
        EClass ECHANGE = eINSTANCE.getEChange();

        /**
         * The meta object literal for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AtomicEChangeImpl <em>Atomic EChange</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AtomicEChangeImpl
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getAtomicEChange()
         * @generated
         */
        EClass ATOMIC_ECHANGE = eINSTANCE.getAtomicEChange();

        /**
         * The meta object literal for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AdditiveEChangeImpl <em>Additive EChange</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.AdditiveEChangeImpl
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getAdditiveEChange()
         * @generated
         */
        EClass ADDITIVE_ECHANGE = eINSTANCE.getAdditiveEChange();

        /**
         * The meta object literal for the '<em><b>Get New Value</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ADDITIVE_ECHANGE___GET_NEW_VALUE = eINSTANCE.getAdditiveEChange__GetNewValue();

        /**
         * The meta object literal for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.SubtractiveEChangeImpl <em>Subtractive EChange</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.SubtractiveEChangeImpl
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getSubtractiveEChange()
         * @generated
         */
        EClass SUBTRACTIVE_ECHANGE = eINSTANCE.getSubtractiveEChange();

        /**
         * The meta object literal for the '<em><b>Get Old Value</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SUBTRACTIVE_ECHANGE___GET_OLD_VALUE = eINSTANCE.getSubtractiveEChange__GetOldValue();

        /**
         * The meta object literal for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectAddedEChangeImpl <em>EObject Added EChange</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectAddedEChangeImpl
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getEObjectAddedEChange()
         * @generated
         */
        EClass EOBJECT_ADDED_ECHANGE = eINSTANCE.getEObjectAddedEChange();

        /**
         * The meta object literal for the '<em><b>New Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EOBJECT_ADDED_ECHANGE__NEW_VALUE = eINSTANCE.getEObjectAddedEChange_NewValue();

        /**
         * The meta object literal for the '<em><b>Is Create</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EOBJECT_ADDED_ECHANGE__IS_CREATE = eINSTANCE.getEObjectAddedEChange_IsCreate();

        /**
         * The meta object literal for the '{@link edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectSubtractedEChangeImpl <em>EObject Subtracted EChange</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.EObjectSubtractedEChangeImpl
         * @see edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.impl.ChangePackageImpl#getEObjectSubtractedEChange()
         * @generated
         */
        EClass EOBJECT_SUBTRACTED_ECHANGE = eINSTANCE.getEObjectSubtractedEChange();

        /**
         * The meta object literal for the '<em><b>Old Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EOBJECT_SUBTRACTED_ECHANGE__OLD_VALUE = eINSTANCE.getEObjectSubtractedEChange_OldValue();

        /**
         * The meta object literal for the '<em><b>Is Delete</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EOBJECT_SUBTRACTED_ECHANGE__IS_DELETE = eINSTANCE.getEObjectSubtractedEChange_IsDelete();

    }

} //ChangePackage
