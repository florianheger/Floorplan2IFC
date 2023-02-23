package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.EntityNodeWithChildren;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllIEntityPanelsOfType {
    public <PanelType extends EntityPanel> List<PanelType> getIfcEntityOfType(Class<PanelType> clazz, ProjectNode projectNode) {
        return getIfcEntityOfTypeRecursive(clazz, projectNode);
    }

    private <PanelType extends EntityPanel> List<PanelType> getIfcEntityOfTypeRecursive(Class<PanelType> clazz, EntityNode<?> entityNode) {
        List<PanelType> panels = new ArrayList<>();
        if (clazz.isInstance(entityNode.getEntityPanel())) {
            panels.add(clazz.cast(entityNode.getEntityPanel()));
        }
        if (entityNode instanceof EntityNodeWithChildren<?> entityNodeWithChildren) {
            entityNodeWithChildren.getEntityNodeChildren().forEach(
                    child -> panels.addAll(getIfcEntityOfTypeRecursive(clazz, child))
            );
        }
        return panels;
    }
}
