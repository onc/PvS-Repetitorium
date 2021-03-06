package de.uulm.pvs.rep.exercises.one.game.entities.projectiles;

import de.uulm.pvs.rep.exercises.one.game.entities.players.Player;
import de.uulm.pvs.rep.exercises.one.game.entities.util.Spawner;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Spawner for {@link Projectile}.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class ProjectileSpawner extends Spawner<Projectile> {

  // spawns per second
  private static final int ONE_SECOND = 1000;
  private static final int SPAWN_RATE = 5;
  private static final int SPAWNS_PER_SECOND = ONE_SECOND / SPAWN_RATE;

  private long nextProjectileTime = System.currentTimeMillis();

  public ProjectileSpawner(int zindex, Dimension windowSize) {
    super(zindex, windowSize);
  }

  /**
   * Spawns a new Projectile at the given location.
   * 
   * @param spawnPoint - point, where the projectile should spawn.
   */
  @Override
  public void spawn(Point spawnPoint) {
    // if it is time to spawn a new one, let it happen
    if (System.currentTimeMillis() > nextProjectileTime) {
      // Move the spawnPoint a little bit, so the projectiles are spawning in front of and in the
      // middle of the spaceship
      Point point = new Point(spawnPoint);
      point.y += Player.DEFAULT_SIZE / 2;
      point.x += Player.DEFAULT_SIZE / 2;
      super.spawn(new Projectile(point));
      // time when the next projectile can be spawned
      nextProjectileTime = System.currentTimeMillis() + SPAWNS_PER_SECOND;
    }
  }

  @Override
  public void spawn(int coordinateX) {
    throw new UnsupportedOperationException("This method is not implemented");
  }

}
