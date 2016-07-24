package de.uulm.pvs.rep.exercises.one.game.entities.enemies;

import de.uulm.pvs.rep.exercises.one.game.entities.util.Spawner;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Spawner for {@link Enemy}. This class holds a list of enemies, which can be rendered and updated
 * at once.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class EnemySpawner extends Spawner<Enemy> {

  public EnemySpawner(int zindex, Dimension windowSize) {
    super(zindex, windowSize);
  }

  /**
   * Spawns an new {@link Enemy} at the given location.
   * 
   * @param spawnPoint - location, where the enemy should spawn
   */
  public void spawn(Point spawnPoint) {
    super.spawn(new Enemy(spawnPoint));
  }

  @Override
  public void spawn(int coordinateX) {
    throw new UnsupportedOperationException("This method is not implemented");
  }
}
