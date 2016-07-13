package de.uulm.pvs.rep.solution.lauchner.widgets;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class HighscoreList extends JPanel {

  private static final long serialVersionUID = 995435032677137346L;

  private static final String HIGHSCORE_LABEL_CAPTION = "Highscores";

  private JList<String> highscoreList;
  private JLabel highsoreLabel;

  /**
   * TODO documentation.
   */
  public HighscoreList() {

    this.highsoreLabel = new JLabel(HIGHSCORE_LABEL_CAPTION);
    this.highscoreList = new JList<>();

    this.setLayout(new BorderLayout());

    this.add(highsoreLabel, BorderLayout.NORTH);
    this.add(highscoreList, BorderLayout.CENTER);
  }

  public void updateList(List<String> highscores) {

    this.highscoreList.setListData(new Vector<>(highscores));
  }
}
