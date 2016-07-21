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
 * Renderer of the game. This class extends {@link JPanel} so this Renderer can be added to any
 * other swing-component like another JPanel.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Renderer extends JPanel {

  private static final long serialVersionUID = -3104742715928448210L;

  // List of rendererables
  private List<Renderable> renderables;

  /**
   * Creates an new Renderer with the given size.
   * 
   * @param windowSize - size of the renderer, usually the size of the window.
   */
  public Renderer(Dimension windowSize) {
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.setPreferredSize(windowSize);

    // Enable double-buffering. Double-buffering means you render you final game-frame onto an
    // back-buffer and show this buffer if you are finished rendering. While you are rendering into
    // the back-buffer, you are showing the 'other' buffer. This prevents many rendering issues like
    // tearing or flickering.
    this.setDoubleBuffered(true);

    this.renderables = new LinkedList<>();
  }

  /**
   * Add a new {@link Renderable} to the list of objects to render. This method calls sort on the
   * renderinList after a {@link Renderable} was added. All Renderables implement compareTo based on
   * there z-index. This way we can take care our objects are rendered in the right z-order.
   * 
   * @param renderable - {@link Renderable} to add.
   */
  public void addRenderable(Renderable renderable) {
    this.renderables.add(renderable);

    Collections.sort(this.renderables);
  }

  /**
   * Remove all renderables from the list.
   */
  public void clear() {
    this.renderables.clear();
  }

  /**
   * Iterates all renderables an renders them to the {@link JPanel}.
   */
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

  /**
   * Triggers repaint on the {@link JPanel}. This implicitly calls paintComponent.
   */
  public void render() {
    this.repaint();
  }

}
