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

  private static final int AMOUNT_OF_BUTTONS = Buttons.values().length;

  public boolean[] buttonsPressed = new boolean[AMOUNT_OF_BUTTONS];
  public boolean pressedQ = false;

  @Override
  public void keyTyped(KeyEvent event) {

    // do nothing...
  }

  @Override
  public void keyPressed(KeyEvent event) {

    switch (event.getKeyCode()) {
      case KeyEvent.VK_UP:
        buttonsPressed[Buttons.UP.ordinal()] = true;
        break;

      case KeyEvent.VK_DOWN:
        buttonsPressed[Buttons.DOWN.ordinal()] = true;
        break;

      case KeyEvent.VK_LEFT:
        buttonsPressed[Buttons.LEFT.ordinal()] = true;
        break;

      case KeyEvent.VK_RIGHT:
        buttonsPressed[Buttons.RIGHT.ordinal()] = true;
        break;

      case KeyEvent.VK_SPACE:
        buttonsPressed[Buttons.SPACE.ordinal()] = true;
        break;

      case KeyEvent.VK_Q:
        pressedQ = true;
        break;

      default:
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent event) {

    switch (event.getKeyCode()) {
      case KeyEvent.VK_UP:
        buttonsPressed[Buttons.UP.ordinal()] = false;
        break;

      case KeyEvent.VK_DOWN:
        buttonsPressed[Buttons.DOWN.ordinal()] = false;
        break;

      case KeyEvent.VK_LEFT:
        buttonsPressed[Buttons.LEFT.ordinal()] = false;
        break;

      case KeyEvent.VK_RIGHT:
        buttonsPressed[Buttons.RIGHT.ordinal()] = false;
        break;

      case KeyEvent.VK_SPACE:
        buttonsPressed[Buttons.SPACE.ordinal()] = false;
        break;

      default:
        break;
    }
  }
}
