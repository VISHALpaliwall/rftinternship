public class EvenPrinter implements Runnable {

    private int limit;
    private int sleepMs;

    public EvenPrinter(int limit, int sleepMs) {
        this.limit = limit;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        for (int i = 0; i <= limit; i += 2) {
            System.out.println("[Thread-EVEN] " + i);
            try {
                Thread.sleep(sleepMs); // BONUS: control order using sleep()
            } catch (InterruptedException e) {
                System.out.println("[Thread-EVEN] Interrupted!");
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("[Thread-EVEN] Done.");
    }
}
