package de.fheger.floorplan2ifc.logic.wrapper.products;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SiteNode;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSite;

public class SiteWrapper extends ProductWrapper<SiteNode, IfcSite> {
    public SiteWrapper(SiteNode elementNode) {
        super(elementNode, new IfcSite());
    }

    @Override
    public void addRelationships() {

    }
}
