package de.fheger.floorplan2ifc.logic.wrapper.products;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcSpace;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SpaceNode;
import de.fheger.floorplan2ifc.logic.Wrapper;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;

public class SpaceWrapper extends ProductWrapper<SpaceNode, IfcSpace> {
    public SpaceWrapper(SpaceNode elementNode) {
        super(elementNode, new IfcSpace());
    }

    @Override
    public void addRelationships() {

    }
}
