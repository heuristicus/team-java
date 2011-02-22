/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import Weapon.BasicWeapon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author michal
 */
public class DefaultUnit extends Unit {

    // Can't pass values in the subclass as parameters to the super constructor.
//    final int HEALTH = 100;
//    final int SPEED = 20;
//    final Weapon WEAPON = new BasicWeapon();
//    final int POINTVAL = 0;
//    final Color COLOR = Color.MAGENTA;
    int x, y;

    public DefaultUnit(int x, int y) {
        super(100, 20, new BasicWeapon(), 0, x, y, Color.magenta);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g2) {
       // Graphics2D g_ = (Graphics2D) g;
        g2.setColor(getColor());
        g2.fillOval(x, y, 20, 40);
    }
}
