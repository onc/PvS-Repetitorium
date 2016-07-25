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
### Streams sind zunächst einmal byte-basiert!



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
