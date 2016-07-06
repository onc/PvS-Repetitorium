package de.uulm.pvs.rep.examples.layouts;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Java swing {@link GridBagLayout}-example.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class GridLayoutExample extends JFrame {

  private static final long serialVersionUID = -5218905969823758710L;
  private static final String WINDOW_TITLE = "GridLayoutExample";

  private static final int GRID_ROWS = 5;
  private static final int GRID_COLS = 3;
  private static final int GRID_GAP = 5;

  /**
   * Default contructor.
   */
  public GridLayoutExample() {

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS, GRID_GAP, GRID_GAP));

    for (int y = 0; y < GRID_ROWS; y++) {
      for (int x = 0; x < GRID_COLS; x++) {
        JButton button = new JButton("Button at (x: " + x + ", y: " + y + ")");
        panel.add(button);
      }
    }

    Container container = this.getContentPane();
    container.add(panel);

    this.setTitle(WINDOW_TITLE);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  /**
   * Main-Method creates an instance of {@link GridLayoutExample} into the AWT-Thread.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new GridLayoutExample();
    });
  }

}
