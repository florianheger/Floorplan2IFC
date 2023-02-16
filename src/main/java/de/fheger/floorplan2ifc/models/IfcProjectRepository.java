package de.fheger.floorplan2ifc.models;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface IfcProjectRepository extends Neo4jRepository<IfcProject, String> {
}
