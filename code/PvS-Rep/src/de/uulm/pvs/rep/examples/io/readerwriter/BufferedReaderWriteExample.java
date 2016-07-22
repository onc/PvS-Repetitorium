package de.uulm.pvs.rep.examples.io.readerwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Example for Buffered Reader and Writer.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class BufferedReaderWriteExample {

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
    reader.close();
  }
}
