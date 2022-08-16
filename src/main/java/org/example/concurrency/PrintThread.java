package org.example.concurrency;

import java.util.Random;
import java.util.stream.Stream;

class PrintThread extends Thread {
  private int seed;

  PrintThread(String threadName, int seed) {

    super(threadName);
    this.seed = seed;
  }

  @Override
  public void run() {
    // Infinite number-stream
    Stream<Integer> stream = Stream.iterate(this.seed, (t) -> t + this.seed);

    try {
      stream.forEach(counter -> {
        try {
          sleep(1500);
        }
        catch (InterruptedException ie) {
          throw new RuntimeException("interrupted");
        }
        System.out.print("\nThread: " + this.getName() + " -> " + counter);
      });
    }
    catch (RuntimeException re) {
      System.out.println("\nException -> Interrupted " + this.getName());
    }
  }
}

class CustomThreadCreation {
  public static void main(String[] args) throws InterruptedException {

    Thread thread1 = new PrintThread("First", 1);
    Thread thread2 = new PrintThread("Second", 1);
    thread1.start();
    thread2.start();

    // Pauses current thread for 3 seconds
    // allowing other async-tasks goAhead
    Thread.sleep(3000);
    System.out.println("\n\nCurrent Thread Sleep");

    thread2.interrupt();
    System.out.println("\n\nSecond Thread Interrupted");

    // Delay current thread
    for (int i = 0; i < 3; i++) {
      Thread.sleep(1500);
      System.out.println("\nLoop-Late thread: " + i);
    }

    // Pauses current thread for 3 seconds
    // allowing other async-tasks goAhead
    Thread.sleep(3000);
    System.out.println("\n\nCurrent Thread Sleep");

    for (int i = 0; i < 10; i++) {
      System.out.println("\nLoop-Waiting: " + thread1.getName() + " - " + i);
      Thread.sleep(150);
      if (i == 7) break;
    }

    thread1.interrupt();
    System.out.println("\n\nFirst Thread Interrupted");


    //-------------------------------------------------------------------------
    // Local class Thread:
    // - stream between 1 and 100
    Thread localClassThread = new Thread() {
      public void run() {
        new Random()
             .ints(10,
                   1,
                   100)
             .forEach(System.out::println); }
    };

    localClassThread.start();

    // Waits for the thread to complete
    localClassThread.join();
    System.out.println("Thread after join: ");
    System.out.println("- isAlive: " + localClassThread.isAlive());
    System.out.println("- isInterrupted: " + localClassThread.isInterrupted());
  }
}