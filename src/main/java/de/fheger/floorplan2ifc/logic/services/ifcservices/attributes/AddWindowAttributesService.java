package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IWindow;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddWindowAttributesService implements IAddAttributesService<IfcWindow, IWindow> {

    private final AddLengthToOpeningElement addLengthToOpeningElement;

    @Autowired
    public AddWindowAttributesService(AddLengthToOpeningElement addLengthToOpeningElement) {
        this.addLengthToOpeningElement = addLengthToOpeningElement;
    }

    @Override
    public void addAttributes(IfcWindow ifcEntity, IWindow iEntity) throws ParseToIfcException {
        addLengthToOpeningElement.addLengthToOpeningElement(iEntity.getEntityLength(), ifcEntity);
    }
}
