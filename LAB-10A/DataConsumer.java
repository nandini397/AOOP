package tena;

public class DataConsumer implements Runnable {
    private DataBuffer dataBuffer;

    public DataConsumer(DataBuffer dataBuffer) {
        this.dataBuffer = dataBuffer;
        System.out.println("DataConsumer created.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = dataBuffer.getData();
                if (data == null) { 
                    break;
                }
                System.out.println("DataConsumer consuming data: " + data);
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break; 
            }
        }
        System.out.println("DataConsumer finished consuming data.");
    }
}
