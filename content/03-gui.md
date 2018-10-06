# Java Swing



### Übersicht der Swing-Hierarchie

![Swing](content/images/swing.svg)<!-- .element height="50%" width="50%" -->



### Setup im Code

```java
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingWindow extends JFrame{
	public static void main(String[] args) {
		new PoemWindow();
	}
	
	public SwingWindow() {
		super(); // Aufruf ist nicht unbedingt notwendig
		setSize(300, 200);
		setTitle("Ein Fenster");		
		getContentPane().add(new JLabel("Hallo, PvS-Rep"));
		this.setVisible(true);
	}
}
```



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
* ...



### Layouts

LayoutManager verwalten das Layout des Fensters. 
Alle Komponenten werden dem Layout entsprechend skaliert und positioniert, auch wenn sich die Fenstergröße ändert.

* **`JFlowLayout` (!)**
* **`JGridLayout` (!)**
* **`JBorderLayout` (!)**
* `JBoxLayout`
* `JCardLayout` 

Note: Fett gedruckte sind Layouts sind die am häufigsten verwendeten

Werden gleich besprochen 



### FlowLayout Beispiel

![Swing FlowLayout](content/images/swing-flow-layout.png)<!-- .element height="50%" width="50%" -->

```java
public class FlowLayoutExample extends JFrame {
	public FlowLayoutExample() {
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		panel.add(new JButton("Button")); 
    	// ... 

		Container container = this.getContentPane();
    	container.add(panel);
    	this.setVisible(true);
	}
}
```

<small>Achtung: Keine 1 zu 1 umsetzung des Bildes!</small>



### GridLayout Beispiel

![Swing GridLayout](content/images/swing-grid-layout.png)<!-- .element height="50%" width="50%" -->

```java
public class GridLayoutExample extends JFrame {
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
}
```



### BorderLayout Beispiel

![Swing BorderLayout](content/images/swing-border-layout.png)<!-- .element height="50%" width="50%" -->

```java
public class BorderLayoutExample extends JFrame {
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
}
```



# Übungen



### Aufgabe 1
Schreibe ein Programm, das die folgende GUI erzeugt 

![Swing Übung](content/images/swing-uebung.png)<!-- .element height="50%" width="50%" -->



### Lösung 1

```java
	JPanel topPanel = new JPanel(); 
	topPanel.setLayout(new GridLayout(2, 2));

	topPanel.add(new JLabel("Name: ")); 
	topPanel.add(new JTextField()); 
	topPanel.add(new JLabel("Passwort: "));
	topPanel.add(new JPasswordField());

	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	panel.add(topPanel, BorderLayout.CENTER); 
	panel.add(new JButton("Login"), BorderLayout.SOUTH);
	
	Container contentPane = this.getContentPane(); 
	contentPane.add(panel); 
	this.setVisible(true); 
```



### Aufgabe 2
Welche GUI erzeugt das folgende Programm?

```java
	JPanel panel = new JPanel(); 
	panel.setLayout(new BorderLayout()); 

	JPanel bottomPanel = new JPanel();  
	bottomPanel.setLayout(new FlowLayout()); 
	bottomPanel.add(new JButton("Abbrechen"));
	bottomPanel.add(new JButton("Ok")); 
	
	panel.add(new JTextArea(), BorderLayout.CENTER); 
	panel.add(bottomPanel, BorderLayout.SOUTH); 
	
	Container container = this.getContentPane(); 
	container.add(panel); 
	this.setVisible(true);
```



### Lösung 2

![Swing Übung](content/images/swing-uebung-zwei.png)<!-- .element height="50%" width="50%" -->



### Aufgabe 3
Schreibe ein Programm, dass die folgende GUI erzeugt

![Swing Übung](content/images/swing-uebung-drei.png)<!-- .element height="50%" width="50%" -->



### Lösung 3

```java
	Container cp = getContentPane();
	cp.setLayout(new BorderLayout());

	JPanel top = new JPanel();
	top.add(new JLabel("Celsius"));
	top.add(new JTextField("", 14));
	
	JPanel bottom = new JPanel();
	bottom.add(new JLabel("Fahrenheit"));
	bottom.add(new JTextField("", 14));
	
	cp.add(top, BorderLayout.NORTH);
	cp.add(bottom, BorderLayout.SOUTH);
	cp.add(new JButton("Convert"), BorderLayout.CENTER);
	setSize(250, 200);
	setTitle("Converter");
	setVisible(true);
```



### Aufgabe 4
Welche GUI erzeugt das folgende Programm?

```java
String[] solmisation = new String[] {"do", "re", "mi", "fa", "sol", "la", "si", "do"};

private Nested() {
	JPanel top = new JPanel();
	addPanel(top, 0);
	getContentPane().setLayout(new BorderLayout());
	getContentPane().add(top, BorderLayout.CENTER);
	this.pack(); 
	this.setVisible(true); 
} 

private JPanel addPanel(JPanel parent, int depth) {
	if (depth >= solmisation.length)
		return null; 

	JPanel child = new JPanel(); 
	child.add(new JButton(solmisation[depth]));
	parent.setBorder(BorderFactory.createLineBorder(Color.black));
	parent.add(child);
	return addPanel(child, depth+1);
}
```



### Lösung 4

![Swing Übung](content/images/swing-uebung-vier.png)<!-- .element height="50%" width="50%" -->



### Bonus

* Was wird `setBorder(...)` bewirken?
* Was könnte `setHgap(3.0)` bedeuten?
* Was stellt ihr euch unter `applyComponentOrientation(...)` vor?
* Was könnte `setAlwaysOnTop(true)` bewirken?
* Was macht wohl `setResizable(false)`?

