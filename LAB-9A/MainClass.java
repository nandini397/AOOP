package ninea;

public class MainClass {
    public static void main(String[] args) {
        DivisiblePrinter printer = new DivisiblePrinter();

        Thread t1 = new Thread(() -> {
            try {
                printer.printTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printer.printThree();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                printer.printFour();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                printer.printFive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t5 = new Thread(() -> {
            try {
                printer.printNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
