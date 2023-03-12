package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelAggregates;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelVoidsElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find a subclass of IfcObjectDefinition by GlobalID.
 */
@Service
public class FindIfcEntityService {

    private final GetIfcProjectService getIfcProjectService;

    @Autowired
    public FindIfcEntityService(GetIfcProjectService getIfcProjectService) {
        this.getIfcProjectService = getIfcProjectService;
    }

    /**
     * Find an object of <i>SearchedIfcType</i> by given <i>searchedGlobalId</i>.
     * @param ifcObjectDefinition Any IFC-Entity. Provides a starting point for the search.
     * @param searchedGlobalId The GlobalID of the searched IFC-Object.
     * @param clazz Class of the searched IFC-Object.
     * @return The searched IFC-Object of tyoe <i>SearchedIfcType</i>.
     * @param <SearchedIfcType> The type of the searched IFC-Object. Extends <i>IfcObjectDefinition</i>.
     * @throws ParseToIfcException If no IFC-Object of type <i>IfcObjectDefinition</i> with GlobalID <i>SearchedIfcType</i> was found.
     */
    public <SearchedIfcType extends IfcObjectDefinition> SearchedIfcType findIfcEntity(
            IfcObjectDefinition ifcObjectDefinition, String searchedGlobalId, Class<SearchedIfcType> clazz)
            throws ParseToIfcException {
        IfcProject ifcProject = getIfcProjectService.getIfcProject(ifcObjectDefinition);
        SearchedIfcType result = findIfcEntityRecursive(ifcProject, searchedGlobalId, clazz);
        if (result == null) {
            throw new ParseToIfcException("Internal Error: IfcEntity " + clazz.getSimpleName() + " with GlobalId " + searchedGlobalId + " not found.");
        }
        return result;
    }

    private <SearchedIfcType extends IfcObjectDefinition> SearchedIfcType findIfcEntityRecursive(
            IfcObjectDefinition ifcObject, String searchedGlobalId, Class<SearchedIfcType> clazz)
            throws ParseToIfcException {
        if (ifcObject.getGlobalId().equals(searchedGlobalId)) {
            if (!clazz.isInstance(ifcObject)) {
                throw new ParseToIfcException("Internal Error: GlobalId " + searchedGlobalId + " is not unique.");
            }
            return clazz.cast(ifcObject);
        }
        if (ifcObject instanceof IfcWall ifcWall) {
            return findIfcEntityInWall(ifcWall, searchedGlobalId, clazz);
        }
        List<IfcRelAggregates> aggregates = ifcObject.getIsDecomposedBy().stream().toList();
        List<IfcObjectDefinition> children = new ArrayList<>();
        aggregates.forEach(a -> children.addAll(a.getRelatedObjects()));
        for (IfcObjectDefinition child : children) {
            SearchedIfcType result = findIfcEntityRecursive(child, searchedGlobalId, clazz);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private <SearchedIfcType extends IfcObjectDefinition> SearchedIfcType findIfcEntityInWall(IfcWall ifcWall, String searchedGlobalId, Class<SearchedIfcType> clazz)
            throws ParseToIfcException {
        List<IfcRelVoidsElement> relVoidsElements = ifcWall.getHasOpenings().stream().toList();
        if (relVoidsElements.size() == 0) {
            return null;
        }
        for (IfcRelVoidsElement relVoidsElement : relVoidsElements) {
            if (!(relVoidsElement.getRelatedOpeningElement() instanceof IfcOpeningElement openingElement)) {
                throw new ParseToIfcException("Internal Error");
            }
            IfcObjectDefinition windowOrDoor = openingElement.getHasFillings().stream().toList().get(0).getRelatedBuildingElement();

            for (IfcObjectDefinition ifcEntity : Arrays.asList(openingElement, windowOrDoor)) {
                if (!ifcEntity.getGlobalId().equals(searchedGlobalId)) {
                    continue;
                }
                if (!clazz.isInstance(ifcEntity)) {
                    throw new ParseToIfcException("Internal Error: GlobalId " + searchedGlobalId + " is not unique.");
                }
                return clazz.cast(ifcEntity);
            }
        }
        return null;
    }
}
