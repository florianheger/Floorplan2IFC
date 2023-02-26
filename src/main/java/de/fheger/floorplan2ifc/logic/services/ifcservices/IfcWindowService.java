package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.interfaces.IWindow;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IfcWindowService extends IfcService<IfcWindow, IWindow> {
    @Autowired
    protected IfcWindowService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcWindow, IWindow> addAttributes) {
        super(IfcWindow.class, IWindow.class, findIfcEntityService, addAttributes);
    }
}
