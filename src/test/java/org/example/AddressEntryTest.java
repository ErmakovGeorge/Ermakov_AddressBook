package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {
    private AddressEntry entry;

    @BeforeEach
    void setUp() {
        // Initialize with some default values
        entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "Anystate", "12345", "john.doe@example.com", "555-1234");
    }

    @Test
    void getFirstName() {
        assertEquals("John", entry.getFirstName());
    }

    @Test
    void setFirstName() {
        entry.setFirstName("Jane");
        assertEquals("Jane", entry.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Doe", entry.getLastName());
    }

    @Test
    void setLastName() {
        entry.setLastName("Smith");
        assertEquals("Smith", entry.getLastName());
    }

    @Test
    void getStreet() {
        assertEquals("123 Main St", entry.getStreet());
    }

    @Test
    void setStreet() {
        entry.setStreet("456 Elm St");
        assertEquals("456 Elm St", entry.getStreet());
    }

    @Test
    void getCity() {
        assertEquals("Anytown", entry.getCity());
    }

    @Test
    void setCity() {
        entry.setCity("Othertown");
        assertEquals("Othertown", entry.getCity());
    }

    @Test
    void getState() {
        assertEquals("Anystate", entry.getState());
    }

    @Test
    void setState() {
        entry.setState("Otherstate");
        assertEquals("Otherstate", entry.getState());
    }

    @Test
    void getZip() {
        assertEquals("12345", entry.getZip());
    }

    @Test
    void setZip() {
        entry.setZip("54321");
        assertEquals("54321", entry.getZip());
    }

    @Test
    void getEmail() {
        assertEquals("john.doe@example.com", entry.getEmail());
    }

    @Test
    void setEmail() {
        entry.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", entry.getEmail());
    }

    @Test
    void getPhone() {
        assertEquals("555-1234", entry.getPhone());
    }

    @Test
    void setPhone() {
        entry.setPhone("555-5678");
        assertEquals("555-5678", entry.getPhone());
    }

    @Test
    void testToString() {
        // Assuming toString is overridden to concatenate basic info
        String expected = "John Doe, 123 Main St, Anytown, Anystate, 12345, john.doe@example.com, 555-1234";
        assertEquals(expected, entry.toString());
    }
}
