package de.uulm.pvs.rep.solution.data;

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
   * @return - Connection to the database
   * @throws SQLException - on connection error
   */
  static Connection getConnection() throws SQLException {

    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  static void resetTables() {

    final String dropTableGames = "DROP TABLE games IF EXISTS;";
    final String dropTablePlayers = "DROP TABLE players IF EXISTS;";
    final String dropTablePresets = "DROP TABLE presets IF EXISTS;";

    final String createTablePlayers =
        "CREATE TABLE players(name VARCHAR(30) NOT NULL PRIMARY KEY);";
    final String createTablePresets = "CREATE TABLE presets(name VARCHAR(30) NOT NULL PRIMARY KEY, "
        + " obstacleSpawnRate INTEGER NOT NULL, monsterSpawnRate INTEGER NOT NULL);";
    final String createTableGames =
        "CREATE TABLE games(id INTEGER IDENTITY PRIMARY KEY, player VARCHAR(30) NOT NULL REFERENCES players(name), "
            + "preset VARCHAR(30) NOT NULL REFERENCES presets(name), score INTEGER NOT NULL, "
            + "playedAt TIMESTAMP DEFAULT NOW);";

    try (Connection connection = DbConnector.getConnection();
        Statement statement = connection.createStatement()) {

      statement.execute(dropTableGames);
      System.out.println("[DB] Dropped table games");
      statement.execute(dropTablePlayers);
      System.out.println("[DB] Dropped table players");
      statement.execute(dropTablePresets);
      System.out.println("[DB] Dropped table presets");

      statement.execute(createTablePlayers);
      System.out.println("[DB] Created table players");
      statement.execute(createTablePresets);
      System.out.println("[DB] Created table presets");
      statement.execute(createTableGames);
      System.out.println("[DB] Created table games");

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  static void seed() {

    final String createPlayer = "INSERT INTO players (name) VALUES ('Bernd');";
    final String createPresetEasy =
        "INSERT INTO presets (name, obstacleSpawnRate, monsterSpawnRate) VALUES ('Easy', 5, 5);";
    final String createPresetMedium =
        "INSERT INTO presets (name, obstacleSpawnRate, monsterSpawnRate) VALUES ('Medium', 10, 10);";
    final String createGame =
        "INSERT INTO games (player, preset, score) VALUES ('Bernd', 'Easy', 1000);";

    try (Connection connection = DbConnector.getConnection();
        Statement statement = connection.createStatement()) {

      statement.execute(createPlayer);
      System.out.println("[DB] Seed player");
      statement.execute(createPresetEasy);
      statement.execute(createPresetMedium);
      System.out.println("[DB] Seed preset");
      statement.execute(createGame);
      System.out.println("[DB] Seed game");

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

}
