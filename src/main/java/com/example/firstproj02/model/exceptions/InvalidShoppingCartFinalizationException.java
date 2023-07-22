package com.example.firstproj02.model.exceptions;

abstract public class InvalidShoppingCartFinalizationException extends Exception {
    public InvalidShoppingCartFinalizationException(String subMessage) {
        super("Invalid finalization shopping card - " + subMessage);
    }

    public InvalidShoppingCartFinalizationException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
