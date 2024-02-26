package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private AddressBook addressBook;
    private Scanner scanner;

    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        String choice = "";
        while (!choice.equals("f")) {
            System.out.println("Menu:");
            System.out.println("a) Load entries from a file");
            System.out.println("b) Add an entry");
            System.out.println("c) Remove an entry");
            System.out.println("d) Find an entry");
            System.out.println("e) List all entries");
            System.out.println("f) Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "a":
                    loadFromFile();
                    break;
                case "b":
                    addEntry();
                    break;
                case "c":
                    removeEntry();
                    break;
                case "d":
                    findEntry();
                    break;
                case "e":
                    listEntries();
                    break;
                case "f":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void addEntry() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter zip: ");
        String zip = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
        addressBook.addEntry(entry);
        System.out.println("Entry added successfully.");
    }


    private void removeEntry() {
        System.out.println("Enter last name of the entry to remove: ");
        String lastName = scanner.nextLine();
        if (addressBook.removeEntry(lastName)) {
            System.out.println("Entry removed successfully.");
        } else {
            System.out.println("No entry found with that last name.");
        }
    }

    private void findEntry() {
        System.out.println("Enter the beginning of the last name to search for: ");
        String prefix = scanner.nextLine();
        var entries = addressBook.findEntry(prefix);
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            for (Map.Entry<String, AddressEntry> entry : entries) {
                System.out.println(entry.getValue());
            }
        }
    }

    private void listEntries() {
        var entries = addressBook.listEntries();
        for (Map.Entry<String, AddressEntry> entry : entries) {
            System.out.println(entry.getValue());
        }
    }
    private void loadFromFile() {
        System.out.print("Enter the filename to load from (including .txt extension): ");
        String filename = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Assuming the file is correctly formatted and has exactly 8 fields per line
                if (values.length == 8) {
                    AddressEntry entry = new AddressEntry(values[0].trim(), values[1].trim(), values[2].trim(), values[3].trim(),
                            values[4].trim(), values[5].trim(), values[6].trim(), values[7].trim());
                    addressBook.addEntry(entry);
                }
            }
            System.out.println("Entries loaded successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while loading entries: " + e.getMessage());
        }
    }

}
