package nl.novi.Eindopdracht.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;


    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message) {
        super(message);
    }


    public AccountNotFoundException(String resourceName, String fieldName,String fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName =resourceName;
        this.fieldName = fieldName;
        this.fieldValue =fieldName;

    }


}



