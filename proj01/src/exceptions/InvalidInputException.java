package exceptions;

abstract public class InvalidInputException extends Exception {
    // add another if needed
    public InvalidInputException(String subMessage) {
        super("Invalid input exception" + subMessage);
    }

    public InvalidInputException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
