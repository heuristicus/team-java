/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import Weapon.Weapon;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author michal
 */
public abstract class Unit {

    protected int health;
    protected int speed;
    //   protected Shape shape;
    protected Weapon weaponType;
    //protected int team;
    protected int pointValue;
    protected int xCoord, yCoord;
    protected Color color;
    protected BufferedImage texture;
//    protected Polygon ship;

    public Unit(int health, int speed, Weapon weaponType, int pointValue, int xCoord, int yCoord, Color color) {
        this.health = health;
        this.speed = speed;
        //      this.shape = shape;
        this.weaponType = weaponType;
        this.pointValue = pointValue;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.color = color;
    }

    /**
     * set/get methods for x/y coordinated and Unit color
     * @author danielcecil
     */
    public void setX(int newX) {
        xCoord = newX;
    }

    public int getX() {
        return xCoord;
    }

    public void setY(int newY) {
        yCoord = newY;
    }

    public int getY() {
        return yCoord;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public Color getColor() {
        return color;
    }

    public void setLocation(Point newLoc) {
        xCoord = newLoc.x;
        yCoord = newLoc.y;
    }

    public Point getLocation() {
        return new Point(xCoord, yCoord);
    }

    public Weapon getWeapon() {
        return weaponType;
    }
    public int getHealth() {
        return health;
    }

    public BufferedImage getTexture() {
        return texture;
    }
    public void setTexture(BufferedImage texture) {
        this.texture = texture;

    }
    public void setTextureFromFile(String filename) {
        try {
            texture = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Error with loading texture to unit.");
        }
    }

    public void giveDamage(int damage) {
        health -= damage;
    }

//    public Polygon getShip() {
//        return ship;
//    }
    public abstract void draw(Graphics2D g2);

    @Override
    public String toString() {
        return "Unit{" + "health=" + health + "xCoord=" + xCoord + "yCoord=" + yCoord + this.hashCode() + '}';
    }
}
