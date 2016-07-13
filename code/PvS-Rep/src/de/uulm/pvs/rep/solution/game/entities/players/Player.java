package de.uulm.pvs.rep.solution.game.entities.players;

import de.uulm.pvs.rep.solution.game.engine.Button;
import de.uulm.pvs.rep.solution.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Player extends Entity {

  private static final String PLAYER_IMAGE_PATH =
      "de/uulm/pvs/rep/solution/resources/spaceship.png";
  private static final int DEFAULT_SIZE = 32;
  private Dimension windowSize;

  /**
   * TODO documentation.
   * 
   * @param zindex - int
   * @param windowSize - {@link Dimension}
   */
  public Player(int zindex, Dimension windowSize) {
    super(new Point(0, windowSize.height / 2), PLAYER_IMAGE_PATH,
        new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
    super.zindex = zindex;
    this.windowSize = windowSize;
  }

  public Player(int zindex, Dimension windowSize, Dimension playerSize) {
    super(new Point(0, windowSize.height / 2), "resources/spaceship.png", playerSize);
  }

  /**
   * TODO documentation.
   * 
   * @param input - boolean[]
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
   * TODO documentation.
   * 
   * @param button - {@link Button}
   */
  private void move(Button button) {

    int stepSize = 1;

    Point position = super.getPosition();
    Dimension size = super.getSize();

    switch (button) {
      case UP:
        if (position.y <= 0) {
          break;
        }
        super.translate(0, -1 * stepSize);
        break;

      case DOWN:
        if (position.y >= windowSize.getHeight() - size.height) {
          break;
        }
        super.translate(0, 1 * stepSize);
        break;

      case LEFT:
        if (position.x <= 0) {
          break;
        }
        super.translate(-1 * stepSize, 0);
        break;

      case RIGHT:
        if (position.x >= windowSize.getWidth() - size.width) {
          break;
        }
        super.translate(1 * stepSize, 0);
        break;

      default:
        break;
    }
  }

}
