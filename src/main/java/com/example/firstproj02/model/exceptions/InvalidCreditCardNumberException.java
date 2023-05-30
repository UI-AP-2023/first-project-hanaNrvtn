package com.example.firstproj02.model.exceptions;

public class InvalidCreditCardNumberException extends InvalidCreditCardInformationException{
    public InvalidCreditCardNumberException() {
        super(" - Invalid credit card format exception");
    }

    public InvalidCreditCardNumberException(String subMessage) {
        super(subMessage);
    }

    public InvalidCreditCardNumberException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
