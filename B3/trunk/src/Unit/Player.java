/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trunk.src.Unit;

import trunk.src.Weapon.Weapon;
import java.awt.Shape;

/**
 *
 * @author michal
 */
public class Player extends Unit {

    public static void main(String[] args) {
        Player p = new Player(1, 2, null, null, 3);
    }

    public Player(int health, int speed, Shape shape, Weapon weaponType, int pointValue) {
        super(health, speed, shape, weaponType, pointValue);
        check();
    }

    public void check() {
        System.out.println(health);
        System.out.println(shape);
        System.out.println(speed);
        System.out.println(weaponType);
        System.out.println(pointValue);
    }
}
