/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Projectile;

import Path.Path;
import Path.StraightPath;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 *
 * @author michal
 */
public class ComplexProjectile extends Projectile implements Serializable {
    //Shape shape;

    Path movePath;

    public ComplexProjectile(int x, int y, int damage, int speed, boolean isEnemy, Shape shape, Color color, Path movePath, String imageReference) {
        super(x, y, damage, speed, isEnemy, shape, color, imageReference);
        this.movePath = movePath;
    }

    public ComplexProjectile(int x, int y, int damage, int speed, boolean isEnemy, Shape shape, Color color, Path movePath, String imageReference, int playerRef) {
        super(x, y, damage, speed, isEnemy, shape, color, imageReference);
        this.movePath = movePath;
        super.setPlayerRef(playerRef);
    }

    @Override
    public void move(int x, int y) {
//       // System.out.println(super.getShape().getClass().getName());
//        if (isEnemy()) {
//            super.setX(x);
//            super.setY(y);
//            if (super.getShape().getClass().getName().contains("Ellipse")) {
//                super.setShape(new Ellipse2D.Double(x, y, 5, 5));
//            } else if (super.getShape().getClass().getName().contains("Rectangle")) {
//                super.setShape(new Rectangle2D.Double(x, y, 5, 5));
//            } else if (super.getShape().getClass().getName().contains("Line")) {
//                super.setShape(new Line2D.Double(x, y, x, y + 10));
//            }
//
//        } else {
//            super.setX(x);
//            super.setY(y);
//            if (super.getShape().getClass().getName().contains("Ellipse")) {
//                super.setShape(new Ellipse2D.Double(x, y, 5, 5));
//            } else if (super.getShape().getClass().getName().contains("Rectangle")) {
//                super.setShape(new Rectangle2D.Double(x, y, 5, 5));
//            } else if (super.getShape().getClass().getName().contains("Line")) {
//                super.setShape(new Line2D.Double(x, y, x, y + 10));
//            }
//
//            // super.setShape(shape);
//        }x
        super.setLocation(new Point(x, y));
    }

    @Override
    public void doMove() {
            Point nextLoc = movePath.getNextLocation(super.getX(), super.getY());
            move((int) nextLoc.getX(), (int) nextLoc.getY());
    }
}
