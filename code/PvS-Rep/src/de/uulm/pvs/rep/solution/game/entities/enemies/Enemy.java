package de.uulm.pvs.rep.solution.game.entities.enemies;

import de.uulm.pvs.rep.solution.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Point;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Enemy extends Entity {

  private static final String ENEMY_IMAGE_PATH = "de/uulm/pvs/rep/solution/resources/monster.png";
  private static final int DEFAULT_SIZE = 64;

  public Enemy(Point spawnPoint) {
    this(spawnPoint, new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  public Enemy(Point spawnPoint, Dimension size) {
    super(spawnPoint, ENEMY_IMAGE_PATH, size);
  }

  public Enemy(Point spawnPoint, String imagePath, Dimension size) {
    super(spawnPoint, imagePath, size);
  }

  public void update() {
    super.translate(-1, 0);
  }
}
