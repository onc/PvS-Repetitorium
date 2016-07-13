package de.uulm.pvs.rep.solution.lauchner.widgets;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class SettingsWidget extends JPanel {

  private static final long serialVersionUID = -3171533741313570963L;

  private static final int MAIN_GRIP_ROWS = 1;
  private static final int MAIN_GRIP_COLS = 2;

  private static final int SETTINGS_GRID_ROWS = 3;
  private static final int SETTINGS_GRID_COLS = 2;

  private static final int GAPS = 16;

  private static final String NAME_LABEL_CAPTION = "Name:";
  private static final String OBSTACLE_AMOUNT_LABEL_CAPTION = "Anzahl Asteroiden:";
  private static final String MONSTER_AMOUNT_LABEL_CAPTION = "Anzahl Monster:";

  private JLabel nameLabel;
  private JTextField nameField;

  private JLabel obstacleAmountLabel;
  private JTextField obstacleAmountField;

  private JLabel monsterAmountLabel;
  private JTextField monsterAmountField;

  private HighscoreList highscoreList;

  /**
   * TODO documentation.
   */
  public SettingsWidget() {

    this.highscoreList = new HighscoreList();
    JPanel leftPanel = this.buildLeftPanel();

    this.setLayout(new GridLayout(MAIN_GRIP_ROWS, MAIN_GRIP_COLS, GAPS, GAPS));

    this.add(leftPanel);
    this.add(highscoreList);
  }

  private JPanel buildLeftPanel() {

    this.nameLabel = new JLabel(NAME_LABEL_CAPTION);
    this.nameField = new JTextField();

    this.obstacleAmountLabel = new JLabel(OBSTACLE_AMOUNT_LABEL_CAPTION);
    this.obstacleAmountField = new JTextField();

    this.monsterAmountLabel = new JLabel(MONSTER_AMOUNT_LABEL_CAPTION);
    this.monsterAmountField = new JTextField();

    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(SETTINGS_GRID_ROWS, SETTINGS_GRID_COLS, GAPS, GAPS));

    leftPanel.add(nameLabel);
    leftPanel.add(nameField);

    leftPanel.add(obstacleAmountLabel);
    leftPanel.add(obstacleAmountField);

    leftPanel.add(monsterAmountLabel);
    leftPanel.add(monsterAmountField);

    return leftPanel;
  }
}
