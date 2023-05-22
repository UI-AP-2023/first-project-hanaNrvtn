package exceptions;

public class UnavailableEmailException extends InvalidInputException {
    public UnavailableEmailException() {
        super("Unavailable email exception");
    }

    public UnavailableEmailException(String subMessage) {
        super(subMessage);
    }

    public UnavailableEmailException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
