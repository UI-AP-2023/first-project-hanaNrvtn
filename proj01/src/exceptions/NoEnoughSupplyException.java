package exceptions;

public class NoEnoughSupplyException extends InvalidShoppingCartFinalizationException {
    public NoEnoughSupplyException() {
        super("No enough supply");
    }

    public NoEnoughSupplyException(String subMessage) {
        super(subMessage);
    }

    public NoEnoughSupplyException(String superMessage, String subMessage) {
        super(superMessage, subMessage);
    }
}
