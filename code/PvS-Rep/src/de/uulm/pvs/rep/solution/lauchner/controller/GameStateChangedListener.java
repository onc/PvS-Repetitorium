package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.data.dto.GameDto;

/**
 * This listener is used to notify the game-controller when the games has finished.
 *
 * @author Christian van Onzenoodt
 *
 */
public interface GameStateChangedListener {

  /**
   * The game has ended.
   * 
   * @param game - the game including player and score
   */
  public void gameFinished(GameDto game);
}
