package JAVA.Day18;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("==========================================");
        System.out.println("  Producer-Consumer Simulation | Day 18  ");
        System.out.println("  GOW AI Academy - RFT Internship         ");
        System.out.println("==========================================");

        // BONUS: Limited buffer size — max 3 items at a time
        int bufferSize = 3;
        int totalItems = 8;
        int produceDelay = 400; // ms — producer is faster
        int consumeDelay = 700; // ms — consumer is slower (forces FULL state)

        SharedBuffer buffer = new SharedBuffer(bufferSize);

        System.out.println("Buffer size   : " + bufferSize);
        System.out.println("Total items   : " + totalItems);
        System.out.println("Produce delay : " + produceDelay + "ms");
        System.out.println("Consume delay : " + consumeDelay + "ms");
        System.out.println("------------------------------------------");
        System.out.println("Watch: Producer waits when FULL,");
        System.out.println("       Consumer waits when EMPTY.");
        System.out.println("==========================================\n");

        Thread producerThread = new Thread(new Producer(buffer, totalItems, produceDelay), "Producer");
        Thread consumerThread = new Thread(new Consumer(buffer, totalItems, consumeDelay), "Consumer");

        // Start both threads — they coordinate via wait/notifyAll
        producerThread.start();
        consumerThread.start();

        // Wait for both to finish
        producerThread.join();
        consumerThread.join();

        System.out.println("\n==========================================");
        System.out.println("Simulation complete!");
        System.out.println("Final buffer size: " + buffer.size() + " (should be 0)");
        System.out.println("==========================================");
    }
}