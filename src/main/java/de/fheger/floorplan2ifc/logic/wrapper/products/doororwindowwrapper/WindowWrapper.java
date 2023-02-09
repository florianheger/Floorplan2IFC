package de.fheger.floorplan2ifc.logic.wrapper.products.doororwindowwrapper;

import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcWall;
import de.fheger.floorplan2ifc.gui.nodes.WindowNode;
import de.fheger.floorplan2ifc.logic.wrapper.products.DoorOrWindowWrapper;

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
