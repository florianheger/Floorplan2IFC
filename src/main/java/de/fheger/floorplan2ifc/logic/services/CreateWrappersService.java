package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.gui.nodes.ElementNodeWithChilds;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.*;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateWrappersService {

    public Wrapper<?, ?>[] createWrappers(ProjectNode projectNode)
            throws ParseToIfcException {
        List<Wrapper<?, ?>> wrapper = new ArrayList<>();
        createWrappersRecursive(projectNode, wrapper);
        return wrapper.toArray(new Wrapper<?, ?>[0]);
    }

    private void createWrappersRecursive(ElementNode<?> currentNode, List<Wrapper<?, ?>> wrapper)
            throws ParseToIfcException {
        wrapper.add(Wrapper.getMatchingWrapper(currentNode));
        if (!(currentNode instanceof ElementNodeWithChilds<?> currentNodeWithChilds)) {
            return;
        }
        for (ElementNode<?> child : currentNodeWithChilds.getElementNodeChildren()) {
            createWrappersRecursive(child, wrapper);
        }
    }
}
