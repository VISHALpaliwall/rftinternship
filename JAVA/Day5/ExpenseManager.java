package JAVA.Day5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    private List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    // ─── CORE FEATURES ───────────────────────────────────────────

    // Add a new expense
    public void addExpense(double amount, String category, String description, LocalDate date) {
        if (amount <= 0) {
            System.out.println("Error: Amount must be greater than 0.");
            return;
        }
        Expense e = new Expense(amount, category, description, date);
        expenses.add(e);
        System.out.println("Expense added: " + category.toUpperCase() + " - Rs." + String.format("%.2f", amount));
    }

    // View all expenses
    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        System.out.println("\n========== ALL EXPENSES ==========");
        System.out.printf("  %-12s | %-20s | %-12s | %s%n",
                "CATEGORY", "DESCRIPTION", "AMOUNT", "DATE");
        System.out.println("  " + "-".repeat(62));
        for (Expense e : expenses) {
            System.out.println(e);
        }
        System.out.println("  " + "-".repeat(62));
        System.out.printf("  TOTAL: Rs.%.2f%n", calculateTotal());
        System.out.println("===================================");
    }

    // Calculate total spending
    public double calculateTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    // ─── BONUS FEATURES ──────────────────────────────────────────

    // BONUS 1: Category-wise spending
    public void categoryWiseSpending() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        Map<String, Double> categoryMap = new HashMap<>();
        for (Expense e : expenses) {
            categoryMap.put(e.getCategory(),
                    categoryMap.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("\n===== CATEGORY-WISE SPENDING =====");
        for (Map.Entry<String, Double> entry : categoryMap.entrySet()) {
            double percent = (entry.getValue() / calculateTotal()) * 100;
            System.out.printf("  %-15s : Rs.%-10.2f (%.1f%%)%n",
                    entry.getKey().toUpperCase(), entry.getValue(), percent);
        }
        System.out.printf("%n  TOTAL          : Rs.%.2f%n", calculateTotal());
        System.out.println("===================================");
    }

    // BONUS 2: Find highest expense
    public void findHighestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        Expense highest = expenses.get(0);
        for (Expense e : expenses) {
            if (e.getAmount() > highest.getAmount()) {
                highest = e;
            }
        }

        System.out.println("\n===== HIGHEST EXPENSE =====");
        System.out.println(highest);
        System.out.println("===========================");
    }

    // BONUS 3: Monthly summary
    public void monthlySummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        Map<String, Double> monthMap = new HashMap<>();
        for (Expense e : expenses) {
            String month = e.getMonth();
            monthMap.put(month, monthMap.getOrDefault(month, 0.0) + e.getAmount());
        }

        System.out.println("\n======= MONTHLY SUMMARY =======");
        for (Map.Entry<String, Double> entry : monthMap.entrySet()) {
            System.out.printf("  %-20s : Rs.%.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println("================================");
    }

    public boolean hasExpenses() {
        return !expenses.isEmpty();
    }
}