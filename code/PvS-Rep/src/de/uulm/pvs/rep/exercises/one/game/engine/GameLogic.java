package de.uulm.pvs.rep.exercises.one.game.engine;


import de.uulm.pvs.rep.exercises.one.game.entities.enemies.Enemy;
import de.uulm.pvs.rep.exercises.one.game.entities.enemies.EnemySpawner;
import de.uulm.pvs.rep.exercises.one.game.entities.players.Player;
import de.uulm.pvs.rep.exercises.one.game.entities.projectiles.Projectile;
import de.uulm.pvs.rep.exercises.one.game.entities.projectiles.ProjectileSpawner;
import de.uulm.pvs.rep.exercises.one.game.entities.util.Background;
import de.uulm.pvs.rep.exercises.one.game.entities.util.Hud;
import de.uulm.pvs.rep.exercises.one.game.entities.util.Spawner;

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

  // Renderable entities
  private Background background;
  private Hud hud;

  private Spawner<Projectile> projectileSpawner;
  private Spawner<Enemy> enemySpawner;

  private Player player;

  private Renderer renderer;
  private Input input;
  private Dimension windowSize;

  // initialize state variables
  private boolean isRunning = false;
  private int score = 0;
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

    // initialize points and set game as 'running'
    this.score = 0;
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
  public int getScore() {
    return this.score;
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
    List<Enemy> enemies = enemySpawner.getList();

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
    this.hudText = String.format("#projectiles: %d | #enemies: %d | points: %d",
        projectileSpawner.getEntityCount(), enemySpawner.getEntityCount(), score);

    // update all modules
    hud.setText(hudText);

    background.update();
    enemySpawner.update();
    projectileSpawner.update();
    player.update(input.buttonsPressed);
  }

  /**
   * Maybe spawn some new stuff.
   */
  private void spawn() {

    // spawnRates are values between 0 and 100.
    // Math.random() returns values greater or equal than 0.0 and less than 1.0.

    final double normalizeValue = 100.0d;

    double monsterProbability = 2 / normalizeValue;

    // if we spawn a new entity everytime the probability is greater than the random
    // we get a lot of spawn if the rate is 100 and none, of the rate is 0.
    if (Math.random() < monsterProbability) {
      enemySpawner
          .spawn(new Point(this.windowSize.width, (int) (Math.random() * this.windowSize.height)));
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
          // FIXME: maybe more points for monsters or something like this...
          score++;
        }
      }
    }
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
