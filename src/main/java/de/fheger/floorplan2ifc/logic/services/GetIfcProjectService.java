package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelVoidsElement;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Returns the <i>IfcProject</i> of any <i>IfcObjectDefinition</i>.
 */
@Service
public class GetIfcProjectService {
    /**
     * Returns the <i>IfcProject</i> of any <i>IfcObjectDefinition</i> resursivly.
     * @param anyIfcEntity Any object which is in the same Graph as the IfcProject.
     * @return The searched IfcProject.
     * @throws ParseToIfcException If no project was found.
     */
    public IfcProject getIfcProject(IfcObjectDefinition anyIfcEntity)
            throws ParseToIfcException {
        IfcProject result = getIfcProjectRecursive(anyIfcEntity);
        if (result == null) {
            throw new ParseToIfcException("Internal Error: Found no IfcProject.");
        }
        return result;
    }

    private IfcProject getIfcProjectRecursive(IfcObjectDefinition anyIfcEntity)
            throws ParseToIfcException {
        if (anyIfcEntity instanceof IfcProject ifcProject) {
            return ifcProject;
        }
        if (anyIfcEntity instanceof IfcWindow ifcWindow) {
            return getIfcProjectRecursive(getIfcWall(ifcWindow));
        }
        if (anyIfcEntity instanceof IfcDoor ifcDoor) {
            return getIfcProjectRecursive(getIfcWall(ifcDoor));
        }
        IfcObjectDefinition parent = anyIfcEntity.getDecomposes().stream().toList().get(0).getRelatingObject();
        return getIfcProjectRecursive(parent);
    }

    private IfcElement getIfcWall(IfcElement ifcElement)
            throws ParseToIfcException {
        List<IfcRelFillsElement> relFillsElements = ifcElement.getFillsVoids().stream().toList();
        if (relFillsElements.size() != 1) {
            throw new ParseToIfcException("Internal Error: " + ifcElement.getClass().getSimpleName() + " has no correct OpeningElement");
        }
        IfcOpeningElement openingElement = relFillsElements.get(0).getRelatingOpeningElement();
        List<IfcRelVoidsElement> relVoidsElements = openingElement.getVoidsElements().stream().toList();
        if (relVoidsElements.size() != 1) {
            throw new ParseToIfcException("Internal Error: " + ifcElement.getClass().getSimpleName() + " has no correct OpeningElement");
        }
        return relVoidsElements.get(0).getRelatingBuildingElement();
    }
}
