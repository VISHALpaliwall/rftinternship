package JAVA.Day1;

import java.util.Scanner;

public class main {

    // Reverse string manually using a loop (no StringBuilder.reverse())
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Swap characters from both ends moving inward
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("  String Reversal | Day 1    ");
        System.out.println("  GOW AI Academy - RFT        ");
        System.out.println("==============================");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();
        String reversed = reverseString(input);

        System.out.println("Reversed: " + reversed);

        scanner.close();
    }
}