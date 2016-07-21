package de.uulm.pvs.rep.solution.lauchner.widgets;

import de.uulm.pvs.rep.solution.data.dto.GameDto;
import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;
import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Widget for the settings like username, amount of monsters and obstacles etc.
 *
 * @author Christian van Onzenoodt
 *
 */
public class SettingsWidget extends JPanel {

  private static final long serialVersionUID = -3171533741313570963L;

  private static final int MAIN_GRIP_ROWS = 1;
  private static final int MAIN_GRIP_COLS = 2;

  private static final int SETTINGS_GRID_ROWS = 5;
  private static final int SETTINGS_GRID_COLS = 2;

  private static final int GAPS = 16;

  private static final String SELECTED_PLAYER_LABEL_CAPTION = "Player:";
  private static final String ADD_PLAYER_BUTTON_CAPTION = "Add Player";
  private static final String PRESET_LABEL_CAPTION = "Name:";
  private static final String OBSTACLE_AMOUNT_LABEL_CAPTION = "Anzahl Asteroiden:";
  private static final String MONSTER_AMOUNT_LABEL_CAPTION = "Anzahl Monster:";

  private JTextField playerNameField;
  private JButton addPlayerButton;

  private JLabel selectedPlayerLabel;
  private JComboBox<String> playersComboBox;

  private JLabel presetLabel;
  private JComboBox<String> presetComboBox;

  private JLabel obstacleAmountLabel;
  private JTextField obstacleAmountField;

  private JLabel monsterAmountLabel;
  private JTextField monsterAmountField;

  private HighscoreList highscoreList;

  /**
   * Create a new {@link SettingsWidget}.
   */
  public SettingsWidget() {

    this.highscoreList = new HighscoreList();
    JPanel leftPanel = this.buildLeftPanel();

    this.setLayout(new GridLayout(MAIN_GRIP_ROWS, MAIN_GRIP_COLS, GAPS, GAPS));

    this.add(leftPanel);
    this.add(highscoreList);
  }

  /**
   * Builds the panel on the left with username, monster and obstacle-settings.
   * 
   * @return - panel with all elements.
   */
  private JPanel buildLeftPanel() {

    this.playerNameField = new JTextField();
    this.addPlayerButton = new JButton(ADD_PLAYER_BUTTON_CAPTION);
    this.addPlayerButton.setActionCommand(ActionConstants.ADD_PLAYER);

    this.selectedPlayerLabel = new JLabel(SELECTED_PLAYER_LABEL_CAPTION);
    this.playersComboBox = new JComboBox<>();
    this.playersComboBox.setActionCommand(ActionConstants.SELECT_PLAYER);

    this.presetLabel = new JLabel(PRESET_LABEL_CAPTION);
    this.presetComboBox = new JComboBox<>();
    this.presetComboBox.setActionCommand(ActionConstants.SELECT_PRESET);

    this.obstacleAmountLabel = new JLabel(OBSTACLE_AMOUNT_LABEL_CAPTION);
    this.obstacleAmountField = new JTextField();

    this.monsterAmountLabel = new JLabel(MONSTER_AMOUNT_LABEL_CAPTION);
    this.monsterAmountField = new JTextField();

    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(SETTINGS_GRID_ROWS, SETTINGS_GRID_COLS, GAPS, GAPS));

    leftPanel.add(playerNameField);
    leftPanel.add(addPlayerButton);

    leftPanel.add(selectedPlayerLabel);
    leftPanel.add(playersComboBox);

    leftPanel.add(presetLabel);
    leftPanel.add(presetComboBox);

    leftPanel.add(obstacleAmountLabel);
    leftPanel.add(obstacleAmountField);

    leftPanel.add(monsterAmountLabel);
    leftPanel.add(monsterAmountField);

    return leftPanel;
  }

  public void setNameField(String name) {
    this.playerNameField.setText(name);
  }

  public String getPlayerNameFieldText() {
    return playerNameField.getText();
  }

  /**
   * Updates the HigscoreList with the given games.
   * 
   * @param games - games to show
   */
  public void setHighscoreList(List<GameDto> games) {

    Collections.sort(games);
    List<String> gamesString = new ArrayList<>();

    for (GameDto game : games) {
      gamesString.add(game.getPlayerDto().getName() + "   " + game.getScore());
    }

    this.highscoreList.updateList(gamesString);
  }

  /**
   * Update the preset {@link JTextField}s with the given preset.
   * 
   * @param preset - preset to show
   */
  public void setPresetSettings(PresetDto preset) {

    this.obstacleAmountField.setText(String.valueOf(preset.getObstacleSpawnRate()));
    this.monsterAmountField.setText(String.valueOf(preset.getMonsterSpawnRate()));
  }

  /**
   * Sets the name of the current player in the {@link JTextField} for the PlayerName.
   * 
   * @param player - player to show
   */
  public void setPlayerName(PlayerDto player) {
    this.playerNameField.setText(player.getName());
  }

  /**
   * Update the preset-Dropdown with with given presets.
   * 
   * @param presets - to show
   */
  public void setPresetList(List<PresetDto> presets) {

    this.presetComboBox.removeAllItems();

    for (PresetDto preset : presets) {
      this.presetComboBox.addItem(preset.getName());
    }
  }

  /**
   * Update the players-Dropdown with the given players.
   * 
   * @param players - to show
   */
  public void setPlayersList(List<PlayerDto> players) {

    this.playersComboBox.removeAllItems();

    for (PlayerDto player : players) {
      this.playersComboBox.addItem(player.getName());
    }
  }

  /**
   * Returns the name of the currently selected preset.
   * 
   * @return - name of the preset or an empty {@link String}, if no preset is selected
   */
  public String getSelectedPresetName() {
    // there is no item selected -> return an empty string to prevent nullpointer on toString()
    if (this.presetComboBox.getSelectedIndex() == -1) {
      return "";
    }
    return this.presetComboBox.getSelectedItem().toString();
  }

  /**
   * Returns the name of the currently selected player.
   * 
   * @return - the name or an empty {@link String}, if no player is selected.
   */
  public String getSelectedPlayerName() {
    if (this.playersComboBox.getSelectedIndex() == -1) {
      return "";
    }
    return this.playersComboBox.getSelectedItem().toString();
  }

  /**
   * Registers the {@link ActionListener} to all {@link JButton} and {@link JComboBox}.
   * 
   * @param actionListener - listener for elements in the component
   */
  public void registerListener(ActionListener actionListener) {
    this.presetComboBox.addActionListener(actionListener);
    this.addPlayerButton.addActionListener(actionListener);
    this.playersComboBox.addActionListener(actionListener);
  }

}
