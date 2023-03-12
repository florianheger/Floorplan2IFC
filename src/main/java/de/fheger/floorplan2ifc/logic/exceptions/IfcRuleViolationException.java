package de.fheger.floorplan2ifc.logic.exceptions;

/**
 * Thrown if the input has a rule violation.
 */
public class IfcRuleViolationException extends Exception {
    public IfcRuleViolationException(String message) {
        super(message);
    }
}
