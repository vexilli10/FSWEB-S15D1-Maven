package org.example.mobile;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }
    public ArrayList<Contact> getMyContacts() {
        // dışarıdan değiştirilmemesi için kopya dönebiliriz
        return new ArrayList<>(myContacts);
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists: " + contact.getName());
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " not found.");
            return false;
        }
        if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update failed.");
            return false;
        }
        myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " not found.");
            return false;
        }
        myContacts.remove(foundPosition);
        return true;
    }

    private int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int idx = findContact(name);
        return (idx >= 0) ? myContacts.get(idx) : null;
    }

    public void printContacts() {
        System.out.println("\nContact List:");
        for (Contact c : myContacts) {
            System.out.println(c.getName() + " -> " + c.getPhoneNumber());
        }
        System.out.println();
    }
}
