package de.uulm.pvs.rep.solution.game.entities.obstacles;

import de.uulm.pvs.rep.solution.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Asteroid extends Entity {

  private static final String ASTEROID_IMAGE_PATH =
      "de/uulm/pvs/rep/solution/resources/asteroid.png";

  private static final int DEFAULT_SPEED_X = -2;
  private static final int DEFAULT_SPEED_Y = 1;

  private static final int DEFAULT_SIZE = 32;

  private int speedX = 0;
  private int speedY = 0;

  public Asteroid(Point spawnPoint) {
    this(spawnPoint, new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  /**
   * TODO documentation.
   * 
   * @param spawnPoint - {@link Point}
   * @param size - {@link Dimension}
   */
  public Asteroid(Point spawnPoint, Dimension size) {
    this(spawnPoint, size, DEFAULT_SPEED_X, DEFAULT_SPEED_Y);
  }

  /**
   * TODO documentation.
   * 
   * @param spawnPoint - {@link Point}
   * @param size - {@link Dimension}
   * @param speedX - int
   * @param speedY - int
   */
  public Asteroid(Point spawnPoint, Dimension size, int speedX, int speedY) {
    super(spawnPoint, ASTEROID_IMAGE_PATH, size);
    this.speedX = speedX;
    this.speedY = speedY;
  }

  public void update() {
    super.translate(this.speedX, this.speedY);
  }

}
