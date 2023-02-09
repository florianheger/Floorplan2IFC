package de.fheger.floorplan2ifc.logic.wrapper.products;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcBuilding;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.BuildingNode;
import de.fheger.floorplan2ifc.logic.Wrapper;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;

public class BuildingWrapper extends ProductWrapper<BuildingNode, IfcBuilding> {
    public BuildingWrapper(BuildingNode elementNode) {
        super(elementNode, new IfcBuilding());
    }

    @Override
    public void addRelationships() {

    }
}
