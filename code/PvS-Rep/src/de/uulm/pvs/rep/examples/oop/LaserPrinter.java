package de.uulm.pvs.rep.examples.oop;

/**
 * Print with LASER!.
 *
 * @author Christian van Onzenoodt
 *
 */
public class LaserPrinter extends AbstractPrinter {

  // we don't need to override the print-Method, because there is already an implementation in the
  // AbstractPrinter-class

  /**
   * But we have to implement printImage(), because on one else in the hierarchy has done it yet. We
   * HAVE TO do it here, because we can create instances and if someone creates an instance all
   * method have to have an implementation.
   */
  @Override
  public void printImage() {
    System.out.println("I'm a LaserPrinter and i'm printing an image");
  }

  public void printUsingLaser() {
    System.out.println("I'm a LaserPrinter and i'm printing user LASER");
  }
}
