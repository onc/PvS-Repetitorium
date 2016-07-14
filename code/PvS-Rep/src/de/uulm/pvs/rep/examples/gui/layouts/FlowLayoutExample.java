package de.uulm.pvs.rep.examples.gui.layouts;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Java swing {@link FlowLayout}-example.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class FlowLayoutExample extends JFrame {

  private static final long serialVersionUID = -7297666990106294513L;
  private static final String WINDOW_TITLE = "FlowLayoutExample";
  private static final Dimension PREFERRED_WINDOW_SIZE = new Dimension(800, 600);
  private static final int AMOUNT_OF_BUTTONS = 10;

  /**
   * Default constructor.
   */
  public FlowLayoutExample() {

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    JLabel label = new JLabel("FlowLayoutExample - try to resize the window!");
    panel.add(label);

    // Create some sample Buttons, to see how FlowLayout works
    for (int i = 0; i < AMOUNT_OF_BUTTONS; i++) {
      JButton button = new JButton("Button Nr: " + i);
      panel.add(button);
    }

    Container container = this.getContentPane();
    container.add(panel);

    this.setTitle(WINDOW_TITLE);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setPreferredSize(PREFERRED_WINDOW_SIZE);
    this.setVisible(true);
  }

  /**
   * Main-Method creates an instance of {@link FlowLayoutExample} into the AWT-Thread.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new FlowLayoutExample();
    });
  }

}
