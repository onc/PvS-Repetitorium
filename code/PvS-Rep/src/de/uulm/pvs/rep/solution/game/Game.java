package de.uulm.pvs.rep.solution.game;

import de.uulm.pvs.rep.solution.game.engine.GameFinishedListener;
import de.uulm.pvs.rep.solution.game.engine.GameLogic;
import de.uulm.pvs.rep.solution.game.engine.Input;
import de.uulm.pvs.rep.solution.game.engine.Renderer;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class for a game.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Game implements Runnable {

  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;

  public static final Dimension WINDOW_SIZE = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

  private Renderer renderer;
  private Input input;
  private GameLogic gameLogic;

  private GameFinishedListener gameFinishedListener;

  /**
   * Creates a new game by initializing the input, renderer and gamelogic.
   */
  public Game() {

    this.input = new Input();
    this.renderer = new Renderer(WINDOW_SIZE);
    this.gameLogic = new GameLogic(renderer, input, WINDOW_SIZE);
  }

  /**
   * Returns the renderer which is a {@link JPanel}.
   * 
   * @return - JPanel of the renderer
   */
  public JPanel getRenderPanel() {
    return this.renderer;
  }

  /**
   * Register the input-class on the given frame.
   * 
   * @param frame - frame where the input is registered to
   */
  public void registerListener(JFrame frame) {
    frame.addKeyListener(input);
  }

  /**
   * Helper-method so i can write getTime(), instead of System....
   * 
   * @return - the current time in nano-seconds
   */
  private long getTime() {
    return System.nanoTime();
  }

  /**
   * Adds the given {@link GameFinishedListener} to this game.
   * 
   * @param gameFinishedListener - listener to add
   */
  public void addGameFinishedListener(GameFinishedListener gameFinishedListener) {
    this.gameFinishedListener = gameFinishedListener;
  }

  /**
   * Starts the game. This class extends {@link Runnable}, so please call .start!!!
   */
  @Override
  public void run() {

    // initializes the game-logic by reseting points, inputs and so on.
    this.gameLogic.initGame();

    final int oneSecond = 1000 * 1000 * 1000;

    // maximal rate of fps
    final int maxRenderHz = 120;
    // maximal rate of updates per second
    final int updateHz = 120;

    // time for rendering one frame in milliseconds
    final long frameTime = oneSecond / maxRenderHz;
    // time for one update in milliseconds
    final long updateTime = oneSecond / updateHz;

    long now = 0;

    // render a new frame at this time!
    long nextFrame = getTime() + frameTime;
    // update the game at this time!
    long nextUpdate = getTime() + updateTime;

    // while the game is running / player has not lost
    while (this.gameLogic.isRunning()) {

      // get the current time
      now = getTime();

      // rerender if it is the time
      if (now > nextFrame) {
        this.gameLogic.render();
        nextFrame = getTime() + frameTime;
      }

      // update game logic if it is the time
      if (now > nextUpdate) {
        this.gameLogic.update();
        nextUpdate = getTime() + updateTime;
      }
    }

    // if where are here, the game is over. call the listener-method to notify all listeners
    gameFinishedListener.gameFinished(this.gameLogic.getPoints());
  }

}

