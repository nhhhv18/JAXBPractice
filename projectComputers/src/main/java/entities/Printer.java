package entities;
import interfaces.Connectable;
import interfaces.DeviceIdentifiable;
import exceptions.PrinterOutOfPaperException;
import exceptions.NotReadableFileException;
import exceptions.InvalidConnectionException;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@EqualsAndHashCode
@ToString
public final class Printer extends Device implements DeviceIdentifiable, AutoCloseable {

    private static final Logger logger = LogManager.getLogger(Printer.class);
    public String file;
    private boolean hasPaper;
    private boolean isConnected;


    public Printer(String name, String brand, int yearOfProduction, String file) {
        super(name, brand, yearOfProduction);
        this.file = file;
        this.hasPaper = true; // Assume printer starts with paper
    }

    public void handleConnection(Boolean state) {
        // Lambda implementation for Connectable with Boolean type
        Connectable<Boolean> connectionHandler = s -> {
            if (s) {
                logger.info("The printer " + name + " is now CONNECTED.");
                isConnected = true;
            } else {
                logger.info("The printer " + name + " is now DISCONNECTED.");
                isConnected = false;
            }
        };

        connectionHandler.changeConnectionState(state);
     //   connectionHandler.displayConnectionStatus();
    }

    public void printFile() throws PrinterOutOfPaperException, NotReadableFileException {
        if (!hasPaper) {
            throw new PrinterOutOfPaperException("Printer is out of paper.");
        }
        if (file == null || file.isEmpty()) {
            throw new NotReadableFileException("File to print is not readable.");
        }
        logger.info("The file \"" + file + "\" has been printed successfully.");
    }

    public void connect() throws InvalidConnectionException {
        // Simulate a failed connection
        if (!isConnected) {
            throw new InvalidConnectionException("Printer failed to connect.");
        }
        logger.info("The printer " + name + " is connected.");
    }


    public void setHasPaper(boolean hasPaper) {
        this.hasPaper = hasPaper;
    }
    
    @Override
    public void displayDeviceDetails() {
        logger.info("Printer: " + name + " | Brand: " + brand + " | Year of Production: " + yearOfProduction);
    }

    @Override
    public String getDeviceName() {
        return name;
    }

    @Override
    public String getDeviceBrand() {
        return brand;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    @Override
    public void close() {
        if (isConnected) {
            handleConnection(false); // Disconnect using the lambda
        }
    }

    public void setConnectionStatus(boolean status) {
        this.isConnected = status;
    }

}
