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
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class PlayerDao {

  private static PlayerDao instance;

  private static final String NAME_COLUMN_NAME = "name";

  /**
   * TODO documentation.
   * 
   * @return - only intance of the playerdao in the app
   */
  public static PlayerDao getInstance() {

    if (instance == null) {
      instance = new PlayerDao();
    }

    return instance;
  }

  /**
   * TODO documentation.
   */
  private PlayerDao() {

  }

  /**
   * TODO documentation.
   */
  public void resetDb() {

    DbConnector.resetTables();
    DbConnector.seed();
  }

  /**
   * TODO documentation.
   * 
   * @return - all players from the database
   */
  public List<PlayerDto> getPlayers() {

    List<PlayerDto> players = new ArrayList<>();

    String query = "SELECT id, name FROM PLAYERS;";

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
   * TODO documentation.
   * 
   * @param name - of the player
   * @return - player with name
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
   * TODO documentation.
   * 
   * @param playerDto - player to save
   */
  public void savePlayer(PlayerDto playerDto) {

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
   * TODO documentation.
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
