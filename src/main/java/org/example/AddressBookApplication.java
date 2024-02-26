package org.example;

public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu(addressBook);
        menu.displayMenu();
    }
}
