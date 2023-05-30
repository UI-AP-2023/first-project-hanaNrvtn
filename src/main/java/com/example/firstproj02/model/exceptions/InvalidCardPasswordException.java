package com.example.firstproj02.model.exceptions;

public class InvalidCardPasswordException extends InvalidCreditCardInformationException{
    public InvalidCardPasswordException() {
        super(" - Invalid card password format exception");
    }

    public InvalidCardPasswordException(String subMessage) {
        super(subMessage);
    }

    public InvalidCardPasswordException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
