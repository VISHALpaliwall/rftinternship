package JAVA.Day5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {

    private double amount;
    private String category;
    private LocalDate date;
    private String description;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Expense(double amount, String category, String description, LocalDate date) {
        this.amount = amount;
        this.category = category.trim().toLowerCase();
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getMonth() {
        return date.getMonth().toString() + " " + date.getYear();
    }

    @Override
    public String toString() {
        return String.format("  %-12s | %-20s | Rs.%-8.2f | %s",
                category.toUpperCase(),
                description,
                amount,
                date.format(FORMATTER));
    }
}
