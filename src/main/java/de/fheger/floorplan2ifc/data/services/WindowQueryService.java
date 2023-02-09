package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcWindow;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class WindowQueryService extends QueryService<IfcWindow> {
    @Override
    public Query addTypeRelatedInformation(IfcWindow ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcWindow ifcElement) {
        return null;
    }
}
