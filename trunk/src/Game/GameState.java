/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import Projectile.Projectile;
import Unit.Enemy;
import Unit.Player;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class GameState implements Serializable{
    
    private final ArrayList<Projectile> projectiles;
    private final ArrayList<Enemy> enemies;
    private final ArrayList<Player> players;

    public GameState(ArrayList<Player> players, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles) {
        this.players = players;
        this.enemies = enemies;
        this.projectiles = projectiles;
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

    



}
