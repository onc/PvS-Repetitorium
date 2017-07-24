# Listener und Observer



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
Note: ANIMIERT! Seperat öffnen, da die Animation sonst nicht funktioniert.




### Beispiel: Die Pull Variante
Beim Pull-Modell erhält der Observer nur eine minimale Benachrichtigung und muss sich die benötigten Informationen selbst vom Observable *holen*. 

Dazu erhält/besitzt der Observer eine Referenz auf das Observable, die entweder in einer Instanzvariable beim Registrieren gespeichert wurde oder als Argument der `update()`-Methode übergeben wird.



### Beispiel: Die Pull Variante
![Observer](content/images/Observer_pull.svg)
Note: ANIMIERT! Seperat öffnen, da die Animation sonst nicht funktioniert.



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
|Klassenname|Auslösung|Beispiel|
|---|---|---|
|ActionEvent|GUI-Komponenten werden betätigt|Betätigen eines Buttons|
|FocusEvent|Komponente bekommt oder verliert den Fokus|Nutzer klickt in TextArea|
|MouseEvent|Mausaktionen werden getätigt|Maus klick|
|TextEvent|Text einer Komponente verändert sich|In TextArea wird Text eingegeben|
|WindowEvent|Zustand eines Fensters ändert sich|Fenster schließen|
|XXXEvent|...|...|
|...|...|...|



### Event Methoden(1/2)
#### ActionEvent
|Rückgabewert|Methode|Aufruf|
|---|---|---|
|String|`getActionCommand()`|Gibt zugehörigen command-String zurück|
|int|`getModifiers()`|Gibt modifizierende Keys (Strg, Umschalt, etc.) zurück|
|long|`getWhen()`|Gibt Zeitstempel des Auftretens zurück|
|...|...|...|



### Event Methoden(2/2)
#### MouseEvent
|Rückgabewert|Methode|Aufruf|
|---|---|---|
|int|`getButton()`|Gibt zurück welcher (wenn überhaupt) Knopf der Maus gedrückt wurde|
|int|`getClickCount()`|Gibt die Anzahl der Klicks eines Events zurück|
|int|`getX()`|Gibt die X Koordinate relativ zur Komponente zurück|
|int|`getY()`|Gibt die Y Koordinate relativ zur Komponente zurück|
|...|...|...|



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
myButton.addEventFilter(MouseEvent.ANY), new EventHandler<MouseEvent>() {
    ...
}

myButton.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
    ...
}
```

Ein Handler wir sozusagen als Filter oder Handler registriert.

Note: deswegen besprechen wir nur handler stellvertretend



### Handler

Jeder Hanlder implementiert das EventHandler-Interface

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
Ausgabe von Pressed, Released, Clicked; nicht zweimal Clicked



### Aufgabe 
Betrachte Folgende GUI

![FX-Übung](content/images/fx-uebung01.png)<!-- .element height="25%" width="25%" -->

Was passiert beim Klick?
```java
		grid.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				nameInput.setText("clicked");
				event.consume();
			}
		});
		
		passInput.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				passInput.setText("also clicked");
			}
		});
```



### Antwort
* Beim Button passiert nichts
* Sonst wird immer 'clicked' in das obere Textfeld geschrieben



und jetzt?
```java
		grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				nameInput.setText("clicked");
			}
		});
		
		passInput.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				passInput.setText("also clicked");
			}
		});

		nameInput.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
