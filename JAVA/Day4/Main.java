package JAVA.Day4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create devices
        Light light = new Light("Living Room Light");
        Fan fan = new Fan("Bedroom Fan");
        AC ac = new AC("Hall AC");

        System.out.println("==========================================");
        System.out.println("     Smart Home Device Controller        ");
        System.out.println("     GOW AI Academy - RFT | Day 4        ");
        System.out.println("==========================================");

        boolean running = true;

        while (running) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Control Light");
            System.out.println("2. Control Fan");
            System.out.println("3. Control AC");
            System.out.println("4. View All Device Status");
            System.out.println("5. Exit");
            System.out.print("Choose (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    controlLight(light, scanner);
                    break;
                case "2":
                    controlFan(fan, scanner);
                    break;
                case "3":
                    controlAC(ac, scanner);
                    break;
                case "4":
                    light.displayStatus();
                    fan.displayStatus();
                    ac.displayStatus();
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye! All devices left as-is.");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-5.");
            }
        }

        scanner.close();
    }

    static void controlLight(Light light, Scanner scanner) {
        System.out.println("\n--- Light Control ---");
        System.out.println("1. Turn ON");
        System.out.println("2. Turn OFF");
        System.out.println("3. Set Brightness");
        System.out.println("4. View Status");
        System.out.print("Choose: ");
        String c = scanner.nextLine().trim();
        switch (c) {
            case "1":
                light.turnOn();
                break;
            case "2":
                light.turnOff();
                break;
            case "3":
                System.out.print("Enter brightness (1-100): ");
                try {
                    light.setBrightness(Integer.parseInt(scanner.nextLine().trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
                break;
            case "4":
                light.displayStatus();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    static void controlFan(Fan fan, Scanner scanner) {
        System.out.println("\n--- Fan Control ---");
        System.out.println("1. Turn ON");
        System.out.println("2. Turn OFF");
        System.out.println("3. Set Speed (1-5)");
        System.out.println("4. View Status");
        System.out.print("Choose: ");
        String c = scanner.nextLine().trim();
        switch (c) {
            case "1":
                fan.turnOn();
                break;
            case "2":
                fan.turnOff();
                break;
            case "3":
                System.out.print("Enter speed level (1=slow, 5=turbo): ");
                try {
                    fan.setSpeed(Integer.parseInt(scanner.nextLine().trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
                break;
            case "4":
                fan.displayStatus();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    static void controlAC(AC ac, Scanner scanner) {
        System.out.println("\n--- AC Control ---");
        System.out.println("1. Turn ON");
        System.out.println("2. Turn OFF");
        System.out.println("3. Set Temperature (16-30°C)");
        System.out.println("4. Set Mode (Cool/Heat/Fan)");
        System.out.println("5. View Status");
        System.out.print("Choose: ");
        String c = scanner.nextLine().trim();
        switch (c) {
            case "1":
                ac.turnOn();
                break;
            case "2":
                ac.turnOff();
                break;
            case "3":
                System.out.print("Enter temperature (16-30): ");
                try {
                    ac.setTemperature(Integer.parseInt(scanner.nextLine().trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
                break;
            case "4":
                System.out.print("Enter mode (Cool/Heat/Fan): ");
                ac.setMode(scanner.nextLine().trim());
                break;
            case "5":
                ac.displayStatus();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
