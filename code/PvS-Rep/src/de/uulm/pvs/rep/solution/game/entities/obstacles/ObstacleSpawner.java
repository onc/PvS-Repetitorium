package de.uulm.pvs.rep.solution.game.entities.obstacles;

import de.uulm.pvs.rep.solution.game.entities.util.Spawner;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Spawner for {@link Asteroid}. This class holds a list of asteroids, which can be rendered and
 * updated at once.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class ObstacleSpawner extends Spawner<Asteroid> {

  public ObstacleSpawner(int zindex, Dimension windowSize) {
    super(zindex, windowSize);
  }

  private static final int DEFAULT_Y_SPAWN_OFFSET = -10;

  /**
   * Spawns an new {@link Asteroid} at the given location in the z-axis. In this method the y-axis
   * is by default above the viewplane.
   * 
   * @param coordinateX - value in the x-axis
   */
  public void spawn(int coordinateX) {
    this.spawn(new Point(coordinateX, DEFAULT_Y_SPAWN_OFFSET));
  }

  /**
   * Spawns an new {@link Asteroid} at the given location.
   * 
   * @param spawnPoint - location, where the android should spawn.
   */
  public void spawn(Point spawnPoint) {
    super.spawn(new Asteroid(spawnPoint));
  }
}
