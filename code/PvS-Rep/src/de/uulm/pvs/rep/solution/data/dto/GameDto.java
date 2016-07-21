package de.uulm.pvs.rep.solution.data.dto;

import java.sql.Timestamp;

/**
 * DTO (Data transport object) for games in the database. This class is a mapping to the 'games'
 * table in the database.
 *
 * @author Christian van Onzenoodt
 *
 */
public class GameDto implements Comparable<GameDto> {

  // columns in the 'games' table
  private int id;
  private PlayerDto playerDto;
  private PresetDto presetDto;
  private int score;
  private Timestamp playedAt;

  /**
   * Creates a dto object without id and timestamp. This constructor is used to create objects for
   * storing in the database, since ids and timestamps are set by the database.
   * 
   * @param playerDto - player of the game
   * @param score - score of the player
   */
  public GameDto(PlayerDto playerDto, PresetDto presetDto, int score) {

    this.id = -1;
    this.playerDto = playerDto;
    this.presetDto = presetDto;
    this.score = score;
  }

  /**
   * Creates a dto object including id and timestamp. This constructor is uses when objects are
   * loaded from the database.
   * 
   * @param id - if of the game
   * @param playerDto - player of the game
   * @param score - score of the player
   * @param playedAt - time the game was played;
   */
  public GameDto(int id, PlayerDto playerDto, PresetDto presetDto, int score, Timestamp playedAt) {

    this.id = id;
    this.playerDto = playerDto;
    this.presetDto = presetDto;
    this.score = score;
    this.playedAt = playedAt;
  }

  public PresetDto getPresetDto() {
    return presetDto;
  }

  public void setPresetDto(PresetDto presetDto) {
    this.presetDto = presetDto;
  }

  public PlayerDto getPlayerDto() {
    return playerDto;
  }

  public void setPlayerDto(PlayerDto playerDto) {
    this.playerDto = playerDto;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Timestamp getPlayedAt() {
    return playedAt;
  }

  public void setPlayedAt(Timestamp playedAt) {
    this.playedAt = playedAt;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "GameDto [id=" + id + ", playerDto=" + playerDto + ", presetDto=" + presetDto
        + ", score=" + score + ", playedAt=" + playedAt + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((playedAt == null) ? 0 : playedAt.hashCode());
    result = prime * result + ((playerDto == null) ? 0 : playerDto.hashCode());
    result = prime * result + ((presetDto == null) ? 0 : presetDto.hashCode());
    result = prime * result + score;
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
    GameDto other = (GameDto) obj;
    if (id != other.id) {
      return false;
    }
    if (playedAt == null) {
      if (other.playedAt != null) {
        return false;
      }
    } else if (!playedAt.equals(other.playedAt)) {
      return false;
    }
    if (playerDto == null) {
      if (other.playerDto != null) {
        return false;
      }
    } else if (!playerDto.equals(other.playerDto)) {
      return false;
    }
    if (presetDto == null) {
      if (other.presetDto != null) {
        return false;
      }
    } else if (!presetDto.equals(other.presetDto)) {
      return false;
    }
    if (score != other.score) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(GameDto other) {
    if (this.getScore() < other.getScore()) {
      return -1;
    } else if (this.getScore() > other.getScore()) {
      return 1;
    }
    return 0;
  }

}
