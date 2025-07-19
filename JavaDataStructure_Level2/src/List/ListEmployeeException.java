package List;

public class ListEmployeeException extends RuntimeException {
    public ListEmployeeException() {
        super();
    }

    public ListEmployeeException(String message) {
        super(message);
    }

    public ListEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListEmployeeException(Throwable cause) {
        super(cause);
    }
}
