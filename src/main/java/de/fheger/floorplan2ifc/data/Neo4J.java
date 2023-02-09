package de.fheger.floorplan2ifc.data;

import org.neo4j.driver.*;
import org.neo4j.driver.exceptions.Neo4jException;
import org.springframework.stereotype.Component;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Neo4J implements AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(Neo4J.class.getName());
    private final Driver driver;

    public Neo4J() {
        String uri = "neo4j+s://b98b0b0e.databases.neo4j.io";
        String user = "neo4j";
        String password = "e6fpVCR5YTJ6A2RBsURG-6K2MUjewpEJTlrpLxSQmoM";
        Config config = Config.defaultConfig();
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password), config);
    }

    public void executeQuery(Query query) throws SaveToDBException {
        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            session.executeWrite(tx -> tx.run(query).single());
        } catch (Neo4jException ex) {

            throw new SaveToDBException("Exceptiojn in Neo4J: " + ex.getMessage());

        }
    }

    public void createFriendship(final String person1Name, final String person2Name) {

        // To learn more about the Cypher syntax, see https://neo4j.com/docs/cypher-manual/current/

        // The Reference Card is also a good resource for keywords https://neo4j.com/docs/cypher-refcard/current/

        var query = new Query(

                """

                        CREATE (p1:Person { name: $person1_name })

                        CREATE (p2:Person { name: $person2_name })

                        CREATE (p1)-[:KNOWS]->(p2)

                        RETURN p1, p2

                        """,

                Map.of("person1_name", person1Name, "person2_name", person2Name));


        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {

            // Write transactions allow the driver to handle retries and transient errors

            var record = session.executeWrite(tx -> tx.run(query).single());

            System.out.printf(

                    "Created friendship between: %s, %s%n",

                    record.get("p1").get("name").asString(),

                    record.get("p2").get("name").asString());

            // You should capture any errors along with the query and data for traceability

        } catch (Neo4jException ex) {

            LOGGER.log(Level.SEVERE, query + " raised an exception", ex);

            throw ex;

        }

    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public static void main(String[] args) {
        new Neo4J().createFriendship("Fynn", "Flo");
    }
}
