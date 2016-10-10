# Objektorientierte Programmierung (OOP)



## (Abstrakte-)
## Klassen und Interfaces



### Klassen
Klassen sind das wichtigste Merkmal objektorientierter Programmiersprachen.

In Klassen werden Methoden und Attribute (Felder) festgelegt (oder beschrieben)

Klassen können instanziiert werden.



![Objektinstanzen](content/images/728px-Autos.png)



### Abstrakte Klassen
Abstrakte Klassen können Implementationen und Felder enthalten, aber keine Konstruktoren.

Eine Klasse *erbt* von einer abstrakten Klasse. (`extends`)

Abstrakte Klassen können **nicht** instanziiert werden.



### Interfaces
Interface enthält nur Methodensignaturen (keine Implementation, keine Felder, keine Konstruktoren).

Eine Klasse *implementiert* ein Interface. (`implements`)

Interfaces können **nicht** instanziiert werden.



## Information Hiding und Vererbung



### Zugriffsmodifizierer 
|           | Die Klasse selbst, innere Klassen | Klassen im selben Package | Unterklassen | Sonstige Klassen |
|-----------|-----------------------------------|---------------------------|--------------|------------------|
| private   | Ja                                | Nein                      | Nein         | Nein             |
| (default) | Ja                                | Ja                        | Nein         | Nein             |
| protected | Ja                                | Ja                        | Ja           | Nein             |
| public    | Ja                                | Ja                        | Ja           | Ja               |

Note: Den Unterschied zwischen innerer Klasse und Unterklasse (extends) erklären



### Polymorphie-Modifizierer
`abstract, final, static`
Note:Polymorphie: griechisch: Vielgestaltigkeit



### abstract
Abstract sagt aus, dass es sich um eine allgemeine Klasse handelt zu der keine konkreten Objekte existieren.

* Abstrakte Klasse kann nicht instanziiert werden.
* *'abstract'* kann sich auf Klassen und Methoden beziehen.

Note: Definition:
1. (besonders Philosophie) die wesentlichen, gesetzmäßigen o.ä. Züge aus etwas Konkretem, sinnlich Wahrnehmbarem ableitend
2. sich [nur] im Gedanklichen, Theoretischen bewegend [und keinen unmittelbar feststellbaren Bezug zur Wirklichkeit habend]



### final
Einfach ausgedrückt bedeutet final in Java "kann nicht überschrieben werden".

* Finale Methoden lassen sich nicht überschreiben.
* Von finalen Klassen kann nicht geerbt werden.
* Finale Attribute und Klassen-Variablen können nur ein einziges Mal gesetzt werden.
* Finale Parameter können nur den beim Methodenaufruf übergebenen Wert haben.
* *'final'* bezieht sich auf Methoden, Attribute und Klassen.



### static
Statische Eigenschaften haben gegenüber Objekteigenschaften den Vorteil, dass sie im Programm ausdrücken, keinen Zustand vom Objekt zu nutzen.

* Statische Methoden und Variablen benötigen keinerlei Instanzen einer Klasse, um aufgerufen zu werden.
* *'static'* bezieht sich auf Methoden und Klassenvariablen.



### Aufgabe 1
Funktioniert die main-Methode der Klasse `Foo` so?

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



### Aufgabe 1 - Lösung
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
Geht nicht, da Body `abstract` ist.



### Aufgabe 2
Funktioniert die main-Methode der Klasse `Foo` so?

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



### Aufgabe 2 - Lösung
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



### Aufgabe 3
Funktioniert die main-Methode der Klasse `Foo` so?

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
        Body albert = new Body(2, 2);
        Person bernd = new Body(2, 2);
        Body carmen = new Person(180, 70);
    }
}
```



### Aufgabe 3 - Lösung
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
1. Nein, `Body` kann nicht instanziiert werden.
1. Nein, `Body` kann nicht instanziiert werden.
1. Ja, denn die Klasse `Person` erbt von `Body`.



### Aufgabe 4
Funktioniert die main-Methode der Klasse `Foo` so?

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



### Aufgabe 4 - Lösung
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
Nein, die Kompilierung wird fehlschlagen, da die Methode nicht implementiert ist.



### Aufgabe 5
Können die beiden Methoden `growAnotherArm` überschrieben werden?

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



### Aufgabe 5 - Lösung
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
1. Nein, da die Methode `growAnotherArm()` in der Klasse `Body` final ist.
1. Ja, alles in Ordnung.



### Aufgabe 6
Sind die Aufrufe von `saySomething()` so möglich? 

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



### Aufgabe 6 - Lösung
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
2. Nein, das Schlüsselwort `this` ist im statischen Kontext nicht erlaubt.
3. Ja, alles in Ordnung.
4. Ja, aber auf eine statische Methode sollte auch statisch zugegriffen werden.



### Aufgabe 7
![A7](content/images/UML-A3-Klassendiagramm.png)



### Aufgabe 7
```java
public class Main {
    public static void main(String[] args) {
        Animal a = new Animal(2, 2, false);
        Person p = new Person(2, 2);
        Body b1 = new Animal(2, 2, false);
        Body b2 = new Person(2, 2);
        Object o1 = new Animal(2, 2, false);
        Object o2 = new Person(2, 2);

        // 1.                   // 2.                   // 3.
        a.hunt();               b1.hunt();              o1.hunt();
        a.mutate();             b1.mutate();            o1.mutate();

        p.grow();               b2.grow();              o2.grow();
        p.mutate();             b2.mutate();            o2.mutate();
    }
}
```



### Aufgabe 8
![A7](content/images/UML-A3-Klassendiagramm.png)



### Aufgabe 8
```java
public class Main {
  public static void main(String[] args) {
    Object a = new Body(2, 2);
    Object p = new Body(2, 2);
    Animal b1 = new Object();
    Person b2 = new Object();
    Body o1 = (Body)new Animal();
    Person o2 = (Person)new Person();
  }
}
```



### Vererbung
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



## Overriding, Overloading



```java
public class GameObject {

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
public class Room extends GameObject {

    private int size;

    public void setSize( int size ) {
        if ( size > 0 )
            this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override 
    public String toString() {
        return String.format( "Room[name=%s, size=%d]", getName(), getSize() );
    }
}
```



## Overriding
Wenn Klassen Methoden von einer Superklasse erben können diese auch überschrieben werden.

Überschreiben dient dazu eine andere Funktionalität einer Methode zu implementieren, sollte dies in einer Klasse gewünscht sein.



Überschriebene Methoden werden vom Compiler priorisiert. Dies bedeutet, dass das Linking einer Methode immer zuerst die Klasse, in der der Aufruf stattfindet, und danach die Superklasse beachtet.

Die Superklasse jeder Klasse ist in Java die `Object` Klasse.



Das Beispiel von eben:
```java
public class Room extends GameObject {

    private int size;

    public void setSize( int size ) {
        if ( size > 0 )
            this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override 
    public String toString() {
        return String.format( "Room[name=%s, size=%d]", getName(), getSize() );
    }
}
```
enthält die überschriebene Methode `toString();`, welche von `Object` geerbt wurde.



## Overloading
Als overloaded (überladen) werden Methoden bezeichnet, welche sich nur in der Anzahl der übergebenen Parameter unterscheiden.

Das Overloading dient dazu Methoden, welche eine ähnliche Funktionalität haben nicht komplett unterschiedich benennen zu müssen.



```java
public class Foo {
    public static int add(int num1) {
        return num1 + num1;
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args){
        System.out.printpl(add(15));
        System.out.printpl(add(15, 10));
    }
}
```
Die Methode `add` ist überladen.



## Aufgabe
Wo geschiet hier overloading, wo overriding?
```java
public class Foo {
    public int add(int num1) {
        return add(num1, num1);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
```
```java
public class Bar extends Foo {
    public int add(int num1) {
        return num1*2;
    }
    
    public float add(float num1, float num2) {
        return num2 + num1;
    }
}
```



## Lösungsvorschlag
```java
public class Foo {
    public int add(int num1) {
        return add(num1, num1);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
```
```java
public class Bar extends Foo {
    public int add(int num1) {
        return num1*2;
    }
    
    public float add(float num1, float num2) {
        return num2 + num1;
    }
}
```
* `Foo:add` ist überladen
* `Foo:add(1)` ist überschrieben in `Bar`
* `Bar:add(2)` ist eine vollkommen neue Methode



## Identität und Gleichheit
### Identität
Der Vergleichsoperator
>**==**

ist für alle Datentypen so definiert, dass er die vollständige Übereinstimmung zweier Werte testet.

"==" testet bei Referenzen, ob diese übereinstimmen, also auf das gleiche Objekt verweisen.



<pre><code class="line-numbers">Point p = new Point(10, 10);
Point q = p;
Point r = new Point(10, 10);
System.out.println(p==q); // true, da p und q dasselbe Objekt referenzieren
System.out.println(p==r); // false, da p und r zwei unterschiedliche
                          // Punkt-Objekte referenzieren</code></pre>



### Gleichheit
Jede Klasse kann eine Methode
>**equals()**

implementieren, die Exemplare dieser Klasse mit beliebigen anderen Objekten vergleichen kann.

"equals()" liefert true, wenn die Objektvariablen einer Instanz vollständig übereinstimmen.

**ABER:** Dies ist nur für die default-implementierung wahr. Equals kann auch überschrieben werden!



<pre><code class="line-numbers">Point p = new Point(10, 10);
Point q = p;
Point r = new Point(10, 10);
System.out.println(p.equals(q)); // true, da p und q dasselbe Objekt referenzieren
System.out.println(p.equals(r)); // true, da p und r identisch sind</code></pre>



## Exceptions
Exceptions, zu deutsch Ausnahmen, sind ungewollte Funktionalitäten des Programms, weche vielleicht, vielleicht aber auch nicht auftreten können.



* Eine Exception kann auftreten, wenn bspw. eine Datei geöffnet werden soll, welche im Filesystem aber nicht vorhanden ist. (FileNotFoundException)
* Eine Exception kann auch auftreten, wenn auf ein uninstanziiertes Objekt zugegriffen werden soll. (NullPointerException)
* Eine Exception kann auftreten, wenn ein Array durchlaufen wird und dabei das Ende überschritten wird. (ArrayIndexOutOfBoundsException)

All diese Beispiele sind schwierig, vielleicht sogar unmöglich vorherzusehen.



Aber was soll das Programm machen, wenn ein solcher Fall eintritt?



In Objektorientierten Programmiersprachen hat sich das Konzept des `Exception Handling` durchgesetzt.

Sollten Fehler auftreten wird ein spezieller Programmabschnitt druchlaufen, welcher den Fehler behebt, umgeht oder anders angemessen darauf reagiert.



## Try - Catch

![Exception Handling](content/images/06_001.png)



`Try` - versuche diesen Programmabschnitt durchzuführen

`Catch` - falls eine Exception auftritt, fang sie hier auf



## Beispiel
Was kann hier schiefgehen?
```java
public class Main
{
    public static void main(String[] args)
    {
        Punkt point = null;
        int val = point.getX();
    }
}
```



## Beispiel
NullPointerException!
```java
public class Main
{
    public static void main(String[] args)
    {
        Punkt point = null;
        try {
            int val = point.getX();
        }
        catch (NullPointerException npe) {
            System.out.println("Es existiert kein Punkt, von dem X abgerufen werden kann.");
        }
    }
}
```



## Beispiel
Was kann hier schiefgehen?
```java
public class Main
{
    public static void main(String[] args)
    {
        int i = 1;
        char[] txt = new char[]{'h','e','y'};
        while (i <= txt.length) {
            System.out.print(txt[i]);
            i++;
        }
    }
}
```



## Beispiel
ArrayIndexOutOfBoundsException! Da das Array Indizes von 0-2 hat.
```java
public class Main
{
    public static void main(String[] args)
    {
        int i = 1;
        char[] txt = new char[]{'h','e','y'};
        try {
            while (i <= txt.length) {
                System.out.print(txt[i]);
                i++;
            }
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Stoopid, why you do that?");
        }
    }
}
```
Ist natürlich einfach zu finden, allerdings nur, wenn man auch weiß, wie groß das Array ist.



### Checked Exceptions
Checked Esceptions müssen beim programmieren beachtet werden. Der Compiler meckert, wenn dies nicht geschiet.
+ IOException
+ FileNotFoundException
+ ParseException
+ ...

=> Alles was von `Exception` erbt.



### Unchecked Exceptions
Unchecked Esceptions werden vom Compiler ignoriert, können aber dennoch im Programmablauf auftreten.
+ ArrayIndexOutOfBoundsException
+ IllegalArgumentException
+ NullPointerException
+ NumberFormatException
+ ...

=> Alles was von `RuntimeException` erbt.



Als Java im letzten Jahrtausend entworfen wurde, galt diese Unterscheidung als chic und modern. Man wollte Fehler danach unterscheiden, ob der Aufrufer sie hätte vermeiden können.



Fehler wie NullPointerException (unchecked) oder IllegalArgumentException (unchecked) liegen an fehlerhafter Verwendung einer Klasse und können quasi überall auftreten. Sie zu deklarieren bringt also quasi keinen Nutzen.

Wenn ein Fehler für den Aufrufer aber unvorhersehbar ist – I/O, Validierung etc. (checked) – dann sollte er zu einem expliziten Teil des Aufrufkontrakts werden.



### Aufgabe 1
Was gibt diese Methode zurück?
```java
static boolean ccc(){
    try {
      return false;
    } catch (Exception e) {
    } finally {
      return true;
    }
}
```
true oder false ?



### Lösung 1
Was gibt diese Methode zurück?
```java
static boolean ccc(){
    try {
      return false;
    } catch (Exception e) {
    } finally {
      return true;
    }
}
```
**true** oder false ?



### Aufgabe 2
Was gibt diese Methode zurück?
```java
public static int aaa() {
    int x = 1;

    try {
      return ++x;
    } catch (Exception e) {
    } finally {
      ++x;
    }
    return x;
}
```
x = 2 oder x = 3 ?



### Lösung 2
Was gibt diese Methode zurück?
```java
public static int aaa() {
    int x = 1;

    try {
      return ++x;
    } catch (Exception e) {
    } finally {
      ++x;
    }
    return x;
}
```
**x = 2** oder x = 3 ?



## Generics
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



Treasure soll alles mögliche enthalten können!
```java
class Treasure {
  private int value;
  public Treasure(){ ... }
  public Treasure(int val){ ... }
  public int getValue(){ return this.value; }
  public void setValue(Object val){ this.value = Integer.parseInt(val); }
}
```
Geht aber nicht... Objects übergeben, casten, exceptions, alles doof :(



Kann man auch so machen!
```java
class Treasure<T> {
  private T value;
  public Treasure(T val) { 
    this.value = val; 
  }
  public T getValue() { 
   return this.value; 
  }
  public void setValue(T val){ 
    this.value = val; 
  }
}
```
```java
Treasure<String> goldSchatz = new Treasure<String>();
Treasure<Integer> silberSchatz = new Treasure<Integer>();
```



```java
public class Tupel<T, V> {
    private T object1;
    private V object2;

    public Tupel(T obj1, V obj2) {
        this.object1 = obj1;
        this.object2 = obj2;
    }

    public String toString() {
        return this.object1 + ", " + this.object2;
    }
}
```



## println von Objekten
### Aufgabe 1
<pre><code class="line-numbers">public static void main(String[] args) {
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
}</code></pre>



## println von Objekten
### Aufgabe 1 - Lösung
<pre><code class="line-numbers">public static void main(String[] args) {
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
        System.out.println(i);                                              // 3 2 1
    }
    char[] charArray = new char[]{'p','v','s',' ','r','e','p'};
    System.out.println(charArray);                                          // pvs rep
    System.out.println(Arrays.asList(charArray));                           // anonymerName@hash
}</code></pre>



## println von Objekten
### Aufgabe 2
```java
public class Tupel<T, V> {
    private T object1;
    private V object2;

    public Tupel(T obj1, V obj2) {
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



## println von Objekten
### Aufgabe 2 - Lösung
```java
public class Tupel<T, V> {
    private T object1;
    private V object2;

    public Tupel(T obj1, V obj2) {
        this.object1 = obj1;
        this.object2 = obj2;
    }

    public static void main(String[] args) {
        Tupel<Integer> coords = new Tupel<Integer>(10, -3);
        System.out.println(coords);                                           // package.Class@hash
        System.out.println(coords.object1);                                   // 10
        System.out.println(coords.object2);                                   // -3
    }
}
```



## println von Objekten
### Aufgabe 3
```java
public class Tupel<T, V> {
    private T object1;
    private V object2;

    public Tupel(T obj1, V obj2) {
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



## println von Objekten
### Aufgabe 3 - Lösung
```java
public class Tupel<T, V> {
    private T object1;
    private V object2;

    public Tupel(T obj1, V obj2) {
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



## println von Objekten
### Aufgabe 4
<pre><code class="line-numbers">public class Cell {
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
}</code></pre>



## println von Objekten
### Aufgabe 4 - Lösung
<pre><code class="line-numbers">public class Cell {
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
}</code></pre>



## UML Klassendiagramm
Klassen und Schnittstellen werden durch Rechtecke dargestellt.
* \+ für public
* \# für protected
* \- für private
* ~ für package

![Komponenten Klassendiagramm](content/images/UmlCd_Klasse-3.svg.png)

![Beziehung Klassendiagramm](content/images/UML-Beziehungen.png)
Note: TODO: erweiterung schreiben. (Klasse-Attribute-Methoden) (Sichtbarkeiten) (Vererbung) (Kardinalitäten?)



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
