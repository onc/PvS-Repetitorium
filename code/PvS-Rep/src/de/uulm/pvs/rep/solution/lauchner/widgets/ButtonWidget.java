package de.uulm.pvs.rep.solution.lauchner.widgets;

import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Widget for the buttons in the main-UI.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class ButtonWidget extends JPanel {

  private static final long serialVersionUID = 7155411780628369603L;

  private static final String START_BUTTON_CAPTION = "Spiel starten";
  private static final String IMPORT_SETTINGS_CAPTION = "Einstellungen importieren";
  private static final String EXPORT_SETTINGS_CAPTION = "Einstellungen exportieren";

  private JButton startGameButton;
  private JButton importSettingsButton;
  private JButton exportSettingsButton;

  /**
   * Creates a new {@link ButtonWidget}.
   */
  public ButtonWidget() {

    startGameButton = new JButton(START_BUTTON_CAPTION);
    importSettingsButton = new JButton(IMPORT_SETTINGS_CAPTION);
    exportSettingsButton = new JButton(EXPORT_SETTINGS_CAPTION);

    startGameButton.setActionCommand(ActionConstants.START_GAME);
    importSettingsButton.setActionCommand(ActionConstants.IMPORT_SETTINGS);
    exportSettingsButton.setActionCommand(ActionConstants.EXPORT_SETTINGS);

    this.setLayout(new FlowLayout());
    this.add(importSettingsButton);
    this.add(exportSettingsButton);
    this.add(startGameButton);
  }

  /**
   * Adds the given {@link ActionListener} to all Buttons in the Widget.
   * 
   * @param actionListener - listener to add
   */
  public void addActionListener(ActionListener actionListener) {
    this.startGameButton.addActionListener(actionListener);
    this.importSettingsButton.addActionListener(actionListener);
    this.exportSettingsButton.addActionListener(actionListener);
  }

}
