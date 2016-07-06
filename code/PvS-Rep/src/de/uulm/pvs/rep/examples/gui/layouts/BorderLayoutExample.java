package de.uulm.pvs.rep.examples.gui.layouts;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Java swing {@link BorderLayout}-example.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class BorderLayoutExample extends JFrame {

  private static final long serialVersionUID = -2967025487459243852L;
  private static final String WINDOW_TITLE = "BorderLayoutExample";

  /**
   * Default constructor.
   */
  public BorderLayoutExample() {

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());

    JButton northButton = new JButton("North");
    JButton southButton = new JButton("South");
    JButton eastButton = new JButton("East");
    JButton westButton = new JButton("West");
    JButton centerButton = new JButton("Center");

    panel.add(northButton, BorderLayout.NORTH);
    panel.add(southButton, BorderLayout.SOUTH);
    panel.add(eastButton, BorderLayout.EAST);
    panel.add(westButton, BorderLayout.WEST);
    panel.add(centerButton, BorderLayout.CENTER);

    Container container = this.getContentPane();
    container.add(panel);

    this.setTitle(WINDOW_TITLE);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  /**
   * Main-Method creates an instance of {@link BorderLayoutExample} into the AWT-Thread.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new BorderLayoutExample();
    });
  }


}
