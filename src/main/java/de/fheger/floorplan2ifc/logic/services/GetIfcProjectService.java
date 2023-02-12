package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

public class GetIfcProjectService {
    public static IfcProject getIfcProject(IfcObjectDefinition anyIfcEntity)
            throws ParseToIfcException {
        IfcProject result = getIfcProjectRecursive(anyIfcEntity);
        if (result == null) {
            throw new ParseToIfcException("Internal Error: Found no IfcProject.");
        }
        return result;
    }

    private static IfcProject getIfcProjectRecursive(IfcObjectDefinition anyIfcEntity) {
        if (anyIfcEntity instanceof IfcProject ifcProject) {
            return ifcProject;
        }
        IfcObjectDefinition parent = anyIfcEntity.getDecomposes().stream().toList().get(0).getRelatingObject();
        return getIfcProjectRecursive(parent);
    }
}
