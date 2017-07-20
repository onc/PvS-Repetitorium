# JavaFX



### Übersicht der JavaFX-Hierarchie

![JavaFX](content/images/javafx.svg)<!-- .element height="50%" width="50%" -->



### Setup im Code

```java
public class ExampleClass extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Hier steht der primäre GUI Code
  }
}```



### FX Komponenten

* `Button`
* `Label`
* `MenuBar`, `Menu`, `MenuItem`
* `CheckBox`
* `RadioButton`
* `TextField`
* `TextArea`
* `PasswordField`
* `ScrollPane`
* ...



### Layouts

LayoutManager verwalten das Layout des Fensters. 
Alle Komponenten werden dem Layout entsprechend skaliert und positioniert, auch wenn sich die Fenstergröße ändert.

* `VBox`, `HBox` *nebeneinander/übereinander*
* `StackPane` *aufeinander*
* `BorderPane` *Bereiche*
* `TilePane`, `FlowPane` *von links nach rechts*
* `AnchorPane` *absolut oder relativ zu umgebenden Rändern*
* `GridPane` *Gitternetz*

Note: TilePane: alle so groß wie die Größte, FlowPane: alle nur so viel groß wie nötig



### BorderPane

![FX_BorderPane](content/images/fx-borderPane.png)<!-- .element height="50%" width="50%" -->



### BorderPane Example

```java
public class BorderPaneExample extends Application {
  ...
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("BorderPaneExample");
    BorderPane rootLayout = new BorderPane();

    Button top = new Button("top");
    BorderPane.setAlignment(top, Pos.CENTER);
    rootLayout.setTop(top);
    ... // das gleiche noch für left, right, center und bottom
    
    primaryStage.setScene(new Scene(rootLayout, 300, 300));
    primaryStage.show();
  }
}```



### TilePane

![FX-TilePane](content/images/fx-tilePane.png)



### TilePane Example

```java
public class TilePaneExample extends Application{
    ...
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TilePaneExample");
		TilePane rootLayout = new TilePane();
		
		Button button = new Button("I'm a Button!");
		TextArea textArea = new TextArea("I'm a TextArea!");
		TextField textField = new TextField("I'm a TextField!");
		RadioButton radioButton = new RadioButton("I'm a RadioButton!");

		rootLayout.getChildren().addAll(button, textArea, textField, radioButton);
		primaryStage.setScene(new Scene(rootLayout, 1076, 400));
		primaryStage.show();
	}
}```



### FlowPane

![FX-FlowPane](content/images/fx-flowPane.png)<!-- .element height="50%" width="50%" -->



### FlowPane Example

```java
public class FlowPaneExample extends Application{
    ...
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FlowPaneExample");
		FlowPane rootLayout = new FlowPane();
		
		Button button = new Button("I'm a Button!");
		TextArea textArea = new TextArea("I'm a TextArea!");
		TextField textField = new TextField("I'm a TextField!");
		RadioButton radioButton = new RadioButton("I'm a RadioButton!");

		rootLayout.getChildren().addAll(button, textArea, textField, radioButton);
		primaryStage.setScene(new Scene(rootLayout, 400, 400));
		primaryStage.show();
	}
}```



### GridPane

![FX-GridPane](content/images/fx-gridPane.png)<!-- .element height="50%" width="50%" -->



### GridPane Example

```java
public class GridPaneExample extends Application{
    ...
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("GridPaneExample");
		GridPane rootLayout = new GridPane();
		
		Button button = new Button("I'm a Button!");
		TextArea textArea = new TextArea("I'm a TextArea!");
		TextField textField = new TextField("I'm a TextField!");

		rootLayout.add(button, 1, 5, 1, 1);
		rootLayout.add(textArea, 1, 1, 3, 2);
		rootLayout.add(textField, 3, 4, 2, 1);
		
		primaryStage.setScene(new Scene(rootLayout, 500, 400));
		primaryStage.show();
		
	}
}```



# Übungen



### Aufgabe 1
Schreibe ein Programm, dass die folgende GUI erzeugt

![Swing Übung](content/images/swing-uebung.png)



### Lösung 1

<pre><code class="line-numbers java">JPanel topPanel = new JPanel();
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
this.setVisible(true);</code></pre>



### Aufgabe 2
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
container.add(panel);
this.setVisible(true);</code></pre>



### Lösung 2

![Swing Übung](content/images/swing-uebung-zwei.png)



### Aufgabe 3
Schreibe ein Programm, dass die folgende GUI erzeugt

![Swing Übung](content/images/swing-uebung-drei.png)



### Lösung 3

<pre><code class="line-numbers java">Container cp = getContentPane();
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
setVisible(true);</code></pre>




### Aufgabe 4
Welche GUI erzeugt das folgende Programm?

<pre><code class="line-numbers java">String[] solmisation = new String[] {"do", "re", "mi", "fa", "sol", "la", "si", "do"};

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
}</code></pre>



### Lösung 4

![Swing Übung](content/images/swing-uebung-vier.png)
