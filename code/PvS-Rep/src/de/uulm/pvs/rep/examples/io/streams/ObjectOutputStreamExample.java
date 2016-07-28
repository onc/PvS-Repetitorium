package de.uulm.pvs.rep.examples.io.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Example class for ObjectInputStream/ObjectOutputStream.
 *
 * @author Christian van Onzenoodt
 *
 */
public class ObjectOutputStreamExample {

  /**
   * Just a little class which we use to write into the file.<br>
   * This class *must* implement {@link Serializable} to be able to write and read it to/from
   * streams.
   *
   * @author Christian van Onzenoodt
   *
   */
  private static class Payload implements Serializable {

    private static final long serialVersionUID = 8051446343366374930L;

    private String content;

    public Payload(String content) {
      this.content = content;
    }

    @Override
    public String toString() {
      return "I'm the class Payload and this is my content: " + this.content;
    }
  }

  /**
   * Main-Method.
   * 
   * @param args - arguments
   * @throws IOException - on io-errors
   * @throws ClassNotFoundException - if the class we read was not found
   */
  public static void main(String[] args) throws IOException, ClassNotFoundException {

    Payload payload = new Payload("Hallo Welt!");

    File file = new File("file.txt");
    // create a new file, if the file not exists
    file.createNewFile();

    // Stream *into* the file
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    // create an objectOutputStream, which streams an object
    // in this case we steam the object into the fileOutputStream
    // the fileOutputSteam streams the object into the file
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    // write the object into the file
    objectOutputStream.writeObject(payload);
    objectOutputStream.flush();
    objectOutputStream.close();

    // create streams from file -> object
    FileInputStream fileInputStream = new FileInputStream(file);
    ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

    // read the object from file
    Object readObject = inputStream.readObject();
    inputStream.close();

    // check, if the object we read is from type Payload
    if (readObject instanceof Payload) {
      // cast the object to payload. we can do this, because we know it is a payload-object
      Payload readPayload = (Payload) readObject;
      System.out.println(readPayload);
    }
  }

}
