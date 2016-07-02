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



##Exception Handling (checked - unchecked)



##Generics



##println von Objekten



##UML Klassendiagramm
