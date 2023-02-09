package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcWall;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class WallQueryService extends QueryService<IfcWall> {
    @Override
    public Query addTypeRelatedInformation(IfcWall ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcWall ifcElement) {
        return null;
    }
}
