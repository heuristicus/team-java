/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Network.GameState;
import Projectile.Projectile;
import Spawn.Spawn;
import Unit.Enemy;
import Unit.Player;
import Unit.Unit;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class Game {

    
    ArrayList<Player> players;
    ArrayList<Enemy> enemies;
    ArrayList<Projectile> projectiles;
    ArrayList<Spawn> spawns;

    public Game() {
        players = new ArrayList<Player>();
        enemies = new ArrayList<Enemy>();
        projectiles = new ArrayList<Projectile>();
        spawns = new ArrayList<Spawn>();
    }

    public GameState getGameState(boolean playerDeath, boolean paused, boolean running) {
        return new GameState(players, enemies, projectiles, spawns, playerDeath, paused, running);
    }

    public void setGameState(GameState state) {
        players = state.getPlayers();
        enemies = state.getEnemies();
        projectiles = state.getProjectiles();
        spawns = state.getSpawns();
    }

    //<editor-fold defaultstate="collapsed" desc="Collision detection.">
    /**
     * Performs simple collision detection by looping through arrays and checking
     * whether two objects represented by 15x5 rectangles around their centre
     * intersect each other. If they do, they are removed from the arrays.
     */
    public void doNaiveCollisionDetection() throws PlayerDeathException {
        long time = System.currentTimeMillis();
        collideEnemies();
        collidePlayers();
        long timeTaken = time - System.currentTimeMillis();
        if (timeTaken >= 20) {
            System.err.printf("WARNING: COLLISION DETECTION TOOK %d MILLISECONDS!\n", timeTaken);
        }
    }

    /**
     * Collides enemies with projectiles fired by the player.
     */
    public void collideEnemies() {
        ArrayList<Enemy> toRemove = new ArrayList<Enemy>();
        ArrayList<Projectile> toRemoveProj = new ArrayList<Projectile>();
        for (Enemy enemy : enemies) {
            for (Projectile projectile : projectiles) {
                if (colliding(enemy, projectile)) {
                    enemy.giveDamage(projectile.getDamage());
                    if (enemy.getHealth() <= 0) {
                        Player dest = getPlayer(projectile.getPlayerRef());
                        dest.addToScore(enemy.getPointValue());
                        toRemove.add(enemy);
                    }
                    toRemoveProj.add(projectile);
                }
            }
        }
        for (Enemy enemy : toRemove) {
            removeEnemy(enemy);
        }
        for (Projectile projectile : toRemoveProj) {
            removeProjectile(projectile);
        }
    }

    /**
     * Collides players with enemies, and projectiles fired by enemies.
     */
    public void collidePlayers() throws PlayerDeathException {
        collidePlayerWithEnemies();
        collidePlayerWithProjectiles();
    }

    private void collidePlayerWithEnemies() throws PlayerDeathException {
        ArrayList<Player> toRemoveP = new ArrayList<Player>();
        ArrayList<Enemy> toRemoveE = new ArrayList<Enemy>();
        for (Player player : players) {
            for (Enemy enemy : enemies) {
                if (colliding(player, enemy)) {
                    player.giveDamage(player.getHealth());
                    toRemoveP.add(player);
                    toRemoveE.add(enemy);
                }
            }
        }
        for (Enemy enemy : toRemoveE) {
            removeEnemy(enemy);
        }
        for (Player player : toRemoveP) {
            removePlayer(player);
        }
    }

    // FIXME pretty much the same code as the code to collide enemies.
    private void collidePlayerWithProjectiles() throws PlayerDeathException {
        ArrayList<Player> toRemove = new ArrayList<Player>();
        ArrayList<Projectile> toRemoveProj = new ArrayList<Projectile>();
        for (Player player : players) {
            for (Projectile projectile : projectiles) {
                if (colliding(player, projectile)) {
                    player.giveDamage(projectile.getDamage());
                    if (player.getHealth() <= 0) {
                        toRemove.add(player);
                    }
                    toRemoveProj.add(projectile);
                }
            }
        }
        for (Player player : toRemove) {
            removePlayer(player);
        }
        for (Projectile projectile : toRemoveProj) {
            removeProjectile(projectile);
        }
    }

    /**
     * Checks collisions between units.
     */
//    private void collideUnits(){
//        Rectangle2D unitBound;
//        Rectangle2D unitBound2;
//        ArrayList<Unit> toRemoveUnit = new ArrayList<Unit>();
//        for (Unit unit1 : units) {
//            for (Unit unit2 : units) {
//                // make sure that we don't collide a ship with itself
//                if (unit1 != unit2){
//                    if (colliding(unit1, unit2)){
//                        toRemoveUnit.add(unit1);
//                        toRemoveUnit.add(unit2);
//                    }
//                }
//            }
//        }
//        for (Unit unit : toRemoveUnit) {
//            units.remove(unit);
//        }
//    }
    /**
     * Does collision detection for collisions between units and projectiles.
     */
    // TODO make this a little nicer. could do with some splitting up.
//    private void collideUnitsAndProjectiles(){
//        Rectangle2D projBound;
//        Rectangle2D unitBound;
//        ArrayList<Projectile> toRemoveProj = new ArrayList<Projectile>();
//        ArrayList<Unit> toRemoveUnit = new ArrayList<Unit>();
//        for (Unit unit : units) {
//            Point uPoint = unit.getLocation();
//            unitBound = getCenteredBox(uPoint); // create bounding box for unit
//            for (Projectile p : projectiles) {
//                Point projPoint = p.getLocation();
//                projBound = getCenteredBox(projPoint); // create bounds for projectile
//                if (projBound.intersects(unitBound)) {
//                    // check if these objects actually intersect. If so, then remove them.
//                    if (colliding(unit, p)) {
//                        toRemoveProj.add(p);
//                        toRemoveUnit.add(unit);
//                    }
//                }
//            }
//        }
//        for (Unit unit : toRemoveUnit) {
//            removeUnitFromArray(unit);
//        }
//        for (Projectile p : toRemoveProj) {
//            removeProjectileFromArray(p);
//        }
//    }
    /**
     * Checks the collision between a projectile and a unit, and returns a value representing
     * whether they should be removed or not. This is a pretty crude method, and
     * really should be changed to something better than comparing types using
     * strings.
     * @param u
     * @param p
     * @return
     */
    public boolean colliding(Unit u, Projectile p) {
        Rectangle2D projBounds = getCenteredBoxProjectile(p.getLocation());
        Rectangle2D unitBounds = getCenteredBox(u.getLocation());
        if (unitBounds.intersects(projBounds)) {
            // The collision is between the player bullets and the player, ignore it.
            if (u.getClass().toString().equals("class Unit.Player") && !p.isEnemy()) {
                return false;
            }
            // Collision between enemy bullets and enemies, ignore it.
            if (u.getClass().toString().equals("class Unit.Enemy") && p.isEnemy()) {
                return false;
            }

            return true; // Collision which requires that objects are removed.
        }
        return false;
    }

    /**
     * Checks collisions between two units.
     * @param u1
     * @param u2
     * @return
     */
    public boolean colliding(Unit u1, Unit u2) {
        if (u1.getClass().toString().equals("class Unit.Player")
                && u2.getClass().toString().equals("class Unit.Enemy")
                || u2.getClass().toString().equals("class Unit.Player")
                && u1.getClass().toString().equals("class Unit.Enemy")) {
            Rectangle2D u1Bound = getCenteredBox(u1.getLocation());
            Rectangle2D u2Bound = getCenteredBox(u2.getLocation());
            if (u1Bound.intersects(u2Bound)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a box of 5x5 pixels with the point passed as the centre.
     * @param centre
     */
    public Rectangle2D getCenteredBox(Point centre) {
        return new Rectangle2D.Double(centre.getX() + 2, centre.getY() + 2, 27, 27);
    }

    public Rectangle2D getCenteredBoxProjectile(Point centre){
        return new Rectangle2D.Double(centre.getX() + 12, centre.getY() + 12, 5, 5);
    }

    /**
     * Returns a centered box for a particular object, with size and offset specified.
     * @param centre Centre point of the object
     * @param xOffset amount to offset from the x coordinate.
     * This will move the top left corner of the bounding box to the left if passed a positive value.
     * @param yOffset Amount to offset from the y coordinate.
     * This will move the bounding boxes top left corner upwards if passed a positive value.
     * @param width The width that you want the bounding box to be.
     * @param height The height that you want the bounding box to be.
     * @return
     */
    public Rectangle2D getCenteredBox(Point centre, int xOffset, int yOffset, int width, int height) {
        return new Rectangle2D.Double(centre.getX() - xOffset, centre.getY() - yOffset, width, height);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Array pruning methods.">
    /**
     * Prunes the unit and projectile arrays to remove objects that are no longer
     * in the field of play.
     * @param frameSize The current size of the game frame.
     */
    public void pruneArrays(Dimension frameSize) {
        // TODO Decide on some kind of range outside the frame in which we keep objects
        int height = frameSize.height;
        int width = frameSize.width;
        pruneEnemyArray(height, width);
        pruneProjectileArray(height, width);
    }

    /**
     * Removes any enemies in the array that are outside a rectangle of the height
     * and width provided.
     * @param height Height of the rectangle.
     * @param width Width of the rectangle.
     */
    public void pruneEnemyArray(int height, int width) {
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, width, height);
        ArrayList<Enemy> toRemove = new ArrayList<Enemy>();
        for (Enemy enemy : enemies) {
            if (!bounds.contains(enemy.getLocation())) {
                toRemove.add(enemy);
            }
        }
        for (Enemy enemy : toRemove) {
            enemies.remove(enemy);
        }
    }

    /**
     * Prunes the projectile array of projectiles that are no longer within
     * the bounding box.
     * @param height
     * @param width
     */
    public void pruneProjectileArray(int height, int width) {
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, width, height);
        ArrayList<Projectile> toRemove = new ArrayList<Projectile>();
        for (Projectile projectile : projectiles) {
            if (!bounds.contains(projectile.getLocation())) {
                toRemove.add(projectile);
            }
        }
        for (Projectile projectile : toRemove) {
            projectiles.remove(projectile);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for adding and removal from arrays, as well as getters.">
    //<editor-fold defaultstate="collapsed" desc="Projectiles.">
    public void removeProjectile(Projectile p) {
        projectiles.remove(p);
    }

    public void removeProjectile(int index) {
        projectiles.remove(index);
    }

    /**
     * Adds a new projectile to the projectiles array.
     * @param addProjectile Projectile to add the the array.
     */
    public void addProjectileToArray(Projectile addProjectile) {
        projectiles.add(addProjectile);
    }

    public void addManyProjectiles(ArrayList<Projectile> newProjectiles){
        projectiles.addAll(newProjectiles);
    }

    /**
     * Returns the list of projectiles currently present in the game.
     * @return Arraylist of projectiles.
     */
    public ArrayList<Projectile> getProjectileArray() {
        return projectiles;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Enemies.">
    public void addEnemy(Enemy e) {
        enemies.add(e);
    }

    public void removeEnemy(Enemy e) {
        enemies.remove(e);
    }

    public void removeEnemy(int index) {
        enemies.remove(index);
    }

    public ArrayList<Enemy> getEnemyArray() {
        return enemies;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Players.">
    public void addPlayer(Player p) {
        players.add(p);
    }

    public void removePlayer(Player p) throws PlayerDeathException {
        int player = players.indexOf(p);
        players.remove(p);
        throw new PlayerDeathException(player);
    }

    public void removePlayer(int index) throws PlayerDeathException {
        players.remove(index);
        throw new PlayerDeathException(index);
    }

    public Player getPlayer(int playerReference){
        for (Player player : players) {
            if (player.getObjectReference() == playerReference){
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> getPlayerArray() {
        return players;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Spawns.">
    public void addSpawn(Spawn s) {
        spawns.add(s);
    }

    public void removeSpawn(Spawn s) {
        spawns.remove(s);
    }

    public void removeSpawn(int index) {
        spawns.remove(index);
    }

    public ArrayList<Spawn> getSpawnArray() {
        return spawns;
    }
    //</editor-fold>

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods to move game objects.">
    /**
     * Executes the doMove method for each projectile in the array.
     * This should move each projectile one step along its path
     */
    public void moveProjectiles() {
        for (Projectile proj : projectiles) {
            proj.doMove();
        }
    }

    /**
     * Executes the doMove method for each enemy.
     * This should move it one step along its path.
     */
    public void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.doMove();
        }
    }
    //</editor-fold>
}
