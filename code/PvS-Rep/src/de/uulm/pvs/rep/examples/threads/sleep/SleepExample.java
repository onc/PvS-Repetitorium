package de.uulm.pvs.rep.examples.threads.sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple example to show how sleep on threads work.
 *
 * @author Christian van Onzenoodt
 *
 */
public class SleepExample {

  private static final int ONE_SECOND = 1000;

  /**
   * Starts a Thread, prints the Time, sleeps for one second, prints the time again and finished.
   * 
   * @param args - arguments
   * @throws InterruptedException - on interruption
   */
  public static void main(String[] args) throws InterruptedException {

    // Create a new thread
    Thread clockThread = new Thread(new Runnable() {

      @Override
      public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        // print the time
        System.out.println("I'm here and it is: " + simpleDateFormat.format(new Date()));
        // sleep for one second
        try {
          Thread.sleep(ONE_SECOND);
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }
        // print the time again
        System.out.println("I'm here and it is: " + simpleDateFormat.format(new Date()));

      }
    });

    // start the thread
    clockThread.start();
  }
}
