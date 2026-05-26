package JAVA.Day6;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    // ArrayList — dynamic, no fixed size like arrays
    private ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    // ─── CORE FEATURES ───────────────────────────────────────────

    // Add contact (no duplicate phone numbers)
    public void addContact(String name, String phone) {
        if (name.isEmpty() || phone.isEmpty()) {
            System.out.println("Error: Name and phone cannot be empty.");
            return;
        }
        // Check duplicate phone
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                System.out.println("Error: Phone number already exists for " + c.getName());
                return;
            }
        }
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added: " + name);
    }

    // Display all contacts
    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\n========== ALL CONTACTS (" + contacts.size() + ") ==========");
        System.out.printf("  %-25s | %s%n", "NAME", "PHONE");
        System.out.println("  " + "-".repeat(40));
        for (Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("  " + "-".repeat(40));
    }

    // Search by name — BONUS: case-insensitive
    public void searchByName(String query) {
        if (query.isEmpty()) {
            System.out.println("Enter a name to search.");
            return;
        }

        List<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            // BONUS: case-insensitive search
            if (c.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(c);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No contact found matching: " + query);
        } else {
            System.out.println("\n===== SEARCH RESULTS (" + results.size() + ") =====");
            System.out.printf("  %-25s | %s%n", "NAME", "PHONE");
            System.out.println("  " + "-".repeat(40));
            for (Contact c : results) {
                System.out.println(c);
            }
            System.out.println("  " + "-".repeat(40));
        }
    }

    // BONUS: Delete contact by name (case-insensitive)
    public void deleteContact(String name) {
        if (name.isEmpty()) {
            System.out.println("Enter a name to delete.");
            return;
        }

        Contact toRemove = null;
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                toRemove = c;
                break;
            }
        }

        if (toRemove == null) {
            System.out.println("Contact not found: " + name);
        } else {
            contacts.remove(toRemove);
            System.out.println("Deleted: " + toRemove.getName());
        }
    }

    public int size() {
        return contacts.size();
    }
}