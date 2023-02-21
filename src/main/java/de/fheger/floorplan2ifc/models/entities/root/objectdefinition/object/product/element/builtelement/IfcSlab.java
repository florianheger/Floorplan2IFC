package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.IfcBuiltElement;
import de.fheger.floorplan2ifc.models.enums.IfcSlabTypeEnum;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@SuppressWarnings("ALL")
@Node
public class IfcSlab extends IfcBuiltElement {
    @Setter
    private IfcSlabTypeEnum predefinedType;
}
