package de.uulm.pvs.rep.solution.game.entities.enemies;

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
public class EnemySpawner implements Renderable {

  private List<Enemy> enemies;
  private List<Enemy> removeList;

  private int zindex;

  /**
   * TODO documentation.
   * 
   * @param zindex - int
   */
  public EnemySpawner(int zindex) {
    this.zindex = zindex;
    this.enemies = Collections.synchronizedList(new LinkedList<>());
    this.removeList = Collections.synchronizedList(new LinkedList<>());
  }

  public void spawnEnemy(Point spawnPoint) {
    enemies.add(new MovingEnemy(spawnPoint));
  }

  /**
   * TODO documentation.
   */
  public void update() {

    // remove all enemies which are on the remove list from the render-list
    this.enemies.removeAll(removeList);
    this.removeList.clear();

    // run update on all remaining
    for (Enemy enemy : enemies) {
      enemy.update();
    }

    // add 'old' to the remove-list
    for (Enemy enemy : enemies) {
      if (enemy.getPosition().x + enemy.getSize().width <= 0) {
        this.removeList.add(enemy);
      }
    }
  }

  public void removeEnemy(Enemy enemy) {
    removeList.add(enemy);
  }

  public int getEnemyCount() {
    return enemies.size();
  }

  @Override
  public void render(Graphics2D graphics) {
    for (Enemy enemy : enemies) {
      enemy.render(graphics);
    }
  }

  public List<Enemy> getList() {
    return enemies;
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
