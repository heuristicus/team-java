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
public class Enemy extends Unit{

    public static void main(String[] args) {
        Enemy p = new Enemy(1, 2, null, null, 3);
        Player r = new Player(4,5, null, null, 6);
    }

    public Enemy(int health, int speed, Shape shape, Weapon weaponType, int pointValue) {
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
