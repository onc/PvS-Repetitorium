# UML - Die Unified Modeling Language



## UML
> Die **Unified Modeling Language** (vereinheitlichte Modellierungssprache), ist eine grafische Modellierungssprache zur Spezifikation, Konstruktion und Dokumentation von Software-Teilen und anderen Systemen. - https://de.wikipedia.org/wiki/Unified_Modeling_Language

Die UML ist Domänen-unabhängig, es werden keine sprachtypischen, sondern möglichst allgemeine Begriffe verwendet.



Die Ziele von UML Diagrammen sind unter Anderem:
* Kommunikation vereinfachen
* Komplexität reduzieren
* Entwurf dokumentieren
* Vollständigkeit und Konsistenz des Entwurfs prüfen



## UML Diagramtypen
* **Klassendiagramm** (statisch)
* Objektdiagramm (statisch)
* **Zustandsdiagramm** (dynamisch)
* Aktivitätsdiagramm (dynamisch)
* Sequenzdiagramme (dynamisch)
* ...



## UML Klassendiagramm
Klassen und Schnittstellen werden durch Rechtecke dargestellt.
* \+ für public
* \# für protected
* \- für private
* ~ für package private (default)

![Komponenten Klassendiagramm](content/images/UmlCd_Klasse-3.svg.png)

![Beziehung Klassendiagramm](content/images/UML-Beziehungen.png)

Note: durchgezogen: extends, gestrichelt implements; vom kind zum parent



### Aufgabe 1
```java
interface Buchbar {
    public void abheben(float betrag);

    public void einzahlen(float betrag);
}
```
```java
abstract class AbstraktesKonto implements Buchbar {
    private int kontonummer;

    AbstraktesKonto(int kNr) { /*...*/ }

    public int getKontonummer() { /*...*/ }
    
    public void setKontonummer(int kNr) { /*...*/ }
}
```
```java
class Konto extends AbstraktesKonto {
    private float kontostand;

    Konto(int kNr) { /*...*/ }

    public float getKontostand() { /*...*/ }
    
    public void setKontostand(float betrag) { /*...*/ }

    public void abheben(float betrag) { /*...*/ }

    public void einzahlen(float betrag) { /*...*/ }
}
```



### Aufgabe 1 - Lösung
![Beziehung Klassendiagramm](content/images/UML-A1-Klassendiagramm.png)



### Aufgabe 2
```java
interface A {
}
```
```java
interface B {
}
```
```java
abstract class C implements A {
}
```
```java
abstract class D extends C {
}
```
```java
final class E extends C implements B {
}
```
```java
class F extends D implements B {
}
```



### Aufgabe 2 - Lösung
![Beziehung Klassendiagramm](content/images/UML-A2-Klassendiagramm.png)



# Zustandsübergangsdiagramm



*Zustandsübergangsdiagramme* oder *Statecharts* sind Modelle die die **Zustände** und **Übergänge** eines Systems beschreiben



## Zustandsübergangsdiagramm - Elemente
* ![Statechart_state](content/images/Statechart_state.svg)<!-- .element style="border:none; box-shadow:none"-->
Zustand
* ![Statechart_start](content/images/Statechart_start.svg)<!-- .element style="border:none; box-shadow:none"-->
Startzustand (**immer notwendig**)
* ![Statechart_end](content/images/Statechart_end.svg)<!-- .element style="border:none; box-shadow:none"-->
Endzustand
* ![Statechart_transition](content/images/Statechart_transition.svg)<!-- .element style="border:none; box-shadow:none"-->
Zustandsübergang, 
  * meistens mit Textanmerkung, wie der Zustandsübergang zustande kommt
  * [a < 5] Wächterausdruck, gibt Bedingungen an
  * wenn kein Text: der Zustand wird automatisch gewechselt



### Beispiel
Lichtschalter

![Statechart1](content/images/Statechart1.png)



### Beispiel
Auto beladen (Beispiel mit Wächterausdrücken)

![Statechart2](content/images/Statechart2.png)



**Aber:** Statecharts sind nicht perfekt



### Beispiel - Buttons im Contactmanager

![Statechart Contactmanager](content/images/Statechart_CM1.png)

Statechart der der Umschalten **links <-> rechts** darstellt. Farben nur zur Übersichtlichkeit

Note: Contactmanager an die Tafel malen!!!



Die Zustände der Buttons modellieren klappt nicht so gut. Wie ist es denn mit den Kontakten?



### Beispiel - Kontakte im Contactmanager

![Statechart Contactmanager](content/images/Statechart_CM2.png)

Statechart nur für das umschalten links <-> rechts.

Übersichtlicher, aber wir haben keine Ahnung von den Buttons...



### Aufgabe
Mit der abgebildeten GUI ist es möglich, einen Scheinwerfer zu steuern.

![Ampel](content/images/Statechart_simple.png)

Die beiden Schalter steuern **eine einzige** farbige Lichtquelle.

Die Lichtquelle kann aus sein oder rotes, grünes oder gelbes Licht erzeugen.

Erstelle ein Statechart, der alle möglichen Zustände sowie deren Übergänge beschreibt.



### Lösungsvorschlag

![Ampel](content/images/Statechart_simple_solution.png)



### Aufgabe

![Ampel](content/images/Statemachine_Ampel.png)

Die Ampel kann der Reihe nach zwischen den Zuständen wechseln 

Die rote und grüne Phase dauert jeweils 30 Sekunden 

Der Übergang zwischen den anderen Phasen dauert 5 Sekunden.

Erstelle ein Statechart, das die Funktionsweise der Ampel beschreibt.

**Tipp:** Nutze für Zeitliche Übergänge Wächterausdrücke



### Lösungsvorschlag

![Ampel](content/images/Statechart_Ampel_solution.png)



### Aufgabe
Ein einfaches Faxgerät hat folgendes Benutzerinterface:

![Faxmachine](content/images/Faxmachine.png)<!-- .element height="50%" width="50%" -->

Mit der Taste Ein/Aus wird das Gerät ein- bzw. ausgeschaltet. 

Mit der Taste Fax/Kopie kann zwischen den Modi Kopieren und Faxen umgeschaltet werden 

Für beide Modi kann die Auflösung mit den Tasten Normal, Fein und Foto geregelt werden.

Das Fax oder die Kopie werden mit weiteren Tasten gestartet, die hier aber nicht von Bedeutung sind. 

Wenn das Gerät ausgeschaltet ist, sind außer der Einschalttaste keine anderen Tasten aktiv.

Außerdem startet das Gerät immer in der Einstellung Fax und Normal, speichert den Zustand der letzten Einstellung also nicht.



### Lösungsvorschlag

![Ampel](content/images/Statechart_Faxmachine_solution.png)



### Fazit
Statecharts sind nicht optimal

Sie können aber dabei helfen, sich den Zustand eines Systems zu verdeutlichen 

Die Verdeutlichung hilft, Fehler zu vermeiden und fehlerhafte Zustände frühzeitig zu erkennen

Es ist wichtig die Zustände und Übergänge richtig zu definieren, um ein verständliches Statechart erstellen zu können.
