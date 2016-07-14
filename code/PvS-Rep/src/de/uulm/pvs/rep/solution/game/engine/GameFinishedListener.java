package de.uulm.pvs.rep.solution.game.engine;

/**
 * This Listener is used to notify the game-logic whenever a game is finished.
 *
 * @author Christian van Onzenoodt
 *
 */
public interface GameFinishedListener {

  /**
   * Game is finished.
   * 
   * @param points - the points the player got in this game.
   */
  public void gameFinished(int points);
}
