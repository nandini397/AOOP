package tena;

public class Data {
    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer();

        Thread producerThread = new Thread(new DataProducer(buffer));
        Thread consumerThread = new Thread(new DataConsumer(buffer));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Producer thread interrupted.");
        }

        try {
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Consumer thread interrupted.");
        }

        System.out.println("Data pipeline system completed.");
    }
}