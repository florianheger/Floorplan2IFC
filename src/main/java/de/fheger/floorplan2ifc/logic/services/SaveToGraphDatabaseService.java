package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.logic.exceptions.SaveToDatabaseException;
import de.fheger.floorplan2ifc.models.IfcProjectRepository;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.stereotype.Component;

/**
 * Saves an <i>IfcProject</i> to the graph database, defined by the application.properties.
 */
@Component
public class SaveToGraphDatabaseService {
    private final IfcProjectRepository ifcProjectRepository;

    public SaveToGraphDatabaseService(IfcProjectRepository ifcProjectRepository) {
        this.ifcProjectRepository = ifcProjectRepository;
    }

    public void save(IfcProject ifcProject)
            throws SaveToDatabaseException {
        try {
            ifcProjectRepository.save(ifcProject);
        } catch (Exception e) {
            throw new SaveToDatabaseException(e.getMessage());
        }
    }
}
