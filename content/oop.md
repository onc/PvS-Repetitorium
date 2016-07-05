# Objektorientierte Programmierung (OOP)



##(Abstrakte-)
##Klassen und Interfaces
```java
class Tutor {
  private int food;
  
  public Tutor(int food){
  }
  
  protected void correct(Sheet sheet){
    ...
  }
  
  void feed(int meal){
    ...
  }
}
```



###Klassen
Klassen sind das wichtigste Merkmal objektorientierter Programmiersprachen.

In Klassen werden Methoden und Attribute (Felder) festgelegt (oder beschrieben)

Klassen können instanziiert werden.



![Objektinstanzen](content/images/728px-Autos.png)



###Abstrakte Klassen
Abstrakte Klassen können Implementationen und Felder enthalten, aber keine Konstruktoren.

Eine Klasse *erbt* von einer abstrakten Klasse. (extends)

Abstrakte Klassen können **nicht** instanziiert werden.



###Interfaces
Interface enthält nur Methodensignaturen (keine Implementation, keine Felder, keine Konstruktoren).

Eine Klasse *implementiert* ein Interface. (implements)

Interfaces können **nicht** instanziiert werden.



##Information Hiding und Vererbung



###Zugriffsmodifizierer 
||Die Klasse selbst, innere Klassen|Klassen im selben Package|Unterklassen|Sonstige Klassen|
|---|:-:|:-:|:-:|:-:|
|private|Ja|Nein|Nein|Nein|
|(default)|Ja|Ja|Nein|Nein|
|protected|Ja|Ja|Ja|Nein|
|public|Ja|Ja|Ja|Ja|
Note:Den Unterschied zwischen innerer Klasse und Unterklasse erklären



###Polymorphie-Modifizierer
**abstract, final, static**

---
Noch Vorhanden, aber hier nicht weiter behandelt: 

strictfp (Strict Floating Point), 

native (Methode nicht in Java geschrieben)
Note:Polymorphie: griechisch: Vielgestaltigkeit



###abstract
Abstract sagt aus, dass es sich um eine allgemeine Klasse handelt zu der keine konkreten Objekte existieren.

* Abstrakte Klasse kann nicht instanziiert werden.
* *'abstract'* kann sich auf Methoden und Attribute beziehen.

Note: Definition:
1. (besonders Philosophie) die wesentlichen, gesetzmäßigen o.ä. Züge aus etwas Konkretem, sinnlich Wahrnehmbarem ableitend
2. sich [nur] im Gedanklichen, Theoretischen bewegend [und keinen unmittelbar feststellbaren Bezug zur Wirklichkeit habend]



###final
Einfach ausgedrückt bedeutet final in Java "du kannst mich jetzt nicht überschreiben".

* Finale Methoden lassen sich nicht überschreiben.
* Von finalen Klassen kann nicht geerbt werden.
* Finale Attribute und Klassen-Variablen können nur ein einziges Mal gesetzt werden.
* Finale Parameter können nur den beim Methodenaufruf übergebenen Wert haben.
* *'final'* bezieht sich auf Methoden, Attribute und Klassen.



###static
Statische Eigenschaften haben gegenüber Objekteigenschaften den Vorteil, dass sie im Programm ausdrücken, keinen Zustand vom Objekt zu nutzen.

* Statische Methoden und Variablen benötigen keinerlei Instanzen einer Klasse, um aufgerufen zu werden.
* *'static'* bezieht sich auf Methoden und Klassenvariablen.



###Vererbung
```java
public class GameObject
{
  public String name;
}
```
```java
public class Player extends GameObject
{
}
```
```java
public class Room extends GameObject
{
  public int size;
}
```



![Vererbung](content/images/gameobjectplayerroom.gif)
Note: TODO: bild eher weg, da man noch gar nicht klassendiagramme hatte!?



##Overriding, Overloading
```java
public class GameObject
{
  private String name;

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }
}
```
```java
public class Room extends GameObject
{
  private int size;

  public void setSize( int size )
  {
    if ( size > 0 )
      this.size = size;
  }

  public int getSize()
  {
    return size;
  }

  @Override public String toString()
  {
    return String.format( "Room[name=%s, size=%d]", getName(), getSize() );
  }
}
```



![Overriding](content/images/kleinroomgameobjecttostring.gif)
Note: TODO: bild eher weg, da man noch gar nicht klassendiagramme hatte!?



##Identität und Gleichheit
###Identität
Der Vergleichsoperator ==  ist für alle Datentypen so definiert, dass er die vollständige Übereinstimmung zweier Werte testet. Bei primitiven Datentypen ist das einfach einzusehen und bei Referenztypen im Prinzip genauso. Der Operator ==  testet bei Referenzen, ob diese übereinstimmen, also auf das gleiche Objekt verweisen. Demnach sagt der Test etwas über die Identität der referenzierten Objekte aus, aber nichts darüber, ob zwei verschiedene Objekte möglicherweise den gleichen Inhalt haben. Der Inhalt der Objekte spielt bei 



```java
Point p = new Point(10, 10);
Point q = p;
Point r = new Point(10, 10);
System.out.println(p==q); // true, da p und q dasselbe Objekt referenzieren
System.out.println(p==r); // false, da p und r zwei unterschiedliche
                          // Punkt-Objekte referenzieren
```



###Gleichheit
Die allgemein gültige Lösung besteht darin, die Klasse festlegen zu lassen, wann Objekte gleich sind. Dazu kann jede Klasse eine Methode equals() implementieren, die Exemplare dieser Klasse mit beliebigen anderen Objekten vergleichen kann. Die Klassen entscheiden immer nach Anwendungsfall, welche Attribute sie für einen Gleichheitstest heranziehen, und equals()  liefert true, wenn die gewünschten Zustände (Objektvariablen) übereinstimmen.



```java
Point p = new Point(10, 10);
Point q = p;
Point r = new Point(10, 10);
System.out.println(p.equals(q)); // true, da p und q dasselbe Objekt referenzieren
System.out.println(p.equals(r)); // true, da p und r identisch sind
```



##Exception Handling (checked - unchecked)
![Exception Handling](content/images/06_001.png)



###Checked Exceptions
Checked Esceptions müssen beim programmieren beachtet werden. Der Compiler meckert, wenn dies nicht geschiet.
+ IOException
+ FileNotFoundException
+ ParseException
+ ClassNotFoundException
+ CloneNotSupportedException
+ InstantiationException
+ InterruptedException
+ NoSuchMethodException
+ NoSuchFieldException
Note: TODO: erklärung schreiben



###Unchecked Exceptions
Unchecked Esceptions werden vom Compiler ignoriert, können aber dennoch auftreten.
+ ArrayIndexOutOfBoundsException
+ ClassCastException
+ IllegalArgumentException
+ IllegalStateException
+ NullPointerException
+ NumberFormatException
+ AssertionError
+ ExceptionInInitializerError
+ StackOverflowError
+ NoClassDefFoundError
Note: TODO: erklärung schreiben



##Generics
```java
class Treasure
{
  private Object value;  
  public Treasure(){ ... }
  public Treasure(Object val){ ... }
  public Object getValue(){ return this.value; }
  public void setValue(Object val){ this.value = val; }
}
```

```java
class Treasure<T>
{
  private T value;
  public Treasure(){ ... }
  public Treasure(T val){ ... }
  public T getValue(){ return this.value; }
  public void setValue(T val){ this.value = val; }
}
```

```java
Treasure<Gold> goldSchatz = new Treasure<Gold>();
Treasure<Silber> silberSchatz = new Treasure<Silber>();
```



```java
public class Tupel<T> {
  private T object1;
  private T object2;
  public Tupel<T>(T object1,T object2) {
    this.object1 = object1;
    this.object2 = object2;
  }
  public String toString() {
    return this.object1 + ", " + this.object2;
  }
  public void add(Tupel<T> other){
    this.object1 = this.object1 + other.object1;
    this.object2 = this.object2 + other.object2;
  }
}
```



##println von Objekten
###Aufgabe 1
```java
public static void main(String[] args) {
  System.out.println("foo");                                              // foo
  System.out.println("bar".charAt(0));                                    // b
  System.out.println(new String("foobar") == new String("foobar"));       // false
  System.out.println(new String("foobar").equals(new String("foobar")));  // true
  System.out.println(1==1);                                               // true
  System.out.println(0.9999f==0.9999d);                                   // false
  System.out.println(new Integer(1).equals(1));                           // true
  int i = 3;
  System.out.println(i++);                                                // 3, aber Wert von i = 4   
  while(--i>0){
    System.out.println(i);                                                // 3 2 1
  }
  char[] charArray = new char[]{'p','v','s',' ','r','e','p'};
  System.out.println(charArray);                                          // pvs rep
  System.out.println(Arrays.asList(charArray));                           // anonymerName@Speicheradresse
}
```



##println von Objekten
###Aufgabe 2
```java
public class Tupel<T> {
  private T object1;
  private T object2;
  public Tupel(T obj1,T obj2) {
    this.object1 = obj1;
    this.object2 = obj2;
  }
  public static void main(String[] args) {
    Tupel<Integer> coords = new Tupel<Integer>(10, -3);
    System.out.println(coords);                                           // package.Class@Speicheradresse
    System.out.println(coords.object1);                                   // 10
    System.out.println(coords.object2);                                   // -3
  }
}
```
Note: TODO: ausgabe nicht als kommentar stehen lassen, sondern als Aufgabe stellen!?



##println von Objekten
###Aufgabe 3
```java
public class Tupel<T> {
  private T object1;
  private T object2;
  public Tupel(T obj1,T obj2) {
    this.object1 = obj1;
    this.object2 = obj2;
  }
  public String toString() {
      return this.object1 + ": " + this.object2;
  }
  public static void main(String[] args) {
    Tupel<Integer> coords = new Tupel<Integer>(10, -3);
    System.out.println(coords);                                           // 10: -3
    System.out.println(coords.object1);                                   // 10
    System.out.println(coords.object2);                                   // -3
  }
}
```
Note: TODO: ausgabe nicht als kommentar stehen lassen, sondern als Aufgabe stellen!?



##println von Objekten
###Aufgabe 4
```java
public class Cell {
  public int row;
  public int col;
  public Cell(int row, int column) {
    this.row = row;
    this.col = column;
  }
  public Cell add(Cell other){
    return new Cell(this.row+other.row, this.col + other.col);
  }
  public String toString(){
    return this.row + "," + this.col;
  }
  public static void main(String[] args) {
    System.out.println(new Cell(1,1));                                    // 1,1
    System.out.println(new Cell(1,1){public String toString(){return this.row + ":" + this.col;}});
                                                                          // 1:1
    System.out.println(new Cell(2,4).add(new Cell(1,-1)));                // 3,3
  }
}
```
Note: TODO: ausgabe nicht als kommentar stehen lassen, sondern als Aufgabe stellen!?



##UML Klassendiagramm
* \+ für public
* \# für protected
* \- für private
* ~ für package

![Komponenten Klassendiagramm](content/images/UmlCd_Klasse-3.svg.png)

![Beziehung Klassendiagramm](content/images/UML-Beziehungen.png)



```java
interface Buchbar{
  public int kontostand(){}
  
  public void abheben(int betrag){}
  
  public void einzahlen(int betrag){}
}
```
```java
class AbstraktesKonto implements Buchbar{
  private int kontonummer;
  
  AbstraktesKonto(int kNr){ kontonummer = knr; }
  
  public int kontostand() { return kontostand; }
  
  public void abheben(int betrag) {
    kontostand -= betrag;
  }
  
  public void einzahlen(int betrag) {
    kontostand += betrag;
  }
}
```




```java
class Konto extends AbstraktesKonto{
  private float kontostand;
  
  Konto(int kontonummer, int betrag) { 
    super(kontonummer);
    kontostand = betrag; 
  }
  
  public float kontostand() { 
    return kontostand*0.999999f;
  }
  
  public void abheben(int betrag) {
    if (betrag>kontostand) {
      System.out.println("Konto nicht gedeckt!");
    } else {
      kontostand -= betrag;
    }
  }
  
  public void einzahlen(int betrag) {
    kontostand += betrag;
  }
}
```
Note: TODO: als Aufgabe anstatt die Lösung direkt zu präsentieren?
