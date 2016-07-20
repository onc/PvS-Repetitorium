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



##Listener
Eine zweite Variante zur Implementierung des Beobachter-Musters sind Listener. Sie lösen die beiden genannten Probleme von eben.



Es gibt Ereignisauslöser, die spezielle Ereignis-Objekte aussenden, und Interessenten, die sich bei den Auslösern an- und abmelden.



Die beteiligten Klassen und Schnittstellen folgen einer bestimmten Namenskonvention; XXX steht im Folgenden stellvertretend für einen Ereignisnamen:
* Eine Klasse für die Ereignisobjekte heißt XXXEvent.
* Die Interessenten implementieren als Listener eine Java-Schnittstelle, die XXXListener heißt.
* Der Ereignisauslöser bietet Methoden addXXXListener(XXXListener) und removeXXXListener(XXXListener) an, um Interessenten an- und abzumelden.



![GUI Zyklus](content/images/gui-cycle.png)



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



```java
public void actionPerformed(ActionEvent event) {
    System.out.println(inputTA.getText()); // Input of an JTextArea
}
```



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



####Consume
```java
public void consume()
```

> Consumes this event so that it will not be processed in the default manner by the source which originated it. - java API



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
