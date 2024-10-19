package tena;
import java.util.Queue;
import java.util.LinkedList;

public class DataBuffer {
    private Queue<String> dataQueue = new LinkedList<>();
    private boolean finished = false; 

    public synchronized void putData(String data) {
        dataQueue.add(data);
        System.out.println("Putting data into buffer: " + data);
        notifyAll(); 
    }

    public synchronized String getData() throws InterruptedException {
        while (dataQueue.isEmpty() && !finished) {
            wait(); 
        }
        if (!dataQueue.isEmpty()) {
            String data = dataQueue.poll();
            System.out.println("Getting data from buffer: " + data);
            return data;
        }
        return null; 
    }

    public synchronized void setFinished() {
        finished = true;
        notifyAll(); 
    }
    
    public synchronized boolean isBufferEmpty() {
        return dataQueue.isEmpty();
    }
}