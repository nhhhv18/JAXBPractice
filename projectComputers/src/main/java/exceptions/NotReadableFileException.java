package exceptions;

public class NotReadableFileException extends Exception {
    public NotReadableFileException(String message) {
        super(message);
    }
}