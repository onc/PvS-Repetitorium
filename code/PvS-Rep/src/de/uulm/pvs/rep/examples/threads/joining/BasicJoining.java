package de.uulm.pvs.rep.examples.threads.joining;

/**
 * Just a simple example to show how join works.
 *
 * @author Christian van Onzenoodt
 *
 */
public class BasicJoining {

  private static int counter = 0;
  private static final int ITERATIONS = 10;

  private static Thread threadOne;
  private static Thread threadTwo;
  private static Thread threadThree;

  /**
   * Simple Runnable-class to have a name on a runnable.
   *
   * @author Christian van Onzenoodt
   *
   */
  private static class MyRunnable implements Runnable {

    private String runnableName;

    public MyRunnable(String name) {
      this.runnableName = name;
    }

    @Override
    public void run() {
      System.out.println("Running thread [" + runnableName + "]");
      for (int i = 0; i < ITERATIONS; i++) {
        System.out.println("[" + runnableName + "] " + counter++);
      }
    }
  }

  /**
   * First run. This run simply starts all threads at once and waits on the end until all threads
   * all finished.
   * 
   * @throws InterruptedException - on interruption
   */
  private static void firstRun() throws InterruptedException {

    threadOne = new Thread(new MyRunnable("Eins"));
    threadTwo = new Thread(new MyRunnable("Zwei"));
    threadThree = new Thread(new MyRunnable("Drei"));

    threadOne.start();
    threadTwo.start();
    threadThree.start();

    threadOne.join();
    threadTwo.join();
    threadThree.join();
  }

  /**
   * Second run. This runs the first thread, waits until the thread is finished, starts the second
   * thread, waits until this thread is finished and so on. To be honest, this makes no sense, since
   * threads are used to run code concurrent, but it shows how join works.
   * 
   * @throws InterruptedException - on interruption
   */
  private static void secondRun() throws InterruptedException {

    threadOne = new Thread(new MyRunnable("Eins"));
    threadTwo = new Thread(new MyRunnable("Zwei"));
    threadThree = new Thread(new MyRunnable("Drei"));

    threadOne.start();
    threadOne.join();
    threadTwo.start();
    threadTwo.join();
    threadThree.start();
    threadThree.join();
  }

  /**
   * Start the test-runs.
   * 
   * @param args - arguments
   * @throws InterruptedException - on interruption
   */
  public static void main(String[] args) {

    try {
      System.out.println("START FIRST RUN!");
      firstRun();
      System.out.println("START SECOND RUN!");
      secondRun();
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
  }

}
