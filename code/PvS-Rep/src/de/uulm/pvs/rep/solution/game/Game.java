package de.uulm.pvs.rep.solution.game;

import de.uulm.pvs.rep.solution.game.engine.Buttons;
import de.uulm.pvs.rep.solution.game.engine.Input;
import de.uulm.pvs.rep.solution.game.engine.Renderer;
import de.uulm.pvs.rep.solution.game.entities.enemies.Enemy;
import de.uulm.pvs.rep.solution.game.entities.enemies.EnemySpawner;
import de.uulm.pvs.rep.solution.game.entities.obstacles.Asteroid;
import de.uulm.pvs.rep.solution.game.entities.obstacles.ObstacleSpawner;
import de.uulm.pvs.rep.solution.game.entities.players.Player;
import de.uulm.pvs.rep.solution.game.entities.projectiles.Projectile;
import de.uulm.pvs.rep.solution.game.entities.projectiles.ProjectileSpawner;
import de.uulm.pvs.rep.solution.game.entities.util.Background;
import de.uulm.pvs.rep.solution.game.entities.util.Hud;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Game {

  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;

  private static final float DEFAULT_SPAWN_PROBABILITY = 0.99f;

  public static final Dimension WINDOW_SIZE = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

  // private JFrame frame = new JFrame("Test");
  private Renderer renderer = new Renderer(WINDOW_SIZE);
  private Input input = new Input();

  private Player player = new Player(2, WINDOW_SIZE);

  private Background background = new Background(0, WINDOW_SIZE);
  private Hud hud = new Hud(1);
  private ProjectileSpawner projectileSpawner = new ProjectileSpawner(2, WINDOW_SIZE);
  private EnemySpawner enemySpawner = new EnemySpawner(2);
  private ObstacleSpawner obstacleSpawner = new ObstacleSpawner(1);

  volatile boolean isRunning = true;

  volatile int points = 0;

  /**
   * TODO documentation.
   */
  public Game() {

    this.renderer.addRenderable(background);
    this.renderer.addRenderable(player);
    this.renderer.addRenderable(enemySpawner);
    this.renderer.addRenderable(projectileSpawner);
    this.renderer.addRenderable(hud);
    this.renderer.addRenderable(obstacleSpawner);
  }

  public Renderer getRenderer() {
    return this.renderer;
  }

  public void registerListener(JFrame frame) {
    frame.addKeyListener(input);
  }

  public long getTime() {
    return System.nanoTime();
  }

  /**
   * TODO documentation.
   */
  public void start() {

    Thread th = new Thread(() -> {

      final int oneSecond = 1000 * 1000 * 1000;

      final int maxRenderHz = 120;
      final int updateHz = 120;

      // time for rendering one frame in milliseconds (16ms)
      final long frameTime = oneSecond / maxRenderHz;
      // time for one update in milliseconds (8ms)
      final long updateTime = oneSecond / updateHz;

      long fpsTime = getTime() + oneSecond;

      long now = 0;
      int frames = 0;
      int ticks = 0;

      long nextFrame = getTime() + frameTime;
      long nextUpdate = getTime() + updateTime;

      while (isRunning) {

        now = getTime();

        // rerender
        if (now > nextFrame) {
          this.render();
          frames++;
          nextFrame = getTime() + frameTime;
        }

        // update game logic
        if (now > nextUpdate) {
          this.update();
          ticks++;
          nextUpdate = getTime() + updateTime;
        }

        // debug every second
        if (now > fpsTime) {
          final String text = String.format(
              "fps: %d | ticks: %d | #projectiles: %d | #enemies: %d | #asteroids: %d | points: %d",
              frames, ticks, projectileSpawner.getProjectileCount(), enemySpawner.getEnemyCount(),
              obstacleSpawner.getAsteroidCound(), points);
          frames = 0;
          ticks = 0;
          fpsTime = getTime() + oneSecond;
          hud.update(text);
        }
      }
    });

    th.run();
  }

  /**
   * TODO documentation.
   */
  private void update() {

    background.update();
    enemySpawner.update();
    projectileSpawner.update();
    obstacleSpawner.update();

    if (input.pressedQ) {
      isRunning = false;
    }

    for (Asteroid asteroid : obstacleSpawner.getList()) {
      if (player.intersects(asteroid)) {
        System.out.println("lost");
        // isRunning = false;
      }
    }

    for (Enemy enemy : enemySpawner.getList()) {

      if (player.intersects(enemy)) {
        System.out.println("lost");
        // isRunning = false;
      }

      for (Projectile projectile : projectileSpawner.getList()) {

        if (projectile.intersects(enemy)) {
          projectileSpawner.removeProjectile(projectile);
          enemySpawner.removeEnemy(enemy);
          points++;
        }
      }
    }

    Point playerPosition = player.getPosition();
    if (Math.random() > DEFAULT_SPAWN_PROBABILITY) {
      enemySpawner.spawnEnemy(new Point(WINDOW_SIZE.width, playerPosition.y));
      obstacleSpawner.spawnAsteroid((int) (WINDOW_SIZE.width * Math.random()));
    }

    if (input.buttonsPressed[Buttons.SPACE.ordinal()]) {
      projectileSpawner.spawnProjectile(new Point(playerPosition));
    }

    if (input.buttonsPressed[Buttons.UP.ordinal()]) {
      player.move(Buttons.UP);
    }

    if (input.buttonsPressed[Buttons.DOWN.ordinal()]) {
      player.move(Buttons.DOWN);
    }

    if (input.buttonsPressed[Buttons.RIGHT.ordinal()]) {
      player.move(Buttons.RIGHT);
    }

    if (input.buttonsPressed[Buttons.LEFT.ordinal()]) {
      player.move(Buttons.LEFT);
    }
  }

  /**
   * TODO documentation.
   */
  void render() {
    renderer.render();
  }

  /**
   * TODO documentation.
   * 
   * @param args - String[]
   */
  public static void main(String[] args) {

    Game game = new Game();

    SwingUtilities.invokeLater(() -> {

      JFrame frame = new JFrame("BLA");
      frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
      frame.setPreferredSize(Game.WINDOW_SIZE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // frame.setUndecorated(true);

      game.registerListener(frame);

      frame.add(game.getRenderer(), BorderLayout.CENTER);
      frame.pack();

      frame.setVisible(true);
    });

    game.start();

  }

}

