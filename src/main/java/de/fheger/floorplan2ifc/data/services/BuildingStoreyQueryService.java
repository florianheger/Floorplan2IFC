package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcBuildingStorey;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class BuildingStoreyQueryService extends QueryService<IfcBuildingStorey> {
    @Override
    public Query addTypeRelatedInformation(IfcBuildingStorey ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcBuildingStorey ifcElement) {
        return null;
    }
}
