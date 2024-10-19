package ninea;

public class DivisiblePrinter {
	 private int currentNumber = 1;
	    private final int MAX_NUMBER = 15;

	    public synchronized void printTwo() throws InterruptedException {
	        while (currentNumber <= MAX_NUMBER) {
	            if (currentNumber % 2 == 0 && currentNumber % 3 != 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
	                System.out.println("Divisible by 2: " + currentNumber);
	                currentNumber++;
	                notifyAll();
	            } else {
	                wait();
	            }
	        }
	    }

	    public synchronized void printThree() throws InterruptedException {
	        while (currentNumber <= MAX_NUMBER) {
	            if (currentNumber % 3 == 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
	                System.out.println("Divisible by 3: " + currentNumber);
	                currentNumber++;
	                notifyAll();
	            } else {
	                wait();
	            }
	        }
	    }

	    public synchronized void printFour() throws InterruptedException {
	        while (currentNumber <= MAX_NUMBER) {
	            if (currentNumber % 4 == 0 && currentNumber % 5 != 0) {
	                System.out.println("Divisible by 4: " + currentNumber);
	                currentNumber++;
	                notifyAll();
	            } else {
	                wait();
	            }
	        }
	    }

	    public synchronized void printFive() throws InterruptedException {
	        while (currentNumber <= MAX_NUMBER) {
	            if (currentNumber % 5 == 0) {
	                System.out.println("Divisible by 5: " + currentNumber);
	                currentNumber++;
	                notifyAll();
	            } else {
	                wait();
	            }
	        }
	    }

	    public synchronized void printNumber() throws InterruptedException {
	        while (currentNumber <= MAX_NUMBER) {
	            if (currentNumber % 2 != 0 && currentNumber % 3 != 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
	                System.out.println("Number: " + currentNumber);
	                currentNumber++;
	                notifyAll();
	            } else {
	                wait();
	            }
	        }
	    }
}