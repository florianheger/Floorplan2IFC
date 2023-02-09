package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcProductExtension.IfcBuilding;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class BuildingQueryService extends QueryService<IfcBuilding> {
    @Override
    public Query addTypeRelatedInformation(IfcBuilding ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcBuilding ifcElement) {
        return null;
    }
}
