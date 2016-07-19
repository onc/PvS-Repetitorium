package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.data.GameDao;
import de.uulm.pvs.rep.solution.data.PresetDao;
import de.uulm.pvs.rep.solution.data.dto.GameDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;
import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;
import de.uulm.pvs.rep.solution.lauchner.widgets.SettingsWidget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

/**
 * Controller for the settings.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class SettingsController implements ActionListener {

  private SettingsWidget settingsWidget;
  private GameDao gameDao = GameDao.getInstance();
  private PresetDao presetDao = PresetDao.getInstance();

  /**
   * TODO documentation.
   */
  public SettingsController() {
    this.settingsWidget = new SettingsWidget();
    this.settingsWidget.registerListener(this);

    this.updateUi();
  }

  // FIXME: implement
  @Override
  public void actionPerformed(ActionEvent event) {

    switch (event.getActionCommand()) {
      case ActionConstants.IMPORT_SETTINGS:
        System.out.println("[SettingsController] Import");
        break;

      case ActionConstants.EXPORT_SETTINGS:
        System.out.println("[SettingsController] Export");
        break;

      case ActionConstants.SELECT_PRESET:
        System.out.println("[SettingsController] Select preset");
        String presetName = this.settingsWidget.getSelectedPresetName();
        this.updatePresetSettings(presetName);
        break;

      default:
        break;
    }
  }

  /**
   * TODO documentation.
   */
  public void updateUi() {

    List<GameDto> games = gameDao.getGames();
    this.settingsWidget.setHighscoreList(games);

    List<PresetDto> presets = presetDao.getPresets();
    this.settingsWidget.setPresetList(presets);
  }

  private void updatePresetSettings(String presetName) {

    PresetDto preset = this.presetDao.getPresetByName(presetName);
    this.settingsWidget.setPresetSettings(preset);
  }

  /**
   * TODO documentation.
   * 
   * @return - the name of the user
   */
  public String getUsername() {

    return "";
  }

  public JPanel getSettingsWidget() {
    return settingsWidget;
  }

}
