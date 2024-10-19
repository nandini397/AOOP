package tenb;

public class LimitedQueueDemo {
    public static void main(String[] args) {
        LimitedQueue queue = new LimitedQueue();

        Thread producerThread = new Thread(new ItemProducer(queue));
        Thread consumerThread = new Thread(new ItemConsumer(queue));

        producerThread.start();
        consumerThread.start();}}