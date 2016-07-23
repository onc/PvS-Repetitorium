package de.uulm.pvs.rep.examples.threads.basics;

/**
 * This version of the {@link BasicThreadExample} uses synchronization to avoid, that concurrent
 * threads are accessing the 'counter'-variable. Only ONE thread can enter the
 * getAndIncrease()-Method at the same time.<br>
 * In this version you don't have missing numbers or duplicates any more.
 *
 * @author Christian van Onzenoodt
 *
 */
public class BasicThreadExamplesSynchronized {

  // Counter for both threads
  private static int counter = 0;
  private static final int ITERATIONS = 10;

  private static synchronized int getAndIncrement() {
    return counter++;
  }

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
          System.out.println(getAndIncrement());
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
