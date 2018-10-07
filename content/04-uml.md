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
