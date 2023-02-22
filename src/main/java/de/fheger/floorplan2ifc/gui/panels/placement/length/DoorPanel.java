package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import de.fheger.floorplan2ifc.gui.panels.placement.EntityPanelWithPlacement;
import de.fheger.floorplan2ifc.gui.panels.placement.SlabPanel;
import de.fheger.floorplan2ifc.gui.panels.placement.SpacePanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoorPanel extends EntityPanelWithLength {
    private final EntityMultiSelect<EntityPanelWithPlacement> connectedPanels = new EntityMultiSelect<>(Arrays.asList(SpacePanel.getSpaces(), SlabPanel.getSlabs()));

    public List<SpacePanel> getConnectedSpaces() {
        return getConnectedPanels(SpacePanel.class);
    }

    public List<SlabPanel> getConnectedSlabs() {
        return getConnectedPanels(SlabPanel.class);
    }

    private <PanelType extends EntityPanel> List<PanelType> getConnectedPanels(Class<PanelType> clazz) {
        List<PanelType> connectedPanels = new ArrayList<>();
        this.connectedPanels.getSelectedPanels().forEach(panel -> {
            if (clazz.isInstance(panel)) {
                connectedPanels.add(clazz.cast(panel));
            }
        });
        return connectedPanels;
    }

    public DoorPanel() {
        super("Door", 0);

        gridPane.add(UiFactory.createStandardLabel("Connects Spaces"), 0, ++rowsInEntityPanel);
        gridPane.add(connectedPanels, 1, rowsInEntityPanel);
    }
}
