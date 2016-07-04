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



####abstract
Es können Methoden und Attribute als abstract bezeichnet (deklariert) werden, was bedeutet, dass entweder die Unterklasse diese implementieren muss oder aber die abgeleitete Klasse ebenfalls als abstrakt deklariert werden muss.

Von einer abstrakten Klasse können keine Instanzen gebildet werden, so dass diese immer erst implementiert werden muss, um das gewünschte Ergebnis zu erreichen.



####final
Es können Klassen, Methoden, Attribute und Parameter als final bezeichnet (deklariert) werden. Einfach ausgedrückt bedeutet final in Java "du kannst mich jetzt nicht überschreiben".

Für finale Klassen bedeutet dies, dass man von ihr nicht erben kann (man kann keine Unterklasse erzeugen). Sie kann also nicht als Vorlage für eine neue Klasse dienen. Grundlegende Klassen, wie zum Beispiel die String-Klasse sind final. Wenn sie es nicht wäre, dann könnte man von ihr erben und ihre Methoden überschreiben und damit das Verhalten der erweiterten Klasse verändern.

Finale Methoden können in Subklassen nicht überschrieben werden.

Finale Attribute und auch Klassen-Variablen können nur ein einziges Mal zugewiesen werden. Sobald die Zuweisung erfolgt ist, kann eine finale Variable ihren Wert nicht mehr ändern. Bei Member-Variablen muss die Zuweisung bei der Instanzierung, bei Klassen-Variablen beim Laden der Klasse erfolgen.

Finale Parameter können ausschliesslich den beim Methodenaufruf übergebenen Wert besitzen. In der Methode selbst lassen sie sich nicht überschreiben.



####static
Es können Methoden und Klassenvariablen als static bezeichnet (deklariert) werden.

Statische Methoden und Variablen benötigen keinerlei Instanzen einer Klasse, um aufgerufen zu werden. Ein Beispiel für einen statischen Member ist z.B. die Konstante PI in der Klasse java.lang.Math.

Auch die Methoden dieser Klasse können einfach aufgerufen werden, ohne vorher eine Instanz dieser Klasse anzulegen, z.B. java.lang.Math.max(3,4).

Sofern eine statische Klassenvariable erst zur Laufzeit dynamisch einen Wert erhalten soll, können Sie dies mit einem statischen Block erreichen.



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



##Generics
```java
class Treasure
{
  private Object value;  
  public Treasure(){ ... }
  public Treasure(Object val){ ... }
  public Object getValue(){ return this.value; }
  public void getValue(Object val){ this.value = val; }
}
```

```java
class Treasure<T>
{
  private T value;
  public Treasure(){ ... }
  public Treasure(T val){ ... }
  public T getValue(){ return this.value; }
  public void getValue(T val){ this.value = val; }
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
  public DoubleObject(T object1,T object2) {
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



##UML Klassendiagramm
