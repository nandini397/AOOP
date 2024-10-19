package tenb;

public class ItemProducer implements Runnable {
    private final LimitedQueue queue;
    private final int TOTAL_ITEMS = 10;  

    public ItemProducer(LimitedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (count < TOTAL_ITEMS) {
                queue.addItem("Item " + count);
                count++;
                Thread.sleep(400); 
            }
            System.out.println("Producer completed production.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

