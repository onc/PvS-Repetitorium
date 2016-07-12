package de.uulm.pvs.rep.solution.game.entities.projectiles;

import de.uulm.pvs.rep.solution.game.engine.Renderable;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class ProjectileSpawner implements Renderable {

  private List<Projectile> projectiles;
  private List<Projectile> removeList;
  private Dimension windowSize;

  private int zindex;

  // spawns per second
  private static final int ONE_SECOND = 1000;
  private static final int SPAWN_RATE = 5;
  private static final int SPAWNS_PER_SECOND = ONE_SECOND / SPAWN_RATE;
  private long nextProjectileTime = System.currentTimeMillis();

  /**
   * TODO documentation.
   * 
   * @param zindex - int
   * @param windowSize - {@link Dimension}
   */
  public ProjectileSpawner(int zindex, Dimension windowSize) {

    this.zindex = zindex;
    this.projectiles = Collections.synchronizedList(new LinkedList<>());
    this.removeList = Collections.synchronizedList(new LinkedList<>());
    this.windowSize = windowSize;
  }

  /**
   * TODO documentation.
   * 
   * @param spawnPoint - {@link Point}
   */
  public void spawnProjectile(Point spawnPoint) {
    if (System.currentTimeMillis() > nextProjectileTime) {
      projectiles.add(new Projectile(spawnPoint));
      nextProjectileTime = System.currentTimeMillis() + SPAWNS_PER_SECOND;
    }
  }

  /**
   * TODO documentation.
   */
  public void update() {

    // remove all projectiles which are on the remove-list from the rendering-list
    this.projectiles.removeAll(removeList);
    this.removeList.clear();

    // update on all remaining
    for (Projectile projectile : projectiles) {
      projectile.update();
    }

    // add 'old' projectiles to the remove-list
    for (Projectile projectile : projectiles) {
      if (projectile.getPosition().x >= windowSize.width) {
        this.removeList.add(projectile);
      }
    }
  }

  public void removeProjectile(Projectile projectile) {
    this.removeList.add(projectile);
  }

  public int getProjectileCount() {
    return projectiles.size();
  }

  @Override
  public void render(Graphics2D graphics) {
    for (Projectile projectile : projectiles) {
      projectile.render(graphics);
    }
  }

  public List<Projectile> getList() {
    return projectiles;
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
