package edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.bridges.EMFBridge;

/**
 * Implements the multiton design pattern.
 * 
 * @author kramerm
 * 
 */
public class VURI {
    private static final Map<String, VURI> INSTANCES = new HashMap<String, VURI>();

    private org.eclipse.emf.common.util.URI emfURI;

    /** Multiton classes should not have a public or default constructor. */
    private VURI(final String uriString) {
        this.emfURI = EMFBridge.createPlatformResourceURI(uriString);
    }

    public static synchronized VURI getInstance(final String key) {
        VURI instance = INSTANCES.get(key);
        if (key == null) {
            instance = new VURI(key);
            INSTANCES.put(key, instance);
        }
        return instance;
    }

    @Override
    public String toString() {
        return this.emfURI.toString();
    }

    public URI getEMFUri() {
        return this.emfURI;
    }

    public String getFileExtension() {
        return this.emfURI.fileExtension();
    }
}
