package JAVA.Day2;

public class CommandProcessor {

    private Calculator calculator;

    public CommandProcessor() {
        this.calculator = new Calculator();
    }

    /**
     * Parses a command string and executes the correct operation.
     * Format: COMMAND num1 num2
     * Example: ADD 10 20
     */
    public String process(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Error: Empty command. Please enter a valid command.";
        }

        String[] parts = input.trim().toUpperCase().split("\\s+");

        if (parts.length != 3) {
            return "Error: Invalid format. Use: COMMAND num1 num2  (e.g., ADD 10 20)";
        }

        String command = parts[0];
        double num1, num2;

        // Parse numbers
        try {
            num1 = Double.parseDouble(parts[1]);
            num2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            return "Error: Invalid numbers. Please provide valid numeric values.";
        }

        // Execute correct operation
        try {
            double result;
            switch (command) {
                case "ADD":
                    result = calculator.add(num1, num2);
                    return formatResult("ADD", num1, num2, result);

                case "SUB":
                    result = calculator.subtract(num1, num2);
                    return formatResult("SUB", num1, num2, result);

                case "MUL":
                    result = calculator.multiply(num1, num2);
                    return formatResult("MUL", num1, num2, result);

                case "DIV":
                    result = calculator.divide(num1, num2);
                    return formatResult("DIV", num1, num2, result);

                // BONUS operations
                case "MOD":
                    result = calculator.modulus(num1, num2);
                    return formatResult("MOD", num1, num2, result);

                case "POW":
                    result = calculator.power(num1, num2);
                    return formatResult("POW", num1, num2, result);

                default:
                    return "Error: Unknown command '" + command +
                            "'. Valid commands: ADD, SUB, MUL, DIV, MOD, POW";
            }
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
    }

    /**
     * Formats the result into a clean readable string.
     */
    private String formatResult(String command, double a, double b, double result) {
        // Display as integer if result has no decimal part
        String numA = (a == (long) a) ? String.valueOf((long) a) : String.valueOf(a);
        String numB = (b == (long) b) ? String.valueOf((long) b) : String.valueOf(b);
        String res = (result == (long) result) ? String.valueOf((long) result) : String.valueOf(result);

        return command + " " + numA + " " + numB + " = " + res;
    }
}
