package de.uulm.pvs.rep.examples.io.readerwriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Example class for FileReader/Writer.
 *
 * @author Christian van Onzenoodt
 *
 */
public class FileReaderWriterExample {

  private static final int BUFFER_SIZE = 50;

  /**
   * Main-Method.
   * 
   * @param args - arguments
   * @throws IOException - on io-errors
   */
  public static void main(String[] args) throws IOException {

    File file = new File("hallo.txt");
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
    reader.close();
  }
}
