package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Redirect System.out to capture output
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut); // Reset System.out to its original
    }

    @Test
    void displayMenu() {
        AddressBook addressBook = new AddressBook(); // Create an AddressBook instance
        Menu menu = new Menu(addressBook); // Pass the AddressBook instance to the Menu constructor
        menu.displayMenu();

        String expectedOutput = "Your expected menu output here"; // Replace this with the actual expected output
        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput));
    }
}
