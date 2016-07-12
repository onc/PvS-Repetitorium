package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.game.Game;
import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 */
public class GameController implements ActionListener {

  private Game game;

  private JFrame gameFrame;

  /**
   * TODO documentation.
   */
  public GameController() {

    game = new Game();

    gameFrame = new JFrame();

    gameFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setLocationRelativeTo(null);
    gameFrame.add(game.getRenderer());
    gameFrame.setResizable(false);
    gameFrame.pack();

  }

  /**
   * TODO documentation.
   */
  private void startGame() {
    gameFrame.setVisible(true);
    gameFrame.toFront();
    game.registerListener(gameFrame);

    new Thread(() -> {
      game.start();
    }).start();
  }

  @Override
  public void actionPerformed(ActionEvent event) {

    if (event.getActionCommand().equals(ActionConstants.START_GAME)) {
      System.out.println("start game");
      startGame();
    }
  }
}
