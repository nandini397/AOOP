package tenb;

public class ItemConsumer implements Runnable {
    private final LimitedQueue queue;
    private final int TOTAL_ITEMS = 10; 

    public ItemConsumer(LimitedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (count < TOTAL_ITEMS) {
                queue.removeItem();
                count++;
                Thread.sleep(800); 
            }
            System.out.println("Consumer completed consumption.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

