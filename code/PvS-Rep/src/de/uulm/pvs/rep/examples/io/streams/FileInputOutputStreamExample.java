package de.uulm.pvs.rep.examples.io.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Example class for FileInputStream/FileOutputStream.
 *
 * @author Christian van Onzenoodt
 *
 */
public class FileInputOutputStreamExample {

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
    inputStream.close();
  }
}
