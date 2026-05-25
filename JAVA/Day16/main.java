import java.util.Scanner;

public class main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("  Multi-Threaded Number Printer | Day 16 ");
        System.out.println("  GOW AI Academy - RFT Internship         ");
        System.out.println("==========================================");

        // BONUS: User-defined limit
        System.out.print("Enter the limit (print numbers up to): ");
        int limit = scanner.nextInt();

        System.out.print("Enter sleep delay in ms (e.g. 300): ");
        int sleepMs = scanner.nextInt();

        System.out.println("\nStarting threads...\n");

        // Create Runnable instances
        Runnable evenTask = new EvenPrinter(limit, sleepMs);
        Runnable oddTask = new OddPrinter(limit, sleepMs);

        // Create Thread objects
        Thread thread1 = new Thread(evenTask, "EvenThread");
        Thread thread2 = new Thread(oddTask, "OddThread");

        // Start both threads — they run independently and interleave naturally
        thread1.start();
        thread2.start();

        // Wait for both to finish before printing summary
        thread1.join();
        thread2.join();

        System.out.println("\n==========================================");
        System.out.println("Both threads finished. All numbers printed.");
        System.out.println("==========================================");

        scanner.close();
    }
}
