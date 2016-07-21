package de.uulm.pvs.rep.solution.data;

import de.uulm.pvs.rep.solution.data.dto.GameDto;
import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data access object) for games in the database. This class uses the singleton pattern, since
 * there is no need to have multiple instances.
 *
 * @author Christian van Onzenoodt
 * @see https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class GameDao {

  // only instance of GameDao in the application
  private static GameDao instance = null;

  private static final String ID_COLUMN_NAME = "id";
  private static final String PLAYER_NAME_COLUMN_NAME = "player";
  private static final String PRESET_NAME_COLUMN_NAME = "preset";
  private static final String SCORE_COLUMN_NAME = "score";
  private static final String PLAYED_AT_COLUMN_NAME = "playedAt";

  /**
   * Singleton-getter for the instance.
   * 
   * @return - only instance of the {@link GameDao} in the app
   */
  public static GameDao getInstance() {

    // if the instance has never been initialized, do it!
    // The getInstance method is static, so this only happens once.
    if (instance == null) {
      instance = new GameDao();
    }

    return instance;
  }

  /**
   * Private constructor to prevent other classes from creating instances.
   */
  private GameDao() {

  }

  /**
   * Gets all games from the database.
   * 
   * @return - all games from the database
   */
  public List<GameDto> getGames() {

    List<GameDto> games = new ArrayList<>();

    final String query = "SELECT id, player, preset, score, playedAt FROM games";

    try (Connection connection = DbConnector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {

        int id = resultSet.getInt(ID_COLUMN_NAME);
        String playerName = resultSet.getString(PLAYER_NAME_COLUMN_NAME);
        String presetName = resultSet.getString(PRESET_NAME_COLUMN_NAME);
        int score = resultSet.getInt(SCORE_COLUMN_NAME);
        Timestamp playedAt = resultSet.getTimestamp(PLAYED_AT_COLUMN_NAME);

        PlayerDto player = PlayerDao.getInstance().getPlayerByName(playerName);
        PresetDto preset = PresetDao.getInstance().getPresetByName(presetName);

        GameDto game = new GameDto(id, player, preset, score, playedAt);
        games.add(game);
      }

    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return games;
  }

  /**
   * Add a game to the database. This method does not store the nested player and preset objects.
   * 
   * @param game - to add
   */
  public void addGame(GameDto game) {

    final String query = "INSERT INTO games(player, preset, score) VALUES(?, ?, ?);";

    final int playerColumnNumber = 1;
    final int presetColumnNumber = 2;
    final int scoreColumnNumber = 3;

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setString(playerColumnNumber, game.getPlayerDto().getName());
      statement.setString(presetColumnNumber, game.getPresetDto().getName());
      statement.setInt(scoreColumnNumber, game.getScore());

      statement.executeUpdate();

    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }

}
