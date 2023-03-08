package de.fheger.floorplan2ifc.models.placements.objectplacement;

import de.fheger.floorplan2ifc.models.placements.IfcObjectPlacement;
import lombok.Getter;

@SuppressWarnings("ALL")
public class IfcLocalPlacement extends IfcObjectPlacement {
    @Getter
    private final double posX;
    @Getter
    private final double posY;
    @Getter
    private final double posZ;

    public IfcLocalPlacement(double posX, double posY, double posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
}
