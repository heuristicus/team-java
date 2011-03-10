/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Projectile;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author michal
 */
public class ComplexProjectile extends Projectile {
    //Shape shape;

    public ComplexProjectile(int x, int y, int damage, int speed, boolean isEnemy, Shape shape, Color color) {
        super(x, y, damage, speed, isEnemy, shape, color);
    }

    @Override
    public void move(int x, int y) {
        System.out.println(super.getShape().getClass().getName());
        if (isEnemy()) {
            super.setX(x);
            super.setY(y);
            if (super.getShape().getClass().getName().contains("Ellipse2D")) {
                super.setShape(new Ellipse2D.Double(x, y, 5, 5));
            } else if (super.getShape().getClass().getName().contains("Rectangle2D")) {
                super.setShape(new Rectangle2D.Double(x, y, 5, 5));
            } else if (super.getShape().getClass().getName().contains("Line")) {
                super.setShape(new Line2D.Double(x, y, x, y + 10));
            }

        } else {
            super.setX(x);
            super.setY(y);
            if (super.getShape().getClass().getName().contains("Ellipse2D")) {
                super.setShape(new Ellipse2D.Double(x, y, 5, 5));
            } else if (super.getShape().getClass().getName().contains("Rectangle2D")) {
                super.setShape(new Rectangle2D.Double(x, y, 5, 5));
            } else if (super.getShape().getClass().getName().contains("Line2D")) {
                super.setShape(new Line2D.Double(x, y, x, y + 10));
            }

            // super.setShape(shape);
        }
    }

    @Override
    public void doMove() {
        if (isEnemy()) {
            move(super.getX(), super.getY() + 10);
        } else {
            move(super.getX(), super.getY() - 10);
        }
    }
}
