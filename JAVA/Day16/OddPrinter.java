public class OddPrinter implements Runnable {

    private int limit;
    private int sleepMs;

    public OddPrinter(int limit, int sleepMs) {
        this.limit = limit;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i += 2) {
            System.out.println("[Thread-ODD ] " + i);
            try {
                Thread.sleep(sleepMs); // BONUS: control order using sleep()
            } catch (InterruptedException e) {
                System.out.println("[Thread-ODD ] Interrupted!");
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("[Thread-ODD ] Done.");
    }
}
