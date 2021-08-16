package pl.internal.hs.wholesale.exception;

public class NotFoundCurrency extends RuntimeException {
    public NotFoundCurrency(String message) {
        super(message);
    }
}
