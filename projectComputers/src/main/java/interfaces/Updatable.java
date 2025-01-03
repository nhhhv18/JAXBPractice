package interfaces;

@FunctionalInterface
public interface Updatable<T> {
    void update(T value);

    default void notifyUpdate() {
        System.out.println("The new version has been updated successfully.");
    }
}
