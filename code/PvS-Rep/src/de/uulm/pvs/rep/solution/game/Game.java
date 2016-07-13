package de.uulm.pvs.rep.solution.game;

import de.uulm.pvs.rep.solution.game.engine.GameFinishedListener;
import de.uulm.pvs.rep.solution.game.engine.GameLogic;
import de.uulm.pvs.rep.solution.game.engine.Input;
import de.uulm.pvs.rep.solution.game.engine.Renderer;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * TODO documentation.
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
   * TODO documentation.
   */
  public Game() {

    this.input = new Input();
    this.renderer = new Renderer(WINDOW_SIZE);
    this.gameLogic = new GameLogic(renderer, input, WINDOW_SIZE);
  }

  public JPanel getRenderPanel() {
    return this.renderer;
  }

  public void registerListener(JFrame frame) {
    frame.addKeyListener(input);
  }

  private long getTime() {
    return System.nanoTime();
  }

  public void addGameFinishedListener(GameFinishedListener gameFinishedListener) {
    this.gameFinishedListener = gameFinishedListener;
  }

  /**
   * TODO documentation.
   */
  @Override
  public void run() {

    this.gameLogic.initGame();

    final int oneSecond = 1000 * 1000 * 1000;

    final int maxRenderHz = 120;
    final int updateHz = 120;

    // time for rendering one frame in milliseconds (16ms)
    final long frameTime = oneSecond / maxRenderHz;
    // time for one update in milliseconds (8ms)
    final long updateTime = oneSecond / updateHz;

    long now = 0;

    long nextFrame = getTime() + frameTime;
    long nextUpdate = getTime() + updateTime;

    while (this.gameLogic.isRunning()) {

      now = getTime();

      // rerender
      if (now > nextFrame) {
        this.gameLogic.render();
        nextFrame = getTime() + frameTime;
      }

      // update game logic
      if (now > nextUpdate) {
        this.gameLogic.update();
        nextUpdate = getTime() + updateTime;
      }
    }

    gameFinishedListener.gameFinished(this.gameLogic.getPoints());
  }

}

