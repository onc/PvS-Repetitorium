package de.uulm.pvs.rep.solution.game.entities.projectiles;

import de.uulm.pvs.rep.solution.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Class for projectile.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Projectile extends Entity {

  private static final String PROJECTILE_IMAGE_PATH = "de/uulm/pvs/rep/resources/projectile.png";

  private static final int DEFAULT_SPEED = 3;
  private static final int DEFAULT_SIZE = 16;

  private int speed = 0;

  /**
   * Creates an new asteroid at the given location.
   * 
   * @param spawnPoint - point where the projectile should spawn
   */
  public Projectile(Point spawnPoint) {
    this(spawnPoint, new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  /**
   * Creates an new asteroid at the given location and with the given size.
   * 
   * @param spawnPoint - point where the projectile should spawn
   * @param size - size of the projectile
   */
  public Projectile(Point spawnPoint, Dimension size) {
    this(spawnPoint, size, DEFAULT_SPEED);
  }

  /**
   * Creates an new asteroid at the given location, the given size and the given speed.
   * 
   * @param spawnPoint - point where the projectile should spawn
   * @param size - size of the projectile
   * @param speed - speed of the projectile
   */
  public Projectile(Point spawnPoint, Dimension size, int speed) {
    super(spawnPoint, PROJECTILE_IMAGE_PATH, size);
    this.speed = speed;
  }

  /**
   * Updates the projectile. This moves the projectile with his speed into the x-axis.
   */
  public void update() {
    super.translate(this.speed, 0);
  }
}
