package de.uulm.pvs.rep.exercises.one.game.entities.util;

import de.uulm.pvs.rep.exercises.one.game.engine.Renderable;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class for the HUD.
 *
 * @author Christian van Onzenoodt
 *
 */
public class Hud implements Renderable {

  private int zindex = 0;

  private static final int OFFSET_Y = 10;
  private String text = "";

  /**
   * Create a new HUD. This hud is rendered to the given z-index.
   * 
   * @param zindex - to render to
   */
  public Hud(int zindex) {
    this.zindex = zindex;
  }

  /**
   * Update the text of the HUD.
   * 
   * @param text - to show
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Render the text.
   */
  @Override
  public void render(Graphics2D graphics) {
    graphics.setColor(Color.WHITE);
    graphics.drawString(this.text, 0, OFFSET_Y);
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

  @Override
  public void update() {
    // We have to have this method because we are a renderable...
  }

}
