package de.uulm.pvs.rep.exercises.one.game.entities.util;

import de.uulm.pvs.rep.exercises.one.game.engine.Renderable;
import de.uulm.pvs.rep.exercises.one.game.entities.Entity;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class for spawners. This class supports all types which are extending {@link Entity}
 * using generics.
 *
 * @author Christian van Onzenoodt
 *
 * @param <T> - type of elements in the spawner (asteroids, projectiles, ...)
 */
public abstract class Spawner<T extends Entity> implements Renderable {

  // elements to render
  private List<T> renderingList;
  // elements to remove from the rendering-list on the next update
  private List<T> removeList;

  // z-index where the spawner should be rendered in
  protected int zindex;
  // size of the window
  private Dimension windowSize;

  /**
   * Creates an new spawner in the given z-index. The window-size is needed to check, if the
   * {@link Entity} in the renderlist are still in the visible area.
   * 
   * @param zindex - index where all entities in this spawner are rendered in
   * @param windowSize - size of the window / rendering-area.
   */
  public Spawner(int zindex, Dimension windowSize) {
    this.zindex = zindex;
    this.windowSize = windowSize;

    this.renderingList = Collections.synchronizedList(new LinkedList<>());
    this.removeList = Collections.synchronizedList(new LinkedList<>());
  }

  /**
   * Adds an new {@link Entity} to the renderingList.
   * 
   * @param entity - to add to the renderingList
   */
  public void spawn(T entity) {
    renderingList.add(entity);
  }

  /**
   * Method to spawn an new entity with an default y-axis coordinate and the given x-coordinate.
   * 
   * @param coordinateX - coordinate on the x-axis
   */
  public abstract void spawn(int coordinateX);

  /**
   * This method is abstract, because the spawner which extends this, has to create an actual
   * instance.
   * 
   * @param spawnPoint - point, where the entity should spawn
   */
  public abstract void spawn(Point spawnPoint);

  /**
   * Checks for {@link Entity} which are no longer visible and removes them from the renderingList.
   * All remaining {@link Entity} on the renderingList are getting updated.
   */
  public void update() {

    this.cleanRenderingList();

    for (Entity entity : renderingList) {
      entity.update();
    }

  }

  /**
   * Returns the list of {@link Entity}.
   * 
   * @return - List of {@link Entity}
   */
  public List<T> getList() {
    return this.renderingList;
  }

  /**
   * Returns the amount of entities on the renderingList.
   * 
   * @return - amount of entities on the renderingList
   */
  public int getEntityCount() {
    return this.renderingList.size();
  }

  public void remove(T entity) {
    this.removeList.add(entity);
  }

  /**
   * Checks, if the given {@link Entity} is still visible.
   * 
   * @param entity - {@link Entity} to check
   * @return true, if the {@link Entity} is visible, otherwise false
   */
  private boolean isVisible(T entity) {

    if (entity.getPosition().x + entity.getSize().width <= 0) {
      // the entity is left of the visible area and no longer visible - remove it
      return false;
    } else if (entity.getPosition().x > this.windowSize.width) {
      // the entity is right of the visible area
      return false;
    } else if (entity.getPosition().y + entity.getSize().height <= 0) {
      // the entity is above of the visible area
      return false;
    } else if (entity.getPosition().y > this.windowSize.height) {
      // the entity is below the visible area
      return false;
    }

    return true;
  }

  /**
   * Cleans up the renderingList, by removing all {@link Entity} on the removeList from the
   * renderingList.
   */
  private void cleanRenderingList() {

    for (T entity : renderingList) {
      // if the entity is no longer visible, add them to the removeList
      if (!this.isVisible(entity)) {
        this.removeList.add(entity);
      }
    }

    // remove all entities on the removeList from the renderingList
    // there are also entities which are added in the main-loop (projectiles hitting enemies)
    this.renderingList.removeAll(removeList);
    // clear the removeList
    this.removeList.clear();
  }

  /**
   * Triggers rerender on all entites on the renderingList.
   */
  @Override
  public void render(Graphics2D graphics) {

    for (T entity : renderingList) {
      entity.render(graphics);
    }
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
