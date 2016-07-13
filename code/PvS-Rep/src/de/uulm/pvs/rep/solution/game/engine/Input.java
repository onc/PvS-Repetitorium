package de.uulm.pvs.rep.solution.game.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Input implements KeyListener {

  private static final int AMOUNT_OF_BUTTONS = Button.values().length;

  public boolean[] buttonsPressed = new boolean[AMOUNT_OF_BUTTONS];

  /**
   * TODO documentation.
   */
  public void clear() {

    for (int i = 0; i < buttonsPressed.length; i++) {
      buttonsPressed[i] = false;
    }
  }

  @Override
  public void keyTyped(KeyEvent event) {

    // do nothing...
  }

  @Override
  public void keyPressed(KeyEvent event) {

    switch (event.getKeyCode()) {
      case KeyEvent.VK_UP:
        buttonsPressed[Button.UP.ordinal()] = true;
        break;

      case KeyEvent.VK_DOWN:
        buttonsPressed[Button.DOWN.ordinal()] = true;
        break;

      case KeyEvent.VK_LEFT:
        buttonsPressed[Button.LEFT.ordinal()] = true;
        break;

      case KeyEvent.VK_RIGHT:
        buttonsPressed[Button.RIGHT.ordinal()] = true;
        break;

      case KeyEvent.VK_SPACE:
        buttonsPressed[Button.SPACE.ordinal()] = true;
        break;

      default:
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent event) {

    switch (event.getKeyCode()) {
      case KeyEvent.VK_UP:
        buttonsPressed[Button.UP.ordinal()] = false;
        break;

      case KeyEvent.VK_DOWN:
        buttonsPressed[Button.DOWN.ordinal()] = false;
        break;

      case KeyEvent.VK_LEFT:
        buttonsPressed[Button.LEFT.ordinal()] = false;
        break;

      case KeyEvent.VK_RIGHT:
        buttonsPressed[Button.RIGHT.ordinal()] = false;
        break;

      case KeyEvent.VK_SPACE:
        buttonsPressed[Button.SPACE.ordinal()] = false;
        break;

      default:
        break;
    }
  }
}
