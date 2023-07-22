package exceptions;

public class InvalidPhoneNumberException extends InvalidInputException {
    public InvalidPhoneNumberException() {
        super("Invalid phoneNumber format exception");
    }

    public InvalidPhoneNumberException(String subMessage) {
        super(subMessage);
    }

    public InvalidPhoneNumberException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
