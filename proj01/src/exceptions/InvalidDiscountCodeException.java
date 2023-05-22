package exceptions;

abstract public class InvalidDiscountCodeException extends Exception {
    public InvalidDiscountCodeException(String subMessage) {
        super("Invalid discount code exception - " + subMessage);
    }

    public InvalidDiscountCodeException(String superMessage, String subMessage) {
        super(superMessage + "-" + subMessage);
    }
}
