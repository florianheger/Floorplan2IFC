package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.models.entities.IfcRoot;

public class AddRootAttributesService {
    public static void addRootAttributes(IfcRoot ifcEntity, ElementPanel elementPanel) {
        String globalId = elementPanel.getGlobalId();
        String name = elementPanel.getName();
        String description = elementPanel.getDescription();

        ifcEntity.setGlobalId(globalId);
        ifcEntity.setName(name);
        ifcEntity.setDescription(description);
    }
}
