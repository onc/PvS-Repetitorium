package de.uulm.pvs.rep.solution.game.entities;

import de.uulm.pvs.rep.solution.game.engine.Renderable;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * TODO.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Entity implements Renderable {

  protected BufferedImage image;

  protected int zindex = 0;

  private Rectangle boundingBox;
  private Point position;

  /**
   * TODO.
   * 
   * @param position - {@link Point}
   * @param imagePath - {@link String}
   * @param size - {@link Dimension}
   */
  public Entity(Point position, String imagePath, Dimension size) {

    this.position = position;
    this.boundingBox = new Rectangle(position.x, position.y, size.width, size.height);

    this.image = loadImage(imagePath);
  }

  public Entity(Point position, String imagePath, Dimension size, int zindex) {
    this(position, imagePath, size);
    this.zindex = zindex;
  }

  /**
   * TODO documentation.
   * 
   * @param path - {@link String}
   * @return {@link BufferedImage}
   */
  private BufferedImage loadImage(String path) {

    ClassLoader classLoader = this.getClass().getClassLoader();
    String imagePath = classLoader.getResource(path).getPath();
    File file = new File(imagePath).getAbsoluteFile();

    try {
      return ImageIO.read(file);
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    return null;
  }

  public Point getPosition() {
    return this.position;
  }

  public Dimension getSize() {
    return this.boundingBox.getSize();
  }

  /**
   * TODO documentation.
   * 
   * @param dx - int
   * @param dy - int
   */
  protected void translate(int dx, int dy) {
    this.position.translate(dx, dy);
    this.boundingBox.setLocation(position);
  }

  /**
   * TODO documentation.
   * 
   * @param enity - {@link Entity}
   * @return - {@link Boolean}
   */
  public boolean intersects(Entity enity) {
    return this.boundingBox.intersects(enity.boundingBox);
  }

  @Override
  public void render(Graphics2D graphics) {
    graphics.drawImage(this.image, this.position.x, this.position.y, this.boundingBox.width,
        this.boundingBox.height, null);
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
