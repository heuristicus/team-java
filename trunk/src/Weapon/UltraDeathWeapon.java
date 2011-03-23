/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapon;

import Path.DiagonalPath;
import Path.StraightPath;
import Path.ZigZagPath;
import Projectile.ComplexProjectile;
import Projectile.Projectile;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class UltraDeathWeapon extends Weapon implements Serializable {

    int fireRate = 20;

    public UltraDeathWeapon() {
        super(10);
        super.setFireRate(fireRate);
//        setTextureFromFile(".//src//Weapon//proton.png");
    }

    @Override
    public ArrayList<Projectile> fire(int x, int y) {
        ArrayList<Projectile> newProjectiles = new ArrayList<Projectile>();
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new StraightPath(StraightPath.Direction.UP), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new StraightPath(StraightPath.Direction.DOWN), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.RIGHT, DiagonalPath.Direction.UP), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.LEFT, DiagonalPath.Direction.UP), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.RIGHT, DiagonalPath.Direction.DOWN), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new DiagonalPath(DiagonalPath.Direction.LEFT, DiagonalPath.Direction.DOWN), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new ZigZagPath(ZigZagPath.Direction.RIGHT), "proton"));
        newProjectiles.add(new ComplexProjectile(x, y, 10, 10, true, null, Color.yellow, new ZigZagPath(ZigZagPath.Direction.LEFT), "proton"));
        return newProjectiles;
    }
}
