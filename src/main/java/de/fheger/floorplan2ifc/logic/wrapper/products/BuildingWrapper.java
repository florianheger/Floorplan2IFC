package de.fheger.floorplan2ifc.logic.wrapper.products;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.BuildingNode;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.facility.IfcBuilding;

public class BuildingWrapper extends ProductWrapper<BuildingNode, IfcBuilding> {
    public BuildingWrapper(BuildingNode elementNode) {
        super(elementNode, new IfcBuilding());
    }

    @Override
    public void addRelationships() {

    }
}
