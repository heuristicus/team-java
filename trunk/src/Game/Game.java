/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B3.trunk.src.Game;

import B3.trunk.src.Projectile.Projectile;
import B3.trunk.src.Unit.Unit;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class Game {

    /*
     * This kind of this is probably necessary - can store all of the stuff that
     * is on the screen - projectiles, ships and whatever else, and then get this
     * list and use it to draw all of the objects on the screen with whichever 
     * thing is going to be doing that - most likely a panel. GameObject is just
     * some way of referring to all of the stuff. We could always have two different
     * arrays for projectiles and ships, and grab them independently.
     */
    ArrayList<Unit> units;
    ArrayList<Projectile> projectiles;

    public Game() {
    }

    /**
     * Adds a unit to the units array.
     * @param addUnit The unit to add to the array.
     */
    public void addUnitToArray(Unit addUnit) {
        units.add(addUnit);
    }

    /**
     * Adds a new projectile to the projectiles array.
     * @param addProjectile Projectile to add the the array.
     */
    public void addProjectileToArray(Projectile addProjectile) {
        projectiles.add(addProjectile);
    }

    /**
     * Returns the list of units currently present in the game.
     * @return Arraylist of units.
     */
    public ArrayList<Unit> getUnitArray() {
        return units;
    }

    /**
     * Returns the list of projectiles currently present in the game.
     * @return Arraylist of projectiles.
     */
    public ArrayList<Projectile> getProjectileArray() {
        return projectiles;
    }
}
