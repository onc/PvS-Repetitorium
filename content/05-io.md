# Streams (IO)



## Streams

<dl>
<dt>`InputStream`</dt>
<dd>ist eine **abstrakte** Super-Klasse für alle Klassen, die `bytes` als **Input** haben.<br>
Beispiele sind: `FileInputStream`, `ObjectInputStream`, `InputStream`</dd>
<br>
<dt>`OutputStream`</dt>
<dd>ist eine **abstrakte** Super-Klasse für alle Klassen, die `bytes` als **Output** haben.<br>
Beispiele sind: `FileOutputStream`, `ObjectOutputStream`, `OutputStream`</dd>
</dl>
<br>
<br>
### Alle Streams sind zunächst einmal byte-basiert!



## Stream Beispiel

```java
    File file = new File("hallo.txt");
    file.createNewFile(); // create a new file, if it does not exist yet

    OutputStream outputStream = new FileOutputStream(file); // create an outputStream *into* the file
    outputStream.write(new String("Hallo Welt\n").getBytes()); // write to the file
    outputStream.flush();
    outputStream.close();

    InputStream inputStream = new FileInputStream(file); // create an inputStream *from* the file
    byte[] buffer = new byte[BUFFER_SIZE]; // tmp array to buffer data from the stream
    inputStream.read(buffer); // read the content into the buffer

    for (byte b : buffer) { // print the content of the array
      System.out.print(String.valueOf(b));
    }

    inputStream.close();
```

Output: 72971081081113287101108116100000000...

72 | 97 | 108 | ...

H | a | l | ...



## Reader

![Java Reader-Klassen](content/images/reader.svg)



## Writer

![Java Writer-Klassen](content/images/writer.svg)



## Beschreibung

<dl>
<dt>`Reader` / `Writer`</dt>
<dd>ist eine **abstrakte** Klasse um Ströme von Zeichen zu lesen/schreiben.</dd>
<br>
<dt>`StringReader` / `StringWriter`</dt>
<dd>wird benutzt, wenn Quelle bzw. Ziel ein String ist.</dd>
<br>
<dt>`InputStreamReader` / `OutputStreamWriter`</dt>
<dd>wird benutzt um einen `InputStream` / `OutputStream` zu *wrappen*.</br>
liest `bytes` und wandelt sie in `chars` um / liest `chars` und wandelt sie in `bytes` um.</dd>
<br>
<dt>`BufferedReader` / `BufferedWriter`</dt>
<dd>sind `Reader` / `Writer` mit einem Puffer.</dd>
</dl>



## Reader / Writer Beispiel

```java
    File file = new File("hallo.txt");
    file.createNewFile(); // create a new file, if it does not exist yet

    Writer writer = new FileWriter(file); // writer *into* the file.
    writer.write("Hallo Welt\n"); // Writes to the file
    writer.flush();
    writer.close();

    Reader reader = new FileReader(file); // create a reader *from* the file
    char[] buffer = new char[BUFFER_SIZE]; // tmp array to buffer data from the reader
    reader.read(buffer); // read content of file into the array

    for (char c : buffer) { // print the content of the array
      System.out.print(c);
    }

    reader.close();
```

Output: Hallo Welt



## BufferedReader / Writer Beispiel

```java
    File file = new File("hallo.txt");
    file.createNewFile(); // create a new file, if it does not exist yet 

    Writer writer = new FileWriter(file); // create a (buffered) writer into the file
    Writer bufferedWriter = new BufferedWriter(writer);
    bufferedWriter.write("Hallo Welt\n"); // write to the file
    bufferedWriter.flush();
    bufferedWriter.close();

    Reader reader = new FileReader(file); // create a (buffered) reader from the file
    BufferedReader bufferedReader = new BufferedReader(reader); // it has to be a BufferedReader to use readLine()
    String line; // read line by line and print

    while ((line = bufferedReader.readLine()) != null) {
      System.out.println(line);
    }

    bufferedReader.close();
    reader.close();</code></pre>
```

Output: Hallo Welt



### Unterscheidung
Wann ist ein Stream `byte`-basiert? Wann ist er `char`-basiert?

Streams die *`Print`* im Namen haben können als `char`-basiert betrachtet werden, da mit ihnen die Anzeige für den Benutzer formatiert werden soll.



### PrintStream Beispiel
```java
public static void main(String[] args){
    System.out.print( "Verhaften Sie die üblichen Verdächtigen!" );
    System.out.print( true );
    System.out.print( -273 );
    System.out.print('\n');
    System.out.print( 1.6180339887498948 );
}
```
`System.out.print` ist ein PrintStream, also ein Strom von Daten-Werten.

```java
Verhaften Sie die üblichen Verdächtigen!true-273
1.618033988749895
```



### OutputStream Beispiel
```java
public static void main(String[] args){
    FileOutputStream fos = new FileOutputStream("t.tmp");
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeInt(12345);
    oos.writeObject("Today");
    oos.writeObject(new Date());

    oos.close();
}
```
`ObjectOutputStream` ist ein OutputStream, also ein Strom von bytes.

```java
¬í w  09t Todaysr java.util.DatehjKYt  xpw  W¯æhx
```



### Aufgabe 1
Was wird ausgegeben?
```java
public static void main(String[] args) throws IOException {
    DataOutputStream out = new DataOutputStream(System.out);

    out.writeBoolean(true);
    out.writeFloat(3.1415f);
    out.writeInt(250177);
    out.writeChar('a');

    if (out != null) {
      out.close();
    }
}
```



### Antwort 1
Was wird ausgegeben?
```java
public static void main(String[] args) throws IOException {
    DataOutputStream out = new DataOutputStream(System.out);

    out.writeBoolean(true);
    out.writeFloat(3.1415f);
    out.writeInt(250177);
    out.writeChar('a');

    if (out != null) {
      out.close();
    }
}
```
@IV ÑA a



### Aufgabe 2
Was wird ausgegeben?
```java
public static void main(String[] args) throws IOException {
    PrintStream out = new PrintStream(System.out);

    out.print(true);
    out.print(3.1415f);
    out.print(250177);
    out.print('a');

    if (out != null) {
      out.close();
    }
}
```



### Antwort 2
Was wird ausgegeben?
```java
public static void main(String[] args) throws IOException {
    PrintStream out = new PrintStream(System.out);

    out.print(true);
    out.print(3.1415f);
    out.print(250177);
    out.print('a');

    if (out != null) {
      out.close();
    }
}
```
true3.1415250177a



### Flushing
Manche Implementierungen von `Writern` und `Readern` buffern bytes automatisch. 

Sollte die Ausgabe zu einem bestimmten Zeitpunkt gewünscht sein muss die `flush()` Methode verwendet werden.

Wenn die Methode `close()` aufgerufen wird, wird üblicherweise vom Reader/Writer auch die Methode `flush()` ausgeführt um alle Daten aus dem Buffer an den Empfänger zu schicken.
