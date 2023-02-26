package de.fheger.floorplan2ifc.gui.entityinterfaces;

import java.util.List;

public interface IEntity {
    String getName();

    String getGlobalId();

    String getDescription();

    boolean hasChildren();

    List<IEntity> getIEntityChildren();
}
