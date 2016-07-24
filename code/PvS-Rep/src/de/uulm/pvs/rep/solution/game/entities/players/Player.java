package de.uulm.pvs.rep.solution.game.entities.players;

import de.uulm.pvs.rep.solution.game.engine.Button;
import de.uulm.pvs.rep.solution.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Class for the Player.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Player extends Entity {

  private static final String PLAYER_IMAGE_PATH = "de/uulm/pvs/rep/resources/spaceship.png";
  public static final int DEFAULT_SIZE = 64;
  private Dimension windowSize;

  private int stepSize = 1;

  /**
   * Creates a new player.
   * 
   * @param zindex - z-index where the player should be rendered.
   * @param windowSize - size of the window / rendered-area.
   */
  public Player(int zindex, Dimension windowSize) {
    super(new Point(0, windowSize.height / 2), PLAYER_IMAGE_PATH,
        new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
    super.zindex = zindex;
    this.windowSize = windowSize;
  }

  /**
   * Creates a new player with the given size.
   * 
   * @param zindex - z-index where the player should be rendered.
   * @param windowSize - size of the window / rendered-area.
   * @playerSize - size of the player
   */
  public Player(int zindex, Dimension windowSize, Dimension playerSize) {
    super(new Point(0, windowSize.height / 2), PLAYER_IMAGE_PATH, playerSize);
  }

  @Override
  public void update() {
    // We have to have this method because we are a renderable...
  }

  /**
   * Update the position of the player based on the pressed keys.
   * 
   * @param input - pressed buttons
   */
  public void update(boolean[] input) {

    if (input[Button.UP.ordinal()]) {
      this.move(Button.UP);
    }

    if (input[Button.DOWN.ordinal()]) {
      this.move(Button.DOWN);
    }

    if (input[Button.RIGHT.ordinal()]) {
      this.move(Button.RIGHT);
    }

    if (input[Button.LEFT.ordinal()]) {
      this.move(Button.LEFT);
    }
  }

  /**
   * Move the player in the given direction.
   * 
   * @param button - Button for the direction
   */
  private void move(Button button) {

    // get position and size of the player to check, if the player is still visible
    Point position = super.getPosition();
    Dimension size = super.getSize();

    switch (button) {
      case UP:
        if (position.y <= 0) {
          break;
        }
        super.translate(0, -1 * this.stepSize);
        break;

      case DOWN:
        if (position.y >= windowSize.getHeight() - size.height) {
          break;
        }
        super.translate(0, 1 * this.stepSize);
        break;

      case LEFT:
        if (position.x <= 0) {
          break;
        }
        super.translate(-1 * this.stepSize, 0);
        break;

      case RIGHT:
        if (position.x >= windowSize.getWidth() - size.width) {
          break;
        }
        super.translate(1 * this.stepSize, 0);
        break;

      default:
        break;
    }
  }

}
