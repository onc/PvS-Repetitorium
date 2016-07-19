package de.uulm.pvs.rep.solution.lauchner.widgets;

import de.uulm.pvs.rep.solution.data.dto.GameDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;
import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

  private static final int SETTINGS_GRID_ROWS = 4;
  private static final int SETTINGS_GRID_COLS = 2;

  private static final int GAPS = 16;

  private static final String NAME_LABEL_CAPTION = "Name:";
  private static final String PRESET_LABEL_CAPTION = "Name:";
  private static final String OBSTACLE_AMOUNT_LABEL_CAPTION = "Anzahl Asteroiden:";
  private static final String MONSTER_AMOUNT_LABEL_CAPTION = "Anzahl Monster:";

  private JLabel nameLabel;
  private JTextField nameField;

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

    this.nameLabel = new JLabel(NAME_LABEL_CAPTION);
    this.nameField = new JTextField();

    this.presetLabel = new JLabel(PRESET_LABEL_CAPTION);
    this.presetComboBox = new JComboBox<>();
    this.presetComboBox.setActionCommand(ActionConstants.SELECT_PRESET);

    this.obstacleAmountLabel = new JLabel(OBSTACLE_AMOUNT_LABEL_CAPTION);
    this.obstacleAmountField = new JTextField();

    this.monsterAmountLabel = new JLabel(MONSTER_AMOUNT_LABEL_CAPTION);
    this.monsterAmountField = new JTextField();

    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(SETTINGS_GRID_ROWS, SETTINGS_GRID_COLS, GAPS, GAPS));

    leftPanel.add(nameLabel);
    leftPanel.add(nameField);

    leftPanel.add(presetLabel);
    leftPanel.add(presetComboBox);

    leftPanel.add(obstacleAmountLabel);
    leftPanel.add(obstacleAmountField);

    leftPanel.add(monsterAmountLabel);
    leftPanel.add(monsterAmountField);

    return leftPanel;
  }

  public void setNameField(String name) {
    this.nameField.setText(name);
  }

  public String getNameFieldText() {
    return nameField.getText();
  }

  /**
   * TODO documentation.
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
   * TODO documentation.
   * 
   * @param preset - preset to show
   */
  public void setPresetSettings(PresetDto preset) {

    this.obstacleAmountField.setText(String.valueOf(preset.getObstacleSpawnRate()));
    this.monsterAmountField.setText(String.valueOf(preset.getMonsterSpawnRate()));
  }

  /**
   * TODO documentation.
   * 
   * @param presets - to show
   */
  public void setPresetList(List<PresetDto> presets) {

    this.presetComboBox.removeAllItems();

    for (PresetDto presetDto : presets) {
      this.presetComboBox.addItem(presetDto.getName());
    }
  }

  public String getSelectedPresetName() {
    return this.presetComboBox.getSelectedItem().toString();
  }

  public void registerListener(ActionListener actionListener) {
    this.presetComboBox.addActionListener(actionListener);
  }

}
