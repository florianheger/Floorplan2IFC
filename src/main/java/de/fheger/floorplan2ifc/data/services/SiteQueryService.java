package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcSite;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class SiteQueryService extends QueryService<IfcSite> {
    @Override
    public Query addTypeRelatedInformation(IfcSite ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcSite ifcElement) {
        return null;
    }
}
