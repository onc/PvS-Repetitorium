package de.uulm.pvs.rep.exercises.one.game.engine;

import java.awt.Graphics2D;

/**
 * Interface for a renderable.
 * 
 * @author Christian van Onzenoodt
 *
 */
public interface Renderable extends Comparable<Renderable> {

  /**
   * Render this component to the given {@link Graphics2D}.
   * 
   * @param graphics - {@link Graphics2D}
   */
  public void render(Graphics2D graphics);

  /**
   * Returns the z-index where the rendererable should be rendered in. Renderables in a list can be
   * sorted using this index.
   * 
   * @return - z-index to render to.
   */
  public int getZindex();

  /**
   * Update the logic.
   */
  public void update();

  @Override
  public default int compareTo(Renderable other) {

    // TODO Renderable's sollen anhand des z-index richtig sortiert werden.
    return 0;
  }

}
