package de.uulm.pvs.rep.examples.oop;

/**
 * AbstractPrinter.
 *
 * @author Christian van Onzenoodt
 *
 */
public abstract class AbstractPrinter implements Printable {

  /**
   * We can define some default implementations here, if we want to...
   */
  @Override
  public void print() {
    System.out.println("I'm just a AbstractPrinter...");
  }

}
