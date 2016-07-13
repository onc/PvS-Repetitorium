package de.uulm.pvs.rep.solution.lauchner;

import de.uulm.pvs.rep.solution.lauchner.controller.GameController;
import de.uulm.pvs.rep.solution.lauchner.controller.SettingsController;
import de.uulm.pvs.rep.solution.lauchner.widgets.ButtonWidget;
import de.uulm.pvs.rep.solution.lauchner.widgets.SettingsWidget;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Launcher extends JFrame {

  private static final long serialVersionUID = 2044232945734099409L;
  private static final String WINDOW_TITLE = "Game";
  private static final Dimension WINDOW_SIZE = new Dimension(800, 600);

  private GameController gameController;
  private SettingsController settingsController;

  private ButtonWidget buttonWidget;
  private SettingsWidget settingsWidget;

  /**
   * TODO documentation.
   */
  public Launcher() {

    gameController = new GameController();
    settingsController = new SettingsController();
  }

  /**
   * TODO documentation.
   */
  public void initGui() {

    this.buttonWidget = new ButtonWidget();
    this.buttonWidget.addActionListener(gameController);
    this.buttonWidget.addActionListener(settingsController);

    this.settingsWidget = new SettingsWidget();

    this.setLayout(new BorderLayout());

    this.add(buttonWidget, BorderLayout.SOUTH);
    this.add(settingsWidget, BorderLayout.CENTER);

    this.setTitle(WINDOW_TITLE);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setPreferredSize(WINDOW_SIZE);
    this.pack();
    this.setVisible(true);
  }

  /**
   * TODO documentation.
   */
  public static void main(String[] args) {

    Launcher launcher = new Launcher();

    SwingUtilities.invokeLater(() -> {
      launcher.initGui();
    });

  }
}
