package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcKernel.IfcRoot;
import org.neo4j.driver.Query;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public abstract class QueryService<IfcType extends IfcRoot> {
    public abstract Query addTypeRelatedInformation(IfcType ifcElement);

    public abstract Query addRelationships(IfcType ifcElement);
}
