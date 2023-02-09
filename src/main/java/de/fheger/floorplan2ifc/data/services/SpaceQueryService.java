package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcSpace;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class SpaceQueryService extends QueryService<IfcSpace> {
    @Override
    public Query addTypeRelatedInformation(IfcSpace ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcSpace ifcElement) {
        return null;
    }
}
