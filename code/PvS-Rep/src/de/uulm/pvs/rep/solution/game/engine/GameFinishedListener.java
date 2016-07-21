package de.uulm.pvs.rep.solution.game.engine;

import de.uulm.pvs.rep.solution.data.dto.GameDto;

/**
 * This Listener is used to notify the game-logic whenever a game is finished.
 *
 * @author Christian van Onzenoodt
 *
 */
public interface GameFinishedListener {

  /**
   * Called if the games has ended.
   * 
   * @param game - the game-object including the player and his score.
   */
  public void gameFinished(GameDto game);
}
