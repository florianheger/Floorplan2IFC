package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.interfaces.IEntity;
import de.fheger.floorplan2ifc.interfaces.IProject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllIEntitiesOfType {
    public <IEntityType extends IEntity> List<IEntityType> getIEntitiesOfType(Class<IEntityType> clazz, IProject project) {
        return getIEntitiesOfTypeRecursive(clazz, project);
    }

    private <IEntityType extends IEntity> List<IEntityType> getIEntitiesOfTypeRecursive(Class<IEntityType> clazz, IEntity entity) {
        List<IEntityType> iEntities = new ArrayList<>();
        if (clazz.isInstance(entity)) {
            iEntities.add(clazz.cast(entity));
        }
        if (entity.hasChildren()) {
            entity.getIEntityChildren().forEach(
                    child -> iEntities.addAll(getIEntitiesOfTypeRecursive(clazz, child))
            );
        }
        return iEntities;
    }
}
