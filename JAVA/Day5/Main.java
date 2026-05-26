package JAVA.Day5;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        System.out.println("==========================================");
        System.out.println("       Expense Tracker System            ");
        System.out.println("       GOW AI Academy - RFT | Day 5      ");
        System.out.println("==========================================");

        // Add some sample data so it's not empty on first run
        manager.addExpense(450.00, "food", "Lunch at canteen", LocalDate.of(2026, 5, 1));
        manager.addExpense(1200.00, "transport", "Monthly bus pass", LocalDate.of(2026, 5, 2));
        manager.addExpense(3500.00, "shopping", "New shoes", LocalDate.of(2026, 5, 10));
        manager.addExpense(800.00, "food", "Dinner with friends", LocalDate.of(2026, 5, 15));
        manager.addExpense(250.00, "utilities", "Mobile recharge", LocalDate.of(2026, 4, 20));
        manager.addExpense(600.00, "food", "Groceries", LocalDate.of(2026, 4, 25));

        System.out.println("\nSample data loaded!");

        boolean running = true;

        while (running) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Total Spending");
            System.out.println("4. Category-wise Spending");
            System.out.println("5. Find Highest Expense");
            System.out.println("6. Monthly Summary");
            System.out.println("7. Exit");
            System.out.print("Choose (1-7): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addExpenseInteractive(manager, scanner);
                    break;
                case "2":
                    manager.viewAllExpenses();
                    break;
                case "3":
                    System.out.printf("%nTotal Spending: Rs.%.2f%n", manager.calculateTotal());
                    break;
                case "4":
                    manager.categoryWiseSpending();
                    break;
                case "5":
                    manager.findHighestExpense();
                    break;
                case "6":
                    manager.monthlySummary();
                    break;
                case "7":
                    running = false;
                    System.out.println("Goodbye! Keep tracking your expenses!");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-7.");
            }
        }

        scanner.close();
    }

    static void addExpenseInteractive(ExpenseManager manager, Scanner scanner) {
        System.out.println("\n--- Add New Expense ---");

        // Amount
        double amount = 0;
        while (amount <= 0) {
            System.out.print("Amount (Rs.): ");
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount <= 0)
                    System.out.println("Amount must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Enter a number.");
            }
        }

        // Category
        System.out.print("Category (food/transport/shopping/utilities/other): ");
        String category = scanner.nextLine().trim();
        if (category.isEmpty())
            category = "other";

        // Description
        System.out.print("Description: ");
        String description = scanner.nextLine().trim();
        if (description.isEmpty())
            description = "No description";

        // Date
        LocalDate date = null;
        while (date == null) {
            System.out.print("Date (dd-MM-yyyy) or press Enter for today: ");
            String dateInput = scanner.nextLine().trim();
            if (dateInput.isEmpty()) {
                date = LocalDate.now();
            } else {
                try {
                    date = LocalDate.parse(dateInput, FORMATTER);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Use dd-MM-yyyy (e.g. 26-05-2026).");
                }
            }
        }

        manager.addExpense(amount, category, description, date);
    }
}