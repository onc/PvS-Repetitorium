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
   * 
   * @return - players from the database.
   */
  public List<PlayerDto> getPlayers() {

    try {
      return this.loadPlayers();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return null;
  }

  /**
   * Get list of all players from the database.
   * 
   * @return - list of players
   * @throws SQLException - sql on errors
   */
  private List<PlayerDto> loadPlayers() throws SQLException {

    List<PlayerDto> players = new ArrayList<>();

    String query = "SELECT id, name FROM player";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      connection = DbConnector.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);

      while (resultSet.next()) {

        int id = resultSet.getInt(ID_COLUMN_NAME);
        String name = resultSet.getString(NAME_COLUMN_NAME);

        PlayerDto player = new PlayerDto(id, name);
        players.add(player);
      }

    } finally {
      resultSet.close();
      statement.close();
      connection.close();
    }

    return players;
  }

  /**
   * TODO documentation.
   * 
   * @param playerDto - player to store
   * @return - stored player including id, otherwise null
   */
  public PlayerDto savePlayer(PlayerDto playerDto) {

    try {
      return this.storePlayer(playerDto);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return null;
  }

  private PlayerDto storePlayer(PlayerDto playerDto) throws SQLException {

    String query = "INSERT INTO player(name) VALUES(?)";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {

      connection = DbConnector.getConnection();
      statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      statement.setString(1, playerDto.getName());

      statement.executeUpdate();

      resultSet = statement.getGeneratedKeys();

      if (resultSet.next()) {
        int id = resultSet.getInt(1);
        playerDto.setId(id);
        return playerDto;
      }
    } finally {
      resultSet.close();
      statement.close();
      connection.close();
    }

    return null;
  }

}
