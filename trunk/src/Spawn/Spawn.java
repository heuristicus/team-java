/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Spawn;

import Unit.Enemy;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class Spawn {

    public final int xLoc, yLoc;
   Enemy spawnUnit;

    public Spawn(int xLoc, int yLoc, Enemy spawnUnit) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        System.out.println(spawnUnit);
        spawnUnit.setLocation(new Point(xLoc, yLoc));
        System.out.println(spawnUnit);
        this.spawnUnit = spawnUnit;
        System.out.println(spawnUnit);
    }

    public void setSpawnUnit(Enemy unit) {
        unit.setLocation(new Point(xLoc, yLoc));
        this.spawnUnit = unit;
    }

    public Enemy getSpawnUnit(){
        return spawnUnit.copy();
    }

    public ArrayList<Enemy> spawnUnits(int numberUnits){
        ArrayList<Enemy> spawns = new ArrayList<Enemy>();
        for (int i = 0; i < numberUnits; i++) {
            spawns.add(getSpawnUnit());
        }
        return spawns;
    }

}
