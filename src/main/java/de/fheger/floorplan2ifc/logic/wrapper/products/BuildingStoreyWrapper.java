package de.fheger.floorplan2ifc.logic.wrapper.products;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcBuildingStorey;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.BuildingStoreyNode;
import de.fheger.floorplan2ifc.logic.Wrapper;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;

public class BuildingStoreyWrapper extends ProductWrapper<BuildingStoreyNode, IfcBuildingStorey> {
    public BuildingStoreyWrapper(BuildingStoreyNode elementNode) {
        super(elementNode, new IfcBuildingStorey());
    }

    @Override
    public void addRelationships() {

    }
}
