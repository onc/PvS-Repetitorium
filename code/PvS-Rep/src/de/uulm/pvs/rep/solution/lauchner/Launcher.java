package de.uulm.pvs.rep.solution.lauchner;

import de.uulm.pvs.rep.solution.data.PlayerDao;
import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
import de.uulm.pvs.rep.solution.lauchner.controller.GameController;
import de.uulm.pvs.rep.solution.lauchner.controller.SettingsController;
import de.uulm.pvs.rep.solution.lauchner.widgets.ButtonWidget;
import de.uulm.pvs.rep.solution.lauchner.widgets.SettingsWidget;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

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

  private ButtonWidget buttonWidget;
  private SettingsWidget settingsWidget;

  /**
   * Create a new {@link Launcher} by creating the needed controllers.
   */
  public Launcher() {

    gameController = new GameController();
    settingsController = new SettingsController();
  }

  /**
   * Initializes the UI with the {@link ButtonWidget} and {@link SettingsWidget}, packs everything
   * together and shows the Frame.
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
   * Main-Method.
   */
  public static void main(String[] args) {

    PlayerDao.getInstance().resetDb();

    List<PlayerDto> players = PlayerDao.getInstance().getPlayers();

    for (PlayerDto playerDto : players) {
      System.out.println(playerDto);
    }

    PlayerDto newPlayer = new PlayerDto("Horschde");
    System.out.println("=================");
    newPlayer = PlayerDao.getInstance().savePlayer(newPlayer);
    System.out.println(newPlayer);
    System.out.println("=================");

    players = PlayerDao.getInstance().getPlayers();

    for (PlayerDto playerDto : players) {
      System.out.println(playerDto);
    }

    System.out.println("=================");
    newPlayer.setName("bernde");
    PlayerDao.getInstance().updatePlayer(newPlayer);
    players = PlayerDao.getInstance().getPlayers();

    for (PlayerDto playerDto : players) {
      System.out.println(playerDto);
    }

    // create a launcher
    // Launcher launcher = new Launcher();

    // initialize the ui in the swing-thread
    // SwingUtilities.invokeLater(() -> {
    // launcher.initGui();
    // });

  }
}
