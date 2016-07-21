#Listener und Observer



##Observer Pattern
###Das Beobachter-Muster
Wir erläutern das Observer-Pattern anhand des PvS-Repetitoriums. 

In diesem Beispiel sind die Tutoren (*wir*) die Erzähler und erklären den Stoff von Programmierung von Systemen. Die Zuhörer (*ihr*) seid diejenigen, welche sich für den Stoff interessieren und aufmerksam zuhören. Wir nennen die Tutoren jetzt Observable (beobachtbar) und die Studenten Observer(Beobachter).

Solange ein Observable einen oder mehrere Observer hat erzählt er, sendet also Mitteilungen. Wenn allerdings kein Observer dem Observable zuhört, dann schweigt er auch. 

Die Observer sind vielleicht nicht immer am Stoff interessiert, dann können sie sich beim Observer abmelden und bekommen keine neuen Nachrichten.
Sollten neue Observer hinzu kommen, können sich diese beim Observable anmelden und werden auch informiert.
Note: Vorlesen!



###Beispiel: Die Push Variante
Im Push-Modell übergibt der Observable der update()-Methode detaillierte Informationen über die Änderung als Parameter.

Der Vorteil hierbei ist, dass Observer und Observable stärker entkoppelt sind, da der Observer keine Informationen über den Observable benötigt.



###Beispiel: Die Push Variante
![Observer](content/images/Observer_push.svg)
Note: ANIMIERT! Seperat öffnen, da die Animation sonst nicht funktioniert.




###Beispiel: Die Pull Variante
Beim Pull-Modell erhält der Observer nur eine minimale Benachrichtigung und muss sich die benötigten Informationen selber aus vom Observable holen. Dazu erhält/besitzt es eine Referenz auf diesen (entweder in einer Instanzvariable beim Registrieren gespeichert oder via Argument der update()-Methode).



###Beispiel: Die Pull Variante
![Observer](content/images/Observer_pull.svg)
Note: ANIMIERT! Seperat öffnen, da die Animation sonst nicht funktioniert.



###Schwierigkeiten von Observer/Observable
Die Typen Observer/Observable bieten eine grundlegende Möglichkeit, das Beobachter-Muster in Java zu realisieren. Allerdings gibt es ein paar Dinge, die Entwickler sich noch zusätzlich wünschen:
* Die Typen Observer/Observable sind nicht generisch deklariert, was dazu führt, dass bei update() immer nur alles als Object übergeben werden kann.
* Oder Observer deklariert nur genau eine update()-Methode. Wenn der Ereignisauslöser unterschiedliche Ereignisse melden möchte, gibt es nur eine Lösung: unterschiedliche Ergebnis-Objekte. Das wiederum führt zu Fallunterscheidungen in der update()-Methode, und die Codequalität verschlechtert sich.



##Events und Listener



###Events
Die Java VM erstellt bei Auftreten eines Ereignisses, wie bspw. das Klicken eines Buttons, automatisch ein Objekt der entsprechenden Event-Klasse.



###Events
|Klassenname|Auslösung|Beispiel|
|---|---|---|
|ActionEvent|GUI-Komponenten werden betätigt|Betätigen eines Buttons|
|FocusEvent|Komponente bekommt oder verliert den Fokus|Nutzer klickt in JTextArea|
|MouseEvent|Mausaktionen werden getätigt|Maus klick|
|TextEvent|Text einer Komponente verändert sich|In JTextArea wird Text eingegeben|
|WindowEvent|Zustand eines Fensters ändert sich|Fenster schließen|
|...|...|...|



###Event Methoden
####ActionEvent
|Rückgabewert|Methode|Aufruf|
|---|---|---|
|String|getActionCommand()|Gibt zugehörigen command-String zurück|
|int|getModifiers()|Gibt modifizierende Keys (Strg, Umschalt, etc.) zurück|
|long|getWhen()|Gibt Zeitstempel des Auftretens zurück|
|...|...|...|

####MouseEvent
|Rückgabewert|Methode|Aufruf|
|---|---|---|
|int|getButton()|Gibt zurück welcher (wenn überhaupt) Knopf der Maus gedrückt wurde|
|int|getClickCount()|Gibt die Anzahl der Klicks eines Events zurück|
|int|getX()|Gibt die X Koordinate relativ zur Komponente zurück|
|int|getY()|Gibt die Y Koordinate relativ zur Komponente zurück|
|...|...|...|



Nicht jedes Event ist von Relevanz, daher gibt es in Java die zugehörigen Listener, die auf bestimmte Events Reagieren

ActionListener

FocusListener

MouseListener

TextListener

WindowListener



###Listener
Um Events zu handhaben gibt es nun die Listener, welche auf bestimmte Events warten und entsprechend reagieren.



Die Listener-Interfaces sind alle Unterklassen des Basis-Interfaces *java.util.EventListener*. 

Die Klasse, die sich für das Auftreten eines bestimmten Events interessiert, also zur Listener-Klasse wird, muss das passende Interface implementieren. 

Zudem muss die jeweilige GUI-Komponente, auf die sich das Ereignis bezieht, sich beim Listener anmelden, indem ihre add...Listener-Methode aufgerufen wird.



Die beteiligten Klassen und Schnittstellen folgen einer bestimmten Namenskonvention; XXX steht im Folgenden stellvertretend für einen Ereignisnamen:
* Eine Klasse für die Ereignisobjekte heißt XXXEvent.
* Die Interessenten implementieren als Listener eine Java-Schnittstelle, die XXXListener heißt.
* Der Ereignisauslöser bietet Methoden addXXXListener(XXXListener) und removeXXXListener(XXXListener) an, um Interessenten an- und abzumelden.



####Consume
Event Objekte werden immer vom Listener abgearbeitet und anschließen konsumiert.

Konsumieren bedeutet, dass das Event-Objekt nicht weitergegeben wird an andere Listener und selbst an andere Methoden innerhalb eines Listeners.

Stattdessen wird es zur Entfernung markiert, sodass der GarbageCollector es aufräumen kann.



Events können auch frühzeitig konsumiert und so die standardgemäße Abarbeitung unterbrochen werden.
```java
public void consume()
```

> Consumes this event so that it will not be processed in the default manner by the source which originated it. - java API



###Unterschiedliche Listener
|Listener|Ereignisse|
|---|---|
|ActionListener|Der Benutzer aktiviert eine Schaltfläche bzw. ein Menü oder drückt [ENTER] auf einem Textfeld.|
|WindowListener|Der Benutzer schließt ein Fenster oder möchte es verkleinern.|
|MouseListener|Der Benutzer drückt auf eine Maustaste.|
|MouseMotionListener|Der Benutzer bewegt die Maus.|



###ActionListener
|Rückgabewert|Methode|
|---|---|
|void|actionPerformed(ActionEvent e)|
Note:![ActionListener](content/images/actioneventactionlisteneruml.gif)



###Aufgabe
Was passiert in dieser Klasse?
```java
public class SomeGUI {
    JTextArea inputTA;
    JButton btn;

    public static void main(String[] args) {
        SomeGUI guiWindow = new SomeGUI();
        guiWindow.btn.doClick(); // Do as if the user has clicked the component
    }

    public SomeGUI() {
        /* ... */
        inputTA = new JTextArea("Hallo Welt!");
        btn = new JButton("Something");
        btn.addActionListener(this);
        /* ... */
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(inputTA.getText()); // Input of an JTextArea
    }
}
```


###Antwort
1. Fenster wird gezeichnet & dargestellt
2. Button wird geklickt
2. Ausgabe des Textes der JTextArea: "Hallo Welt!"



###MouseListener
|Rückgabewert|Methode|
|---|---|
|void|mouseClicked(MouseEvent e)|
|void|mouseEntered(MouseEvent e)|
|void|mouseExited(MouseEvent e)|
|void|mousePressed(MouseEvent e)|
|void|mouseReleased(MouseEvent e)|



```java
public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released: X = " + e.getX() + " Y = " + e.getY());
}

public void mousePressed(MouseEvent e) {
    System.out.println("Mouse pressed: X = " + e.getX() + " Y = " + e.getY());
}

public void mouseExited(MouseEvent e) {
    System.out.println("Mouse exited: X = " + e.getX() + " Y = " + e.getY());
}

public void mouseEntered(MouseEvent e) {
    System.out.println("Mouse entered: X = " + e.getX() + " Y = " + e.getY());
}

public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse clicked: X = " + e.getX() + " Y = " + e.getY());
}
```



mousePressed() + mouseReleased() = mouseClicked()



###Frage
Was passier hier, wenn ein Button geklickt wird?
```java
public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released");
    consume();
}

public void mousePressed(MouseEvent e) {
    System.out.println("Mouse pressed");
}

public void mouseExited(MouseEvent e) {
}

public void mouseEntered(MouseEvent e) {
}

public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse clicked");
}
```


###Antwort
mousePressed() und MouseReleased() werden aufgerufen, mouseClicked() aber nicht.



###MouseMotionListener
|Rückgabewert|Methode|
|---|---|
|void|mouseDragged(MouseEvent e)|
|void|mouseMoved(MouseEvent e)|



```java
public void mouseMoved(MouseEvent arg0) {
    System.out.println("Mouse moved: X = " + e.getX() + " Y = " + e.getY());
}

public void mouseDragged(MouseEvent arg0) {
    System.out.println("Mouse dragging: X = " + e.getX() + " Y = " + e.getY());
}
```



###Listener Hinzufügen
Anonyme Klasse
```java
someButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Ok Button clicked.");
    }});
```
Vorteil: 
* Klein
* Übersichtlich
Nachteil: 
* Redundanter Code, wenn gleiche Prozeduren in mehreren Listenern ausgeführt werden sollen.
Note: runter


Listener Klasse - Objektvergleich
```java
someButton.addActionListener(new SomeButtonListener());

class SomeButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(someButton)) {
            /* ... */
        } else if (ae.getSource().equals(otherButton)) {
            /* ... */
        }
    }
}
```
Vorteil: 
* Zentral
* Übersichtlich
Nachteil: 
* Viele Fallunterscheidungen
* Swing Komponenten müssen in Klassenvariablen zugänglich gemacht werden.

ListenerKlasse kann auch die eigene Klasse sein
Note: runter


Listener Klasse - Commands
```java
someButton.setActionCommand("DoAsITellYou");
someButton.addActionListener(new SomeButtonListener());

class SomeButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        String command = e.getActionCommand();  
        if (command.equals( "DoAsITellYou" )) {
            /* ... */
        } else if (command.equals( "YoureNotMyBoss" )) {
            /* ... */
        }
    }
}
```
Vorteil: 
* Zentral
* Übersichtlich
Nachteil: 
* Viele Fallunterscheidungen

ListenerKlasse kann auch die eigene Klasse sein
