/**
 * Thrown to indicate that the limits of a range are not valid.
 */
public class IllegalLimitException extends IllegalArgumentException {
    public IllegalLimitException(String message) {
        super(message);
    }
}