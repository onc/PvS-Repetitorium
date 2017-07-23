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
Schreibe ein Programm, das die folgende GUI erzeugt 

![FX-Übung](content/images/fx-uebung01.png)<!-- .element height="50%" width="50%" -->



### Lösung 1 (1/2)

```java
		primaryStage.setTitle("FX-Übung 01");
		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();
				
		Label name = new Label("Name: ");
		name.setPrefSize(150, 75);
		TextField nameInput = new TextField();
		nameInput.setPrefSize(150, 75);
		
		Label pass = new Label("Password: ");
		pass.setPrefSize(150, 75);
		TextField passInput = new TextField();
		passInput.setPrefSize(150, 75);

		Button login = new Button("Login");
		login.setPrefSize(300, 50);
        ...```



### Lösung 1 (2/2)

```java
        ...
		grid.addColumn(1, name, pass);
		grid.addColumn(2, nameInput, passInput);
		
		root.setCenter(grid);
		root.setBottom(login);
		
		BorderPane.setAlignment(grid, Pos.CENTER);
		BorderPane.setAlignment(login, Pos.TOP_CENTER);
	
		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();	
```



### Aufgabe 2
Welche GUI erzeugt das folgende Programm?

```java
		primaryStage.setTitle("FX-Übung 02");
		BorderPane root = new BorderPane();
		FlowPane flow = new FlowPane();
		
		Button cancel = new Button("Abbrechen");
		Button okay = new Button("OK");
		
		TextArea textArea = new TextArea();
		
		flow.getChildren().addAll(cancel, okay);
		root.setCenter(textArea);
		root.setBottom(flow);
	
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
```



### Lösung 2

![FX-Übung](content/images/fx-uebung02.png)<!-- .element height="50%" width="50%" -->



### Aufgabe 3
Schreibe ein Programm, dass die folgende GUI erzeugt

![FX-Übung](content/images/fx-uebung03.png)<!-- .element height="50%" width="50%" -->



### Lösung 3

```java
		primaryStage.setTitle("FX-Übung 03");
		BorderPane root = new BorderPane();
		TilePane top = new TilePane();
		FlowPane bottom = new FlowPane();
		
		Label c = new Label("Celsius");
		TextField celsius = new TextField();
		Label f = new Label("Fahrenheit");
		TextField fahrenheit = new TextField();
		Button button = new Button("Convert");
		button.prefWidthProperty().bind(root.widthProperty());
		button.prefHeightProperty().bind(root.heightProperty());
		
		top.getChildren().addAll(c, celsius);
		bottom.getChildren().addAll(f, fahrenheit);
		root.setCenter(button);
		root.setTop(top);
		root.setBottom(bottom);
	
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
```



### Aufgabe 4
Welche GUI erzeugt das folgende Programm?

```java
	String[] solmisation = new String[] {"do", "re", "mi", "fa", "sol"};
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FX-Übung 04");
		HBox root = new HBox();
		addHBox(root, 0);

		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();	
	}
	
	private HBox addHBox(HBox parent, int depth) {
		if(depth >= solmisation.length) {
			return null;
		} else {
			HBox child = new HBox();
			child.getChildren().add(new Button(solmisation[depth]));
			parent.getChildren().add(child);
			return addHBox(child, depth+1);
		}
	}```



### Lösung 4

![FX-Übung](content/images/fx-uebung04.png)<!-- .element height="50%" width="50%" -->

