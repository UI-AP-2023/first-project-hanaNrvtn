package com.example.firstproj02.model.exceptions;

public class UnavailableEmailException extends UnavailableInputException {

    public UnavailableEmailException() {
        super("Unavailable email exception");
    }

    public UnavailableEmailException(String subMessage) {
        super(subMessage);
    }

    public UnavailableEmailException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
