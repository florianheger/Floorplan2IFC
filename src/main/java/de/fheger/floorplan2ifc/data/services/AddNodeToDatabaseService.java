package de.fheger.floorplan2ifc.data.services;

import com.buildingsmart.tech.ifc.IfcKernel.IfcRoot;
import de.fheger.floorplan2ifc.data.Neo4J;
import de.fheger.floorplan2ifc.data.SaveToDBException;
import org.neo4j.driver.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddNodeToDatabaseService {
    private final Neo4J neo4J;

    @Autowired
    public AddNodeToDatabaseService(Neo4J neo4J) {
        this.neo4J = neo4J;
    }


    public void createNodeWithRootAttributes(IfcRoot ifcRoot) throws SaveToDBException {
        Query query = new Query("""
                CREATE (e:$type { GlobalId: $global_id, Name: $name, Description: $description }
                RETURN e
                """,
                Map.of("type", ifcRoot.getClass().getSimpleName(),
                        "global_id", ifcRoot.getGlobalId(),
                        "name", ifcRoot.getGlobalId(),
                        "description", ifcRoot.getDescription())
        );
        neo4J.executeQuery(query);
    }
}
