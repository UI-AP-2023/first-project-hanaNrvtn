package com.example.firstproj02.model.exceptions;

public class NoEnoughCreditException extends InvalidShoppingCartFinalizationException {
    public NoEnoughCreditException() {
        super("No enough credit exception");
    }

    public NoEnoughCreditException(String superMessage) {
        super(superMessage);
    }

    public NoEnoughCreditException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
