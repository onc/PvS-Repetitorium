package de.uulm.pvs.rep.exercises.one.game.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class which checks for pressed keys. <br>
 * We want to be able to press and hold a key like UP or DOWN and get continues movement. Therefore
 * we have to register an {@link KeyListener} which checks for presses and releases and updates an
 * array of booleans for all keys.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Input implements KeyListener {

  // get the length of the button-enum
  private static final int AMOUNT_OF_BUTTONS = Button.values().length;

  // create an array for the buttons
  public boolean[] buttonsPressed = new boolean[AMOUNT_OF_BUTTONS];

  /**
   * Set all booleans to false, which marks all buttons as 'not-pressed'.
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

    // TODO: je nach gedruecktem Button, setze die entsprechende Stelle im
    // buttonsPressed-Array auf true. Tip: Schaue dir die API zu enums an.
  }

  @Override
  public void keyReleased(KeyEvent event) {

    // TODO: je nach gedruecktem Button, setze die entsprechende Stelle im
    // buttonsPressed-Array auf false. Tip: Schaue dir die API zu enums an.
  }
}
