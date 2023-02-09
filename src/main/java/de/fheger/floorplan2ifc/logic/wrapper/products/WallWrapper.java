package de.fheger.floorplan2ifc.logic.wrapper.products;

import com.buildingsmart.tech.ifc.IfcKernel.IfcObjectDefinition;
import com.buildingsmart.tech.ifc.IfcKernel.IfcRelAggregates;
import com.buildingsmart.tech.ifc.IfcProductExtension.*;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcDoor;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcWall;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcWindow;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.WallNode;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.Wrapper;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import nl.tue.isbe.ifcspftools.GuidHandler;

public class WallWrapper extends ProductWrapper<WallNode, IfcWall> {
    public WallWrapper(WallNode elementNode) {
        super(elementNode, new IfcWall());
    }

    private void addOpeningElement(IfcElement doorOrWindow) {
        IfcOpeningElement ifcOpeningElement = new IfcOpeningElement();
        ifcOpeningElement.setPredefinedType(IfcOpeningElementTypeEnum.OPENING);

        IfcRelVoidsElement relWallOpening = new IfcRelVoidsElement(GuidHandler.getNewIfcGloballyUniqueId(), getIfcElement(), ifcOpeningElement);
        getIfcElement().getHasOpenings().add(relWallOpening);
        ifcOpeningElement.getHasOpenings().add(relWallOpening);

        IfcRelFillsElement relOpeningDoorOrWindow = new IfcRelFillsElement(GuidHandler.getNewIfcGloballyUniqueId(), ifcOpeningElement, doorOrWindow);
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
