package de.uulm.pvs.rep.solution.game.entities.enemies;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Class for an moving {@link Enemy}.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class MovingEnemy extends Enemy {

  private static final String MOVING_ENEMY_IMAGE_PATH = "de/uulm/pvs/rep/resources/monster.png";

  private static final int DEFAULT_SIZE = 64;

  private static final float AMPLITUTE = 2.5f;
  private static final float MULTIPLICATOR = 0.025f;

  private int iterator = 0;

  public MovingEnemy(Point spawnPoint) {
    this(spawnPoint, new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  public MovingEnemy(Point spawnPoint, Dimension size) {
    super(spawnPoint, size, MOVING_ENEMY_IMAGE_PATH);
  }

  /**
   * Updates the enemy. using cos to let the enemy moving up and down.
   */
  public void update() {
    // FIXME: ugly, but it works...
    iterator++;
    // use cos-function to get the entity moving up and down.
    int offsetY = Math.round(AMPLITUTE * (float) Math.cos(MULTIPLICATOR * iterator));
    super.translate(-1, offsetY);
  }
}
