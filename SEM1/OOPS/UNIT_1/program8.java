/*
 * write a java code to demonstrate producer 7 consumer problems using thread wait and notify methods
 *
 * Threads communicatre Primarily by sharing access to filef s anf the object refernce fields refers to this forms of communication is extrememly efficient but makes two kinds of erroes possible threads interference and memory consistency errors the tools needed to prevent these errors is synchronizations
 *
 * Question wrte java program to demonstrate the producer and consumer problem using generation of number
 * setup wise ececution procedure
 *
 * step1: create a main thread cl;ass which involved methods to synchronize mechanism such as locks semophores or condition variable s to coordinates the access to ensure mutual execlusion. the mechanism help in preventing race condition and maintaining intergity of the shared data 
 *
 * step2: Implements the producer: creare a producer thread that generates data and adds it to the shared buffer the producer should acquire the necessary synchronization lock or semaphore before accessing the buffer. if the buffer is full the producer should wait until there is space available 
 *
 * steps3: Implements the consumer create thread the retrieves data from the shared buffers and processes it. similar to the producer the consumer should acquire the synchronization lock or semaphore before accessing if the number is empty the consumer should wait until there os data available 
 *
 * step4: Start the threads instantiate and start multipke producer and consumer threads each thread will execute concurrently and preform its respective task
 *
 * step5: coordinate producer and consumer actions use synchronization mechanism to coordinate the actions of producer and consumer
 * step6: Ensure termination. define a termination condition for the producer and consumer threads fpr instance you can sert a maximum number of items to be produced or consumed once the termination consdition is met signal the threads to exit gracefully.
 */

import java.util.*;

public class program8{

    // Shared buffer for producer and consumer
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int capacity = 5; // Buffer capacity
    private volatile boolean running=true;
    // Producer thread
    class Producer extends Thread {
        @Override
        public void run() {
            int value = 0;
            while (running) {
                synchronized (buffer) {
                    // Wait if the buffer is full
                    while (buffer.size() == capacity) {
                        try {
                            System.out.println("Buffer is full. Producer is waiting...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }

                    // Add the item to the buffer
                    System.out.println("Producer produced: " + value);
                    buffer.add(value++);
                    
                    // Notify the consumer
                    buffer.notify();
                }

                // Simulate time delay
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Consumer thread
    class Consumer extends Thread {
        @Override
        public void run() {
            while (running) {
                synchronized (buffer) {
                    // Wait if the buffer is empty
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("Buffer is empty. Consumer is waiting...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }

                    // Remove the item from the buffer
                    int value = buffer.removeFirst();
                    System.out.println("Consumer consumed: " + value);

                    // Notify the producer
                    buffer.notify();
                }

                // Simulate time delay
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Main method to run the producer-consumer demo
    public static void main(String[] args) {
        program8 demo = new program8();
        Scanner in=new Scanner(System.in);
        String Inter;
        // Create and start producer and consumer threads
        Producer producer = demo.new Producer();
        Consumer consumer = demo.new Consumer();
        
        producer.start();
        consumer.start();
        
        Inter=in.nextLine();
        demo.running=false;
        
        producer.interrupt();
        consumer.interrupt();
        
        System.out.println("Threads were interrupted");
    }
}
