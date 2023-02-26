package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.entityinterfaces.IEntity;
import de.fheger.floorplan2ifc.gui.entityinterfaces.IProject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllIEntityPanelsOfType {
    public <IEntityType extends IEntity> List<IEntityType> getIfcEntityOfType(Class<IEntityType> clazz, IProject project) {
        return getIfcEntityOfTypeRecursive(clazz, project);
    }

    private <IEntityType extends IEntity> List<IEntityType> getIfcEntityOfTypeRecursive(Class<IEntityType> clazz, IEntity entity) {
        List<IEntityType> iEntities = new ArrayList<>();
        if (clazz.isInstance(entity)) {
            iEntities.add(clazz.cast(entity));
        }
        if (entity.hasChildren()) {
            entity.getIEntityChildren().forEach(
                    child -> iEntities.addAll(getIfcEntityOfTypeRecursive(clazz, child))
            );
        }
        return iEntities;
    }
}
