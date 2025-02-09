// Thread1: Generates numbers from 1 to 5
class Thread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread1: " + i);
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread1 Interrupted!");
            }
        }
        System.out.println("Thread1 Finished!");
    }
}

// Thread2: Generates numbers from 10 to 15
class Thread2 extends Thread {
    public void run() {
        for (int i = 10; i <= 15; i++) {
            System.out.println("Thread2: " + i);
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread2 Interrupted!");
            }
        }
        System.out.println("Thread2 Finished!");
    }
}

// Main class to start both threads
public class program7{
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        System.out.println("Thread1 and Thread2 are in NEW state.");

        t1.start();
        t2.start();

        System.out.println("Thread1 and Thread2 are in RUNNABLE state.");

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Both threads have TERMINATED.");
    }
}
