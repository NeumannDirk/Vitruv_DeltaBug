/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.changes.echange.feature;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.vitruvius.framework.changes.echange.feature.FeaturePackage
 * @generated
 */
public interface FeatureFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    FeatureFactory eINSTANCE = edu.kit.ipd.sdq.vitruvius.framework.changes.echange.feature.impl.FeatureFactoryImpl.init();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    FeaturePackage getFeaturePackage();

} //FeatureFactory