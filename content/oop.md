# Objektorientierte Programmierung (OOP)



##(Abstrakte-)
##Klassen und Interfaces



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
Note:Polymorphie: griechisch: Vielgestaltigkeit



###abstract
Abstract sagt aus, dass es sich um eine allgemeine Klasse handelt zu der keine konkreten Objekte existieren.

* Abstrakte Klasse kann nicht instanziiert werden.
* *'abstract'* kann sich auf Klassen und Methoden beziehen.

Note: Definition:
1. (besonders Philosophie) die wesentlichen, gesetzmäßigen o.ä. Züge aus etwas Konkretem, sinnlich Wahrnehmbarem ableitend
2. sich [nur] im Gedanklichen, Theoretischen bewegend [und keinen unmittelbar feststellbaren Bezug zur Wirklichkeit habend]



###final
Einfach ausgedrückt bedeutet final in Java "kann nicht überschrieben werden".

* Finale Methoden lassen sich nicht überschreiben.
* Von finalen Klassen kann nicht geerbt werden.
* Finale Attribute und Klassen-Variablen können nur ein einziges Mal gesetzt werden.
* Finale Parameter können nur den beim Methodenaufruf übergebenen Wert haben.
* *'final'* bezieht sich auf Methoden, Attribute und Klassen.



###static
Statische Eigenschaften haben gegenüber Objekteigenschaften den Vorteil, dass sie im Programm ausdrücken, keinen Zustand vom Objekt zu nutzen.

* Statische Methoden und Variablen benötigen keinerlei Instanzen einer Klasse, um aufgerufen zu werden.
* *'static'* bezieht sich auf Methoden und Klassenvariablen.



###Aufgabe 1
Funktioniert die main-Methode der Klasse Foo so?

Ja, oder nein. Warum?
```java
public abstact class Body {
    int limbs;
    int eyes;

    public Body(int limb, int eye){
        this.limbs = limb;
        this.eyes = eye;
    }
}
```
```java
class Foo {
    public static void main(String[] args){
        Body albert = new Body(10, 2);
    }
}
```


###Aufgabe 1 - Lösung
```java
public abstact class Body {
    int limbs;
    int eyes;

    public Body(int limb, int eye){
        this.limbs = limb;
        this.eyes = eye;
    }
}
```
```java
class Foo {
    public static void main(String[] args){
        Body albert = new Body(10, 2);
    }
}
```
Geht nicht, da Body *abstract* ist.


###Aufgabe 2
Funktioniert die main-Methode der Klasse Foo so?

Ja, oder nein. Warum?
```java
public class Person extends Body {
    final int height;
    int weight;

    public Person(int height, int weight){
        super(4, 2);
        this.height = height;
        this.weight = weight;
    }
    
    public void grow(final int distance) {
        this.height += distance;
    }
}
```
```java
class Foo {
    public static void main(String[] args){
        Person albert = new Person(180, 70);
        albert.grow(10);
    }
}
```


###Aufgabe 2 - Lösung
```java
public class Person extends Body {
    final int height;
    int weight;

    public Person(int height, int weight){
        super(4, 2);
        this.height = height;
        this.weight = weight;
    }
    
    public void grow(final int distance) {
        this.height += distance;
    }
}
```
```java
class Foo {
    public static void main(String[] args){
        Person albert = new Person(180, 70);
        albert.grow(10);
    }
}
```
Nein, da height final ist.


###Aufgabe 3
Funktioniert die main-Methode der Klasse Foo so?

Ja, oder nein. Warum?
```java
public class Person extends Body {
    int height;
    int weight;

    public Person(int height, int weight){
        super(4, 2);
        this.height = height;
        this.weight = weight;
    }
    
    public void grow(final int distance) {
        this.height += distance;
    }
}
```
```java
class Foo {
    public static void main(String[] args){
        Body albert = new Body(2, 2);
        Person bernd = new Body(2, 2);
        Body carmen = new Person(180, 70);
    }
}
```


###Aufgabe 3 - Lösung
```java
public class Person extends Body {
    final int height;
    int weight;

    public Person(int height, int weight){
        super(4, 2);
        this.height = height;
        this.weight = weight;
    }
    
    public void grow(final int distance) {
        this.height += distance;
    }
}
```
```java
class Foo {
    public static void main(String[] args){
        Body albert = new Body(2, 2);
        Person bernd = new Body(2, 2);
        Body carmen = new Person(180, 70);
    }
}
```
1. Nein, *Body* kann nicht instanziiert werden.
1. Nein, *Body* kann nicht instanziiert werden.
1. Ja, denn die Klasse *Person* erbt von *Body*.


###Aufgabe 4
Funktioniert die main-Methode der Klasse Foo so?

Ja, oder nein. Warum?
```java
public abstact class Body {
    int limbs;
    int eyes;

    public Body(int limb, int eye){
        this.limbs = limb;
        this.eyes = eye;
    }
    
    abstract int walk();
}
```
```java
class Foo {
    public static void main(String[] args){
        Person albert = new Person(180, 70);
        albert.walk();
    }
}
```


###Aufgabe 4 - Lösung
```java
public abstact class Body {
    int limbs;
    int eyes;

    public Body(int limb, int eye){
        this.limbs = limb;
        this.eyes = eye;
    }
    
    abstract int walk();
}
```
```java
class Foo {
    public static void main(String[] args){
        Person albert = new Person(180, 70);
        albert.walk();
    }
}
```
Jain, der Aufruf der Methode ist erlaubt.

**Aber!** Die kompilierung wird fehlschlagen, da die Methode nicht implementiert ist.


###Aufgabe 5
Können die beiden Methoden *growAnotherArm* überschrieben werden?

Ja, oder nein. Warum?
```java
public abstract class Body {
    int limbs;
    int eyes;

    public Body(int limb, int eye){
        this.limbs = limb;
        this.eyes = eye;
    }
    
    final void growAnotherArm(){
        this.limbs = this.limbs + 1;
    }
    
    void growAnotherArm(int arms){
        this.limbs = this.limbs + arms;
    }
}
```
```java
public class Person extends Body {
    int height;
    int weight;

    public Person(int height, int weight){
        super(4, 2);
        this.height = height;
        this.weight = weight;
    }
    
    final void growAnotherArm(){
        this.limbs = this.limbs + 2;
    }
    
    void growAnotherArm(int arms){
        this.limbs = this.limbs + (arms*2);
    }
}
```


###Aufgabe 5 - Lösung
```java
public abstract class Body {
    int limbs;
    int eyes;

    public Body(int limb, int eye){
        this.limbs = limb;
        this.eyes = eye;
    }
    
    final void growAnotherArm(){
        this.limbs = this.limbs + 1;
    }
    
    void growAnotherArm(int arms){
        this.limbs = this.limbs + arms;
    }
}
```
```java
public class Person extends Body {
    int height;
    int weight;

    public Person(int height, int weight){
        super(4, 2);
        this.height = height;
        this.weight = weight;
    }
    
    final void growAnotherArm(){
        this.limbs = this.limbs + 2;
    }
    
    void growAnotherArm(int arms){
        this.limbs = this.limbs + (arms*2);
    }
}
```
1. Nein, da die Methode growAnotherArm() in der Klasse *Body* final ist.
1. Ja, alles in Ordnung.


###Aufgabe 6
Sind die Aufrufe von *saySomething()* so möglich? 

Ja, oder nein. Warum?
```java
class Foo {
    public static void main(String[] args) {
        saySomething("Tobias");
        this.saySomething("Tobias");
        new Foo().saySomething();
        Foo pseudoInstanz = new Foo();
        pseudoInstanz.saySomething("Christian");
    }

    void saySomething() {
        System.out.println("Hallo!");
    }

    static void saySomething(String s) {
        System.out.println("Hallo, " + s);
    }
}
```


###Aufgabe 6 - Lösung
```java
class Foo {
    public static void main(String[] args) {
        saySomething("Tobias");
        this.saySomething("Tobias");
        new Foo().saySomething();
        Foo pseudoInstanz = new Foo();
        pseudoInstanz.saySomething("Christian");
    }

    void saySomething() {
        System.out.println("Hallo!");
    }

    static void saySomething(String s) {
        System.out.println("Hallo, " + s);
    }
}
```
1. Ja, da die statische Methode aufgerufen wird.
2. Nein, das Schlüsselwort *this* ist im statischen kontext nicht erlaubt.
3. Ja, alles in Ordnung.
4. Ja, aber auf eine statische Methode sollte auch statisch zugegriffen werden.



###Vererbung
Durch den Vererbungsmechanismus werden alle sichtbaren Eigenschaften der Oberklasse auf die Unterklasse übertragen.
```java
public class GameObject {
    public String name;
}
```
```java
public class Player extends GameObject {
}
```
```java
public class Room extends GameObject {
    public int size;
}
```



##Overriding, Overloading
```java
public class GameObject
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
```
```java
public class Room extends GameObject
{
    private int size;

    public void setSize( int size ) {
        if ( size > 0 )
            this.size = size;
    }

    public int getSize() {s
        return size;
    }

    @Override public String toString() {
        return String.format( "Room[name=%s, size=%d]", getName(), getSize() );
    }
}
```



##Identität und Gleichheit
###Identität
Der Vergleichsoperator
>**==**

ist für alle Datentypen so definiert, dass er die vollständige Übereinstimmung zweier Werte testet.

"==" testet bei Referenzen, ob diese übereinstimmen, also auf das gleiche Objekt verweisen.



```java
Point p = new Point(10, 10);
Point q = p;
Point r = new Point(10, 10);
System.out.println(p==q); // true, da p und q dasselbe Objekt referenzieren
System.out.println(p==r); // false, da p und r zwei unterschiedliche
                          // Punkt-Objekte referenzieren
```



###Gleichheit
Jede Klasse kann eine Methode
>**equals()**

implementieren, die Exemplare dieser Klasse mit beliebigen anderen Objekten vergleichen kann.

"equals()" liefert true, wenn die Objektvariablen einer Instanz vollständig übereinstimmen.



```java
Point p = new Point(10, 10);
Point q = p;
Point r = new Point(10, 10);
System.out.println(p.equals(q)); // true, da p und q dasselbe Objekt referenzieren
System.out.println(p.equals(r)); // true, da p und r identisch sind
```



##Exception Handling (checked - unchecked)
![Exception Handling](content/images/06_001.png)
Note: TODO: Exceptions generell erklären



###Checked Exceptions
Checked Esceptions müssen beim programmieren beachtet werden. Der Compiler meckert, wenn dies nicht geschiet.
+ IOException
+ FileNotFoundException
+ ParseException
+ ...
Note: TODO: erklärung schreiben



###Unchecked Exceptions
Unchecked Esceptions werden vom Compiler ignoriert, können aber dennoch im Programmablauf auftreten.
+ ArrayIndexOutOfBoundsException
+ IllegalArgumentException
+ NullPointerException
+ NumberFormatException
+ ...
Note: TODO: erklärung schreiben



##Generics
> Generics realisieren das Prinzip des Stellvertreters

```java
List<T>
```

Eine liste ist genereisch, weil sie alle Arten von Daten in sich tragen kann.



Wenn angegeben wird, dass die Liste nur Contacts speichern soll sagst der Programmierer damit, dass alle Elemente in dieser Liste vom Typ Contact sind. 



Der Compiler behandelt Generics dann so: 
>"Das was hier behandelt wird ist vom Typ XY und, wenn das nicht so ist, dann kann ich damit nicht umgehen und werfe mit Exceptions um mich"



Generics vereinfachen also unter umständen das Programmieren, da der Programmierer angeben kann mit welchen Datentypen ein Programmabschnitt umgehen kann. 

Typumwandlungen und (teilweise) Exception Handling kann so vermieden werden.



```java
class Treasure {
    private int value;  
    public Treasure(){ ... }
    public Treasure(int val){ ... }
    public int getValue(){ return this.value; }
    public void setValue(Object val){ this.value = Integer.parseInt(val); }
}
```

```java
class Treasure<T> {
    private T value;
    public Treasure(){ ... }
    public Treasure(T val){ ... }
    public T getValue(){ return this.value; }
    public void setValue(T val){ this.value = val; }
}
```

```java
Treasure<String> goldSchatz = new Treasure<String>();
Treasure<Integer> silberSchatz = new Treasure<Integer>();
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
    public void add(Tupel<T> other) {
        this.object1 = this.object1 + other.object1;
        this.object2 = this.object2 + other.object2;
    }
}
```



##println von Objekten
###Aufgabe 1
```java
public static void main(String[] args) {
    System.out.println("foo");
    System.out.println("bar".charAt(0));
    System.out.println(new String("foobar") == new String("foobar"));
    System.out.println(new String("foobar").equals(new String("foobar")));
    System.out.println(1==1);
    System.out.println(0.9999f==0.9999d);
    System.out.println(new Integer(1).equals(1));
    int i = 3;
    System.out.println(i++);
    while(--i>0){
        System.out.println(i);
    }
    char[] charArray = new char[]{'p','v','s',' ','r','e','p'};
    System.out.println(charArray);
    System.out.println(Arrays.asList(charArray));
}
```
Note: Lösung unten


##println von Objekten
###Aufgabe 1 - Lösung
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
        System.out.println(coords);
        System.out.println(coords.object1);
        System.out.println(coords.object2);
    }
}
```
Note: Lösung unten


##println von Objekten
###Aufgabe 2 - Lösung
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
        System.out.println(coords);
        System.out.println(coords.object1);
        System.out.println(coords.object2);
    }
}
```
Note: Lösung unten


##println von Objekten
###Aufgabe 3 - Lösung
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
        System.out.println(new Cell(1,1));
        System.out.println(new Cell(1,1){public String toString(){return this.row + ":" + this.col;}});
        System.out.println(new Cell(2,4).add(new Cell(1,-1)));
    }
}
```
Note: Lösung unten


##println von Objekten
###Aufgabe 4 - Lösung
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



##UML Klassendiagramm
Klassen und Schnittstellen werden durch Rechtecke dargestellt.
* \+ für public
* \# für protected
* \- für private
* ~ für package

![Komponenten Klassendiagramm](content/images/UmlCd_Klasse-3.svg.png)

![Beziehung Klassendiagramm](content/images/UML-Beziehungen.png)
Note: TODO: erweiterung schreiben. (Klasse-Attribute-Methoden) (Sichtbarkeiten) (Vererbung) (Kardinalitäten?)



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
Note: TODO: Lösung erstellen




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
