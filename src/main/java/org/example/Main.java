package org.example;

import org.example.models.Grocery;
import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;

public class Main {
    public static void main(String[] args) {
        // --- Grocery App Başlat ---
        Grocery.startGrocery();

        // --- Mobile Phone Testleri ---
        MobilePhone phone = new MobilePhone("555-1234");
        Contact bob   = Contact.createContact("Bob",   "31415926");
        Contact alice = Contact.createContact("Alice", "16180339");
        Contact tom   = Contact.createContact("Tom",   "11235813");

        phone.addNewContact(bob);
        phone.addNewContact(alice);
        phone.addNewContact(tom);

        phone.printContacts();

        Contact jane = Contact.createContact("Jane", "23571113");
        phone.addNewContact(jane);

        phone.printContacts();

        phone.updateContact(alice, Contact.createContact("Alice", "99999999"));
        phone.printContacts();

        phone.removeContact(tom);
        phone.printContacts();
    }
}
