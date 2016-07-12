package de.uulm.pvs.rep.solution.game.entities.util;

import de.uulm.pvs.rep.solution.game.engine.Renderable;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Background implements Renderable {

  private static final String BACKGROUND_IMAGE_PATH =
      "de/uulm/pvs/rep/solution/resources/background.png";

  private BufferedImage backgroundImage;
  private Dimension windowSize;

  private int imageWidth;
  private int imageHeight;

  private int zindex;

  private int itt = 0;

  /**
   * TODO documentation.
   * 
   * @param zindex - int
   * @param windowSize - {@link Dimension}
   */
  public Background(int zindex, Dimension windowSize) {

    this.zindex = zindex;
    this.windowSize = windowSize;

    ClassLoader classLoader = getClass().getClassLoader();
    String backgroundPath = classLoader.getResource(BACKGROUND_IMAGE_PATH).getPath();
    File background = new File(backgroundPath).getAbsoluteFile();

    try {
      backgroundImage = ImageIO.read(background);

      imageWidth = backgroundImage.getWidth();
      imageHeight = backgroundImage.getHeight();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * TODO documentation.
   */
  public void update() {

    itt++;

    if (itt >= imageWidth / 2) {
      itt = 0;
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    graphics.drawImage(backgroundImage, 0, 0, this.windowSize.width, this.windowSize.height, itt, 0,
        imageWidth / 2 + itt, imageHeight, null);
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
