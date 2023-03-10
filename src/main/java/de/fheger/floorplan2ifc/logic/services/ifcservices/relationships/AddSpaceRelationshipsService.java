package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.interfaces.ISpace;
import de.fheger.floorplan2ifc.interfaces.IWall;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelSpaceBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddSpaceRelationshipsService implements IAddRelationshipsService<IfcSpace, ISpace> {

    private final FindIfcEntityService findIfcEntityService;

    @Autowired
    public AddSpaceRelationshipsService(FindIfcEntityService findIfcEntityService) {
        this.findIfcEntityService = findIfcEntityService;
    }

    @Override
    public void addRelationships(IfcSpace ifcEntity, ISpace iEntity) throws ParseToIfcException {
        List<IWall> boundedWalls = iEntity.getBoundedWalls();
        for (IWall boundedWall : boundedWalls) {
            IfcWall boundedIfcWall = findIfcEntityService.findIfcEntity(ifcEntity, boundedWall.getGlobalId(), IfcWall.class);
            IfcRelSpaceBoundary relSpaceBoundary = new IfcRelSpaceBoundary(ifcEntity, boundedIfcWall);
            ifcEntity.getBoundedBy().add(relSpaceBoundary);
            boundedIfcWall.getProvidesBoundaries().add(relSpaceBoundary);
        }
    }
}
