package com.example.firstproj02.model.exceptions;

public class InvalidCVV2Exception extends InvalidCreditCardInformationException {
    public InvalidCVV2Exception() {
        super(" - Invalid CVV2 format exception");
    }

    public InvalidCVV2Exception(String subMessage) {
        super(subMessage);
    }

    public InvalidCVV2Exception(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
