package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcPlumbingFireProtectionDomain.IfcSanitaryTerminal;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
public class SanitaryTerminalQueryService extends QueryService<IfcSanitaryTerminal> {
    @Override
    public Query addTypeRelatedInformation(IfcSanitaryTerminal ifcElement) {
        return null;
    }

    @Override
    public Query addRelationships(IfcSanitaryTerminal ifcElement) {
        return null;
    }
}
