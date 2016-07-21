package de.uulm.pvs.rep.solution.game.entities.obstacles;

import de.uulm.pvs.rep.solution.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Class for an asteroid.
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

  /**
   * Spawns an asteroid at the given location.
   * 
   * @param spawnPoint - point where the asteroid should spawn
   */
  public Asteroid(Point spawnPoint) {
    this(spawnPoint, new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  /**
   * Spawns an asteroid at the given location, with the given size.
   * 
   * @param spawnPoint - point where the asteroid should spawn
   * @param size - size of the asteroid
   */
  public Asteroid(Point spawnPoint, Dimension size) {
    this(spawnPoint, size, DEFAULT_SPEED_X, DEFAULT_SPEED_Y);
  }

  /**
   * Spawns an asteroid at the given location, which the given size and the speeds in x and y.
   * 
   * @param spawnPoint - point where the asteroid should spawn
   * @param size - size of the asteroid
   * @param speedX - speed in the x-axis
   * @param speedY - speed in the y-axis
   */
  public Asteroid(Point spawnPoint, Dimension size, int speedX, int speedY) {
    super(spawnPoint, ASTEROID_IMAGE_PATH, size);
    this.speedX = speedX;
    this.speedY = speedY;
  }

  /**
   * Update the asteroid. This moves the asteroid into his directions in x- and y-axis.
   */
  public void update() {
    super.translate(this.speedX, this.speedY);
  }

}
