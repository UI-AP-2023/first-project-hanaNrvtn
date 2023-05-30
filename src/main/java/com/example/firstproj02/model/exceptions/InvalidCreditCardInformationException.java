package com.example.firstproj02.model.exceptions;

abstract public class InvalidCreditCardInformationException extends Exception{
    public InvalidCreditCardInformationException(String subMessage) {
        super("Invalid credit card information exception" + subMessage);
    }

    public InvalidCreditCardInformationException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
