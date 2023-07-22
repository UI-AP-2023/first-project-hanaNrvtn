package exceptions;

public class UnavailablePhoneNumberException extends InvalidInputException {
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
