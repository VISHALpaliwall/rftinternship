package JAVA.Day3;

public class Question {

    private String questionText;
    private String[] options; // 4 options: A, B, C, D
    private int correctOption; // 1-based index (1=A, 2=B, 3=C, 4=D)

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    // Returns the correct answer text e.g. "B) Paris"
    public String getCorrectAnswerText() {
        int idx = correctOption - 1;
        char letter = (char) ('A' + idx);
        return letter + ") " + options[idx];
    }

    // Display the question with all options
    public void display(int questionNumber) {
        System.out.println("\nQ" + questionNumber + ": " + questionText);
        char label = 'A';
        for (String option : options) {
            System.out.println("  " + label + ") " + option);
            label++;
        }
    }

    // Check if user's answer is correct (1-based)
    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}