package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    AddressBook addressBook;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    void addEntry() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "Anystate", "12345", "john.doe@example.com", "123-456-7890");
        addressBook.addEntry(entry);
        assertEquals(1, addressBook.listEntries().size());
        assertTrue(addressBook.listEntries().stream().anyMatch(e -> e.getValue().equals(entry)));
    }

    @Test
    void removeEntry() {
        AddressEntry entry = new AddressEntry("Jane", "Doe", "456 Elm St", "Othertown", "Otherstate", "67890", "jane.doe@example.com", "098-765-4321");
        addressBook.addEntry(entry);
        boolean removed = addressBook.removeEntry("Doe");
        assertTrue(removed);
        assertEquals(0, addressBook.listEntries().size());
    }

    @Test
    void findEntry() {
        AddressEntry entry1 = new AddressEntry("John", "Smith", "123 Main St", "Anytown", "Anystate", "12345", "john.smith@example.com", "123-456-7890");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Elm St", "Othertown", "Otherstate", "67890", "jane.doe@example.com", "098-765-4321");
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);
        Set<Map.Entry<String, AddressEntry>> results = addressBook.findEntry("Smi");
        assertEquals(1, results.size());
        assertTrue(results.stream().anyMatch(e -> e.getKey().equals("Smith")));
    }

    @Test
    void listEntries() {
        AddressEntry entry1 = new AddressEntry("John", "Smith", "123 Main St", "Anytown", "Anystate", "12345", "john.smith@example.com", "123-456-7890");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Elm St", "Othertown", "Otherstate", "67890", "jane.doe@example.com", "098-765-4321");
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);
        Set<Map.Entry<String, AddressEntry>> entries = addressBook.listEntries();
        assertEquals(2, entries.size());
        assertTrue(entries.stream().anyMatch(e -> e.getKey().equals("Smith")));
        assertTrue(entries.stream().anyMatch(e -> e.getKey().equals("Doe")));
    }
}
