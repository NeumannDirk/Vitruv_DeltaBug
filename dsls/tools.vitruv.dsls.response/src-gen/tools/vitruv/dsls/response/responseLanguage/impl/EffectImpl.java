/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.response.responseLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.vitruv.dsls.response.responseLanguage.Effect;
import tools.vitruv.dsls.response.responseLanguage.EffectStatement;
import tools.vitruv.dsls.response.responseLanguage.ResponseLanguagePackage;
import tools.vitruv.dsls.response.responseLanguage.RoutineCallBlock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.impl.EffectImpl#getEffectStatement <em>Effect Statement</em>}</li>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.impl.EffectImpl#getCallRoutine <em>Call Routine</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EffectImpl extends MinimalEObjectImpl.Container implements Effect
{
  /**
   * The cached value of the '{@link #getEffectStatement() <em>Effect Statement</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectStatement()
   * @generated
   * @ordered
   */
  protected EList<EffectStatement> effectStatement;

  /**
   * The cached value of the '{@link #getCallRoutine() <em>Call Routine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCallRoutine()
   * @generated
   * @ordered
   */
  protected RoutineCallBlock callRoutine;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EffectImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ResponseLanguagePackage.Literals.EFFECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EffectStatement> getEffectStatement()
  {
    if (effectStatement == null)
    {
      effectStatement = new EObjectContainmentEList<EffectStatement>(EffectStatement.class, this, ResponseLanguagePackage.EFFECT__EFFECT_STATEMENT);
    }
    return effectStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoutineCallBlock getCallRoutine()
  {
    return callRoutine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCallRoutine(RoutineCallBlock newCallRoutine, NotificationChain msgs)
  {
    RoutineCallBlock oldCallRoutine = callRoutine;
    callRoutine = newCallRoutine;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.EFFECT__CALL_ROUTINE, oldCallRoutine, newCallRoutine);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCallRoutine(RoutineCallBlock newCallRoutine)
  {
    if (newCallRoutine != callRoutine)
    {
      NotificationChain msgs = null;
      if (callRoutine != null)
        msgs = ((InternalEObject)callRoutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.EFFECT__CALL_ROUTINE, null, msgs);
      if (newCallRoutine != null)
        msgs = ((InternalEObject)newCallRoutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.EFFECT__CALL_ROUTINE, null, msgs);
      msgs = basicSetCallRoutine(newCallRoutine, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.EFFECT__CALL_ROUTINE, newCallRoutine, newCallRoutine));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.EFFECT__EFFECT_STATEMENT:
        return ((InternalEList<?>)getEffectStatement()).basicRemove(otherEnd, msgs);
      case ResponseLanguagePackage.EFFECT__CALL_ROUTINE:
        return basicSetCallRoutine(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.EFFECT__EFFECT_STATEMENT:
        return getEffectStatement();
      case ResponseLanguagePackage.EFFECT__CALL_ROUTINE:
        return getCallRoutine();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.EFFECT__EFFECT_STATEMENT:
        getEffectStatement().clear();
        getEffectStatement().addAll((Collection<? extends EffectStatement>)newValue);
        return;
      case ResponseLanguagePackage.EFFECT__CALL_ROUTINE:
        setCallRoutine((RoutineCallBlock)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.EFFECT__EFFECT_STATEMENT:
        getEffectStatement().clear();
        return;
      case ResponseLanguagePackage.EFFECT__CALL_ROUTINE:
        setCallRoutine((RoutineCallBlock)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.EFFECT__EFFECT_STATEMENT:
        return effectStatement != null && !effectStatement.isEmpty();
      case ResponseLanguagePackage.EFFECT__CALL_ROUTINE:
        return callRoutine != null;
    }
    return super.eIsSet(featureID);
  }

} //EffectImpl
