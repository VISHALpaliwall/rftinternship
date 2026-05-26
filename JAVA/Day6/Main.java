package JAVA.Day6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        System.out.println("==========================================");
        System.out.println("         Contact Manager | Day 6         ");
        System.out.println("   GOW AI Academy - RFT Internship        ");
        System.out.println("==========================================");

        // Sample contacts preloaded
        manager.addContact("Vishal Paliwal", "9876543210");
        manager.addContact("Rahul Sharma", "9812345678");
        manager.addContact("Priya Singh", "9988776655");
        manager.addContact("Amit Kumar", "9001122334");
        manager.addContact("Neha Verma", "8899001122");

        System.out.println("Sample contacts loaded!\n");

        boolean running = true;

        while (running) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter name  : ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter phone : ");
                    String phone = scanner.nextLine().trim();
                    manager.addContact(name, phone);
                    break;

                case "2":
                    manager.displayAll();
                    break;

                case "3":
                    System.out.print("Search name : ");
                    String query = scanner.nextLine().trim();
                    manager.searchByName(query);
                    break;

                case "4":
                    System.out.print("Delete contact (enter name): ");
                    String delName = scanner.nextLine().trim();
                    manager.deleteContact(delName);
                    break;

                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Enter 1-5.");
            }
        }

        scanner.close();
    }
}