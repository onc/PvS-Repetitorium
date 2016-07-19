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

  private static final String ID_COLUMN_NAME = "id";
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

        int id = resultSet.getInt(ID_COLUMN_NAME);
        String name = resultSet.getString(NAME_COLUMN_NAME);

        PlayerDto player = new PlayerDto(id, name);
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
   * @param id - id of the player to find
   * @return player
   */
  public PlayerDto getPlayerById(int id) {

    String query = "SELECT id, name FROM players WHERE id = ?";

    ResultSet resultSet = null;

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, id);

      resultSet = statement.executeQuery();

      if (resultSet.next()) {
        int playerId = resultSet.getInt(ID_COLUMN_NAME);
        String playerName = resultSet.getString(NAME_COLUMN_NAME);

        return new PlayerDto(playerId, playerName);
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
   * @return - the new player
   */
  public PlayerDto savePlayer(PlayerDto playerDto) {

    String query = "INSERT INTO players(name) VALUES(?)";

    ResultSet resultSet = null;

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement =
            connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

      statement.setString(1, playerDto.getName());

      statement.executeUpdate();

      resultSet = statement.getGeneratedKeys();

      if (resultSet.next()) {
        int id = resultSet.getInt(1);
        playerDto.setId(id);
        return playerDto;
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
   * @param playerDto - player to update
   */
  public void updatePlayer(PlayerDto playerDto) {

    String query = "UPDATE players SET name=? WHERE id=?";

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setString(1, playerDto.getName());
      statement.setInt(2, playerDto.getId());

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
  public void storeDeletePlayer(PlayerDto playerDto) {

    String query = "DELETE FROM players WHERE id=?";

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, playerDto.getId());

      statement.executeUpdate();

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

}
