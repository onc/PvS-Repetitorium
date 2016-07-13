package de.uulm.pvs.rep.solution.game;

import de.uulm.pvs.rep.solution.game.engine.Button;
import de.uulm.pvs.rep.solution.game.engine.GameFinishedListener;
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

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * TODO documentation.
 * 
 * @author Christian van Onzenoodt
 *
 */
public class Game implements Runnable {

  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;

  private static final float DEFAULT_SPAWN_PROBABILITY = 0.99f;

  public static final Dimension WINDOW_SIZE = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

  private Renderer renderer;
  private Input input;

  private Player player;

  private Background background;
  private Hud hud;
  private ProjectileSpawner projectileSpawner;
  private EnemySpawner enemySpawner;
  private ObstacleSpawner obstacleSpawner;

  private GameFinishedListener gameFinishedListener;

  private volatile boolean isRunning = true;

  private volatile int points = 0;

  /**
   * TODO documentation.
   */
  public Game() {

    this.renderer = new Renderer(WINDOW_SIZE);
    this.input = new Input();

  }

  /**
   * TODO documentation.
   */
  private void initGame() {

    this.player = new Player(2, WINDOW_SIZE);
    this.projectileSpawner = new ProjectileSpawner(2, WINDOW_SIZE);
    this.enemySpawner = new EnemySpawner(2);
    this.obstacleSpawner = new ObstacleSpawner(1);
    this.background = new Background(0, WINDOW_SIZE);
    this.hud = new Hud(1);

    this.renderer.clear();
    this.input.clear();

    this.renderer.addRenderable(background);
    this.renderer.addRenderable(player);
    this.renderer.addRenderable(enemySpawner);
    this.renderer.addRenderable(projectileSpawner);
    this.renderer.addRenderable(hud);
    this.renderer.addRenderable(obstacleSpawner);

    this.points = 0;
    this.isRunning = true;
  }

  public Renderer getRenderer() {
    return this.renderer;
  }

  public void registerListener(JFrame frame) {
    frame.addKeyListener(input);
  }

  private long getTime() {
    return System.nanoTime();
  }

  public void addGameFinishedListener(GameFinishedListener gameFinishedListener) {
    this.gameFinishedListener = gameFinishedListener;
  }

  /**
   * TODO documentation.
   */
  @Override
  public void run() {

    initGame();

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
  }

  /**
   * TODO documentation.
   */
  private void update() {

    for (Asteroid asteroid : obstacleSpawner.getList()) {
      if (player.intersects(asteroid)) {
        System.out.println("lost");
        isRunning = false;
        gameFinishedListener.gameFinished(this.points);
      }
    }

    for (Enemy enemy : enemySpawner.getList()) {

      if (player.intersects(enemy)) {
        System.out.println("lost");
        isRunning = false;
        gameFinishedListener.gameFinished(this.points);
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

    if (input.buttonsPressed[Button.SPACE.ordinal()]) {
      projectileSpawner.spawnProjectile(playerPosition);
    }

    background.update();
    enemySpawner.update();
    projectileSpawner.update();
    obstacleSpawner.update();
    player.update(input.buttonsPressed);
  }

  /**
   * TODO documentation.
   */
  private void render() {
    renderer.render();
  }

}

