package entities;

import interfaces.Powerable;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@EqualsAndHashCode
@ToString
public class Computer {

    private static final Logger logger = LogManager.getLogger(Computer.class);

    private String computerName;
    private OperatingSystem operatingSystem;
    private List<Device> devices;  // List of devices (Monitor, Keyboard, Printer)
    private List<Storage> storageDevices;  // List of storage devices
    private List<String> powerSources;
    private List<String> installedApplications;
    private Set<String> userAccounts; // Custom Linked List for User Accounts
    private Map<String, Integer> userLoginCounts;


   /*  private static int instanceCount;
    static {
        // Static block 
        instanceCount = 0;
        logger.info("Computer class loaded.");
    }   */

    public Computer(String computerName, OperatingSystem operatingSystem, List<Device> devices, List<Storage> storageDevices) {
        this.computerName = computerName;
        this.operatingSystem = operatingSystem;
        this.devices = devices;
        this.storageDevices = storageDevices;
       // instanceCount++;
    }

    public Computer(String computerName, OperatingSystem operatingSystem, 
    List<Device> devices, List<Storage> storageDevices, 
    List<String> powerSources, List<String> installedApplications,
    Set<String> userAccounts, Map<String, Integer> userLoginCounts) {
        this.computerName = computerName;
        this.operatingSystem = operatingSystem;
        this.devices = devices;
        this.storageDevices = storageDevices;
        this.powerSources = powerSources;
        this.installedApplications = installedApplications;
        this.userAccounts = userAccounts;
        this.userLoginCounts = userLoginCounts;
      //  instanceCount++;
    }

    /* public void setUserLoginCounts(Map<String, Integer> userLoginCounts) {
        this.userLoginCounts = userLoginCounts;
    } */

    /* public static void showInstanceCount() {

        logger.info("Number of computers created: " + instanceCount);
    } */

    public void handlePower(Boolean state) {
        Powerable<Boolean> powerHandler = s -> {
            if (s) {
                logger.info("The computer "+ computerName +" is ON.");
            } else {
                logger.info("The computer "+ computerName +" is OFF.");
            }
        };
        powerHandler.changePowerState(state);
       // powerHandler.displayPowerStatus();
    }

    public void displayComputerDetails() {
        System.out.println();
        logger.info("Computer Name: " + computerName);
    //    operatingSystem.update(operatingSystem.getVersion()); // Polymorphism with OS

        //Streams
        System.out.println();
        System.out.println("Computer Devices:");
        devices.stream().forEach( x -> System.out.println(x.toString()));
        System.out.println();
        System.out.println("Storage Devices:");
        storageDevices.stream().forEach( x -> System.out.println(x.toString()));
        System.out.println();
        System.out.println("Power Sources:");
        powerSources.stream().forEach( x -> System.out.println(x.toString()));
        System.out.println();
        System.out.println("Installed applications:");
        installedApplications.stream().forEach( x -> System.out.println(x.toString()));
        System.out.println();
     /*
        for (Device device : devices) {
            device.displayDeviceDetails();
        }
         for (Storage storage : storageDevices) {
            storage.displayStorageDetails();
        }
      */

        /*Custom LinkedList
            if (powerSources != null) {
                logger.info("Power Sources: ");
                powerSources.printList();
            } else {
                logger.warn("Power Sources: Not Available");
            }

        if (installedApplications != null) {
            logger.info("Installed Applications: ");
            installedApplications.printList();
        } else {
            logger.warn("Installed Applications: Not Available");
        }

         */

      /*  System.out.println();
            if (userAccounts != null) {
                logger.info("User Accounts: " + userAccounts);
            } else {
                logger.warn("User Accounts: Not Available");
            }

        for (UserRole role : UserRole.values()) {

            for (String account : userAccounts) {

                if (account.toLowerCase().contains(role.getRoleName().toLowerCase())) {

                    System.out.println(account + " is a " + role.getDescription());
                    break;
                }
            }
        }
        System.out.println();

            // Display user login counts
            if (userLoginCounts != null) {
                logger.info("User Login Counts:");
                userLoginCounts.forEach((user, count) ->
                        logger.info("  " + user + ": " + count + " logins"));
            } else {
                logger.warn("User Login Counts: Not Available");
            }

       */



    }
    }