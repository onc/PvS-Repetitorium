package de.uulm.pvs.rep.examples.oop;

/**
 * Controller of all printers.
 *
 * @author Christian van Onzenoodt
 *
 */
public class PrinterController {

  /**
   * Just playing with printer.<br>
   * Run the programm and take a look at the output. Try to understand, where the outputs are coming
   * from. Maybe you want to draw an basic UML-diagram on the problem first.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {

    // we can create a new LaserPrinter
    LaserPrinter laserPrinter = new LaserPrinter();
    // the printer can print
    laserPrinter.print();
    laserPrinter.printImage();
    laserPrinter.printUsingLaser();

    // we can also create an LasterPrinter this way
    Printable laserPrinterTwo = new LaserPrinter();
    laserPrinterTwo.print();
    laserPrinterTwo.printImage();
    // we can not do this, because laserTwo is an Printable :(
    // laserPrinterTwo.printUsingLaser();

    SomeOtherPrinter someOtherPrinter = new SomeOtherPrinter();
    someOtherPrinter.print();
    someOtherPrinter.printImage();
  }

}
