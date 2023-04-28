package nl.novi.Eindopdracht.Exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
