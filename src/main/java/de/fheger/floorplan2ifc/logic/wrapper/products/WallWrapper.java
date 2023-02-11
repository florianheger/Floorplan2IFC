package de.fheger.floorplan2ifc.logic.wrapper.products;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.WallNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelVoidsElement;
import de.fheger.floorplan2ifc.models.enums.IfcOpeningElementTypeEnum;

public class WallWrapper extends ProductWrapper<WallNode, IfcWall> {
    public WallWrapper(WallNode elementNode) {
        super(elementNode, new IfcWall());
    }

    private void addOpeningElement(IfcElement doorOrWindow) {
        IfcOpeningElement ifcOpeningElement = new IfcOpeningElement();
        ifcOpeningElement.setPredefinedType(IfcOpeningElementTypeEnum.OPENING);

        IfcRelVoidsElement relWallOpening = new IfcRelVoidsElement(getIfcElement(), ifcOpeningElement);
        getIfcElement().getHasOpenings().add(relWallOpening);
        ifcOpeningElement.getHasOpenings().add(relWallOpening);

        IfcRelFillsElement relOpeningDoorOrWindow = new IfcRelFillsElement(ifcOpeningElement, doorOrWindow);
        ifcOpeningElement.getHasFillings().add(relOpeningDoorOrWindow);
        doorOrWindow.getFillsVoids().add(relOpeningDoorOrWindow);
    }

    @Override
    public void addAttributes() throws ParseToIfcException {
        super.addAttributes();

        getElementNode().getElementPanel().getInterfernceWalls();
    }

    @Override
    public void addRelationships() {

    }

    @Override
    protected boolean isStandardRelationship(IfcObjectDefinition child) {
        return !(child instanceof IfcWindow || child instanceof IfcDoor);
    }

    @Override
    protected void addSpecialRelationship(IfcObjectDefinition child)
            throws ParseToIfcException {
        if (!(child instanceof IfcElement childElement)) {
            throw new ParseToIfcException("internal error in WallWrapper");
        }
        addOpeningElement(childElement);
    }
}
