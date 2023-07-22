package com.example.firstproj02.model.exceptions;

public class InvalidEmailException extends InvalidInputException {
    public InvalidEmailException() {
        super(" - Invalid email format exception");
    }

    public InvalidEmailException(String subMessage) {
        super(subMessage);
    }

    public InvalidEmailException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
