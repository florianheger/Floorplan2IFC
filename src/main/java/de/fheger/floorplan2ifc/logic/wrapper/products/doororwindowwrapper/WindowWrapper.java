package de.fheger.floorplan2ifc.logic.wrapper.products.doororwindowwrapper;


import de.fheger.floorplan2ifc.gui.nodes.WindowNode;
import de.fheger.floorplan2ifc.logic.wrapper.products.DoorOrWindowWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;

public class WindowWrapper extends DoorOrWindowWrapper<WindowNode, IfcWall> {
    public WindowWrapper(WindowNode elementNode) {
        super(elementNode, new IfcWall());
    }


    @Override
    public int getElementLength() {
        return getElementNode().getElementPanel().getLength();
    }

    @Override
    public void addRelationships() {

    }
}
