package entities;
import interfaces.DeviceIdentifiable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EqualsAndHashCode
@ToString
public final class Keyboard extends Device implements  DeviceIdentifiable {

    private static final Logger logger = LogManager.getLogger(Keyboard.class);
    protected final boolean backlit; // final variable (we can't change a keyboards's backlit, but the keyboard)
    protected final String keyboardType;


    public Keyboard(String name, String brand, int yearOfProduction, boolean backlit, String keyboardType) {
        super(name, brand, yearOfProduction);
        this.backlit = backlit;
        this.keyboardType = keyboardType;
    }

    @Override
    public void displayDeviceDetails() {
        logger.info("Keyboard: " + name + " | Brand: " + brand + " | Year of Production: " + yearOfProduction + " | Backlit: " + (backlit ? "Yes" : "No")+ " | Type: " + keyboardType);
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