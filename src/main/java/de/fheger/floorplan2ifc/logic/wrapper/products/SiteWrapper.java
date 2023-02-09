package de.fheger.floorplan2ifc.logic.wrapper.products;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcSite;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SiteNode;
import de.fheger.floorplan2ifc.logic.Wrapper;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;

public class SiteWrapper extends ProductWrapper<SiteNode, IfcSite> {
    public SiteWrapper(SiteNode elementNode) {
        super(elementNode, new IfcSite());
    }

    @Override
    public void addRelationships() {

    }
}
