package de.fheger.floorplan2ifc.logic.wrapper.products.doororwindowwrapper;


import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.panels.SpacePanel;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.wrapper.products.DoorOrWindowWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelNests;

import java.util.HashSet;
import java.util.Set;

public class DoorWrapper extends DoorOrWindowWrapper<DoorNode, IfcDoor> {

    public DoorWrapper(DoorNode elementNode) {
        super(elementNode, new IfcDoor());
    }

    @Override
    public void addRelationships() throws ParseToIfcException {
        SpacePanel[] connectedSpacePanels = getElementNode().getElementPanel().getConnectedSpaces().toArray(new SpacePanel[0]);
        if (connectedSpacePanels.length == 0) {
            return;
        }
        if (connectedSpacePanels.length != 2) {
            throw new ParseToIfcException("The Door " + getIfcElement().getName() + " connects to 1 or more than 2 spaces.");
        }
        Set<IfcSpace> spaces = new HashSet<>(getIfcElements(connectedSpacePanels, IfcSpace.class));
        IfcRelNests relDoorSpaces = new IfcRelNests(getIfcElement(), new HashSet<>(spaces));
        getIfcElement().getNests().add(relDoorSpaces);
        spaces.forEach(s -> s.getIsNestedBy().add(relDoorSpaces));
    }

    @Override
    public int getElementLength() {
        return getElementNode().getElementPanel().getLength();
    }
}
