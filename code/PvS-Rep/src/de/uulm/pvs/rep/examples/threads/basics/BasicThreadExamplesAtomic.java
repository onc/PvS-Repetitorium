package de.uulm.pvs.rep.examples.threads.basics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link BasicThreadExample} suffers the problem of missing and duplicate numbers due to the fact
 * the ++ operator is not an atomic operation. If you are using ++, java will do<br>
 * variable = variable + 1<br>
 * this is a read of the variable, an increment and a write back<br>
 * If two threads are accessing the ++ operation at the same time, you are in trouble. Besides of
 * using a synchronized method, you can use special class, which provide atomic operations like
 * incrementAndGet().
 *
 * @author Christian van Onzenoodt
 *
 */
public class BasicThreadExamplesAtomic {

  // Counter for both threads. This time we are using an atomic integer!
  private static AtomicInteger counter = new AtomicInteger(0);
  private static final int ITERATIONS = 10;

  /**
   * Main-Method.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {

    // create a new runable
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        // do it 10 times
        for (int i = 0; i < ITERATIONS; i++) {
          // AtomicInteger provides a method called getAndIncrement();
          System.out.println(counter.getAndIncrement());
        }
      }
    };

    // create two threads
    Thread threadOne = new Thread(runnable);
    Thread threadTwo = new Thread(runnable);
    // run the threads
    threadOne.start();
    threadTwo.start();
  }
}
