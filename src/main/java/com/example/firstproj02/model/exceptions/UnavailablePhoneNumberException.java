package com.example.firstproj02.model.exceptions;

public class UnavailablePhoneNumberException extends UnavailableEmailException {
    public UnavailablePhoneNumberException() {
        super("Unavailable phone number exception");
    }

    public UnavailablePhoneNumberException(String subMessage) {
        super(subMessage);
    }

    public UnavailablePhoneNumberException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
