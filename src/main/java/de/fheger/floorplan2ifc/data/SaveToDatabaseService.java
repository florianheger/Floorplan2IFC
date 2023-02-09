package de.fheger.floorplan2ifc.data;

import com.buildingsmart.tech.ifc.IfcKernel.IfcObjectDefinition;
import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import com.buildingsmart.tech.ifc.IfcPlumbingFireProtectionDomain.IfcSanitaryTerminal;
import com.buildingsmart.tech.ifc.IfcProductExtension.*;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcDoor;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcWall;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcWindow;
import de.fheger.floorplan2ifc.data.helper.IfcProjectToListHelper;
import de.fheger.floorplan2ifc.data.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveToDatabaseService {
    private ProjectQueryService projectQueryService;
    private SiteQueryService siteQueryService;
    private BuildingQueryService buildingQueryService;
    private BuildingStoreyQueryService buildingStoreyQueryService;
    private WallQueryService wallQueryService;
    private DoorQueryService doorQueryService;
    private WindowQueryService windowQueryService;
    private OpeningElementQueryService openingElementQueryService;
    private SpaceQueryService spaceQueryService;
    private SanitaryTerminalQueryService sanitaryTerminalQueryService;

    private AddNodeToDatabaseService addNodeToDatabaseService;
    private IfcProjectToListHelper ifcProjectToListHelper;

    @Autowired
    public SaveToDatabaseService(ProjectQueryService projectQueryService, SiteQueryService siteQueryService, BuildingQueryService buildingQueryService,
                                 BuildingStoreyQueryService buildingStoreyQueryService, WallQueryService wallQueryService, DoorQueryService doorQueryService,
                                 WindowQueryService windowQueryService, OpeningElementQueryService openingElementQueryService, SpaceQueryService spaceQueryService,
                                 SanitaryTerminalQueryService sanitaryTerminalQueryService, AddNodeToDatabaseService addNodeToDatabaseService,
                                 IfcProjectToListHelper ifcProjectToListHelper) {
        this.projectQueryService = projectQueryService;
        this.siteQueryService = siteQueryService;
        this.buildingQueryService = buildingQueryService;
        this.buildingStoreyQueryService = buildingStoreyQueryService;
        this.wallQueryService = wallQueryService;
        this.doorQueryService = doorQueryService;
        this.windowQueryService = windowQueryService;
        this.openingElementQueryService = openingElementQueryService;
        this.spaceQueryService = spaceQueryService;
        this.sanitaryTerminalQueryService = sanitaryTerminalQueryService;
        this.addNodeToDatabaseService = addNodeToDatabaseService;
        this.ifcProjectToListHelper = ifcProjectToListHelper;
    }


    public void saveToDatabase(IfcProject ifcProject) throws SaveToDBException {
        List<IfcObjectDefinition> ifcElements = ifcProjectToListHelper.ifcProjectToList(ifcProject);
        saveNodes(ifcElements);
    }

    private void saveNodes(List<IfcObjectDefinition> ifcElements)
            throws SaveToDBException {
        for (IfcObjectDefinition ifcElement : ifcElements) {
            addNodeToDatabaseService.createNodeWithRootAttributes(ifcElement);
        }
    }

    private QueryService<?> getMatchingQueryService(IfcObjectDefinition ifcElement) throws SaveToDBException {
        if (ifcElement instanceof IfcProject) {
            return projectQueryService;
        }
        if (ifcElement instanceof IfcSite) {
            return siteQueryService;
        }
        if (ifcElement instanceof IfcBuilding) {
            return buildingQueryService;
        }
        if (ifcElement instanceof IfcBuildingStorey) {
            return buildingStoreyQueryService;
        }
        if (ifcElement instanceof IfcWall) {
            return wallQueryService;
        }
        if (ifcElement instanceof IfcDoor) {
            return doorQueryService;
        }
        if (ifcElement instanceof IfcWindow) {
            return windowQueryService;
        }
        if (ifcElement instanceof IfcOpeningElement) {
            return openingElementQueryService;
        }
        if (ifcElement instanceof IfcSpace) {
            return spaceQueryService;
        }
        if (ifcElement instanceof IfcSanitaryTerminal) {
            return sanitaryTerminalQueryService;
        }
        throw new SaveToDBException("Found unknwon IfcType: " + ifcElement.getClass().getSimpleName());
    }
}
