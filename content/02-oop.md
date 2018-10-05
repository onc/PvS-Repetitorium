# Objektorientierte Programmierung (OOP)



## (Abstrakte-)
## Klassen und Interfaces



### Klassen
Klassen sind das wichtigste Merkmal objektorientierter Programmiersprachen.

In Klassen werden Methoden und Attribute (Felder) festgelegt (oder beschrieben)

Klassen können instanziiert werden.

Note: Schablone, eigener Datentyp/Datenstruktur



![Objektinstanzen](content/images/728px-Autos.png)

Note: Kuchenform – Durchmesser/Volumen immer gleich, aber Teig verschieden; *evtl Bild malen*



### Abstrakte Klassen
**VEREINFACHT:**

Abstrakte Klassen können Implementierungen und Felder enthalten

Eine Klasse **erbt** von einer abstrakten Klasse. (`extends`)

Abstrakte Klassen können **nicht** instanziiert werden.



### Abstrakte Klassen
**ABER:**

Abstrakte Klassen können Implementierungen und Felder enthalten, **auch Konstruktoren**

Eine Klasse **erbt** von einer abstrakten Klasse. (`extends`)

Abstrakte Klassen können **nicht** instanziiert werden.

Note: default-Konstruktor!



### Interfaces
**VEREINFACHT:**

Ein Interface enthält nur Methodensignaturen (keine Implementierungen, keine Felder, keine Konstruktoren).

Eine Klasse **implementiert** ein Interface. (`implements`)

Interfaces können **nicht** instanziiert werden.



### Interfaces
**ABER:**

Ein Interface enthält nur Methodensignaturen und **statische** Implementierungen und Felder (keine Konstruktoren).

Eine Klasse **implementiert** ein Interface. (`implements`)

Interfaces können **nicht** instanziiert werden.

Note: Kuchenform: Volumen und Durchmesser statisch



## Information Hiding und Vererbung



### Zugriffsmodifizierer 
|               | Die Klasse selbst, innere Klassen | Klassen im selben Package | Unterklassen | Sonstige Klassen |
| ------------- | --------------------------------- | ------------------------- | ------------ | ---------------- |
| private "-"   | Ja                                | Nein                      | Nein         | Nein             |
| (default) "~" | Ja                                | Ja                        | Nein         | Nein             |
| protected "#" | Ja                                | Ja                        | Ja           | Nein             |
| public "+"    | Ja                                | Ja                        | Ja           | Ja               |

Note: Erklären: mehrere Klassen in einer Datei, innere Klassen, Unterklassen; default == package private


### Polymorphie-Modifizierer
`abstract, final, static`
Note:Polymorphie: griechisch: Vielgestaltigkeit



### abstract
Abstract sagt aus, dass es sich um eine allgemeine Klasse handelt zu der keine konkreten Objekte existieren.

* Abstrakte Klasse kann nicht instanziiert werden.
* `abstract` kann sich auf Klassen und Methoden beziehen.

Note: Definition:
1. (besonders Philosophie) die wesentlichen, gesetzmäßigen o.ä. Züge aus etwas Konkretem, sinnlich Wahrnehmbarem ableitend
2. sich [nur] im Gedanklichen, Theoretischen bewegend [und keinen unmittelbar feststellbaren Bezug zur Wirklichkeit habend]



### final
Einfach ausgedrückt bedeutet final in Java "kann nicht überschrieben werden".

* Finale Methoden lassen sich nicht überschreiben.
* Von finalen Klassen kann nicht geerbt werden.
* Finale Attribute und Klassenvariablen können nur ein einziges Mal gesetzt werden.
* Finale Parameter können nur den beim Methodenaufruf übergebenen Wert haben.
* `final` bezieht sich auf Methoden, Attribute und Klassen.



### static
Statische Eigenschaften gelten für die Klasse an sich, unabhängig von Instanzen.

* Statische Methoden und Variablen benötigen keinerlei Instanzen einer Klasse, um aufgerufen zu werden.
* Statische Methoden und Variablen sind für alle Instanzen einer Klasse gültig
* `static` bezieht sich auf Methoden und Klassenvariablen.



### Quick-Quiz
* Attribut
* Variable
* Klassenvariable
* Objektattribut
* Objektvariable
* Klassenattribut
* Feld



### Quick-Quiz 
*Erfahrungsgemäßer Sprachgebrauch*
* Attribut **Objekt**
* Variable **Methode**
* Klassenvariable **Klasse**
* Objektattribut **Objekt**
* Objektvariable **Objekt**
* Klassenattribut **Klasse**
* Feld **Klasse**



### Aufgabe 1
Funktioniert die main-Methode der Klasse `Foo` so?

Ja, oder nein. Warum?
```java
public abstract class Body {
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
public abstract class Body {
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
// Body: abstrakte Klasse mit Attributen 'int limbs' und 'int eyes' und einem Konstruktor
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
// Body: abstrakte Klasse mit Attributen 'int limbs' und 'int eyes' und einem Konstruktor
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
Nein, da `height` final ist.



### Aufgabe 3
Funktioniert die main-Methode der Klasse `Foo` so?

Ja, oder nein. Warum?
```java
public class Person extends Body {
// Body: abstrakte Klasse mit Attributen 'int limbs' und 'int eyes' und einem Konstruktor
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
// Body: abstrakte Klasse mit Attributen 'int limbs' und 'int eyes' und einem Konstruktor
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

Note: abstract -> konkret geht, andersrum nicht!



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
Nein, es wird einen Fehler beim Kompilieren geben,  da die Methode `walk()` nicht implementiert ist.



### Aufgabe 5
Können die beiden Methoden `growAnotherArm()` überschrieben werden?

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
![A7](content/images/UML-A3-Klassendiagramm.png)<!-- .element height="50%" width="50%" -->

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



### Aufgabe 7 - Lösung
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
1. Ok
2. * `b1.hunt()` existiert nicht für einen `Body`
  * `b2.grow()` existiert nicht für einen `Body`
3. * `o1.hunt()` existiert nicht für ein `Object`
  * `o1.mutate()` existiert nicht für ein `Object`
  * `o2.grow()` existiert nicht für ein `Object`
  * `o2.mutate()` existiert nicht für ein `Object`



### Aufgabe 8
![A7](content/images/UML-A3-Klassendiagramm.png)<!-- .element height="50%" width="50%" -->

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



### Aufgabe 8 - Lösung
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
Keiner dieser Aufrufe funktioniert so.



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

    public void setName(String name) {
        this.name = name;
    }
}
```
```java
public class Room extends GameObject {

    private int size;

    public void setSize(int size) {
        if (size > 0)
            this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override 
    public String toString() {
        return String.format("Room[name=%s, size=%d]", getName(), getSize());
    }
}
```



## Overriding
Eine 'geerbte' Methode kann überschrieben werden.

Überschreiben dient dazu die Funktionalität einer Methode zu ändern, falls nötig.



Überschriebene Methoden werden vom Compiler priorisiert. Es wird also immer zuerst in der Klasse nach der ensprechenden Methode gesucht, in der der Aufruf stattfindet.

Die Superklasse **jeder** Klasse ist in Java die `Object` Klasse.



Das Beispiel von eben:
```java
public class Room extends GameObject {

    private int size;

    public void setSize(int size) {
        if (size > 0)
            this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override 
    public String toString() {
        return String.format("Room[name=%s, size=%d]", getName(), getSize());
    }
}
```
enthält die überschriebene Methode `toString()`, welche von `Object` geerbt wurde.



## Overloading
Als overloaded (überladen) werden Methoden bezeichnet, welche sich nur in der Anzahl und/oder dem Typ der übergebenen Parameter unterscheiden.

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
        System.out.println(add(15));
        System.out.println(add(15, 10));
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

Note: Referenzen an die Tafel malen



### Gleichheit
Jede Klasse kann eine Methode
>**`equals()`**

implementieren, die Exemplare dieser Klasse mit beliebigen anderen Objekten vergleichen kann.

`equals()` liefert true, wenn die Objektvariablen einer Instanz vollständig übereinstimmen.

**ABER:** Das entspricht der default-Implementierung wahr. `equals()` kann auch überschrieben werden!



<pre><code class="line-numbers">Point p = new Point(10, 10);
Point q = p;
Point r = new Point(10, 10);
System.out.println(p.equals(q)); // true, da p und q dasselbe Objekt referenzieren
System.out.println(p.equals(r)); // true, da p und r identisch sind</code></pre>



## Exceptions
Exceptions, zu deutsch Ausnahmen, sind ungewolltes Verhalten eines Programms, das auftreten **kann**.



Eine Exception kann auftreten, wenn zum Beispiel

* eine Datei geöffnet werden soll, die im Filesystem nicht vorhanden ist. (`FileNotFoundException`)
* auf ein nicht instanziiertes Objekt zugegriffen werden soll. (`NullPointerException`)
* beim Zugriff auf Elemente in einem Array der minimale oder maximale Index unter- bzw. überschritten wird (`ArrayIndexOutOfBoundsException`)



Solche Fälle sind schwierig bis unmöglich vorherzusehen.



Also – was tun?



In Objektorientierten Programmiersprachen hat sich das Konzept des `Exception Handling` durchgesetzt.

Sollten Fehler auftreten wird ein spezieller Programmabschnitt druchlaufen, der angemessen auf den Fehler reagiert (beheben, umgehen, ...).



## Try - Catch

![Exception Handling](content/images/06_001.png)



`try` – versuche diesen Programmabschnitt durchzuführen

`catch` – falls eine Exception auftritt, fang sie hier auf



## Beispiel
Was kann hier schiefgehen?
```java
public class Main {
    public static void main(String[] args) {
        Punkt point = null;
        int val = point.getX();
    }
}
```



## Beispiel
NullPointerException!
```java
public class Main {
    public static void main(String[] args) {
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
public class Main {
    public static void main(String[] args) {
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
public class Main {
    public static void main(String[] args) {
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
Ist natürlich einfach zu finden, wenn man weiß wie groß das Array ist.



### Checked Exceptions
Checked Esceptions müssen beim Programmieren behandelt werden, anderfalls wird der Code nicht kompilieren.
+ IOException
+ FileNotFoundException
+ ParseException
+ ...

=> Alles was von `Exception` erbt.



### Unchecked Exceptions
Unchecked Esceptions werden vom Compiler ignoriert, können aber dennoch im Programmablauf auftreten und behandelt werden.
+ ArrayIndexOutOfBoundsException
+ IllegalArgumentException
+ NullPointerException
+ NumberFormatException
+ ...

=> Alles was von `RuntimeException` erbt.



Als Java im letzten Jahrtausend entworfen wurde, galt diese Unterscheidung als chic und modern. 

Man wollte Fehler danach unterscheiden, ob der Aufrufer sie hätte vermeiden können oder nicht.



Fehler wie `NullPointerException` (unchecked) oder `IllegalArgumentException` (unchecked) liegen an einer fehlerhaften Verwendung der betreffenden Klasse und können prinzipiell überall auftreten. 

Sie zu behandeln bringt hat folglich eine sehr schlecht "Kosten-Nutzen-Ratio"



Wenn ein Fehler für den Aufrufer aber unvorhersehbar ist – I/O, Validierung etc. (checked) – dann sollte er zu einem expliziten Teil des Ablaufes (und damit behandelt) werden.



### Aufgabe 1
Was gibt diese Methode zurück?
```java
static boolean ccc() {
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
static boolean ccc() {
    try {
      return false;
    } catch (Exception e) {
    } finally {
      return true;
    }
}
```
**true**



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
**x = 2** 



## Generics
> Generics realisieren das Prinzip des Stellvertreters

```java
List<T>
```

Eine generische Liste kann alle möglichen Arten von Daten beinhalten.



Während des Instanziierens wird dann der Typ der Listenelemente festgelegt.

z.B. `List<Integer> = new ArrayList<>()` 

oder 

`List<Contact> = new LinkedList<>()`



Der Compiler behandelt behandelt die Liste dann nach dem Motto:
>"Diese Liste ist vom Typ XY und wenn man mir einen anderen Typen gibt, dann komme ich nicht klar und werfe Exceptions!"



Generics vereinfachen also unter Umständen das Programmieren, da die generelle Implementierung an sich typunabhängig sein kann, bei der Verwendung aber ein fester Typ angegeben wird.

Die Angabe dieses Typen bei der Verwendung hilft, Fehlerquellen einzugrenzen.

Typumwandlungen und (teilweise auch) Exception Handling kann so vermieden werden.



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
    while(--i > 0){
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
    while(--i > 0){
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
        Tupel<Integer,Integer> coords = new Tupel<Integer,Integer>(10, -3);
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
        Tupel<Integer,Integer> coords = new Tupel<Integer,Integer>(10, -3);
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
        Tupel<Integer,Integer> coords = new Tupel<Integer,Integer>(10, -3);
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
        Tupel<Integer,Integer> coords = new Tupel<Integer,Integer>(10, -3);
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
