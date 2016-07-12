package de.uulm.pvs.rep.solution.game.entities.util;

import de.uulm.pvs.rep.solution.game.engine.Renderable;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class Hud implements Renderable {

  private int zindex = 0;

  private final int offsetY = 10;
  private String text = "";

  public Hud(int zindex) {
    this.zindex = zindex;
  }

  public void update(String text) {
    this.text = text;
  }

  @Override
  public void render(Graphics2D graphics) {
    graphics.setColor(Color.WHITE);
    graphics.drawString(this.text, 0, offsetY);
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
