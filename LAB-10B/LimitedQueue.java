package tenb;
import java.util.LinkedList;
import java.util.Queue;

public class LimitedQueue {
    private final Queue<String> queue = new LinkedList<>();
    private final int MAX_SIZE = 2;

    public synchronized void addItem(String item) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            System.out.println("Queue is full. Waiting to add...");
            wait(); 
        }

        queue.add(item);
        System.out.println("Added: " + item);
        notifyAll();
    }

    public synchronized String removeItem() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Waiting to remove...");
            wait();  
        }

        String item = queue.poll();
        System.out.println("Removed: " + item);
        notifyAll();  
        return item;
    }
}

