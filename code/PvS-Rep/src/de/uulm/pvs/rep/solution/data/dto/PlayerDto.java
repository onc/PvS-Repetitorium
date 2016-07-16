package de.uulm.pvs.rep.solution.data.dto;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class PlayerDto {

  private int id;
  private String name;

  /**
   * TODO documentation.
   * 
   * @param name - name of the player
   */
  public PlayerDto(String name) {

    this.id = -1;
    this.name = name;
  }

  /**
   * TODO documentation.
   * 
   * @param id - id of the player
   * @param name - name of the player
   */
  public PlayerDto(int id, String name) {

    this.id = id;
    this.name = name;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    PlayerDto other = (PlayerDto) obj;
    if (id != other.id) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "PlayerDto [id=" + id + ", name=" + name + "]";
  }

}
