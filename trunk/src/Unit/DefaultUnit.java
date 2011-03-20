/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import Weapon.BasicWeapon;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author michal
 */
public class DefaultUnit extends Unit implements Serializable{

    // Can't pass values in the subclass as parameters to the super constructor.
//    final int HEALTH = 100;
//    final int SPEED = 20;
//    final Weapon WEAPON = new BasicWeapon();
//    final int POINTVAL = 0;
//    final Color COLOR = Color.MAGENTA;
    int x, y;

    public DefaultUnit(int x, int y) {
        super(100, 20, new BasicWeapon(), 0, x, y, Color.magenta, "default");
        this.x = x;
        this.y = y;
    }

//    @Override
//    public void draw(Graphics2D g2, Map m) {
//        g2.drawImage(null, null, null);
//    }
}
