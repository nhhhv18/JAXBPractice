package interfaces;

@FunctionalInterface
public interface Connectable<T> {
    void changeConnectionState(T state);

    default void displayConnectionStatus() {
        System.out.println("Connection state has changed.");
    }
}