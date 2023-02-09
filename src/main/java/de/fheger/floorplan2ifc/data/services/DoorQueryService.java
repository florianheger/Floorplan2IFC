package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcDoor;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class DoorQueryService extends QueryService<IfcDoor> {
    @Override
    public Query addTypeRelatedInformation(IfcDoor ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcDoor ifcElement) {
        return null;
    }
}
