package com.example.firstproj02.model.exceptions;

public class UnavailableDiscountCodeException extends InvalidDiscountCodeException {
    public UnavailableDiscountCodeException() {
        super(" - discount code not found");
    }

    public UnavailableDiscountCodeException(String subMessage) {
        super(subMessage);
    }

    public UnavailableDiscountCodeException(String superMessage, String subMessage) {
        super(superMessage, subMessage);
    }
}
