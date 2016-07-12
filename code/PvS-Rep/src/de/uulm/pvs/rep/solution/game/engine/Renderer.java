package de.uulm.pvs.rep.solution.game.engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Renderer extends JPanel {

  private static final long serialVersionUID = -3104742715928448210L;

  private List<Renderable> renderables;

  /**
   * TODO documentation.
   * 
   * @param windowSize - {@link Dimension}
   */
  public Renderer(Dimension windowSize) {
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.setPreferredSize(windowSize);

    this.setDoubleBuffered(true);

    this.renderables = new LinkedList<>();
  }

  /**
   * TODO documentation.
   * 
   * @param renderable - {@link Renderable}
   */
  public void addRenderable(Renderable renderable) {
    this.renderables.add(renderable);

    Collections.sort(this.renderables);
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    Graphics2D g2d = (Graphics2D) graphics.create();

    for (Renderable renderable : this.renderables) {
      renderable.render(g2d);
    }

    g2d.dispose();
    // magic to get it running smooth
    Toolkit.getDefaultToolkit().sync();
  }

  public void render() {
    this.repaint();
  }

}
