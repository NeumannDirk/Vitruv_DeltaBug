/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.response.responseLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.UpdateElement#getElement <em>Element</em>}</li>
 *   <li>{@link tools.vitruv.dsls.response.responseLanguage.UpdateElement#getUpdateBlock <em>Update Block</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.dsls.response.responseLanguage.ResponseLanguagePackage#getUpdateElement()
 * @model
 * @generated
 */
public interface UpdateElement extends EffectStatement
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(ExistingElementReference)
   * @see tools.vitruv.dsls.response.responseLanguage.ResponseLanguagePackage#getUpdateElement_Element()
   * @model containment="true"
   * @generated
   */
  ExistingElementReference getElement();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.response.responseLanguage.UpdateElement#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(ExistingElementReference value);

  /**
   * Returns the value of the '<em><b>Update Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update Block</em>' containment reference.
   * @see #setUpdateBlock(ExecutionCodeBlock)
   * @see tools.vitruv.dsls.response.responseLanguage.ResponseLanguagePackage#getUpdateElement_UpdateBlock()
   * @model containment="true"
   * @generated
   */
  ExecutionCodeBlock getUpdateBlock();

  /**
   * Sets the value of the '{@link tools.vitruv.dsls.response.responseLanguage.UpdateElement#getUpdateBlock <em>Update Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update Block</em>' containment reference.
   * @see #getUpdateBlock()
   * @generated
   */
  void setUpdateBlock(ExecutionCodeBlock value);

} // UpdateElement
