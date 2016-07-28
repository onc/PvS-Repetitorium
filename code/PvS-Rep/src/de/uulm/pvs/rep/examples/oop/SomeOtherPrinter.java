package de.uulm.pvs.rep.examples.oop;

/**
 * Just a printer in the cloud.
 *
 * @author Christian van Onzenoodt
 *
 */
public class SomeOtherPrinter extends AbstractPrinter {

  /**
   * We don't have to, but we can override this method.
   */
  @Override
  public void print() {
    System.out.println("Just someOtherPrinter, printing stuff...");
  }

  /**
   * We have to do this one {@see LaserPrinter}.
   */
  @Override
  public void printImage() {
    System.out.println("printing images is difficult :(");
  }

}
