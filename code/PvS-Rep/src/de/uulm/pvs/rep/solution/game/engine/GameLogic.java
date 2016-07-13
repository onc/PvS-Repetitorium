package de.uulm.pvs.rep.solution.game.engine;

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

/**
 * TODO documentation.
 *
 * @author Christian van Onzenoodt
 *
 */
public class GameLogic {

  private static final float DEFAULT_SPAWN_PROBABILITY = 0.99f;

  private Background background;
  private Hud hud;
  private ProjectileSpawner projectileSpawner;
  private EnemySpawner enemySpawner;
  private ObstacleSpawner obstacleSpawner;

  private Player player;

  private Renderer renderer;
  private Input input;
  private Dimension windowSize;

  private boolean isRunning = false;
  private int points = 0;
  private String hudText = "";

  /**
   * TODO documentation.
   * 
   * @param renderer - {@link Renderer}
   * @param input - {@link Input}
   * @param windowSize - {@link Dimension}
   */
  public GameLogic(Renderer renderer, Input input, Dimension windowSize) {
    this.renderer = renderer;
    this.input = input;
    this.windowSize = windowSize;
  }

  /**
   * TODO documentation.
   */
  public void initGame() {

    this.player = new Player(2, this.windowSize);
    this.projectileSpawner = new ProjectileSpawner(2, this.windowSize);
    this.enemySpawner = new EnemySpawner(2);
    this.obstacleSpawner = new ObstacleSpawner(1);
    this.background = new Background(0, this.windowSize);
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

  public boolean isRunning() {
    return this.isRunning;
  }

  public int getPoints() {
    return this.points;
  }

  /**
   * TODO documentation.
   */
  public void render() {
    renderer.render();
  }

  /**
   * TODO documentation.
   */
  public void update() {

    for (Asteroid asteroid : obstacleSpawner.getList()) {
      if (player.intersects(asteroid)) {
        System.out.println("lost");
        isRunning = false;
      }
    }

    for (Enemy enemy : enemySpawner.getList()) {

      if (player.intersects(enemy)) {
        System.out.println("lost");
        isRunning = false;
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
      enemySpawner.spawnEnemy(new Point(this.windowSize.width, playerPosition.y));
      obstacleSpawner.spawnAsteroid((int) (this.windowSize.width * Math.random()));
    }

    if (input.buttonsPressed[Button.SPACE.ordinal()]) {
      projectileSpawner.spawnProjectile(playerPosition);
    }

    this.hudText = String.format("#projectiles: %d | #enemies: %d | #asteroids: %d | points: %d",
        projectileSpawner.getProjectileCount(), enemySpawner.getEnemyCount(),
        obstacleSpawner.getAsteroidCound(), points);

    hud.update(hudText);
    background.update();
    enemySpawner.update();
    projectileSpawner.update();
    obstacleSpawner.update();
    player.update(input.buttonsPressed);
  }
}
