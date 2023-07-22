package com.example.firstproj02.model.exceptions;

public class UnavailableUserNameException extends UnavailableInputException {
    public UnavailableUserNameException() {
        super("Unavailable user name exception");
    }

    public UnavailableUserNameException(String subMessage) {
        super(subMessage);
    }

    public UnavailableUserNameException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
