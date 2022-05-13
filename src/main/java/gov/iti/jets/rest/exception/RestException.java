package gov.iti.jets.rest.exception;

public class RestException extends Throwable {
    private  String message;
    private Exception exception;

    public RestException(String message, Exception exception) {
        this.message = message;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
