package de.fheger.floorplan2ifc.interfaces;

import java.util.List;

public interface IEntity {
    String getName();

    String getGlobalId();

    String getDescription();

    boolean hasChildren();

    List<IEntity> getIEntityChildren();
}
