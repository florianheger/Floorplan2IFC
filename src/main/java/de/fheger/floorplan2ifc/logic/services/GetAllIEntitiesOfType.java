package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.interfaces.IEntity;
import de.fheger.floorplan2ifc.interfaces.IProject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Get all IEntity objects of defined type.
 */
@Service
public class GetAllIEntitiesOfType {
    /**
     * Get all IEntity objects of type defined by <i>IEntityType</i>.
     * @param clazz The searched IEntity type as Class object.
     * @param project The corresponding IProject. Provides a starting point for the search.
     * @return A List of all IEntity of type <i>clazz</i>
     * @param <IEntityType> The searched IEntity type.
     */
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
