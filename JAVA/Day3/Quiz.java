package JAVA.Day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private List<Question> questions;
    private List<Integer> userAnswers;
    private String quizTitle;

    public Quiz(String quizTitle) {
        this.quizTitle = quizTitle;
        this.questions = new ArrayList<>();
        this.userAnswers = new ArrayList<>();
    }

    // Add a question to the quiz
    public void addQuestion(Question q) {
        questions.add(q);
    }

    // BONUS: Randomize question order
    public void randomize() {
        Collections.shuffle(questions);
    }

    // Run the full quiz
    public void start(Scanner scanner) {
        System.out.println("\n==========================================");
        System.out.println("         " + quizTitle);
        System.out.println("  GOW AI Academy - RFT Internship | Day 3");
        System.out.println("==========================================");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Enter 1, 2, 3, or 4 for each answer.");
        System.out.println("==========================================");

        userAnswers.clear();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.display(i + 1);

            int answer = -1;
            while (answer < 1 || answer > 4) {
                System.out.print("  Your answer (1-4): ");
                try {
                    answer = Integer.parseInt(scanner.nextLine().trim());
                    if (answer < 1 || answer > 4) {
                        System.out.println("  Invalid! Enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("  Invalid! Enter a number between 1 and 4.");
                }
            }

            userAnswers.add(answer);

            // Instant feedback
            if (q.isCorrect(answer)) {
                System.out.println("  ✔ Correct!");
            } else {
                System.out.println("  ✘ Wrong!");
            }
        }

        showResults();
    }

    // Calculate and display final score + BONUS: show correct answers
    private void showResults() {
        int score = 0;

        System.out.println("\n==========================================");
        System.out.println("              QUIZ RESULTS               ");
        System.out.println("==========================================");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            int userAns = userAnswers.get(i);
            boolean correct = q.isCorrect(userAns);

            if (correct)
                score++;

            char userLetter = (char) ('A' + userAns - 1);
            String status = correct ? "✔" : "✘";

            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());
            System.out.println("  Your answer  : " + userLetter + ") " + q.getOptions()[userAns - 1] + "  " + status);

            // BONUS: Show correct answer if wrong
            if (!correct) {
                System.out.println("  Correct answer: " + q.getCorrectAnswerText());
            }
        }

        System.out.println("\n==========================================");
        System.out.println("  SCORE: " + score + " / " + questions.size());
        System.out.println("  " + getGrade(score, questions.size()));
        System.out.println("==========================================");
    }

    // Grade message based on score
    private String getGrade(int score, int total) {
        double percent = (double) score / total * 100;
        if (percent == 100)
            return "Perfect Score! Outstanding!";
        else if (percent >= 80)
            return "Excellent Work!";
        else if (percent >= 60)
            return "Good Job!";
        else if (percent >= 40)
            return "Keep Practicing!";
        else
            return "Don't give up, try again!";
    }
}