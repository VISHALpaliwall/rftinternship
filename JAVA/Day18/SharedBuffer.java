package JAVA.Day18;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int MAX_SIZE; // BONUS: limited buffer size

    public SharedBuffer(int maxSize) {
        this.MAX_SIZE = maxSize;
    }

    // Producer calls this — waits if buffer is FULL
    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == MAX_SIZE) {
            System.out.println("  [BUFFER FULL]  Producer waiting... (size=" + buffer.size() + ")");
            wait(); // release lock and wait
        }
        buffer.add(item);
        System.out.println("  [PRODUCED] Item: " + item + "  | Buffer: " + buffer);
        notifyAll(); // wake up waiting consumer
    }

    // Consumer calls this — waits if buffer is EMPTY
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("  [BUFFER EMPTY] Consumer waiting...");
            wait(); // release lock and wait
        }
        int item = buffer.poll();
        System.out.println("  [CONSUMED] Item: " + item + "  | Buffer: " + buffer);
        notifyAll(); // wake up waiting producer
        return item;
    }

    public synchronized int size() {
        return buffer.size();
    }
}