package exceptions;

public class InvalidPasswordException extends InvalidInputException {
    public InvalidPasswordException() {
        super("Invalid password format exception");
    }

    public InvalidPasswordException(String subMessage) {
        super(subMessage);
    }

    public InvalidPasswordException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
