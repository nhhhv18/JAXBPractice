package interfaces;

@FunctionalInterface
public interface Powerable<T> {
    void changePowerState(T state);

    default void displayPowerStatus() {
        System.out.println("Power state has been changed.");
    }
}
