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
   * TODO documentation.
   * 
   * @param game - the game
   */
  public void gameFinished(GameDto game);
}
