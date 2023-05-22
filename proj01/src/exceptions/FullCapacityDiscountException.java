package exceptions;

public class FullCapacityDiscountException extends InvalidDiscountCodeException{
    public FullCapacityDiscountException() {
        super("discount code not found");
    }

    public FullCapacityDiscountException(String subMessage) {
        super(subMessage);
    }

    public FullCapacityDiscountException(String superMessage, String subMessage) {
        super(superMessage, subMessage);
    }
}
