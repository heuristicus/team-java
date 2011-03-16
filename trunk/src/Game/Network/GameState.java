/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import Projectile.Projectile;
import Spawn.Spawn;
import Unit.Enemy;
import Unit.Player;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class GameState implements Serializable {

    boolean playerDeath;
    boolean paused;
    boolean running;
    private final ArrayList<Projectile> projectiles;
    private final ArrayList<Enemy> enemies;
    private final ArrayList<Player> players;
    private final ArrayList<Spawn> spawns;

    public GameState(){
        projectiles = new ArrayList<Projectile>();
        enemies = new ArrayList<Enemy>();
        players = new ArrayList<Player>();
        spawns = new ArrayList<Spawn>();
    }

    public GameState(ArrayList<Player> players, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles, ArrayList<Spawn> spawns) {
        this.players = players;
        this.enemies = enemies;
        this.projectiles = projectiles;
        this.spawns = spawns;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isPlayerDeath() {
        return playerDeath;
    }

    public boolean isRunning() {
        return running;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public ArrayList<Spawn> getSpawns() {
        return spawns;
    }

    /**
     * removes objects from this state's arrays which are also present in the state
     * passed to the method.
     * !!!!Not sure if this works if passing object over a network!!!!
     * @param state
     */
    public void removeDuplicates(GameState state){
        projectiles.removeAll(state.getProjectiles());
        enemies.removeAll(state.getEnemies());
        players.removeAll(state.getPlayers());
        spawns.removeAll(state.getSpawns());
    }

    /**
     * Puts the objects that are in the given state into this state.
     * @param state
     */
    public void joinState(GameState state){
        enemies.addAll(state.getEnemies());
        players.addAll(state.getPlayers());
        projectiles.addAll(state.getProjectiles());
        spawns.addAll(state.getSpawns());
    }
    

    @Override
    public String toString() {
        return "GameState{" + "playerDeath=" + playerDeath + "\npaused=" + paused + "\nrunning=" + running + "\nprojectiles=" + projectiles + "\nenemies=" + enemies + "\nplayers=" + players + "\nspawns=" + spawns + '}';
    }


}
