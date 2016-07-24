package de.uulm.pvs.rep.exercises.one.game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * Launcher for the game.
 *
 * @author Christian van Onzenoodt
 *
 */
public class Launcher extends JFrame {

  private static final long serialVersionUID = -7710011414960920377L;

  private Game game;

  /**
   * Launcher for the game.
   */
  public Launcher() {

    // create a new game
    this.game = new Game();

    this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    // add the game to the frame (this)
    this.add(game.getRenderPanel());
    this.setResizable(false);
    this.pack();
    this.setVisible(true);

    // pass 'this' to the game to register the keylistener
    game.registerListener(this);

    // run the game
    Thread gameThread = new Thread(game);
    gameThread.run();
  }

  /**
   * TODO documentation.
   * 
   * @param args - arguments
   */
  public static void main(String[] args) {

    new Launcher();
  }
}
