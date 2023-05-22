package exceptions;

abstract public class InvalidShoppingCartFinalizationException extends Exception {
    // add another if needed
    public InvalidShoppingCartFinalizationException(String subMessage) {
        super("Invalid finalization shopping card - " + subMessage);
    }

    public InvalidShoppingCartFinalizationException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
