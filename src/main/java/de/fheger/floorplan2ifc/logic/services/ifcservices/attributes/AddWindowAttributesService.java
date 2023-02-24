package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.WindowNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddWindowAttributesService implements IAddAttributesService<IfcWindow, WindowNode> {

    private final AddLengthToOpeningElement addLengthToOpeningElement;

    @Autowired
    public AddWindowAttributesService(AddLengthToOpeningElement addLengthToOpeningElement) {
        this.addLengthToOpeningElement = addLengthToOpeningElement;
    }

    @Override
    public void addAttributes(IfcWindow ifcEntity, WindowNode entityNode) throws ParseToIfcException {
        addLengthToOpeningElement.addLengthToOpeningElement(entityNode.getEntityPanel().getEntityLength(), ifcEntity);
    }
}
