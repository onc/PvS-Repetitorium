package de.uulm.pvs.rep.examples.gui.menu;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

/**
 * Java swing menu example.
 *
 * @author Christian van Onzenoodt
 *
 */
public class MenuExample extends JFrame {

  private static final long serialVersionUID = -3786239345295570453L;
  private static final String WINDOW_TITLE = "MenuExample";
  private static final Dimension PREFERED_WINDOW_SIZE = new Dimension(800, 600);

  private static final String MENU_TITLE_CAPTION = "Datei";

  private static final String MENU_ITEM_SAVE_CAPTION = "Speichern";
  private static final String MENU_ITEM_SAVE_AS_CAPTION = "Speichern unter";
  private static final String MENU_ITEM_EXIT_CAPTION = "Beenden";

  /**
   * Create the menuExample.
   */
  public MenuExample() {

    // Create the menuItems
    JMenuItem saveMenuItem = new JMenuItem(MENU_ITEM_SAVE_CAPTION);
    JMenuItem saveAsMenuItem = new JMenuItem(MENU_ITEM_SAVE_AS_CAPTION);
    JMenuItem exitMenuItem = new JMenuItem(MENU_ITEM_EXIT_CAPTION);

    // create the 'file' menu
    JMenu fileMenu = new JMenu(MENU_TITLE_CAPTION);
    // add the items to the menu
    fileMenu.add(saveMenuItem);
    fileMenu.add(saveAsMenuItem);
    fileMenu.add(new JSeparator());
    fileMenu.add(exitMenuItem);

    // create a menuBar
    JMenuBar menuBar = new JMenuBar();
    // add the menu to the menuBar
    menuBar.add(fileMenu);

    // set the menuBar to the JFrame(this)
    this.setJMenuBar(menuBar);

    // show the window
    this.setTitle(WINDOW_TITLE);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setPreferredSize(PREFERED_WINDOW_SIZE);
    this.setVisible(true);
  }

  /**
   * Main-Method creates an instance of {@link MenuExample} into the AWT-Thread.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new MenuExample();
    });
  }
}
