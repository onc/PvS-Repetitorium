package de.uulm.pvs.rep.solution.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class DbConnector {

  private static final String URL = "jdbc:hsqldb:file:data/db/scores.db";
  public static final String DRIVER = "org.hsqldb.jdbcDriver";

  private static final String USER = "SA";
  private static final String PASSWORD = "";

  private static final String DB_INIT_SCRIPT_PATH = "de/uulm/pvs/rep/solution/data/db.sql";

  static {
    try {
      Class.forName(DRIVER);
    } catch (ClassNotFoundException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * TODO documentation.
   * 
   * @throws SQLException - oh no
   */
  static void resetDb() throws SQLException {

    Connection connection = null;
    Statement statement = null;

    try {
      connection = DbConnector.getConnection();
      statement = connection.createStatement();

      String query = DbConnector.loadInitScript();

      statement.execute(query);
    } finally {
      statement.close();
      connection.close();
    }
  }

  /**
   * TODO documentation.
   * 
   * @return - script to initialize the database
   */
  static String loadInitScript() {

    ClassLoader classLoader = DbConnector.class.getClassLoader();
    String scriptPath = classLoader.getResource(DB_INIT_SCRIPT_PATH).getPath();
    File file = new File(scriptPath).getAbsoluteFile();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

      StringBuilder stringBuilder = new StringBuilder();

      for (String line = bufferedReader.readLine(); line != null; line =
          bufferedReader.readLine()) {
        stringBuilder.append(line);
      }

      return stringBuilder.toString();

    } catch (FileNotFoundException exception) {
      exception.printStackTrace();
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    return "";
  }

  /**
   * TODO documentation.
   * 
   * @return - Connection to the database
   */
  static Connection getConnection() {

    try {
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return null;
  }
}
