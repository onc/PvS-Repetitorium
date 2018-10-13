# Threads



## Essenzielle Unterscheidung

Bei modernen Betriebssystemen gehört zu jedem **Prozess** mindestens ein **Thread** (zu Deutsch *Faden* oder *Ausführungsstrang*), der den Programmcode ausführt. 

Damit werden also genau genommen nicht Prozesse parallel ausgeführt, sondern nur die Threads. 

Innerhalb eines Prozesses kann es mehrere Threads geben, die alle im selben Adressraum ablaufen. 

Die einzelnen Threads eines Prozesses können untereinander auf ihre öffentlichen Daten zugreifen.



## Beispiele
Prozess-basiertes Multitasking ermöglicht, dass der Java Compiler zusammen mit einem Text-Editor genutzt werden kann.

Im Texteditor (Prozess) kann gleichzeitig die automatische Rechtschreibprüfung und automatisches Speichern einer Datei ausgeführt werden.



## Wichtige Begriffe und Schlüsselwörter
| Schlüsselwort | Funktion                                                                                                      |
| ------------- | ------------------------------------------------------------------------------------------------------------- |
| Thread        | *Klasse*, welche unterschiedliche Methoden für die Handhabung von Nebenläufigkeit anbietet.                   |
| Runnable      | *Interface*, welches die `run()`-Methode vorgibt.                                                             |
| start         | Bewirkt das starten eines Threads. Die Java VM ruft intern die `run()`-Methode des `Runnable` Interfaces auf. |
| synchronized  | Markiert kritische Programmabschnitte                                                                         |
| volatile      | Markiert Variablen um zu verhindern, dass diese zwischengespeichert werden.                                   |
| atomic        | *Klasse*, die Bspw. `AtomicInteger` nutz um Funktionen Atomar auszuführen.                                    |
| join          | Bewirkt, dass Threads aufeinander warten.                                                                     |
| sleep         | Verzögert die Ausführung eines Threads                                                                        |



## Einen neuen Thread erstellen und starten

```java
    Thread clockThread = new Thread(new Runnable() {

      @Override
      public void run() {
        // do something
      }
    });

    clockThread.start();
```

### Wichtig 
Ein `Thread` nimmt z.B. ein `Runnable` und überschreibt die `run()`-Methode. Anschließend wird der Thread mit `start()` gestartet.



## Threads gleichzeitig laufen lassen

```java
    Runnable runnableOne = new Runnable() {
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
    new Thread(runnableTwo).start();
```

Startet zwei Threads die nebenläufig abgearbeitet werden.

Output: [T2] 0, [T2] 1, [T1] 0, [T1] 3, [T2] 2, [T1] 4, [T2] 5, ...



## Threads gleichzeitig laufen lassen

```java
    Runnable runnableOne = new Runnable() {
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
    new Thread(runnableTwo).start();
```

Startet zwei Threads die nebenläufig abgearbeitet werden.

Output: [T2] 0, [T2] 1, [T1] 0, [T1] 3, [T2] 2, [T1] 4, [T2] 5, ...

## Was ist mit den Zahlen los? Da sind manche doppelt!!11!



## Synchronisieren von konkurrierenden Zugriffen

```java
    private static synchronized int getAndIncrement() { return counter++; }

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
    }
```

**Problem**: Die Operation `++` ist nicht atomar!

**Lösung**: Die Threads nicht gleichzeitig in die `getAndIncrement`- Methode lassen.

Methode muss **synchronized** sein.



# Übungen



## Was gibt dieses Programm aus?

```java
public class Foo {

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
}
```



## Lösung

```
do it!
and here
I'm here
```



## Was gibt dieses Programm aus?

```java
public class Foo extends Thread {
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
}
```



## Lösung

Kann man nicht sagen! 



## Lösung

Kann man nicht sagen! 

**Neue Frage:** Warum? Da wurde doch `AtomicInteger` verwendet...



## Lösung 2

Wegen des Schedulers



## Aufgabe

```java
public class MyThreads extends Thread { 
  public static int counter = 0; 

  public static void main(String[] args) {
    for(int i = 0; i < 20; i++) { 
      MyThreads mt = new MyThreads(); 
      mt.start(); 
    } 
    System.out.println("counter = " + counter); 
  } 

  public void run() { 
    for(int i = 0; i < 100000; i++) { 
      counter++; 
    } 
    System.out.println("Incremented counter!"); 
  } 
}
```

1. Wird `Counter` den Wert 2.000.000 erreichen? Wenn nein, warum nicht?
2. Was musst du ändern, damit der counter am Ende sicher den Wert 2000000 hat?
3. Was passiert wenn du direkt nach ``mt.start()`` ein `mt.join()` einfügst. Macht das Sinn? 



## Lösung

```java
public class MyThreads extends Thread { 
  public static int counter = 0; 

  public static void main(String[] args) {
    for(int i = 0; i < 20; i++) { 
      MyThreads mt = new MyThreads(); 
      mt.start(); 
    } 
    System.out.println("counter = " + counter); 
  } 

  public void run() { 
    for(int i = 0; i < 100000; i++) { 
      counter++; 
    } 
    System.out.println("Incremented counter!"); 
  } 
}
```

0. Wird `Counter` den Wert 2.000.000 erreichen? Wenn nein, warum nicht?
  * Der Wert **kann** 2.000.000 erreichen, wird aber auch oft einen anderen Wert ausgeben. Dies geschieht weil Updates verloren gehen. 
1. Was musst du ändern, damit der counter am Ende sicher den Wert 2000000 hat?
  * `counter++` in eine synchronisierte Methode auslagern. 
  * Alle Threads in Liste speichern und `join()` auf jedem aufrufen, vor dem finalen Print-Statement
2. Was passiert wenn du direkt nach ``mt.start()`` ein `mt.join()` einfügst. Macht das Sinn?
  * Macht keinen Sinn, weil dann nur ein Thread auf einmal läuft. 



## Aufgabe

```java
public class DeadLock extends Thread { 
  public static void main(String[] args) throws Exception {
    Object l1 = new Object(); Object l2 = new Object(); 
    Thread t1 = new DeadLock(l1, l2); Thread t2 = new DeadLock(l2, l1); 
    t1.start(); t2.start();
    t1.join(); t2.join();
  } 
  private Object lock1; private Object lock2; 

  public DeadLock(Object lock1, Object lock2) { 
    this.lock1 = lock1; this.lock2 = lock2; 
  } 

  public void run() { 
    synchronized(lock1) { System.out.println("First lock acquired!"); 
        synchronized(lock2) { System.out.println("Second lock acquired!"); 
        } 
      } System.out.println("Done! All locks released!"); 
  } 
}
```

1.  Was ist der Unterschied zwischen einer synchronized Methode und den synchronized Blöcken in der run Methode im Code?
2.  Wenn das Programm ausgeführt wird, bleibt es in einem Deadlock stecken. An welcher Stelle im Code bleiben die Threads genau hängen? 
3.  Wofür sind die join Aufrufe gut? Was passiert wenn sie entfernt werden? 
4.  Wieso kommt es zum Deadlock? 
5.  Wie kann der Deadlock verhindert werden? (Tipp: Es müssen nur zwei Zeichen im Programm geändert werden.)



## Aufgabe

```java
public class DeadLock extends Thread { 
  public static void main(String[] args) throws Exception {
    Object l1 = new Object(); Object l2 = new Object(); 
    Thread t1 = new DeadLock(l1, l2); Thread t2 = new DeadLock(l2, l1); 
    t1.start(); t2.start();
    t1.join(); t2.join();
  } 
  private Object lock1; private Object lock2; 

  public DeadLock(Object lock1, Object lock2) { 
    this.lock1 = lock1; this.lock2 = lock2; 
  } 

  public void run() { 
    synchronized(lock1) { System.out.println("First lock acquired!"); 
        synchronized(lock2) { System.out.println("Second lock acquired!"); 
        } 
      } System.out.println("Done! All locks released!"); 
  } 
}
```

1.  Was ist der Unterschied zwischen einer synchronized Methode und den synchronized Blöcken in der run Methode im Code?
  * Methoden synchronisieren auf ihrem Objekt. Bei einem Block kann man das Lock explizit angeben. 
2.  Wenn das Programm ausgeführt wird, bleibt es in einem Deadlock stecken. An welcher Stelle im Code bleiben die Threads genau hängen?
  *  Bei den synchronized Blöcken in der `run()` Methode
3.  Wofür sind die join Aufrufe gut? Was passiert wenn sie entfernt werden?
  * Die join Aufrufe warten darauf, dass beide Threads fertig sind. Dadurch bleibt das Programm beim ersten Deadlock stehen. Werden die join Aufrufe entfernt, läuft das Programm weiter, bleibt am Ende aber immer noch in Deadlocks stecken.
4.  Wieso kommt es zum Deadlock?
  * `l1` und `l2` werden jeweils von einem Thread geblockt und nie wieder frei gegeben. 
5.  Wie kann der Deadlock verhindert werden? (Tipp: Es müssen nur zwei Zeichen im Programm geändert werden.) 
  * `l1` und `l2` vertauschen.
