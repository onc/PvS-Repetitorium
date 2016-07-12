package de.uulm.pvs.rep.solution.game.entities.projectiles;

import de.uulm.pvs.rep.solution.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * TODO.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Projectile extends Entity {

  private static final String PROJECTILE_IMAGE_PATH =
      "de/uulm/pvs/rep/solution/resources/projectile.png";

  private static final int DEFAULT_SPEED = 3;
  private static final int DEFAULT_SIZE = 16;

  private int speed = 0;

  public Projectile(Point spawnPoint) {
    this(spawnPoint, new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  public Projectile(Point spawnPoint, Dimension size) {
    this(spawnPoint, size, DEFAULT_SPEED);
  }

  public Projectile(Point spawnPoint, Dimension size, int speed) {
    super(spawnPoint, PROJECTILE_IMAGE_PATH, size);
    this.speed = speed;
  }

  public void update() {
    super.translate(this.speed, 0);
  }
}
