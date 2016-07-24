package de.uulm.pvs.rep.exercises.one.game.entities;

import de.uulm.pvs.rep.exercises.one.game.engine.Renderable;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Basic-class for all entities in the game.
 * 
 * @author Christian van Onzenoodt
 *
 */
public abstract class Entity implements Renderable {

  // image of the entity
  protected BufferedImage image;

  // z-index the entity is rendered in. Higher z-index values are in front of lower ones.
  protected int zindex = 0;

  // bounding-box of the entity. this is used to check for intersections with other entities.
  private Rectangle boundingBox;
  private Point position;

  /**
   * Creates an new {@link Entity}. In this case a z-index of 0 is used. If you can not see you
   * entity, you maybe should check, if you have to set this to a higher value.
   * 
   * @param position - point where the entity should spawn
   * @param imagePath - path to the image of the entity
   * @param size - size of the entity
   */
  public Entity(Point position, String imagePath, Dimension size) {

    this.position = position;
    this.boundingBox = new Rectangle(position.x, position.y, size.width, size.height);

    this.image = this.loadImage(imagePath);
  }

  /**
   * Creates an new {@link Entity}.
   * 
   * @param position - point where the entity should spawn
   * @param imagePath - path to the image of the entity
   * @param size - size of the entity
   * @param zindex - z-index for the entity
   */
  public Entity(Point position, String imagePath, Dimension size, int zindex) {
    this(position, imagePath, size);
    this.zindex = zindex;
  }

  /**
   * Loads an images from the given Path.
   * 
   * @param path - path of the image
   * @return loaded image
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
    return new Point(this.position);
  }

  /**
   * Get size of the entity.
   * 
   * @return size of the entity
   */
  public Dimension getSize() {
    return this.boundingBox.getSize();
  }

  /**
   * Move the entity. This also updates the boundingBox.
   * 
   * @param dx - amount of pixels to translate in the x-axis
   * @param dy - amount of pixels to translate in the y-axis
   */
  protected void translate(int dx, int dy) {
    this.position.translate(dx, dy);
    this.boundingBox.setLocation(position);
  }

  /**
   * Checks if this entity intersects the given entity.
   * 
   * @param enity - entity to check against.
   * @return true, if the entities intersects otherwise false.
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
