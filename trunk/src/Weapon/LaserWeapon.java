package Weapon;

import Path.DiagonalPath;
import Path.StraightPath;
import Projectile.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jere
 */
public class LaserWeapon extends Weapon implements Serializable {

    Projectile p1, p2, p3;

    public LaserWeapon() {
        super(10);
//        super.setTextureFromFile(".//src//Weapon//laser.png");
        super.setProjectile(new BasicProjectile(10, 10, "laser"));
    }

//    @Override
//    public void fire(Graphics2D g, int x, int y) {
//        for(int i = 0; i < super.range*10;i++)
//        {
//            projectile.move(x+15,y-i);
////            projectile.draw(g);
//        }
//    }
    // Mostly for testing purposes.
//    public void fire(int x, int y) {
//        for (int i = 0; i <= super.range * 10; i++) {
//            if (y - i > 0) {
//                projectile.move(x, y - i);
//            }
//        }
//    }

    @Override
    public ArrayList<Projectile> fire(int x, int y) {
        ArrayList<Projectile> newProjectiles = new ArrayList<Projectile>();
        newProjectiles.add(new ComplexProjectile(x, y, 30, 10, false, null, Color.yellow, new StraightPath(StraightPath.Direction.DOWN), "laser"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, false, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.LEFT, DiagonalPath.Direction.UP), "laser"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, false, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.RIGHT, DiagonalPath.Direction.UP), "laser"));
        return newProjectiles;
    }
}
