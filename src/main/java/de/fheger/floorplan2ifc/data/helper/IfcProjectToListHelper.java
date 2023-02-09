package de.fheger.floorplan2ifc.data.helper;

import com.buildingsmart.tech.ifc.IfcKernel.IfcObjectDefinition;
import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import com.buildingsmart.tech.ifc.IfcKernel.IfcRoot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IfcProjectToListHelper {
    public List<IfcObjectDefinition> ifcProjectToList(IfcObjectDefinition ifcElement) {
        List<IfcObjectDefinition> elements = new ArrayList<>();
        elements.add(ifcElement);
        ifcElement.getIsDecomposedBy().forEach(
                relAggregates -> relAggregates.getRelatedObjects().forEach(
                        e ->elements.addAll(ifcProjectToList(e))
                )
        );
        return elements;
    }
}