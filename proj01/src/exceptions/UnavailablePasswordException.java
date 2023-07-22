package exceptions;

public class UnavailablePasswordException extends UnavailableInputException {
    public UnavailablePasswordException() {
        super("Unavailable password exception");
    }

    public UnavailablePasswordException(String subMessage) {
        super(subMessage);
    }

    public UnavailablePasswordException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
