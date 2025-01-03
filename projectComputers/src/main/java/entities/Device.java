package entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// Abstract Class
public abstract class Device {
    protected String name;
    protected String brand;
    protected int yearOfProduction;

    public Device(String name, String brand, int yearOfProduction) {
        this.name = name;
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
    }

    public abstract void displayDeviceDetails();

}


