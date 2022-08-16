package org.example.concurrency;

import java.util.stream.Stream;


class NumberGenerator extends Number implements Runnable {
    private int seed = 1;

    NumberGenerator(int seed) {
        this.seed = seed;
    }

    @Override
    public void run() {
        Stream<Integer> infiniteStream =
                Stream.iterate(this.seed, (t) -> t + this.seed);
        try {
            infiniteStream.forEach(s -> {
                // must satisfy catch/specify for InterruptedException
                try {
                    // numbers printed every half a second
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    // throws an unchecked method when interrupted
                    throw new RuntimeException("interrupted");
                }
                // print numbers and include thread name
                System.out.print(": " + s + " ");
            });

        } catch (RuntimeException re) {
            // Print a statement and terminate cleanly
            System.out.println("\nInterrupted the thread's execution");
        }
    }

    @Override
    public int intValue() {
        return this.seed;
    }

    @Override
    public long longValue() {
        return this.seed;
    }

    @Override
    public float floatValue() {
        return this.seed;
    }

    @Override
    public double doubleValue() {
        return this.seed;
    }
}

public class RunnableThreadCreation {
    public static void main(String[] args) throws InterruptedException {

        // Create a Thread, pass a Runnable object, in this case an instance
        // of NumberGenerator class
        Thread n = new Thread(new NumberGenerator(100));

        // Now we call start() which executes NumberGenerator's run()
        n.start();

        // Pause current thread and let new asynchronous thread do a
        // little work in the mean time
        Thread.sleep(3000);

        // Interrupt third asynchronous thread
        n.interrupt();

        // Wait until it is confirmed that last thread is terminated.
        while (n.isAlive()) {

            System.out.println("\nWaiting for " + n.getName() +
                    " to terminate");
            Thread.sleep(150);
        }

        System.out.println("\nAll threads interrupted, " +
                "Terminating main thread");
    }
}