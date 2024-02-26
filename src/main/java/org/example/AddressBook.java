package org.example;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AddressBook {
    private TreeMap<String, AddressEntry> entries;

    public AddressBook() {
        entries = new TreeMap<>();
    }

    // Add an AddressEntry
    public void addEntry(AddressEntry entry) {
        entries.put(entry.getLastName(), entry);
    }

    // Remove an AddressEntry by last name
    public boolean removeEntry(String lastName) {
        if(entries.containsKey(lastName)) {
            entries.remove(lastName);
            return true;
        }
        return false;
    }

    // Find entries by last name prefix
    public Set<Map.Entry<String, AddressEntry>> findEntry(String lastNamePrefix) {
        return entries.subMap(lastNamePrefix, lastNamePrefix + Character.MAX_VALUE).entrySet();
    }

    // List all entries in alphabetical order
    public Set<Map.Entry<String, AddressEntry>> listEntries() {
        return entries.entrySet();
    }
}
