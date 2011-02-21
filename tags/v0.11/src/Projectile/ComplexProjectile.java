/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Projectile;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author michal
 */
public class ComplexProjectile extends Projectile {

    public ComplexProjectile(int x, int y, int damage, int speed, boolean isEnemy, Shape shape, Color color) {
        super(x, y, damage, speed, isEnemy, shape, color);
    }

    @Override
    public void move(int x, int y) {
        super.setX(x);
        super.setY(y);
    }

    @Override
    public void doMove() {
        move(super.getX(), super.getY() + 10);
    }
}
