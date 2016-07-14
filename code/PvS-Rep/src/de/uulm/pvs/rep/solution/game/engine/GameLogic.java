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
import de.uulm.pvs.rep.solution.game.entities.util.Spawner;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

/**
 * The main game logic. This class contains methods for triggering a re-render, update the
 * game-logic and getting the points a player got.
 *
 * @author Christian van Onzenoodt
 *
 */
public class GameLogic {

  // Default probability for spawning an asteroid and monster per round
  private static final float DEFAULT_SPAWN_PROBABILITY = 0.99f;

  // Renderable entities
  private Background background;
  private Hud hud;

  private Spawner<Projectile> projectileSpawner;
  private Spawner<Enemy> enemySpawner;
  private Spawner<Asteroid> obstacleSpawner;

  private Player player;

  private Renderer renderer;
  private Input input;
  private Dimension windowSize;

  // initialize state variables
  private boolean isRunning = false;
  private int points = 0;
  private String hudText = "";

  /**
   * Creates a new GameLogic instance.
   * 
   * @param renderer - Renderer to draw to
   * @param input - Input which checks for pressed buttons
   * @param windowSize - Size of the window to render to
   */
  public GameLogic(Renderer renderer, Input input, Dimension windowSize) {
    this.renderer = renderer;
    this.input = input;
    this.windowSize = windowSize;
  }

  /**
   * Initialize the game.
   */
  public void initGame() {

    // create the renderables
    this.player = new Player(2, this.windowSize);
    this.projectileSpawner = new ProjectileSpawner(2, this.windowSize);
    this.enemySpawner = new EnemySpawner(2, this.windowSize);
    this.obstacleSpawner = new ObstacleSpawner(1, this.windowSize);
    this.background = new Background(0, this.windowSize);
    this.hud = new Hud(1);

    // clear the renderer (remove all 'old' rendererables)
    this.renderer.clear();
    // clear the input in case some of the pressed buttons is still marked as triggered
    this.input.clear();

    // add the rendererable to the renderer
    this.renderer.addRenderable(background);
    this.renderer.addRenderable(player);
    this.renderer.addRenderable(enemySpawner);
    this.renderer.addRenderable(projectileSpawner);
    this.renderer.addRenderable(hud);
    this.renderer.addRenderable(obstacleSpawner);

    // initialize points and set game as 'running'
    this.points = 0;
    this.isRunning = true;
  }

  /**
   * Checks, if the game is still running.
   * 
   * @return true, if the game is still running, otherwise false
   */
  public boolean isRunning() {
    return this.isRunning;
  }

  /**
   * Returns the points a player got.
   * 
   * @return the points a player got.
   */
  public int getPoints() {
    return this.points;
  }

  /**
   * Triggers rerender on the {@link Renderer}.
   */
  public void render() {
    renderer.render();
  }

  /**
   * Updates the gamelogic.
   */
  public void update() {

    // get 'needed' stuff, so the code is more readable
    Point playerPosition = player.getPosition();

    List<Projectile> projectiles = projectileSpawner.getList();
    List<Asteroid> asteroids = obstacleSpawner.getList();
    List<Enemy> enemies = enemySpawner.getList();

    // if the player intersects an asteroid, game is lost
    if (this.intersectsAsteroid(player, asteroids)) {
      this.setGameLost();
    }

    // if the player intersects an enemy, game is lost
    if (this.intersectsEnemy(player, enemies)) {
      this.setGameLost();
    }

    // check if there is a enemy <-> projectile intersection
    this.checkProjectiles(enemies, projectiles);

    // spawn new stuff
    this.spawn();

    // if space is pressed, spawnProjectile. spawn-rate is handled by the spawner.
    if (input.buttonsPressed[Button.SPACE.ordinal()]) {
      projectileSpawner.spawn(playerPosition);
    }

    // 'build' the text for the hud
    this.hudText = String.format("#projectiles: %d | #enemies: %d | #asteroids: %d | points: %d",
        projectileSpawner.getEntityCount(), enemySpawner.getEntityCount(),
        obstacleSpawner.getEntityCount(), points);

    // update all modules
    // FIXME: maybe update
    hud.setText(hudText);

    background.update();
    enemySpawner.update();
    projectileSpawner.update();
    obstacleSpawner.update();
    player.update(input.buttonsPressed);
  }

  /**
   * Maybe spawn some new stuff.
   */
  private void spawn() {

    if (Math.random() > DEFAULT_SPAWN_PROBABILITY) {
      enemySpawner
          .spawn(new Point(this.windowSize.width, (int) (Math.random() * this.windowSize.height)));
      obstacleSpawner.spawn((int) (this.windowSize.width * Math.random()));
    }
  }

  /**
   * Marks the game as lost by setting the isRunning boolean to false. This stops the main
   * game-loop.
   */
  private void setGameLost() {
    System.out.println("lost");
    isRunning = false;
  }

  /**
   * Checks, if one of the {@link Projectile}s intersects with one of the {@link Enemy}s. If there
   * is an intersections, remove the projectile and the enemy from the list and increase the points
   * by one.
   * 
   * @param enemies - enemies to check
   * @param projectiles - projectiles to check
   */
  private void checkProjectiles(List<Enemy> enemies, List<Projectile> projectiles) {

    for (Enemy enemy : enemies) {
      for (Projectile projectile : projectiles) {
        if (projectile.intersects(enemy)) {
          projectileSpawner.remove(projectile);
          enemySpawner.remove(enemy);
          points++;
        }
      }
    }
  }

  /**
   * Checks, if the given {@link Player} intersects one of the given {@link Asteroid}s.
   * 
   * @param player - player to check
   * @param asteroids - asteroids to check against
   * @return true, if the player instersects one of the asteroids, otherwise false
   */
  private boolean intersectsAsteroid(Player player, List<Asteroid> asteroids) {

    for (Asteroid asteroid : asteroids) {
      if (player.intersects(asteroid)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks, if the given {@link Player} intersects one of the given {@link Enemy}.
   * 
   * @param player - player to check
   * @param enemies - enemies to check
   * @return true, if the player intersects one of the enemies, otherwise false
   */
  private boolean intersectsEnemy(Player player, List<Enemy> enemies) {

    for (Enemy enemy : enemies) {
      if (player.intersects(enemy)) {
        return true;
      }
    }
    return false;
  }
}
