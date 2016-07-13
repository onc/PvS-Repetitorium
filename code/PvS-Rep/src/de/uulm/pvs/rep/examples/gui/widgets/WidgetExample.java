package de.uulm.pvs.rep.examples.gui.widgets;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Java swing widget examples.
 * 
 * @author Christian van Onzenoodt
 */
public class WidgetExample extends JFrame {

  private static final long serialVersionUID = 8967100311460513201L;
  private static final String WINDOW_TITLE = "WidgetExample";
  private static final Dimension PREFERRED_WINDOW_SIZE = new Dimension(800, 600);

  private static final Dimension TEXT_FIELD_SIZE = new Dimension(200, 24);

  /**
   * Default constructor.
   */
  public WidgetExample() {

    // Create a new Panel and add BoxLayout to it
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // Create all the widgets and add them to the panel
    this.addButton(panel);
    this.addLabel(panel);
    this.addTextField(panel);
    this.addScrollableTextArea(panel);
    this.addPasswordField(panel);
    this.addRadioButtons(panel);
    this.setMenuBar(this);

    // Get the ContentPane and add the Panel to the Pane
    Container container = this.getContentPane();
    container.add(panel);

    // Set JFrame options and show the Frame
    this.setTitle(WINDOW_TITLE);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setPreferredSize(PREFERRED_WINDOW_SIZE);
    this.setVisible(true);
  }

  /**
   * Creates a {@link JPasswordField} and adds it to the given {@link JPanel}.
   * 
   * @param panel - to add to
   */
  private void addPasswordField(JPanel panel) {

    JPasswordField passwordField = new JPasswordField("Password");
    passwordField.setPreferredSize(TEXT_FIELD_SIZE);
    passwordField.setMaximumSize(TEXT_FIELD_SIZE);
    panel.add(passwordField);
  }

  /**
   * Creates a {@link JTextArea}, wrap it into a {@link JScrollPane} and add everything to the given
   * {@link JPanel}.
   * 
   * @param panel - to add to
   */
  private void addScrollableTextArea(JPanel panel) {

    JTextArea textArea = new JTextArea("Das ist eine JTextArea.\n");
    textArea.append("Sie ist mehrzeilig.\n");
    textArea.append("Und kann sogar scrollen!");
    JScrollPane scrollPane = new JScrollPane(textArea);

    panel.add(scrollPane);
  }

  /**
   * Creates a {@link JTextField} and adds it to the given {@link JPanel}.
   * 
   * @param panel - to add to
   */
  private void addTextField(JPanel panel) {

    JTextField textField = new JTextField("Das ist ein JTextField");
    textField.setPreferredSize(TEXT_FIELD_SIZE);
    textField.setMaximumSize(TEXT_FIELD_SIZE);
    panel.add(textField);
  }

  /**
   * Creates a {@link JLabel} and adds it to the given {@link JPanel}.
   * 
   * @param panel - to add to
   */
  private void addLabel(JPanel panel) {

    JLabel label = new JLabel("Das ist ein JLabel");
    panel.add(label);
  }

  /**
   * Creates a {@link JButton} and adds it to the given {@link JPanel}.
   * 
   * @param panel - to add to
   */
  private void addButton(JPanel panel) {

    JButton button = new JButton("Das ist JButton mit ToolTip");
    button.setToolTipText("Das ist ein Button");
    panel.add(button);
  }

  /**
   * Creates some {@link JRadioButton}, adds them into a {@link ButtonGroup} and adds all
   * {@link JRadioButton} it to the given {@link JPanel}.
   * 
   * @param panel - to add to
   */
  private void addRadioButtons(JPanel panel) {

    JRadioButton firstButton = new JRadioButton("One");
    JRadioButton secoundButton = new JRadioButton("Two");

    ButtonGroup radioButtonGroup = new ButtonGroup();
    radioButtonGroup.add(firstButton);
    radioButtonGroup.add(secoundButton);

    panel.add(firstButton);
    panel.add(secoundButton);
  }

  /**
   * Creates a {@link JMenuBar}, {@link JMenu} and one {@link JMenuItem} and adds them as a
   * {@link JMenuBar} onto the given {@link JFrame}.
   * 
   * @param frame - to add to
   */
  private void setMenuBar(JFrame frame) {

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Datei");
    JMenuItem menuItem = new JMenuItem("Beenden");

    menu.add(menuItem);
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);
  }

  /**
   * Main-Method creates an instance of {@link WidgetExample} into the AWT-Thread.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {
    // passes an lambda function to the invokeLater method.
    // you can use this since java8 instead of new Runnable in this case.
    SwingUtilities.invokeLater(() -> {
      new WidgetExample();
    });
  }
}
