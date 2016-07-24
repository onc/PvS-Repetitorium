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

  /**
   * Java 8 provides the option to provide default implementations in interfaces. Since all
   * renderables should share the same compareTo method implementation to have Collections.sort()
   * work properly, we provide this default implementation bases on the z-index.
   */
  @Override
  public default int compareTo(Renderable other) {
    if (this.getZindex() < other.getZindex()) {
      return -1;
    } else if (this.getZindex() > other.getZindex()) {
      return 1;
    }
    return 0;
  }

}
