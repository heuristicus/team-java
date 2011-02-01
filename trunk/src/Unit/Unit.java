/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package B3.trunk.src.Unit;

import B3.trunk.src.Weapon.Weapon;
import java.awt.Shape;

/**
 *
 * @author michal
 */
public abstract class Unit {

    protected int health;
    protected int speed;
    protected Shape shape;
    protected Weapon weaponType;
    //protected int team;
    protected int pointValue;

    public Unit(int health, int speed, Shape shape, Weapon weaponType, int pointValue) {
        this.health = health;
        this.speed = speed;
        this.shape = shape;
        this.weaponType = weaponType;
        this.pointValue = pointValue;
    }



}
