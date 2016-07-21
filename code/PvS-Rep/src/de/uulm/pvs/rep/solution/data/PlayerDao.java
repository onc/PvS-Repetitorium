package de.uulm.pvs.rep.solution.data;

import de.uulm.pvs.rep.solution.data.dto.PlayerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data access object) for players in the database. This class uses the singleton pattern,
 * since there is no need to have multiple instances.
 *
 * @author Christian van Onzenoodt
 * @see https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class PlayerDao {

  // only instance of PlayerDao in the application.
  private static PlayerDao instance = null;

  private static final String NAME_COLUMN_NAME = "name";

  /**
   * Singleton-getter for the instance.
   * 
   * @return - only instance of the {@link PlayerDao} in the app
   */
  public static PlayerDao getInstance() {

    // if the instance has never been initialized, do it!
    // The getInstance method is static, so this only happens once.
    if (instance == null) {
      instance = new PlayerDao();
    }

    return instance;
  }

  /**
   * Private constructor to prevent other classes from creating instances.
   */
  private PlayerDao() {

  }

  /**
   * Debug method to make the {@link DbConnector} methods accessible.
   */
  public void resetDb() {

    DbConnector.resetTables();
    DbConnector.seed();
  }

  /**
   * Get all players from the database.
   * 
   * @return - all players from the database
   */
  public List<PlayerDto> getPlayers() {

    List<PlayerDto> players = new ArrayList<>();

    String query = "SELECT name FROM players;";

    try (Connection connection = DbConnector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {

        String name = resultSet.getString(NAME_COLUMN_NAME);

        PlayerDto player = new PlayerDto(name);
        players.add(player);
      }

    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return players;
  }

  /**
   * Returns a player from the database by name.
   * 
   * @param name - of the player
   * @return - player with name or <code>null</code>, if the player was not found
   */
  public PlayerDto getPlayerByName(String name) {

    String query = "SELECT name FROM players WHERE name LIKE ?";

    ResultSet resultSet = null;

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setString(1, name);

      resultSet = statement.executeQuery();

      if (resultSet.next()) {
        String playerName = resultSet.getString(NAME_COLUMN_NAME);

        return new PlayerDto(playerName);
      }

    } catch (SQLException exception) {
      exception.printStackTrace();
    } finally {
      try {
        resultSet.close();
      } catch (SQLException sqlException) {
        sqlException.printStackTrace();
      }
    }

    return null;
  }

  /**
   * Add a player to the database.<br>
   * FIXME: maybe return something to check, if the player already exists.
   * 
   * @param playerDto - player to save
   */
  public void addPlayer(PlayerDto playerDto) {

    String query = "INSERT INTO players(name) VALUES(?)";

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setString(1, playerDto.getName());

      statement.executeUpdate();

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * Removes the given player from the database.
   * 
   * @param playerDto - player to delete
   */
  public void deletePlayer(PlayerDto playerDto) {

    String query = "DELETE FROM players WHERE name LIKE ?";

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setString(1, playerDto.getName());

      statement.executeUpdate();

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

}
