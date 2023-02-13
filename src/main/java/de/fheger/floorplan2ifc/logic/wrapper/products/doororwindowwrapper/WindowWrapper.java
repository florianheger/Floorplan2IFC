package de.fheger.floorplan2ifc.logic.wrapper.products.doororwindowwrapper;


import de.fheger.floorplan2ifc.gui.nodes.WindowNode;
import de.fheger.floorplan2ifc.logic.wrapper.products.DoorOrWindowWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;

public class WindowWrapper extends DoorOrWindowWrapper<WindowNode, IfcWindow> {
    public WindowWrapper(WindowNode elementNode) {
        super(elementNode, new IfcWindow());
    }


    @Override
    public int getElementLength() {
        return getElementNode().getElementPanel().getWindowLength();
    }

    @Override
    public void addRelationships() {

    }
}
