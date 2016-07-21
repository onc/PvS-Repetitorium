package de.uulm.pvs.rep.solution.data.dto;

/**
 * DTO (Data transport object) for the player in the database. This class is mapping to the
 * 'presets' table in the database.
 *
 * @author Christian van Onzenoodt
 *
 */
public class PresetDto {

  private String name;
  private int obstacleSpawnRate;
  private int monsterSpawnRate;

  /**
   * Create a new Dto.
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

  @Override
  public String toString() {
    return "PresetDto [name=" + name + ", obstacleSpawnRate=" + obstacleSpawnRate
        + ", monsterSpawnRate=" + monsterSpawnRate + "]";
  }

}
