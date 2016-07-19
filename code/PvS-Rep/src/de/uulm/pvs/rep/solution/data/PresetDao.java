package de.uulm.pvs.rep.solution.data;

import de.uulm.pvs.rep.solution.data.dto.PresetDto;

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
public class PresetDao {

  private static PresetDao instance = null;

  private static final String ID_COLUMN_NAME = "id";
  private static final String NAME_COLUMN_NAME = "name";
  private static final String OBSTACLE_SPAWN_RATE_COLUMN_NAME = "obstacleSpawnRate";
  private static final String MONSTER_SPAWN_RATE_COLUMN_NAME = "monsterSpawnRate";

  /**
   * TODO documentation.
   * 
   * @return - only instance in the application.
   */
  public static PresetDao getInstance() {

    if (instance == null) {
      instance = new PresetDao();
    }

    return instance;
  }

  private PresetDao() {

  }

  /**
   * TODO documentation.
   * 
   * @return - all presets from the database
   */
  public List<PresetDto> getPresets() {

    List<PresetDto> presets = new ArrayList<>();

    final String query = "SELECT id, name, obstacleSpawnRate, monsterSpawnRate FROM presets;";

    try (Connection connection = DbConnector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      int id = resultSet.getInt(ID_COLUMN_NAME);
      String name = resultSet.getString(NAME_COLUMN_NAME);
      int obstacleSpawnRate = resultSet.getInt(OBSTACLE_SPAWN_RATE_COLUMN_NAME);
      int monsterSpawnRate = resultSet.getInt(MONSTER_SPAWN_RATE_COLUMN_NAME);

      PresetDto preset = new PresetDto(id, name, obstacleSpawnRate, monsterSpawnRate);

      presets.add(preset);

    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return presets;
  }

  /**
   * TODO documentation.
   * 
   * @param id - id of the preset
   * @return preset with the given id
   */
  public PresetDto getPresetById(int id) {

    final String query =
        "SELECT id, name, obstacleSpawnRate, monsterSpawnRate FROM presets WHERE id=?;";

    ResultSet resultSet = null;

    try (Connection connection = DbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, id);

      resultSet = statement.executeQuery();

      if (resultSet.next()) {

        int presetId = resultSet.getInt(ID_COLUMN_NAME);
        String name = resultSet.getString(NAME_COLUMN_NAME);
        int obstacleSpawnRate = resultSet.getInt(OBSTACLE_SPAWN_RATE_COLUMN_NAME);
        int monsterSpawnRate = resultSet.getInt(MONSTER_SPAWN_RATE_COLUMN_NAME);

        return new PresetDto(presetId, name, obstacleSpawnRate, monsterSpawnRate);
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

}
