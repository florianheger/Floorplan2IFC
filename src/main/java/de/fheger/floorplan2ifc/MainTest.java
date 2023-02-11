package de.fheger.floorplan2ifc;

import de.fheger.floorplan2ifc.logic.IfcProjectRepository;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSite;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelAggregates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;

@Component
public class MainTest {
    private final IfcProjectRepository ifcProjectRepository;

    @Autowired
    public MainTest(IfcProjectRepository ifcProjectRepository) {
        this.ifcProjectRepository = ifcProjectRepository;
    }

    public void modelsTest() {
        IfcProject ifcProject = new IfcProject();
        ifcProject.setName("Name");
        ifcProject.setDescription("Description");

        IfcSite ifcSite = new IfcSite();

        IfcRelAggregates relAggregates = new IfcRelAggregates(ifcProject, new HashSet<>(Collections.singleton(ifcSite)));
        ifcProject.getIsDecomposedBy().add(relAggregates);
        ifcSite.getDecomposes().add(relAggregates);

        ifcProjectRepository.save(ifcProject);
    }
}
