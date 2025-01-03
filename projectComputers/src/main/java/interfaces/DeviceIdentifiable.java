package interfaces;

public interface DeviceIdentifiable {
    String getDeviceName();
    String getDeviceBrand();
    
    default void displayIdentifier() {
        System.out.println("Device Name: " + getDeviceName() + ", Brand: " + getDeviceBrand());
    }
}