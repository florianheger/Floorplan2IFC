package de.fheger.floorplan2ifc.logic.wrapper.products;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.BuildingStoreyNode;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcBuildingStorey;

public class BuildingStoreyWrapper extends ProductWrapper<BuildingStoreyNode, IfcBuildingStorey> {
    public BuildingStoreyWrapper(BuildingStoreyNode elementNode) {
        super(elementNode, new IfcBuildingStorey());
    }

    @Override
    public void addRelationships() {

    }
}
