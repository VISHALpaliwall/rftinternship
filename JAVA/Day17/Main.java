package JAVA.Day17;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("    Task Scheduler System | Day 17       ");
        System.out.println("    GOW AI Academy - RFT Internship       ");
        System.out.println("==========================================");

        // ScheduledExecutorService — Java's built-in thread-based scheduler
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
        Map<String, ScheduledFuture<?>> scheduledTasks = new LinkedHashMap<>();

        boolean running = true;
        while (running) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add One-Time Task (runs after delay)");
            System.out.println("2. Add Repeating Task (like alarm)");
            System.out.println("3. Cancel a Task");
            System.out.println("4. View Scheduled Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Task name    : ");
                    String name1 = scanner.nextLine().trim();
                    System.out.print("Task message : ");
                    String msg1 = scanner.nextLine().trim();
                    System.out.print("Delay (secs) : ");
                    int delay1 = Integer.parseInt(scanner.nextLine().trim());

                    ScheduledFuture<?> task1 = scheduler.schedule(() -> {
                        System.out.println("\n[TASK EXECUTED] " + name1 + ": " + msg1);
                        System.out.print("Choose (1-5): "); // re-prompt
                    }, delay1, TimeUnit.SECONDS);

                    scheduledTasks.put(name1, task1);
                    System.out.println("Task \"" + name1 + "\" scheduled to run after " + delay1 + " second(s).");
                    break;

                case "2":
                    // BONUS: Repeat tasks like alarm
                    System.out.print("Task name         : ");
                    String name2 = scanner.nextLine().trim();
                    System.out.print("Task message      : ");
                    String msg2 = scanner.nextLine().trim();
                    System.out.print("Initial delay (s) : ");
                    int delay2 = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Repeat every (s)  : ");
                    int repeat = Integer.parseInt(scanner.nextLine().trim());

                    ScheduledFuture<?> task2 = scheduler.scheduleAtFixedRate(() -> {
                        System.out.println("\n[REPEATING TASK] " + name2 + ": " + msg2);
                        System.out.print("Choose (1-5): ");
                    }, delay2, repeat, TimeUnit.SECONDS);

                    scheduledTasks.put(name2, task2);
                    System.out.println("Repeating task \"" + name2 + "\" scheduled every " + repeat + "s (starts in "
                            + delay2 + "s).");
                    break;

                case "3":
                    // BONUS: Cancel a task
                    System.out.print("Task name to cancel: ");
                    String cancelName = scanner.nextLine().trim();
                    ScheduledFuture<?> toCancel = scheduledTasks.get(cancelName);
                    if (toCancel != null) {
                        toCancel.cancel(false);
                        scheduledTasks.remove(cancelName);
                        System.out.println("Task \"" + cancelName + "\" cancelled.");
                    } else {
                        System.out.println("Task not found: " + cancelName);
                    }
                    break;

                case "4":
                    System.out.println("\n--- Scheduled Tasks ---");
                    if (scheduledTasks.isEmpty()) {
                        System.out.println("  No tasks scheduled.");
                        break;
                    }
                    for (Map.Entry<String, ScheduledFuture<?>> entry : scheduledTasks.entrySet()) {
                        String status = entry.getValue().isCancelled() ? "CANCELLED"
                                : entry.getValue().isDone() ? "DONE" : "PENDING";
                        System.out.println("  " + entry.getKey() + " — " + status);
                    }
                    break;

                case "5":
                    running = false;
                    System.out.println("Shutting down scheduler...");
                    scheduler.shutdown();
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}