package de.uulm.pvs.rep.exercises.one.game.entities.enemies;

import de.uulm.pvs.rep.exercises.one.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Base-class for enemies.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Enemy extends Entity {

  // defaults for size and image
  private static final String ENEMY_IMAGE_PATH = "de/uulm/pvs/rep/resources/monster.png";
  private static final int DEFAULT_SIZE = 64;

  /**
   * Creates an new {@link Enemy} at the given point. This uses defaults for size and image of the
   * enemy.
   * 
   * @param spawnPoint - point, where the new enemy should spawn
   */
  public Enemy(Point spawnPoint) {
    this(spawnPoint, new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  /**
   * Creates an new {@link Enemy} at the given point with the given size. Uses an default image of
   * the enemy.
   * 
   * @param spawnPoint - point, where the new enemy should spawn
   * @param size - size of the enemy
   */
  public Enemy(Point spawnPoint, Dimension size) {
    this(spawnPoint, size, ENEMY_IMAGE_PATH);
  }

  /**
   * Creates an new {@link Enemy} at the given point with the given size an the given image.
   * 
   * @param spawnPoint - point, where the new enemy should spawn
   * @param size - size of the enemy
   */
  public Enemy(Point spawnPoint, Dimension size, String imagePath) {
    super(spawnPoint, imagePath, size);
  }

  /**
   * Update the enemy. This basically means move the enemy to the left ;).
   */
  public void update() {
    super.translate(-1, 0);
  }
}
