package de.uulm.pvs.rep.examples.threads.basics;

/**
 * This is a basic example on threads. Run this example a few times and you will notice, that there
 * are results where some numbers appear multiple times, or numbers are missed.<br>
 * This happens due to concurrent accesses on the 'counter' variable. See
 * {@link BasicThreadExamplesSynchronized} how to avoid these problems.
 *
 * @author Christian van Onzenoodt
 *
 */
public class BasicThreadExample {

  // Counter for both threads
  private static int counter = 0;
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
          // print the counter
          System.out.println(counter);
          // increase the counter by one
          counter = counter + 1;
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
