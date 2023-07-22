package com.example.firstproj02.model.exceptions;

public class ExpiredDiscountCodeException extends InvalidDiscountCodeException {   // fix - problem
    public ExpiredDiscountCodeException() {
        super(" - discount code not found");
    }

    public ExpiredDiscountCodeException(String subMessage) {
        super(subMessage);
    }

    public ExpiredDiscountCodeException(String superMessage, String subMessage) {
        super(superMessage, subMessage);
    }
}
