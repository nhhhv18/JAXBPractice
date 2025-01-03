package entities;
import interfaces.Updatable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@EqualsAndHashCode
@ToString
public class OperatingSystem {

    private static final Logger logger = LogManager.getLogger(OperatingSystem.class);

    //Lets imagine that our computers can only maintain following types of operating system:
    public enum OperatingSystemType {
        WINDOWS,
        MACOS,
        LINUX;
    }

    private OperatingSystemType name;
    private String version;

    public OperatingSystem(OperatingSystemType name, String version) {
        this.name = name;
        this.version = version;
    }

    public OperatingSystemType getName() {
        return name;
    }

    public void setName(OperatingSystemType name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void performUpdate(String newVersion) {
        // Lambda expression using the generic Updatable interface
        Updatable<String> updater = v -> {
            this.version = v;
          //  logger.info("Operating System updated to version: " + name + " " + v);
        };
        updater.update(newVersion);
    }
}
