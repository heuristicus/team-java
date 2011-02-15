/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;


import Projectile.Projectile;
import Unit.Unit;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
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
        units = new ArrayList<Unit>();
        projectiles = new ArrayList<Projectile>();
    }

    /**
     * Prunes the unit and projectile arrays to remove objects that are no longer
     * in the field of play.
     * @param frameSize The current size of the game frame.
     */
    public void pruneArrays(Dimension frameSize){
        // TODO Decide on some kind of range outside the frame in which we keep objects
        int height = frameSize.height;
        int width = frameSize.width;
        pruneUnitArray(height, width);
        pruneProjectileArray(height, width);
    }

    /**
     * Removes any units in the array that are outside a rectangle of the height
     * and width provided.
     * @param height Height of the rectangle.
     * @param width Width of the rectangle.
     */
    public void pruneUnitArray(int height, int width) {
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, width, height);
        ArrayList<Unit> toRemove = new ArrayList<Unit>();
        for (Unit unit : units) {
            if (!bounds.contains(unit.getLocation())){
                toRemove.add(unit);
            }
        }
        for (Unit unit : toRemove) {
            units.remove(unit);
        }
    }

    public void pruneProjectileArray(int height, int width){
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, width, height);
        ArrayList<Projectile> toRemove = new ArrayList<Projectile>();
        for (Projectile projectile : projectiles) {
            if (!bounds.contains(projectile.getLocation())){
                toRemove.add(projectile);
            }
        }
        for (Projectile projectile : toRemove) {
            projectiles.remove(projectile);
        }
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
/**
 * Returns the unit array size to be used in the game panel class
 * @return
 */
    public int getUnitArrayLength(){
        return units.size();
    }
}
