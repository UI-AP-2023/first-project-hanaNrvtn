package exceptions;

public class NotFoundDiscountCodeException extends InvalidDiscountCodeException{
    public NotFoundDiscountCodeException() {
        super("discount code not found");
    }

    public NotFoundDiscountCodeException(String subMessage) {
        super(subMessage);
    }

    public NotFoundDiscountCodeException(String superMessage, String subMessage) {
        super(superMessage, subMessage);
    }
}
