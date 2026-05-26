package JAVA.Day7;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("    Word Frequency Counter | Day 7       ");
        System.out.println("    GOW AI Academy - RFT Internship       ");
        System.out.println("==========================================");
        System.out.println("Enter a sentence (or press Enter for demo):");
        System.out.print("> ");

        String input = scanner.nextLine().trim();

        // Use demo input if empty
        if (input.isEmpty()) {
            input = "THIS IS A TEST THIS IS SIMPLE TEST";
            System.out.println("Using demo: " + input);
        }

        // BONUS: Ignore case — convert to lowercase
        String[] words = input.toLowerCase().split("\\s+");

        // HashMap: word -> frequency (replaces nested loops)
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String word : words) {
            // Remove punctuation from word edges
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            if (!word.isEmpty()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        // Display frequency of each word
        System.out.println("\n========== WORD FREQUENCY ==========");
        System.out.printf("  %-20s | %s%n", "WORD", "COUNT");
        System.out.println("  " + "-".repeat(30));
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.printf("  %-20s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("  " + "-".repeat(30));
        System.out.println("  Total unique words: " + freqMap.size());

        // BONUS: Find most frequent word
        String mostFreqWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFreqWord = entry.getKey();
            }
        }
        System.out.println("\n  Most frequent word: \"" + mostFreqWord + "\" (" + maxCount + " times)");
        System.out.println("=====================================");

        scanner.close();
    }
}