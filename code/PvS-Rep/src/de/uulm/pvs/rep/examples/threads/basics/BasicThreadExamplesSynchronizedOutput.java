package de.uulm.pvs.rep.examples.threads.basics;

/**
 * You may noticed the output of the examples {@link BasicThreadExample},
 * {@link BasicThreadExamplesSynchronized} and {@link BasicThreadExamplesAtomic} is in kind of a
 * weird order. The reason for this order is concurrent threads, which are printing to the (slow)
 * console. There is no guarantee the threads are running in a ping-pong manner. This is totally up
 * to the scheduler! This example shows you which thread is printing which number.
 *
 * @author Christian van Onzenoodt
 *
 */
public class BasicThreadExamplesSynchronizedOutput {

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

    Runnable runnableOne = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < ITERATIONS; i++) {
          System.out.println("[T1] " + getAndIncrement());
        }
      }
    };

    Runnable runnableTwo = new Runnable() {

      @Override
      public void run() {
        for (int i = 0; i < ITERATIONS; i++) {
          System.out.println("[T2] " + getAndIncrement());
        }
      }
    };

    // create two threads
    Thread threadOne = new Thread(runnableOne);
    Thread threadTwo = new Thread(runnableTwo);
    // run the threads
    threadOne.start();
    threadTwo.start();
  }
}
