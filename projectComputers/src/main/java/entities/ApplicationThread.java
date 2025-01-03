package entities;
import java.util.List;

class ApplicationThread extends Thread {
    private final List<String> applications;

    public ApplicationThread(List<String> applications) {
        this.applications = applications;
    }

    @Override
    public void run() {
        System.out.println("ApplicationThread is processing...");
        applications.forEach(app -> System.out.println("Application: " + app));
    }
}
