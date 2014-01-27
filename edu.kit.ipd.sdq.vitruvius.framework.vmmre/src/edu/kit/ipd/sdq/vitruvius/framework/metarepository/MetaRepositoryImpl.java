package edu.kit.ipd.sdq.vitruvius.framework.metarepository;

import java.util.HashMap;
import java.util.Map;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Mapping;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Metamodel;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.MetamodelsReferring;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.ProjectInput;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.ViewType;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.MappingManaging;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.MetamodelManaging;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.ProjectPreparing;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.ViewTypeManaging;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.datatypes.ClaimableConcatHashMap;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.datatypes.ClaimableConcatMap;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.datatypes.ClaimableHashMap;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.datatypes.ClaimableMap;

public class MetaRepositoryImpl implements MetamodelManaging, ViewTypeManaging, MappingManaging, ProjectPreparing {

    // FIXME either rename all gets in interfaces to claim... instead of get... or change
    // implementations so that they do
    // not claim but only get elements

    private ClaimableMap<VURI, Metamodel> uri2MetamodelMap;
    /**
     * Maps all file extensions of all registered metamodels to the respective metamodel. It is
     * ensured by {@link #addMetamodel(Metamodel) addMetamodel} that for every file extension at
     * most one metamodel is mapped.
     */
    private Map<String, Metamodel> fileExtension2MetamodelMap;
    private ClaimableMap<VURI, ViewType> uri2ViewTypeMap;
    private ClaimableConcatMap<VURI, Mapping> uris2MappingMap;

    public MetaRepositoryImpl() {
        this.uri2MetamodelMap = new ClaimableHashMap<VURI, Metamodel>();
        this.fileExtension2MetamodelMap = new HashMap<String, Metamodel>();
        this.uri2ViewTypeMap = new ClaimableHashMap<VURI, ViewType>();
        this.uris2MappingMap = new ClaimableConcatHashMap<VURI, Mapping>();
    }

    @Override
    public void addMetamodel(final Metamodel metamodel) {
        VURI uri = metamodel.getURI();
        this.uri2MetamodelMap.putClaimingNullOrSameMapped(uri, metamodel);
        String[] fileExtensions = metamodel.getFileExtensions();
        for (String fileExtension : fileExtensions) {
            Metamodel mappedMetamodel = this.fileExtension2MetamodelMap.get(fileExtension);
            if (mappedMetamodel != null) {
                throw new RuntimeException("The metamodel '" + metamodel
                        + "' cannot be registered for the file extension '" + fileExtension
                        + "' because the metamodel '" + mappedMetamodel + "' is already mapped to it!");
            }
            this.fileExtension2MetamodelMap.put(fileExtension, metamodel);
        }
    }

    @Override
    public Metamodel getMetamodel(final VURI uri) {
        return this.uri2MetamodelMap.get(uri);
    }

    @Override
    public Metamodel getMetamodel(final String fileExtension) {
        return this.fileExtension2MetamodelMap.get(fileExtension);
    }

    @Override
    public void addViewType(final ViewType viewType) {
        claimReferredMetamodels(viewType);
        VURI viewTypeURI = viewType.getURI();
        this.uri2ViewTypeMap.putClaimingNullOrSameMapped(viewTypeURI, viewType);
    }

    private void claimReferredMetamodels(final MetamodelsReferring metamodelsReferring) {
        VURI[] metamodelURIs = metamodelsReferring.getMetamodelURIs();
        for (VURI metamodelURI : metamodelURIs) {
            this.uri2MetamodelMap.claimKeyIsMapped(metamodelURI);
        }
    }

    @Override
    public ViewType getViewType(final VURI uri) {
        return this.uri2ViewTypeMap.get(uri);
    }

    @Override
    public void addMapping(final Mapping mapping) {
        claimReferredMetamodels(mapping);
        VURI[] metamodelURIs = mapping.getMetamodelURIs();
        this.uris2MappingMap.putClaimingNullOrSameMapped(mapping, metamodelURIs);
    }

    @Override
    public Mapping getMapping(final VURI... metamodelURIs) {
        for (VURI metamodelURI : metamodelURIs) {
            this.uri2MetamodelMap.claimKeyIsMapped(metamodelURI);
        }
        return this.uris2MappingMap.claimValueForKeys(metamodelURIs);
    }

    @Override
    public ProjectInput getProjectInput() {
        ProjectInput projectInput = new ProjectInput(this.uri2MetamodelMap, this.uri2ViewTypeMap, this.uris2MappingMap);
        return projectInput;
    }
}
