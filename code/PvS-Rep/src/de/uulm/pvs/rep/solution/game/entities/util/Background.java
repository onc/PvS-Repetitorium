package de.uulm.pvs.rep.solution.game.entities.util;

import de.uulm.pvs.rep.solution.game.engine.Renderable;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Renderable for the background.
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
   * Creates an new Background with the given size and z-index. Uses an default for the
   * background-image.
   * 
   * @param zindex - z-index where the background should be rendered
   * @param windowSize - size of the background, usually the size of the window
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
   * Updates the background-logic. In this case we only increment a counter until it reaches the
   * half size of the window. If this value is reached, reset the counter to zero. <br>
   * Our background is made of an image which is duplicated along the x-axis. initially we only see
   * the left part of the image. now we are moving it until the right part is visible, moving it
   * back to the initial position and so on.
   */
  public void update() {

    itt++;

    if (itt >= imageWidth / 2) {
      itt = 0;
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    //
    // (if this part is odd formatted after auto-formatting the file, please revert the change and
    // go to: window -> preferences -> java -> code style -> formatter -> edit -> off/on tags
    // and enable tags.
    //
    // draw only the part of the image, which should be shown
    //
    // initial setup:
    //
    // @formatter:off 
    //
    //         Hidden part
    //            v
    // |-------|///////
    // |       |///////
    // |       |///////
    // |-------|///////
    //    ^
    //  Window/visible part of the image
    //
    // setup before reset: 
    //
    // @formatter:off 
    //
    //        Window/visible part of the image
    //            v
    // ///////|-------|
    // ///////|       |
    // ///////|       |
    // ///////|-------|
    //    ^
    //  Hidden part
    //
    // @formatter:on 
    graphics.drawImage(backgroundImage, 0, 0, this.windowSize.width, this.windowSize.height, itt, 0,
        imageWidth / 2 + itt, imageHeight, null);
  }

  @Override
  public int getZindex() {
    return this.zindex;
  }

}
