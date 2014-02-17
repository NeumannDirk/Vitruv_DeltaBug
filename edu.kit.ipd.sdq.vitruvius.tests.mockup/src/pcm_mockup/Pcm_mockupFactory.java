/**
 */
package pcm_mockup;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pcm_mockup.Pcm_mockupPackage
 * @generated
 */
public interface Pcm_mockupFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Pcm_mockupFactory eINSTANCE = pcm_mockup.impl.Pcm_mockupFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Repository</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Repository</em>'.
     * @generated
     */
    Repository createRepository();

    /**
     * Returns a new object of class '<em>Interface</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Interface</em>'.
     * @generated
     */
    Interface createInterface();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    Pcm_mockupPackage getPcm_mockupPackage();

} //Pcm_mockupFactory
