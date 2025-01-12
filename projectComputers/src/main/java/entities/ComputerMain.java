
package entities;

//import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;


import static entities.OperatingSystem.OperatingSystemType.*;
import static entities.Storage.StorageType.*;



public class ComputerMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
         final Logger logger = LogManager.getLogger(ComputerMain.class);

        Device monitor = new Monitor("Samsung Solvd2024", "Samsung", 2022, 27);
        Device keyboard = new Keyboard("Keyboard Mechanical 123", "Logitech", 2021, true, "Mechanical");
        Device printer = new Printer("LaserJet 123", "HP", 2020, "Solvd Documentation");
        Storage storage = new Storage(SSDS, 512, 200);
        OperatingSystem os = new OperatingSystem(WINDOWS, "11");

        List<Device> devices = new ArrayList<>();
        devices.add(monitor);
        devices.add(keyboard);
        devices.add(printer);

        List<Storage> storageDevices = new ArrayList<>();
        storageDevices.add(storage);

        List<String> powerSources = new ArrayList<>();
        powerSources.add("AC Adapter");
        powerSources.add("Battery");

        List<String> installedApplications = new ArrayList<>();
        installedApplications.add("Google Chrome");
        installedApplications.add("Visual Studio Code");
        installedApplications.add("Microsoft Word");


        Set<String> userAccounts = new HashSet<>();
        userAccounts.add("admin");
        userAccounts.add("user1");
        userAccounts.add("guest");
        userAccounts.add("user2");
        userAccounts.add("user3");
        userAccounts.add("user4");

        Map<String, Integer> userLoginCounts = new HashMap<>();
        userLoginCounts.put("admin", 5);
        userLoginCounts.put("user1", 3);
        userLoginCounts.put("guest", 1);

        Computer computer = new Computer("MyComputer", os, devices, storageDevices, powerSources, installedApplications, userAccounts, userLoginCounts);
        // Turns the computer on using the lambda expression - the functional interface Powerable
        computer.handlePower(true);
        //computer.displayComputerDetails();
        
/*
        System.out.println();
        //stream
        Map.Entry<String, Integer> maxEntry = userLoginCounts.entrySet()
                .stream()
                .reduce((x, y) -> x.getValue() > y.getValue() ? x : y)
                .get();
        System.out.println("User with the highest logins: " + maxEntry.getKey() + " with " + maxEntry.getValue() + " logins");
        System.out.println();
        //stream
        int userCount = (int) userAccounts.stream()
                .filter(account -> account.toLowerCase().contains("user"))
                .count();
        System.out.println("User count: " + userCount);
        System.out.println();
        //stream
        int guestCount = (int) userAccounts.stream()
                .filter(account -> account.equalsIgnoreCase("guest"))
                .count();
        System.out.println("Guest count: " + guestCount);
        System.out.println();
        //stream
        int applicationCount = (int) installedApplications.stream().count();
        System.out.println("Number of installed applications: " + applicationCount);
        System.out.println();
        //stream
        System.out.println("Installed applications in upperCase");
        List<String> uppercaseInstalledApplications = installedApplications.stream()
                .map(String::toUpperCase) // Convert to uppercase
                .collect(Collectors.toList());
        System.out.println(uppercaseInstalledApplications);
        System.out.println();

 */






        /*
        // Updates the version using the lambda expression - the functional interface Updatable
        logger.info("Current Version: " + os.getVersion());
        os.performUpdate("12");
        logger.info("Updated Version: " + os.getVersion());

        System.out.println();

        // Connects the printer using the lambda expression - the functional interface Connectable
        ((Printer) printer).handleConnection(true);
        try {
            ((Printer) printer).printFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Disconnect the printer
        ((Printer) printer).handleConnection(false);
         */
/* EXCEPTIONS
    //Try-catch with resources
  //  System.out.println("\nPrinting with Try-With-Resources");
    try (Printer p = printer) {
        p.setConnectionStatus(true); // We don't simulate a connection issue
        p.connect();
    } catch (InvalidConnectionException e) {
        System.err.println("Error during connection: " + e.getMessage());
    }
        // Try-Catch
    // System.out.println("\nPrinting File with Exception Handling");
        try {
            printer.setHasPaper(false); // Simulate no paper
            printer.printFile();
        } catch (PrinterOutOfPaperException | NotReadableFileException e) {
            System.err.println("Error: " + e.getMessage());
        }
    //System.out.println("\nAdding Data to Storage");
        try {
            storage.addData(350); // Simulate adding more data than capacity
        } catch (StorageFullException e) {
            System.err.println("Error: " + e.getMessage());
        }
        // Throws
    //System.out.println("\nChecking Monitor Visibility");
        try {
            ((Monitor) monitor).turnOffMonitor(); // Simulate monitor off
            ((Monitor) monitor).checkVisibility();
        } catch (NotVisibleMonitorException e) {
            System.err.println("Error: " + e.getMessage());
        }
            */

        System.out.println();
        // Turn the computer off using the lambda expression - the functional interface Powerable
        computer.handlePower(false);

      //  Computer.showInstanceCount();
    }
}
