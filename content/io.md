# Streams (IO)



## Streams

<dl>
<dt>`InputStream`</dt>
<dd>ist eine **abstrakte** Super-Klasse für alle Klasen, die `bytes` als **input** haben.<br>
Beispiele sind: `FileInputStream`, `ObjectInputStream`, `InputStream`</dd>
<br>
<dt>`OutputStream`</dt>
<dd>ist eine **abstrakte** Super-Klasse für alle Klasen, die `bytes` als **output** haben.<br>
Beispiele sind: `FileOutputStream`, `ObjectOutputStream`, `OutputStream`</dd>
</dl>
<br>
<br>
### Alle Streams sind zunächst einmal byte-basiert!



## Stream Beispiel

<pre><code class="line-numbers java">File file = new File("hallo.txt");
// create a new file, if the file not exists.
file.createNewFile();
// create an outputStream *into* the file
OutputStream outputStream = new FileOutputStream(file);
// write to the file
outputStream.write(new String("Hallo Welt\n").getBytes());
outputStream.flush();
outputStream.close();

// Create an inputStream *from* the file
InputStream inputStream = new FileInputStream(file);
// tmp array to buffer data from the stream
byte[] buffer = new byte[BUFFER_SIZE];
// create the content into the buffer
inputStream.read(buffer);
// print the content of the array
for (byte b : buffer) {
  System.out.print(String.valueOf(b));
}
inputStream.close();</code></pre>

Output: 72971081081113287101108116100000000...

72 -> H, 97 -> a, 108 -> l, ...



## Reader

![Java Reader-Klassen](content/images/reader.svg)



## Writer

![Java Writer-Klassen](content/images/writer.svg)



## Beschreibung

<dl>
<dt>`Reader` / `Writer`</dt>
<dd>ist eine **abstrakte** Klasse um Ströme von Zeichen zu schreiben/lesen.</dd>
<br>
<dt>`StringReader` / `StringWriter`</dt>
<dd>wird benutzt, wenn Quelle / Ziel ein String ist.</dd>
<br>
<dt>`InputStreamReader` / `OutputStreamWriter`</dt>
<dd>wird benutzt um einen `InputStream` / `OutputStream` zu *wrappen*.</br>
Wandelt `bytes` aus oder in den `Stream` in `chars` um.</dd>
<br>
<dt>`BufferedReader` / `BufferedWriter`</dt>
<dd>sind `Reader` / `Writer` mit einem Puffer.</dd>
</dl>



## Reader / Writer Beispiel

<pre><code class="line-numbers java">File file = new File("hallo.txt");
// create a new file, if the file not exists
file.createNewFile();
// writer *into* the file.
Writer writer = new FileWriter(file);
// Writes to the file
writer.write("Hallo Welt\n");
writer.flush();
writer.close();

// Create a reader *from* the file
Reader reader = new FileReader(file);
// tmp array to buffer data from the reader
char[] buffer = new char[BUFFER_SIZE];
// read content of file into the array
reader.read(buffer);
// print the content of the array
for (char c : buffer) {
  System.out.print(c);
}
reader.close();</code></pre>

Output: Hallo Welt



## BufferedReader / Writer Beispiel

<pre><code class="line-numbers java" data-highlight-lines="6,15,18">File file = new File("hallo.txt");
// create a new file, if the file not exists
file.createNewFile();
// create a (buffered) writer into the file
Writer writer = new FileWriter(file);
Writer bufferedWriter = new BufferedWriter(writer);
// write to the file
bufferedWriter.write("Hallo Welt\n");
bufferedWriter.flush();
bufferedWriter.close();

// create a (buffered) reader from the file
Reader reader = new FileReader(file);
// note: buffered reader has to be a BufferedReader instead of a reader to use readLine()
BufferedReader bufferedReader = new BufferedReader(reader);
// read line by line and print
String line;
while ((line = bufferedReader.readLine()) != null) {
  System.out.println(line);
}
bufferedReader.close();
reader.close();</code></pre>

Output: Hallo Welt



### Unterscheidung
Wann sind Ströme byte- wann char-basiert.

Eine Methode ist alle Streams die *'Print'* im Namen tragen als Character-Basiert zu verstehen, da mit ihnen die Anzeige für den Benutzer formatiert werden soll.



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
Manche Implementierungen von Writern und Readern buffern bytes automatisch. 

Sollte die Ausgabe zu einem bestimmten Zeitpunkt gewünscht sein muss die `flush()` Methode verwendet werden.

Wenn die Methode `close()` aufgerufen wird, wird üblicherweise vom Reader/Writer auch die Methode `flush()` ausgeführt um alle auf dem Buffer befindlichen Daten an den Empfänger zu geben.
