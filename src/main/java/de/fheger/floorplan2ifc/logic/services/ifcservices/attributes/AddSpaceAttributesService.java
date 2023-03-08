package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.ISpace;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import org.springframework.stereotype.Service;

@Service
public class AddSpaceAttributesService implements IAddAttributesService<IfcSpace, ISpace> {
    @Override
    public void addAttributes(IfcSpace ifcEntity, ISpace iEntity) throws ParseToIfcException {
        double floorArea = iEntity.getFloorArea();
        ifcEntity.setFloorArea(floorArea);

        String floorAreaDin277 = iEntity.getFloorAreaDin();
        ifcEntity.setFloorAreaDin277(floorAreaDin277);
    }
}
