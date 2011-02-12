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
    private boolean enemy;
    private int speed;
    private Color color;
    private int x;
    private int y;
    
    public Projectile(int x, int y, int damage, int speed, boolean enemy, Shape shape, Color color)
    {
        this.damage = damage;
        this.enemy = enemy;
        this.speed = speed;
        this.shape = shape;
        this.color = color;
    }

    // Accessory methods.
    public int getDamage() { return damage; }
    public Shape getShape() { return shape; }
    public boolean getEnemy() { return enemy; }
    public int getSpeed() { return speed; }
    public Color getColor() { return color; }
    public Point getLocation(){ return new Point(x,y); }

    public void setShape(Shape shape) { this.shape = shape; }

    // Abstract methods.
    public abstract void move(int x, int y);

    // Rendering methods.
    public void draw(Graphics2D g2)
    {
        g2.fill(shape);
    }
}
