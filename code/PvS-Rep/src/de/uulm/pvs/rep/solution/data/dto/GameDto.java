package de.uulm.pvs.rep.solution.data.dto;

import java.sql.Timestamp;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class GameDto {

  private int id;
  private PlayerDto playerDto;
  private int score;
  private Timestamp playedAt;

  /**
   * TODO documentation.
   * 
   * @param playerDto - player of the game
   * @param score - score of the player
   */
  public GameDto(PlayerDto playerDto, int score) {

    this.id = -1;
    this.playerDto = playerDto;
    this.score = score;
  }

  /**
   * TODO documentation.
   * 
   * @param id - if of the game
   * @param playerDto - player of the game
   * @param score - score of the player
   * @param playedAt - time the game was played;
   */
  public GameDto(int id, PlayerDto playerDto, int score, Timestamp playedAt) {

    this.id = id;
    this.playerDto = playerDto;
    this.score = score;
    this.playedAt = playedAt;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((playedAt == null) ? 0 : playedAt.hashCode());
    result = prime * result + ((playerDto == null) ? 0 : playerDto.hashCode());
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
    if (score != other.score) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "GameDto [id=" + id + ", playerDto=" + playerDto + ", score=" + score + ", playedAt="
        + playedAt + "]";
  }

}
