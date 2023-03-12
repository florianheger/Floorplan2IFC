package de.fheger.floorplan2ifc.logic.exceptions;

/**
 * Thrown if the parsing to IFC failed.
 */
public class ParseToIfcException extends Exception {
    public ParseToIfcException(String message) {
        super(message);
    }
}
