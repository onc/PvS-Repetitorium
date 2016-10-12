# Threads



## Essenzielle Unterscheidung

Bei modernen Betriebssystemen gehört zu jedem **Prozess** mindestens ein **Thread** (zu Deutsch *Faden* oder *Ausführungsstrang*), der den Programmcode ausführt. Damit werden also genau genommen die Prozesse nicht mehr parallel ausgeführt, sondern nur die Threads. 

Innerhalb eines Prozesses kann es mehrere Threads geben, die alle zusammen in demselben Adressraum ablaufen. Die einzelnen Threads eines Prozesses können untereinander auf ihre öffentlichen Daten zugreifen.

----

Beispiel (Prozess): Prozess basiertes Multitasking ermöglicht, dass der Java Compiler zusammen mit einem Text-Editor genutzt werden kann.

Beispiel (Thread): Im selben Prozess (bspw. Texteditor) kann die automatische Rechtschreibprüfung und automatisches Speichern einer Datei ausgeführt werden.



## Wichtige Begriffe und Schlüsselwörter
| Schlüsselwort | Funktion |
|---|---|
| Thread | *Klasse*, welche unterschiedliche Methoden für die Handhabung von Nebenläufigkeit anbietet. |
| Runnable | *Interface*, welches die `run()`-Methode vorgibt. |
| start | Bewirkt das starten eines Threads. Die Java VM ruft intern die `run()`-Methode des `Runnable` Interfaces auf. |
| synchronized | Markiert kritische Programmabschnitte |
| volatile | Markiert Variablen um zu verhindern, dass diese zwischengespeichert werden. |
| atomic | *Klasse*, die Bspw. `AtomicInteger` nutz um Funktionen Atomar auszuführen. |
| join | Bewirkt, dass Threads auf einander warten. |
| sleep | Verzögert die Ausführung eines Threads |



## Einen neuen Thread erstellen und starten

<pre><code class="line-numbers">Thread clockThread = new Thread(new Runnable() {

  @Override
  public void run() {
    // do something
  }
});

clockThread.start();</code></pre>

Wichtig: Ein `Thread` nimmt (z.B.) ein `Runnable` bei dem die `run()`-Methode überschrieben wird. Anschließend wird der Thread mit `start()` gestartet.



## Threads gleichzeitig laufen lassen

<pre><code class="line-numbers">Runnable runnableOne = new Runnable() {
  @Override
  public void run() {
    for (int i = 0; i < ITERATIONS; i++) {
      System.out.println("[T1] " + counter++);
    }
  }
};

Runnable runnableTwo = new Runnable() {
  @Override
  public void run() {
    for (int i = 0; i < ITERATIONS; i++) {
      System.out.println("[T2] " + counter++);
    }
  }
};

new Thread(runnableOne).start();
new Thread(runnableTwo).start();</code></pre>

Dies startet zwei Threads die dann nebenläufig abgearbeitet werden.

Ouput: [T2] 0, [T2] 1, [T1] 0, [T1] 3, [T2] 2, [T1] 4, [T2] 5, ...

## Was ist mit den nummern los? Da sind manche doppelt!!11!



## Synchronisieren von konkurrierenden Zugriffen

<pre><code class="line-numbers" data-highlight-lines="1">private static synchronized int getAndIncrement() { return counter++; }

public static void main(String[] args) {

  Runnable runnableOne = new Runnable() {
    public void run() {
      for (int i = 0; i < ITERATIONS; i++) {
        System.out.println("[T1] " + getAndIncrement());
      }
    }
  };

  Runnable runnableTwo = new Runnable() {
    public void run() {
      for (int i = 0; i < ITERATIONS; i++) {
        System.out.println("[T2] " + getAndIncrement());
      }
    }
  };
  new Thread(runnableOne).start();
  new Thread(runnableTwo).start();
}</code></pre>

**Problem**: Die Operation `++` ist nicht atomar!

Nur jeweils ein Thread darf gleichzeitig innerhalb der Methode getAndIncrement() sein.

**Lösung**: Methode muss synchronized sein.



# Übungen



## Was gibt dieses Programm aus?

<pre><code class="line-numbers">public class Foo {

  private static class MyRunnable implements Runnable {
    @Override
    public void run() {
      Thread.sleep(5);
      System.out.println("I'm here");
    }
  }

  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() { System.out.println("and here"); }
    });
    System.out.println("do it!");
    new Thread(new MyRunnable()).start();
    thread.start();
  }
}</code></pre>



## Lösung

```
do it!
and here
I'm here
```



## Was gibt dieses Programm aus?

<pre><code class="line-numbers">public class Foo extends Thread {
  private String name; private AtomicInteger content;
  public Foo(String name, AtomicInteger content) {
    this.name = name; this.content = content; 
  }
  public void run() {
    for (int i = 0; i < 1000; i++) {
      if (this.name.equals("F")) { 
        content.set(1);
      } else if (this.name.equals("B")) { 
        content.set(0); 
      }
    }
  }
  public static void main(String[] args) {
    AtomicInteger integer = new AtomicInteger(2);
    Foo foo = new Foo("F", integer);
    Foo fooBar = new Foo("B", integer);
    foo.start(); fooBar.start();
    foo.join(); fooBar.join();
    System.out.println(integer.get());
  }
}</code></pre>



## Lösung

Kann man nicht sagen! 

Neue Frage: Warum? Da wurde doch AtomicInteger verwendet...



## Lösung 2

Scheduler
