package de.uulm.pvs.rep.solution.data;

import de.uulm.pvs.rep.solution.data.dto.GameDto;
import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class GameDao {

  private static GameDao instance;

  private static final String ID_COLUMN_NAME = "id";
  private static final String PLAYER_NAME_COLUMN_NAME = "player";
  private static final String PRESET_NAME_COLUMN_NAME = "preset";
  private static final String SCORE_COLUMN_NAME = "score";
  private static final String PLAYED_AT_COLUMN_NAME = "playedAt";

  /**
   * TODO documentation.
   * 
   * @return - only instance of the gamedao in the app
   */
  public static GameDao getInstance() {

    if (instance == null) {
      instance = new GameDao();
    }

    return instance;
  }

  private GameDao() {

  }

  /**
   * TODO documentation.
   * 
   * @return - all games from the database
   */
  public List<GameDto> getGames() {

    List<GameDto> games = new ArrayList<>();

    String query = "SELECT id, player, preset, score, playedAt FROM games";

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

}
