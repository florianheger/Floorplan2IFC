package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcOpeningElement;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class OpeningElementQueryService extends QueryService<IfcOpeningElement> {
    @Override
    public Query addTypeRelatedInformation(IfcOpeningElement ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcOpeningElement ifcElement) {
        return null;
    }
}
