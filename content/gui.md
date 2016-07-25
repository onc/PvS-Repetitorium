# Swing



### Übersicht der Swing-Hierarchie

![Swing](content/images/swing.svg)



### Swing Komponenten

* `JButton`
* `JLabel`
* `JMenuBar`, `JMenu`, `JMenuItem`
* `JCheckBox`
* `JRadioButton`
* `JTextField`
* `JTextArea`
* `JPasswordField`
* `JScrollPane`



### Layouts

LayoutManager verwalten das Layout des Fensters. 
Alle Komponenten werden dem Layout entsprechend skaliert und positioniert, auch wenn sich die Fenstergröße ändert.

* `JFlowLayout` (!)
* `JGridLayout` (!)
* `JBorderLayout` (!)
* `JBoxLayout`
* `JCardLayout`



### FlowLayout

![Swing FlowLayout](content/images/swing-flow-layout.png)



### FlowLayout Example

<pre><code class="line-numbers java" data-highlight-lines="4-6">public class FlowLayoutExample extends JFrame {
  public FlowLayoutExample() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    panel.add(new JButton("Button"));
    // ...

    Container container = this.getContentPane();
    container.add(panel);

    this.setVisible(true);
  }
}</code></pre>



### BorderLayout

![Swing BorderLayout](content/images/swing-border-layout.png)



### BorderLayout Example

<pre><code class="line-numbers java" data-highlight-lines="5-10"> public class BorderLayoutExample extends JFrame {

  public BorderLayoutExample() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
  
    panel.add(new JButton("North"), BorderLayout.NORTH);
    panel.add(new JButton("South"), BorderLayout.SOUTH);
    panel.add(new JButton("West"), BorderLayout.WEST);
    panel.add(new JButton("Center"), BorderLayout.CENTER);
  
    Container container = this.getContentPane();
    container.add(panel);
  
    this.setVisible(true);
  }
}</code></pre>




### GridLayout

![Swing GridLayout](content/images/swing-grid-layout.png)



### GridLayout Example

<pre><code class="line-numbers java" data-highlight-lines="8-15">public class GridLayoutExample extends JFrame {

  private static final int GRID_ROWS = 5;
  private static final int GRID_COLS = 3;

  public GridLayoutExample() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS, GRID_GAP));

    for (int y = 0; y < GRID_ROWS; y++) {
      for (int x = 0; x < GRID_COLS; x++) {
        JButton button = new JButton("Button at (x: " + x + ", y: " + y + ")");
        panel.add(button);
      }
    }

    Container container = this.getContentPane();
    container.add(panel);

    this.setVisible(true);
  }
}</code></pre>



# Übungen



Schreibe ein Programm, dass die folgende GUI erzeugt

![Swing Übung](content/images/swing-uebung.png)



Lösung

<pre><code class="line-numbers java">JPanel topPanel = new JPanel();
topPanel.setLayout(new GridLayout(2, 2));

topPanel.add(new JLabel("Name: "));
topPanel.add(new JTextField());

topPanel.add(new JLabel("Passwort: "));
topPanel.add(new JPasswordField());

JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());

panel.add(leftPanel, BorderLayout.CENTER);
panel.add(new JButton("Login"), BorderLayout.SOUTH);

Container contentPane = this.getContentPane();
contentPane.add(panel);</code></pre>



Welche GUI erzeugt das folgende Programm?

<pre><code class="line-numbers java">JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());

JPanel bottomPanel = new JPanel();
bottomPanel.setLayout(new FlowLayout());

bottomPanel.add(new JButton("Abbrechen"));
bottomPanel.add(new JButton("Ok"));

panel.add(new JTextArea(), BorderLayout.CENTER);
panel.add(bottomPanel, BorderLayout.SOUTH);

Container container = this.getContentPane();
container.add(panel);</code></pre>



Lösung

![Swing Übung](content/images/swing-uebung-zwei.png)

