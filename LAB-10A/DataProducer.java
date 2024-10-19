package tena;

public class DataProducer implements Runnable {
    private DataBuffer dataBuffer;
    private String[] dataItems = {"Data 1", "Data 2", "Data 3"};

    public DataProducer(DataBuffer dataBuffer) {
        this.dataBuffer = dataBuffer;
        System.out.println("DataProducer created.");
    }

    @Override
    public void run() {
        for (String data : dataItems) {
            System.out.println("DataProducer producing data: " + data);
            dataBuffer.putData(data);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return; 
            }
        }
        dataBuffer.setFinished(); 
        System.out.println("DataProducer finished producing data.");
    }
}