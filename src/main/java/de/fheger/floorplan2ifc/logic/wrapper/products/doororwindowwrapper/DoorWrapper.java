package de.fheger.floorplan2ifc.logic.wrapper.products.doororwindowwrapper;


import com.buildingsmart.tech.ifc.IfcKernel.IfcRelNests;
import com.buildingsmart.tech.ifc.IfcProductExtension.IfcSpace;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcDoor;
import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.panels.SpacePanel;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.wrapper.products.DoorOrWindowWrapper;
import nl.tue.isbe.ifcspftools.GuidHandler;

import java.util.List;

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
        List<IfcSpace> spaces = getIfcElements(connectedSpacePanels, IfcSpace.class);
        IfcRelNests relDoorSpaces = new IfcRelNests(GuidHandler.getNewIfcGloballyUniqueId(), getIfcElement(), spaces.toArray(new IfcSpace[0]));
        getIfcElement().getNests().add(relDoorSpaces);
        spaces.forEach(s -> s.getIsNestedBy().add(relDoorSpaces));
    }

    @Override
    public int getElementLength() {
        return getElementNode().getElementPanel().getLength();
    }
}
