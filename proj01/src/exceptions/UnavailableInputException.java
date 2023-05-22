package exceptions;

abstract public class UnavailableInputException extends Exception {
    public UnavailableInputException(String subMessage) {
        super("Unavailable input exception - " + subMessage);
    }

    public UnavailableInputException(String superMessage, String subMessage) {
        super(subMessage + " - " + subMessage);
    }
}
