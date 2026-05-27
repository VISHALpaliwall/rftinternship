package JAVA.Day18;

public class Consumer implements Runnable {

    private final SharedBuffer buffer;
    private final int itemCount; // how many items to consume
    private final int delayMs; // delay between each consumption

    public Consumer(SharedBuffer buffer, int itemCount, int delayMs) {
        this.buffer = buffer;
        this.itemCount = itemCount;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                buffer.consume();
                Thread.sleep(delayMs);
            }
            System.out.println("  [CONSUMER DONE] All " + itemCount + " items consumed.");
        } catch (InterruptedException e) {
            System.out.println("  [CONSUMER] Interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}