/**
 */
package uml_mockup.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uml_mockup.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Uml_mockupFactoryImpl extends EFactoryImpl implements Uml_mockupFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Uml_mockupFactory init() {
        try {
            Uml_mockupFactory theUml_mockupFactory = (Uml_mockupFactory)EPackage.Registry.INSTANCE.getEFactory(Uml_mockupPackage.eNS_URI);
            if (theUml_mockupFactory != null) {
                return theUml_mockupFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Uml_mockupFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Uml_mockupFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case Uml_mockupPackage.UPACKAGE: return createUPackage();
            case Uml_mockupPackage.INTERFACE: return createInterface();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UPackage createUPackage() {
        UPackageImpl uPackage = new UPackageImpl();
        return uPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Interface createInterface() {
        InterfaceImpl interface_ = new InterfaceImpl();
        return interface_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Uml_mockupPackage getUml_mockupPackage() {
        return (Uml_mockupPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static Uml_mockupPackage getPackage() {
        return Uml_mockupPackage.eINSTANCE;
    }

} //Uml_mockupFactoryImpl
