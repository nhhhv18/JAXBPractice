package entities;
import interfaces.DeviceIdentifiable;
import exceptions.NotVisibleMonitorException;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EqualsAndHashCode
@ToString
public final class Monitor extends Device implements  DeviceIdentifiable {

    private static final Logger logger = LogManager.getLogger(Monitor.class);
    protected final int size;  // final variable (we can't change a monitor's size, but the monitor)
    private boolean isOn;

    public Monitor(String name, String brand, int yearOfProduction, int size) {
        super(name, brand, yearOfProduction);
        this.size = size;
        this.isOn = true; // Assume monitor starts on
    }

    public void checkVisibility() throws NotVisibleMonitorException {
        if (!isOn) {
            throw new NotVisibleMonitorException("The monitor is not visible because it is off.");
        }
    }

    public void turnOffMonitor() {
        this.isOn = false;
    }

    @Override
    public void displayDeviceDetails() {
        logger.info("Monitor: " + name + " | Brand: " + brand + " | Year of Production: " + yearOfProduction + " | Size: " + size + " inches");
    }

    @Override
    public String getDeviceName() {
        return name;
    }

    @Override
    public String getDeviceBrand() {
        return brand;

    }

}