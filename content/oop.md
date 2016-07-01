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



##Overriding, Overloading



##Identität und Gleichheit



##Exception Handling (checked - unchecked)



##Generics



##println von Objekten



##UML Klassendiagramm
