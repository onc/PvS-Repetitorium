package de.uulm.pvs.rep.solution.data.dto;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class PresetDto {

  private int id = -1;
  private String name;
  private int obstacleSpawnRate;
  private int monsterSpawnRate;

  /**
   * TODO documentation.
   * 
   * @param id - id of the preset
   * @param name - name of the preset
   * @param obstacleSpawnRate - rate of obstacles
   * @param monsterSpawnRate - rate of monsters
   */
  public PresetDto(int id, String name, int obstacleSpawnRate, int monsterSpawnRate) {
    this.id = id;
    this.name = name;
    this.obstacleSpawnRate = obstacleSpawnRate;
    this.monsterSpawnRate = monsterSpawnRate;
  }

  /**
   * TODO documentation.
   * 
   * @param name - name of the preset
   * @param obstacleSpawnRate - rate of obstacles
   * @param monsterSpawnRate - rate of monsters
   */
  public PresetDto(String name, int obstacleSpawnRate, int monsterSpawnRate) {
    this.name = name;
    this.obstacleSpawnRate = obstacleSpawnRate;
    this.monsterSpawnRate = monsterSpawnRate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getObstacleSpawnRate() {
    return obstacleSpawnRate;
  }

  public void setObstacleSpawnRate(int obstacleSpawnRate) {
    this.obstacleSpawnRate = obstacleSpawnRate;
  }

  public int getMonsterSpawnRate() {
    return monsterSpawnRate;
  }

  public void setMonsterSpawnRate(int monsterSpawnRate) {
    this.monsterSpawnRate = monsterSpawnRate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + monsterSpawnRate;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + obstacleSpawnRate;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    PresetDto other = (PresetDto) obj;
    if (id != other.id) {
      return false;
    }
    if (monsterSpawnRate != other.monsterSpawnRate) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (obstacleSpawnRate != other.obstacleSpawnRate) {
      return false;
    }
    return true;
  }

}
