package nl.novi.Eindopdracht.Exceptions;

public class InspectionNotFoundException extends RuntimeException{

    public InspectionNotFoundException() {
    }

    public InspectionNotFoundException(String message) {
        super(message);
    }
}
