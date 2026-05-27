package JAVA.Day18;

public class Producer implements Runnable {

    private final SharedBuffer buffer;
    private final int itemCount; // how many items to produce
    private final int delayMs; // delay between each production

    public Producer(SharedBuffer buffer, int itemCount, int delayMs) {
        this.buffer = buffer;
        this.itemCount = itemCount;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= itemCount; i++) {
                buffer.produce(i);
                Thread.sleep(delayMs);
            }
            System.out.println("  [PRODUCER DONE] All " + itemCount + " items produced.");
        } catch (InterruptedException e) {
            System.out.println("  [PRODUCER] Interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}