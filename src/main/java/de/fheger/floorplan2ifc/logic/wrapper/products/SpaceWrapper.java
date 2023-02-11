package de.fheger.floorplan2ifc.logic.wrapper.products;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SpaceNode;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;

public class SpaceWrapper extends ProductWrapper<SpaceNode, IfcSpace> {
    public SpaceWrapper(SpaceNode elementNode) {
        super(elementNode, new IfcSpace());
    }

    @Override
    public void addRelationships() {

    }
}
