package hibernate.exception;

public class CustomDaoException extends RuntimeException {
    public CustomDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
