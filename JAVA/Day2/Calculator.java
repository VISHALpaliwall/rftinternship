package JAVA.Day2;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return a / b;
    }

    // BONUS: Modulus
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Modulus by zero is not allowed.");
        }
        return a % b;
    }

    // BONUS: Power
    public double power(double a, double b) {
        return Math.pow(a, b);
    }
}