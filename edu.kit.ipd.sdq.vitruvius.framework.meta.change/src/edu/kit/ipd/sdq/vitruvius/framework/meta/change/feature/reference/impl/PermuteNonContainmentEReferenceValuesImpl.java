/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.impl;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.EChange;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.EFeatureChange;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.FeaturePackage;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.list.impl.PermuteEListImpl;

import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.PermuteNonContainmentEReferenceValues;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.ReferencePackage;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.UpdateEReference;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.UpdateNonContainmentEReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permute Non Containment EReference Values</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.impl.PermuteNonContainmentEReferenceValuesImpl#getAffectedFeature <em>Affected Feature</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.impl.PermuteNonContainmentEReferenceValuesImpl#getOldAffectedEObject <em>Old Affected EObject</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.impl.PermuteNonContainmentEReferenceValuesImpl#getNewAffectedEObject <em>New Affected EObject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermuteNonContainmentEReferenceValuesImpl<T extends EObject> extends PermuteEListImpl<T> implements PermuteNonContainmentEReferenceValues<T> {
	/**
	 * The cached value of the '{@link #getAffectedFeature() <em>Affected Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference affectedFeature;

	/**
	 * The cached value of the '{@link #getOldAffectedEObject() <em>Old Affected EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldAffectedEObject()
	 * @generated
	 * @ordered
	 */
	protected EObject oldAffectedEObject;

	/**
	 * The cached value of the '{@link #getNewAffectedEObject() <em>New Affected EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewAffectedEObject()
	 * @generated
	 * @ordered
	 */
	protected EObject newAffectedEObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PermuteNonContainmentEReferenceValuesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReferencePackage.Literals.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffectedFeature() {
		if (affectedFeature != null && affectedFeature.eIsProxy()) {
			InternalEObject oldAffectedFeature = (InternalEObject)affectedFeature;
			affectedFeature = (EReference)eResolveProxy(oldAffectedFeature);
			if (affectedFeature != oldAffectedFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE, oldAffectedFeature, affectedFeature));
			}
		}
		return affectedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetAffectedFeature() {
		return affectedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedFeature(EReference newAffectedFeature) {
		EReference oldAffectedFeature = affectedFeature;
		affectedFeature = newAffectedFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE, oldAffectedFeature, affectedFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOldAffectedEObject() {
		if (oldAffectedEObject != null && oldAffectedEObject.eIsProxy()) {
			InternalEObject oldOldAffectedEObject = (InternalEObject)oldAffectedEObject;
			oldAffectedEObject = eResolveProxy(oldOldAffectedEObject);
			if (oldAffectedEObject != oldOldAffectedEObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT, oldOldAffectedEObject, oldAffectedEObject));
			}
		}
		return oldAffectedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOldAffectedEObject() {
		return oldAffectedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldAffectedEObject(EObject newOldAffectedEObject) {
		EObject oldOldAffectedEObject = oldAffectedEObject;
		oldAffectedEObject = newOldAffectedEObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT, oldOldAffectedEObject, oldAffectedEObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getNewAffectedEObject() {
		if (newAffectedEObject != null && newAffectedEObject.eIsProxy()) {
			InternalEObject oldNewAffectedEObject = (InternalEObject)newAffectedEObject;
			newAffectedEObject = eResolveProxy(oldNewAffectedEObject);
			if (newAffectedEObject != oldNewAffectedEObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT, oldNewAffectedEObject, newAffectedEObject));
			}
		}
		return newAffectedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetNewAffectedEObject() {
		return newAffectedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewAffectedEObject(EObject newNewAffectedEObject) {
		EObject oldNewAffectedEObject = newAffectedEObject;
		newAffectedEObject = newNewAffectedEObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT, oldNewAffectedEObject, newAffectedEObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE:
				if (resolve) return getAffectedFeature();
				return basicGetAffectedFeature();
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT:
				if (resolve) return getOldAffectedEObject();
				return basicGetOldAffectedEObject();
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT:
				if (resolve) return getNewAffectedEObject();
				return basicGetNewAffectedEObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE:
				setAffectedFeature((EReference)newValue);
				return;
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT:
				setOldAffectedEObject((EObject)newValue);
				return;
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT:
				setNewAffectedEObject((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE:
				setAffectedFeature((EReference)null);
				return;
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT:
				setOldAffectedEObject((EObject)null);
				return;
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT:
				setNewAffectedEObject((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE:
				return affectedFeature != null;
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT:
				return oldAffectedEObject != null;
			case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT:
				return newAffectedEObject != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EChange.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EFeatureChange.class) {
			switch (derivedFeatureID) {
				case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE: return FeaturePackage.EFEATURE_CHANGE__AFFECTED_FEATURE;
				case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT: return FeaturePackage.EFEATURE_CHANGE__OLD_AFFECTED_EOBJECT;
				case ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT: return FeaturePackage.EFEATURE_CHANGE__NEW_AFFECTED_EOBJECT;
				default: return -1;
			}
		}
		if (baseClass == UpdateEReference.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == UpdateNonContainmentEReference.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EChange.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EFeatureChange.class) {
			switch (baseFeatureID) {
				case FeaturePackage.EFEATURE_CHANGE__AFFECTED_FEATURE: return ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__AFFECTED_FEATURE;
				case FeaturePackage.EFEATURE_CHANGE__OLD_AFFECTED_EOBJECT: return ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__OLD_AFFECTED_EOBJECT;
				case FeaturePackage.EFEATURE_CHANGE__NEW_AFFECTED_EOBJECT: return ReferencePackage.PERMUTE_NON_CONTAINMENT_EREFERENCE_VALUES__NEW_AFFECTED_EOBJECT;
				default: return -1;
			}
		}
		if (baseClass == UpdateEReference.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == UpdateNonContainmentEReference.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //PermuteNonContainmentEReferenceValuesImpl
