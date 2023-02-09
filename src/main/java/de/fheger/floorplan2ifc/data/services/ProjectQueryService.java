package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class ProjectQueryService extends QueryService<IfcProject> {
    @Override
    public Query addTypeRelatedInformation(IfcProject ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcProject ifcElement) {
        return null;
    }
}
