package JAVA.Day3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create quiz
        Quiz quiz = new Quiz("Java & General Knowledge Quiz");

        // Add questions: new Question("text", new String[]{"A","B","C","D"},
        // correctOptionNumber)
        quiz.addQuestion(new Question(
                "Which keyword is used to create a class in Java?",
                new String[] { "create", "class", "new", "object" },
                2));

        quiz.addQuestion(new Question(
                "What is the size of an int in Java?",
                new String[] { "8 bits", "16 bits", "32 bits", "64 bits" },
                3));

        quiz.addQuestion(new Question(
                "Which of these is NOT a Java OOP principle?",
                new String[] { "Inheritance", "Polymorphism", "Compilation", "Encapsulation" },
                3));

        quiz.addQuestion(new Question(
                "What does JVM stand for?",
                new String[] { "Java Visual Machine", "Java Virtual Machine", "Java Verified Module",
                        "Java Value Method" },
                2));

        quiz.addQuestion(new Question(
                "Which collection allows duplicate elements?",
                new String[] { "HashSet", "TreeSet", "ArrayList", "LinkedHashSet" },
                3));

        quiz.addQuestion(new Question(
                "What is the default value of a boolean in Java?",
                new String[] { "true", "false", "0", "null" },
                2));

        quiz.addQuestion(new Question(
                "Which method is the entry point of a Java program?",
                new String[] { "start()", "run()", "init()", "main()" },
                4));

        quiz.addQuestion(new Question(
                "Which of these is used for exception handling?",
                new String[] { "try-catch", "if-else", "for-loop", "switch-case" },
                1));

        // BONUS: Randomize question order
        System.out.print("Randomize questions? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        if (choice.equals("yes") || choice.equals("y")) {
            quiz.randomize();
            System.out.println("Questions randomized!");
        }

        // Start the quiz
        quiz.start(scanner);

        scanner.close();
    }
}
