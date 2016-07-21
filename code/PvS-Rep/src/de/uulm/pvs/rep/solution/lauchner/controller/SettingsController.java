package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.data.GameDao;
import de.uulm.pvs.rep.solution.data.PlayerDao;
import de.uulm.pvs.rep.solution.data.PresetDao;
import de.uulm.pvs.rep.solution.data.dto.GameDto;
import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
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
public class SettingsController implements ActionListener, GameStateChangedListener {

  private SettingsWidget settingsWidget;

  private GameDao gameDao = GameDao.getInstance();
  private PresetDao presetDao = PresetDao.getInstance();
  private PlayerDao playerDao = PlayerDao.getInstance();

  private GameSettingsChangeListener gameSettingsChangeListener;

  /**
   * Create a new {@link SettingsController}.
   */
  public SettingsController() {
    this.settingsWidget = new SettingsWidget();
    this.settingsWidget.registerListener(this);

    // update all components
    this.updateHighscoreList();
    this.updatePlayerList();
    this.updatePresetList();
  }

  /**
   * Register a {@link GameSettingsChangeListener} to notify the {@link GameController} of changes
   * made to the settings.
   * 
   * @param gameSettingsChangeListener - the listener
   */
  public void registerGameSettingsListener(GameSettingsChangeListener gameSettingsChangeListener) {
    this.gameSettingsChangeListener = gameSettingsChangeListener;
  }

  @Override
  public void actionPerformed(ActionEvent event) {

    switch (event.getActionCommand()) {

      case ActionConstants.SELECT_PRESET:
        System.out.println("[SettingsController] Select preset");
        String presetName = this.settingsWidget.getSelectedPresetName();
        System.out.println("[SettingsController] Select preset: " + presetName);
        // only update settings if a preset was selected
        if (!presetName.equals("")) {
          this.updatePresetSettings(presetName);
        }
        break;

      case ActionConstants.SELECT_PLAYER:
        String playerName = this.settingsWidget.getSelectedPlayerName();
        System.out.println("[SettingsController] Select player: " + playerName);
        // only update settings if a player was selected
        if (!playerName.equals("")) {
          this.updatePlayerSettings(playerName);
        }
        break;

      case ActionConstants.ADD_PLAYER:
        String newPlayerName = this.settingsWidget.getPlayerNameFieldText();
        System.out.println("[SettingsController] Add player: " + newPlayerName);
        this.addPlayer(newPlayerName);
        break;

      default:
        break;
    }
  }

  /**
   * Load all games from the database and update the HighscoreList in the {@link SettingsWidget}.
   */
  private void updateHighscoreList() {

    List<GameDto> games = gameDao.getGames();
    this.settingsWidget.setHighscoreList(games);
  }

  /**
   * Load all presets from the database and update the Preset-Dropdown in the
   * {@link SettingsWidget}.
   */
  private void updatePresetList() {

    List<PresetDto> presets = presetDao.getPresets();
    this.settingsWidget.setPresetList(presets);
  }

  /**
   * Load all players from the database and update the player-Dropdown in the
   * {@link SettingsWidget}.
   */
  private void updatePlayerList() {

    List<PlayerDto> players = playerDao.getPlayers();
    this.settingsWidget.setPlayersList(players);
  }

  /**
   * If a preset was selected, update the {@link SettingsWidget} and notify the
   * {@link GameController} via {@link GameSettingsChangeListener}.
   * 
   * @param presetName - preset to show
   */
  private void updatePresetSettings(String presetName) {

    PresetDto preset = this.presetDao.getPresetByName(presetName);
    // if the listener has been set
    if (gameSettingsChangeListener != null) {
      // update the ui
      this.settingsWidget.setPresetSettings(preset);
      // notify the GameController
      this.gameSettingsChangeListener.presetChanged(preset);
      // trigger update of the list
      this.updatePresetList();
    }
  }

  /**
   * If a player was selected, update the {@link SettingsWidget} and notify the
   * {@link GameController} via the {@link GameSettingsChangeListener}.
   * 
   * @param playerName - name of player to show
   */
  private void updatePlayerSettings(String playerName) {

    PlayerDto player = this.playerDao.getPlayerByName(playerName);
    // if the listener has been set
    if (gameSettingsChangeListener != null) {
      // update the ui
      this.settingsWidget.setPlayerName(player);
      // notify the GameController
      this.gameSettingsChangeListener.playerChanged(player);
      // trigger update of the list
      this.updatePlayerList();
    }
  }

  /**
   * Add a player to the database.
   * 
   * @param playerName - player for database
   */
  private void addPlayer(String playerName) {
    PlayerDto newPlayer = new PlayerDto(playerName);
    playerDao.addPlayer(newPlayer);
    this.updatePlayerList();
  }

  /**
   * Returns the widget of the settings.
   * 
   * @return the {@link JPanel} of the settings
   */
  public JPanel getSettingsWidget() {
    return settingsWidget;
  }

  /**
   * Update the HighscoreList, if a game has ended.
   */
  @Override
  public void gameFinished(GameDto game) {

    this.updateHighscoreList();
  }

}
