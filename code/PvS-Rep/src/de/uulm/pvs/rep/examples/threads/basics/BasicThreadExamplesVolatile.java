package de.uulm.pvs.rep.examples.threads.basics;

/**
 * You may heard about the volatile keyword. At first it may sounds like you could fix all your
 * problems using this keyword. This is not true in all circumstances.<br>
 * Volatile only ensures that any thread that READS a field will see the most recently written
 * value!! You get absolutely NO guarantee your concurrent writes are thread-safe.
 *
 * @author Christian van Onzenoodt
 *
 */
public class BasicThreadExamplesVolatile {

  // Counter for both threads
  private static volatile int counter = 0;
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
          // get and increase the counter.
          System.out.println(counter++);
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
