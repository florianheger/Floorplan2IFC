package de.fheger.floorplan2ifc.data;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataCommands {

    private SaveToDatabaseService saveToDatabaseService;

    @Autowired
    public DataCommands(SaveToDatabaseService saveToDatabaseService) {
        this.saveToDatabaseService = saveToDatabaseService;
    }

    public void saveToDatabase(IfcProject ifcProject) {

    }
}
