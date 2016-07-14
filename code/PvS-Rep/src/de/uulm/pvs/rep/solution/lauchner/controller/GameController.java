package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.game.Game;
import de.uulm.pvs.rep.solution.game.engine.GameFinishedListener;
import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Controller for the game. This controller starts the game an returns the points etc. a user got
 * while playing the game.
 * 
 * @author Christian van Onzenoodt
 */
public class GameController implements ActionListener, GameFinishedListener {

  private Game game;

  private JFrame gameFrame;

  /**
   * Create a new GameController. This creates a game, a frame for the game, sets all default
   * options for this frame and registers all used listeners ({@link KeyListener} and
   * {@link GameFinishedListener})
   */
  public GameController() {

    game = new Game();

    gameFrame = new JFrame();

    gameFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setLocationRelativeTo(null);
    gameFrame.add(game.getRenderPanel());
    gameFrame.setResizable(false);
    gameFrame.pack();

    game.registerListener(gameFrame);
    game.addGameFinishedListener(this);
  }

  /**
   * Starts a game. This methods sets the game-frame visible, brings the frame to front and starts
   * the game in a new {@link Thread}.
   */
  private void startGame() {

    gameFrame.setVisible(true);
    gameFrame.toFront();

    Thread gameThread = new Thread(game);
    gameThread.start();
  }

  @Override
  public void actionPerformed(ActionEvent event) {

    // if the user pressed the 'start-game'-button, start the game
    if (event.getActionCommand().equals(ActionConstants.START_GAME)) {
      System.out.println("start game");
      startGame();
    }
  }

  @Override
  public void gameFinished(int points) {
    // if the game has ended, do something
    System.out.println(points);
    gameFrame.setVisible(false);
  }
}
