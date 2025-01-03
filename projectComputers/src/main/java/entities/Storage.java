package entities;
import exceptions.StorageFullException;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EqualsAndHashCode
@ToString
public class Storage {

    private static final Logger logger = LogManager.getLogger(Storage.class);

    public enum StorageType {
        RAM("Random Access Memory"),
        CACHE_MEMORY("Cache Memory"),
        REGISTERS("Registers"),
        HDDS("Hard Disk Drives"),
        SSDS("Solid State Drives"),
        NVME_DRIVES("NVMe Drives"),
        EMMC("Embedded MultiMediaCard"),
        SSHDS("Solid State Hybrid Drives");

        private final String description;

        StorageType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void displayDetails() {
            System.out.println(this.name() + " - " + description);
        }
    }

    private StorageType type;
    private int capacity;
    private int usedSpace;

    public Storage(StorageType type, int capacity, int usedSpace) {
        this.type = type;
        this.capacity = capacity;
        this.usedSpace = usedSpace;
    }

    public StorageType getType() {
        return type;
    }

    public void setType(StorageType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(int usedSpace) {
        this.usedSpace = usedSpace;
    }

    public void displayStorageDetails() {
        logger.info("Storage Type: " + type + "(" + getType().getDescription() + "), Capacity: " + capacity + "GB, Used Space: " + usedSpace + "GB");
    }

    public void addData(int dataSize) throws StorageFullException {
        if (usedSpace + dataSize > capacity) {
            throw new StorageFullException("Storage is full. Cannot add " + dataSize + "GB of data.");
        }
        usedSpace += dataSize;
        logger.info(dataSize + "GB of data added successfully.");
    }
}