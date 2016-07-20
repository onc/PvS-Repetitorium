package de.uulm.pvs.rep.solution.lauchner;

import de.uulm.pvs.rep.solution.data.PlayerDao;
import de.uulm.pvs.rep.solution.lauchner.controller.GameController;
import de.uulm.pvs.rep.solution.lauchner.controller.SettingsController;
import de.uulm.pvs.rep.solution.lauchner.widgets.ButtonWidget;
import de.uulm.pvs.rep.solution.lauchner.widgets.SettingsWidget;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Launcher for the game. This is the main class and frame for the application.
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

  /**
   * Create a new {@link Launcher} by creating the needed controllers.
   */
  public Launcher() {

    gameController = new GameController();
    settingsController = new SettingsController();

    settingsController.registerGameSettingsListener(gameController);
    gameController.registerGameStateChangedListener(settingsController);
  }

  /**
   * Initializes the UI with the {@link ButtonWidget} and {@link SettingsWidget}, packs everything
   * together and shows the Frame.
   */
  public void initGui() {

    this.setLayout(new BorderLayout());

    this.add(gameController.getButtonWidget(), BorderLayout.SOUTH);
    this.add(settingsController.getSettingsWidget(), BorderLayout.CENTER);

    this.setTitle(WINDOW_TITLE);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setPreferredSize(WINDOW_SIZE);
    this.pack();
    this.setVisible(true);
  }

  /**
   * Main-Method.
   */
  public static void main(String[] args) {

    PlayerDao.getInstance().resetDb();

    // create a launcher
    Launcher launcher = new Launcher();

    // initialize the ui in the swing-thread
    SwingUtilities.invokeLater(() -> {
      launcher.initGui();
    });

  }
}
