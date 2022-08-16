package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
  public static void main(String[] args)
       throws InterruptedException {

    ExecutorService service = Executors.newSingleThreadExecutor();

    service.execute(ExecutorExample::taskThreadOne);
    service.execute(ExecutorExample::taskThreadTwo);

    // MAIN-THREAD: Running asynchronously
    for (int i = 1; i < 11; i++) {
      System.out.println("---------------------> MainThread - task: " + i);
      Thread.sleep(250);     }

    service.shutdown();
    service.awaitTermination(2, TimeUnit.SECONDS);
    System.out.println("All done!!");
  }

  // Method will run asynchronously, printing numbers 1-5
  private static void taskThreadOne() {
    for (int i = 1; i <= 5; i++) {
      System.out.println("---------------> First taskThread: " + i);
      try {       Thread.sleep(250);     }
      catch (InterruptedException iex) {     break;   }
    }
  }

  // Method will run asynchronously, printing numbers 10-5
  private static void taskThreadTwo() {
    for (int i = 10; i > 5; i--) {
      if(i == 10) System.out.println("\n\n\n");
      System.out.println("------> Second taskThread: " + i);
      try {       Thread.sleep(250);     }
      catch (InterruptedException iex) {      break;    }
    }
  }
}