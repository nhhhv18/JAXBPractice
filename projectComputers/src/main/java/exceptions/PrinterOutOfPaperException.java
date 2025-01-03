package exceptions; 

public class PrinterOutOfPaperException extends Exception {
    public PrinterOutOfPaperException(String message) {
        super(message);
    }
}