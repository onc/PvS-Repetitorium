package de.uulm.pvs.rep.solution.game.engine;

import java.awt.Graphics2D;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public interface Renderable extends Comparable<Renderable> {

  /**
   * TODO documentation.
   * 
   * @param graphics - {@link Graphics2D}
   */
  public void render(Graphics2D graphics);

  /**
   * TODO documentation.
   * 
   * @return - int
   */
  public int getZindex();

  @Override
  /**
   * TODO documentation.
   */
  public default int compareTo(Renderable other) {
    if (this.getZindex() < other.getZindex()) {
      return -1;
    } else if (this.getZindex() > other.getZindex()) {
      return 1;
    }
    return 0;
  }

}
