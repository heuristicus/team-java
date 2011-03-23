package Weapon;

import Path.DiagonalPath;
import Path.StraightPath;
import Projectile.*;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jere
 */
public class ProtonWeapon extends Weapon implements Serializable {

    int fireRate = 100;

    public ProtonWeapon() {
        super(10);
        super.setFireRate(fireRate);
//        setTextureFromFile(".//src//Weapon//proton.png");
        super.setProjectile(new BasicProjectile(10, 10, "proton"));
    }

    @Override
    public ArrayList<Projectile> fire(int x, int y) {
        ArrayList<Projectile> newProjectiles = new ArrayList<Projectile>();
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new StraightPath(StraightPath.Direction.UP), "proton"));
//        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new StraightPath(StraightPath.Direction.DOWN), "proton"));
//        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.RIGHT, DiagonalPath.Direction.UP), "proton"));
//        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.LEFT, DiagonalPath.Direction.UP), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.RIGHT, DiagonalPath.Direction.DOWN), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.LEFT, DiagonalPath.Direction.DOWN), "proton"));
        return newProjectiles;
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
}
