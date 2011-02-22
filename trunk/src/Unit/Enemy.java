/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import Weapon.Weapon;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

/**
 *
 * @author michal
 */
public class Enemy extends Unit {



    public Enemy(int health, int speed,  Weapon weaponType, int pointValue, int xCoord, int yCoord, Color color) {
        super(health, speed, weaponType, pointValue, xCoord, yCoord, color);
        
    }

    public void draw(Graphics2D g2) {
       // Graphics2D g_ = (Graphics2D) g;
        g2.setColor(color);
        Polygon p = new Polygon();
        Path2D triangle = new Path2D.Double();
        triangle.moveTo(xCoord, yCoord + 20);
        triangle.lineTo(xCoord - 10, yCoord - 10);
        triangle.lineTo(xCoord + 10, yCoord - 10);
        Area a = new Area(triangle);
        g2.fill(a);
    }

}
