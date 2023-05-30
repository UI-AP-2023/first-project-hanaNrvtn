package com.example.firstproj02.model.exceptions;

abstract public class InvalidInputException extends Exception {
    public InvalidInputException(String subMessage) {
        super("Invalid input exception" + subMessage);
    }

    public InvalidInputException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
