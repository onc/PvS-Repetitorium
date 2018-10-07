# GUI



## Java Swing



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



# Handler und Observer 



## Observer Pattern
### Das Beobachter-Muster
Am Beispiel dieses Repetitoriums



In diesem Beispiel ist der Tutor (*ich*) der Erzähler, der den Stoff von PvS erklärt. 

Die Zuhörer (*ihr*) sind diejenigen, die sich für den Stoff interessieren und aufmerksam zuhören. 

Wir nennen den Tutor jetzt **observable** (beobachtbar) und die Studenten **Observer** (Beobachter).



Solange ein Observable einen oder mehrere Observer hat erzählt er, sendet also Mitteilungen. 

Wenn allerdings kein Observer dem Observable zuhört, dann schweigt er auch. 



Sind Observer nicht mehr am Stoff interessiert, dann können sie sich abmelden (den Raum verlassen) und bekommen keine neuen Nachrichten.

Sollten neue/abgemeldete Observer (wieder) Interesse am Stoff haben, können sie sich beim Observable anmelden (den Raum betreten) und werden (wieder) informiert.



### Beispiel: Die Push Variante
Im Push-Modell übergibt der Observable der `update()`-Methode detaillierte Informationen über die Änderung als Parameter.

Der Vorteil hierbei ist, dass Observer und Observable stärker entkoppelt sind, da der Observer keine Informationen über das Observable benötigt.



### Beispiel: Die Push Variante
![Observer](content/images/Observer_push.svg)
Note: ANIMIERT! Separat öffnen, da die Animation sonst nicht funktioniert.




### Beispiel: Die Pull Variante
Beim Pull-Modell erhält der Observer nur eine minimale Benachrichtigung und muss sich die benötigten Informationen selbst vom Observable *holen*. 

Dazu erhält/besitzt der Observer eine Referenz auf das Observable, die entweder in einer Instanzvariable beim Registrieren gespeichert wurde oder als Argument der `update()`-Methode übergeben wird.



### Beispiel: Die Pull Variante
![Observer](content/images/Observer_pull.svg)
Note: ANIMIERT! Separat öffnen, da die Animation sonst nicht funktioniert.



### Was kann beobachtet werden?
* Eigene Klassen
    * StudentBoard Beispiel aus der Übung
    * ...
* Collections von javaFX 
    * ObservableList
    * ObservableMap
    * ...
* ...



### Schwierigkeiten von Observer/Observable
Die Typen Observer/Observable bieten eine grundlegende Möglichkeit, das Beobachter-Muster in Java zu realisieren. ABER: 
* Die Typen Observer/Observable sind nicht generisch deklariert; `update()` kann immer nur ein Object übergeben werden.
* Alternativ deklariert der Observer genau eine `update()`-Methode. Sollen jetzt unterschiedliche Ereignisse gemeldet werden, können verschiedene Objekte verwendet werden. Das führt allerdings zu Fallunterscheidungen in der `update()`-Methode, und die Codequalität verschlechtert sich.



## Events und Handler



### Events
Die Java VM erstellt beim Auftreten eines Ereignisses (z.B. Button-Klick) automatisch ein Objekt der entsprechenden Event-Klasse.



### Events
| Klassenname | Auslösung                                  | Beispiel                         |
| ----------- | ------------------------------------------ | -------------------------------- |
| ActionEvent | GUI-Komponenten werden betätigt            | Betätigen eines Buttons          |
| FocusEvent  | Komponente bekommt oder verliert den Fokus | Nutzer klickt in TextArea        |
| MouseEvent  | Mausaktionen werden getätigt               | Maus klick                       |
| TextEvent   | Text einer Komponente verändert sich       | In TextArea wird Text eingegeben |
| WindowEvent | Zustand eines Fensters ändert sich         | Fenster schließen                |
| XXXEvent    | ...                                        | ...                              |
| ...         | ...                                        | ...                              |



### Event Methoden(1/2)
#### ActionEvent
| Rückgabewert | Methode              | Aufruf                                                 |
| ------------ | -------------------- | ------------------------------------------------------ |
| String       | `getActionCommand()` | Gibt zugehörigen command-String zurück                 |
| int          | `getModifiers()`     | Gibt modifizierende Keys (Strg, Umschalt, etc.) zurück |
| long         | `getWhen()`          | Gibt Zeitstempel des Auftretens zurück                 |
| ...          | ...                  | ...                                                    |



### Event Methoden(2/2)
#### MouseEvent
| Rückgabewert | Methode           | Aufruf                                                             |
| ------------ | ----------------- | ------------------------------------------------------------------ |
| int          | `getButton()`     | Gibt zurück welcher (wenn überhaupt) Knopf der Maus gedrückt wurde |
| int          | `getClickCount()` | Gibt die Anzahl der Klicks eines Events zurück                     |
| int          | `getX()`          | Gibt die X Koordinate relativ zur Komponente zurück                |
| int          | `getY()`          | Gibt die Y Koordinate relativ zur Komponente zurück                |
| ...          | ...               | ...                                                                |



Nicht jedes Event ist relevant, daher gibt es in Java fertige Handler, die auf die wichtigsten Events reagieren:
* ActionEvent.ANY
* InputEvent.ANY
    * MouseEvent.ANY
        * MouseEvent.MOUSE_PRESSED
        * MouseEVent.MOUSE_RELEASED
        * ...
    * KeyEvent.ANY
    * ...
* WindowEvent.ANY
    * ...
* ...



## Event Processing
Wichtig sind hier die **Event Capturing Phase** in der das Event 'aufgenommen' wird und die **Event Bubbling Phase** in der das Event weiter verarbeitet wird



### Filter und Handler
Filter und Handler reagieren beim Eintreten eines Events entsprechend (wie programmiert).

Der große Unterschied liegt darin, dass Events zuerst beim Filter ankommen.



#### Filter
Während der Event Capturing Phase

Ein Filter auf einem Eltern-Knoten kann die Verarbeitung eines Events für mehrere Kind-Knoten bereitstellen



#### Handler
Während der Event Bubbling Phase

Wenn ein Handler auf einem Kind-Knoten das Event nicht konsumiert (`consume()`) kann das Event vom Eltern-Knoten weiter verarbeitet werden.



Filter sind im Grunde Handler
```java
myButton.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
    ...
}

myButton.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
    ...
}
```

Ein Handler wir sozusagen als Filter oder Handler registriert.

Note: deswegen besprechen wir nur handler stellvertretend



### Handler

Jeder Handler implementiert das EventHandler-Interface

Ein Handler kann eine eigene Klasse, eine anonyme Klasse oder ein Funktionsparameter (Lambda) sein.

Note: Allgemeine Handler!



#### Eigene Klasse
```java
public class MyHandler implements EventHandler<MouseEvent> {
	@Override
	public void handle(MouseEvent event) {
		System.out.println("Mouse Event");
	}

```

```java 
MyHandler handler = new MyHandler();
myButton.addEventHandler(MouseEvent.ANY, handler);

myButton.addEventHandler(MouseEvent.ANY, new MyHandler());
```

Note: innerhalb der handle-methode if-block für spezifische events



#### Anonyme Klasse
```java
myButton.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
                System.out.println("Mouse Event");
			}
		});
```



#### Anonyme Funktion (Lambda)
```java
myButton.setOnMousePressed((MouseEvent event) -> {
    System.out.println("Mouse Event: Mouse Pressed!");
});
```

Note: hier dann keine allgemeinen Handler mehr!



#### Vordefinierte Methoden
Statt einen allgemeinen Handler hinzuzufügen und ein bestimmtes Event als Parameter zu definieren, kann ein Handler auch gleich für ein bestimmtes Event hinzugefügt werden!



#### Vordefinierte Methoden
* setOnAction
* setOnMouseClicked
* setOnMouseMoved
* setOnKeyPressed
* ...



#### Beispiele:
```java
myButton.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public void handle(ActionEvent event) {
        // your code
    }
});

myButton.setOnMouseClicked((MouseEvent event) -> {
    // your code
});
```



#### Consume
Konsumieren bedeutet, dass das Event-Objekt nicht weitergegeben wird. 

Stattdessen wird es als entfernbar markiert und vom GarbageCollector aufgeräumt.



Events können auch frühzeitig konsumiert und so die standardgemäße Abarbeitung unterbrochen werden.
```java
public void consume()
```

> Consumes this event so that it will not be processed in the default manner by the source which originated it. - java API



## ActionEvent
* ActionEvent.ANY
* ActionEvent.ACTION



### Aufgabe
Was passiert in dieser Klasse?
```java
public class HandlerExample01 extends Application implements EventHandler<ActionEvent>{
	Button myButton;
	TextArea myTextArea;
	
	public static void main(String[] args) {...}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
        ...
		myButton = new Button("Click me!");
		myButton.setOnAction(this);
		myTextArea = new TextArea("Hello World!");
        ...
		myButton.getOnAction().handle(new ActionEvent());
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(myTextArea.getText());
	}
}
```



### Antwort
1. Fenster wird gezeichnet & dargestellt
2. Button click wird simuliert
2. Ausgabe des Textes der TextArea: "Hallo Welt!"



## MouseEvent
* MouseEvent.ANY
* MouseEvent.MOUSE_ENTERED
* MouseEvent.MOUSE_EXITED
* MouseEvent.MOUSE_PRESSED
* MouseEvent.MOUSE_RELEASED
* MouseEvent.MOUSE_CLICKED
* MouseEvent.MOUSE_DRAGGED
* ...



### Aufgabe
Was passiert hier, wenn der Button geklickt wird?
```java
		myButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Clicked");
				event.consume();
			}
		});

		myButton.setOnMouseReleased((MouseEvent event) -> {
			System.out.println("Released");
		});
		
		myButton.setOnMousePressed((MouseEvent event) -> {
			System.out.println("Pressed");
		});
		
		myButton.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Clicked");
		});
```



### Antwort
Ausgabe von 
* *Pressed* 
* *Released*
* *Clicked*

ein zweites mal *Clicked* wird nicht ausgegeben



### Aufgabe 
Betrachte Folgende GUI

![Swing-Übung](content/images/swing-uebung.png)<!-- .element height="25%" width="25%" -->

Was passiert beim Klick?
```java
		grid.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() { // grid ist das Pane im Grid-Layout
			@Override
			public void handle(MouseEvent event) {
				nameInput.setText("clicked");
				event.consume();
			}
		});
```



### Antwort
* Beim Button passiert nichts, da kein Handler hinzugefügt wurde
* Sonst wird immer 'clicked' in das obere Textfeld geschrieben



und jetzt?
```java
		grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				nameInput.setText("clicked");
			}
		});
		
		passInput.setOnMouseClicked(new EventHandler<MouseEvent>() { // passInput ist das Passwort-Feld
			@Override
			public void handle(MouseEvent event) {
				passInput.setText("also clicked");
			}
		});

		nameInput.setOnMouseClicked(new EventHandler<MouseEvent>() { // nameInput ist das Name-Feld
			@Override
			public void handle(MouseEvent event) {
				nameInput.setText("clicked textfield");
			}
		});
```



### Antwort
* Beim Button passiert nichts
* Beim Klick auf das untere Textfeld wird 'also clicked' reingeschrieben
* Beim Klick auf das obere Textfeld wird 'clicked textfield' reingeschrieben
* Bei den Labels wird 'clicked' in das obere Feld geschrieben



# Das MVC-Muster

Das Model View Controller (kurz MVC)-Pattern ist ein Architekturmuster bzw. Entwurfsmuster, das einen flexiblen Programmentwurf bietet, eine spätere Änderung oder Erweiterung erleichtert und eine Wiederverwendbarkeit der einzelnen Komponenten ermöglicht.

Anwendungen, welche nach den Prinzipien von MVC gestaltet werden, bestehen aus drei austauschbaren Komponenten. 
* Model - Die Daten (-haltung)
* View - Die darstellenden Komponenten
* Controller - Die Steuerung der Anwendung



## Model
Das **Model** besteht aus mehreren Model-Klassen. Jede repräsentiert eine grundlegende Einheit innerhalb der verwendeten Datenstruktur. Sie stellen darüber hinaus grundlegende Datenoperationen zur Verfügung, welche nicht der prinzipiellen Programmlogik zugehörig sind. Beispiele dafür wären die Suche gewisser Inhalte oder das Hinzufügen und Löschen von Daten.



## View
**View**-Klassen stellen die grafische Benutzeroberfläche bereit. Die Model-Klassen stellen die angezeigten Daten zur Verfügung, eine direkte Verbindung zwischen den beiden Programmteilen existiert allerdings nicht. Der Controller informiert die Bestandteile der Oberflächendarstellung über Änderungen am Model und diese passen die angezeigten Inhalte bei Bedarf an.



## Controller
Die **Controller**-Klassen fungieren als Verbindungsstück zwischen View- und Model-Bestandteilen. Aktionen der Nutzer leitet der View zum Controller weiter, welcher die dahinterstehende Programmlogik ausführt. Die Logik informiert einzelne Views im Bedarfsfall über Änderungen am Model, um eine passende Reaktion auf diese zu ermöglichen.



## Veranschaulichung
![Swing-Übung](content/images/MVC.png)<!-- .element height="50%" width="50%" -->

Note: hierzu am besten frei erzählen. Auch wichtig: Das MVC-Muster ist keine strikte Vorgabe, es gibt Zeiten, da ist es nicht ohne Probleme anwendbar und stellt nur eine **Orientierung** dar.
