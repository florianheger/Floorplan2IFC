package de.fheger.floorplan2ifc.logic.exceptions;

/**
 * Thrown in case of a database error.
 */
public class SaveToDatabaseException extends Exception {
    public SaveToDatabaseException(String message) {
        super(message);
    }
}
