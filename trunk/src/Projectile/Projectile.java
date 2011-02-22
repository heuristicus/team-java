package Projectile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 *
 * @author Jere
 */
public abstract class Projectile {

    private int damage;
    private Shape shape;
    private boolean isEnemy;
    private int speed;
    private Color color;
    private int x;
    private int y;

    public Projectile(int x, int y, int damage, int speed, boolean enemy, Shape shape, Color color) {
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.isEnemy = enemy;
        this.speed = speed;
        this.shape = shape;
        this.color = color;
    }

    // Accessory methods.
    public int getDamage() {
        return damage;
    }

    public Shape getShape() {
        return shape;
    }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public boolean isEnemy() {
        return isEnemy;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }

    public Point getLocation() {
        return new Point(x, y);
    }

    public void setLocation(Point newLoc) {
        this.x = newLoc.x;
        this.y = newLoc.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    // Abstract methods.
    public abstract void move(int x, int y);

    //temporary method to move the projectiles while we have no paths.
    // May want to have this method call move, and then draw. If this is done,
    // then you can pass this a graphics object and it will move the projectile
    // and then draw it, all in one
    public abstract void doMove();

    // Rendering methods.
    public void draw(Graphics2D g2) {
        g2.fill(shape);
    }

    @Override
    public String toString() {
        return "Projectile{" + "damage=" + damage + "isEnemy=" + isEnemy + "x=" + x + "y=" + y + this.hashCode() + '}';
    }

    
}
