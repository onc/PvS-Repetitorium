package de.uulm.pvs.rep.solution.lauchner.widgets;

import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * TODO documentation.
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
   * TODO documentation.
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
   * TODO documentation.
   * 
   * @param actionListener - {@link ActionListener}
   */
  public void addActionListener(ActionListener actionListener) {
    this.startGameButton.addActionListener(actionListener);
    this.importSettingsButton.addActionListener(actionListener);
    this.exportSettingsButton.addActionListener(actionListener);
  }

}
