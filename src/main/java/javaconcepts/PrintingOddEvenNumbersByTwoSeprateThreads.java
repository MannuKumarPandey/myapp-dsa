package javaconcepts;

public class PrintingOddEvenNumbersByTwoSeprateThreads {

    public static void main(String[] args) {
        //sending max value from constructors
        OddEvenPrinter printer = new OddEvenPrinter(10);

        //giving the runnable target here in both the constructors
        Thread oddThread = new Thread(printer::printOdd, "Thread 1 : ");
        Thread evenThread = new Thread(printer::printEven, "Thread 2 : ");
        //starting both the threads
        oddThread.start();
        evenThread.start();
    }
}
/* is concept me ham abhi bhi thrread scheduler ke random behave ko consider kar rahe hai
* agar thread scheduler odd thread ko time diya and uski bari nahi hai tab usko wait karna hai
* and jab even thread apna kam karke notify karenga odd thread ko tab wo apna kamm chalu karega*/

class OddEvenPrinter {
    private int number = 1;
    private final int max;
    private boolean oddTurn = true; // odd starts first

    public OddEvenPrinter(int max) {
        this.max = max;
    }

    public synchronized void printOdd() {
        while (number <= max) {
            //jab odd thread ki bari hogi to wo is loop me nahi jayega
            //is loop me jane ke bad wait karna hai
            while (!oddTurn) { // not odd's turn
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println(Thread.currentThread().getName()+ number);
            number++;
            oddTurn = false; // now even's turn
            notify(); // wake up even thread
        }
    }

    public synchronized void printEven() {
        while (number <= max) {
            while (oddTurn) { // not even's turn
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName()+ number);
            number++;
            oddTurn = true; // now odd's turn
            notify(); // wake up odd thread
        }
    }
}

