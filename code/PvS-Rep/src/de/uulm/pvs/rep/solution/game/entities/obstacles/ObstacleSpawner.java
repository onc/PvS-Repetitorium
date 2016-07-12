package de.uulm.pvs.rep.solution.game.entities.obstacles;

import de.uulm.pvs.rep.solution.game.engine.Renderable;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class ObstacleSpawner implements Renderable {

  private static final int DEFAULT_Y_SPAWN_OFFSET = -10;

  private List<Asteroid> asteroids;
  private List<Asteroid> removeList;

  private int zindex;

  /**
   * TODO documentation.
   * 
   * @param zindex - int
   */
  public ObstacleSpawner(int zindex) {
    this.zindex = zindex;

    this.asteroids = Collections.synchronizedList(new LinkedList<>());
    this.removeList = Collections.synchronizedList(new LinkedList<>());
  }

  public void spawnAsteroid(int coordinateX) {
    spawnAsteroid(new Point(coordinateX, DEFAULT_Y_SPAWN_OFFSET));
  }

  public void spawnAsteroid(Point spawnPoint) {
    asteroids.add(new Asteroid(spawnPoint));
  }

  /**
   * TODO documentation.
   */
  public void update() {

    this.asteroids.removeAll(this.removeList);
    this.removeList.clear();

    for (Asteroid asteroid : asteroids) {
      asteroid.update();
    }

    for (Asteroid asteroid : asteroids) {
      if (asteroid.getPosition().x + asteroid.getSize().width <= 0) {
        this.removeList.add(asteroid);
      }
    }
  }

  public void removeAsteroid(Asteroid asteroid) {
    removeList.add(asteroid);
  }

  public int getAsteroidCound() {
    return asteroids.size();
  }

  public List<Asteroid> getList() {
    return asteroids;
  }

  @Override
  public void render(Graphics2D graphics) {
    for (Asteroid asteroid : asteroids) {
      asteroid.render(graphics);
    }
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
