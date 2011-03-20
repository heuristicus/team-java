package Weapon;

import Projectile.Projectile;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author Jere
 */
public abstract class Weapon implements Serializable {

    // range = pixels*10. So 1 range is 10 pixels moved up.
    protected int range;
    protected Projectile projectile;
    String textureLoc;
//    protected BufferedImage texture;

    public Weapon(Projectile projectile, int range) {
        this.projectile = projectile;
        this.range = range;
    }

    public Weapon(int range) {
        this.range = range;
    }

    // Accessory methods
    public int getRange() {
        return range;
    }

    public int getDamage() {
        return projectile.getDamage();
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void setProjectile(Projectile proj) {
        this.projectile = proj;
    }
//    public BufferedImage getTexture() {
//        return texture;
//    }
//    public void setTexture(BufferedImage texture) {
//        this.texture = texture;
//
//    }

    public void setTextureLoc(String loc) {
        textureLoc = loc;
    }

    public BufferedImage getTexture() {
        try {
            return ImageIO.read(new File(textureLoc));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Error with loading texture to unit.");
        }
        System.err.println("Get texture error, null is being returned.");
        return null;
    }

    // Abstract methods.
    public abstract void fire(Graphics2D g, int x, int y);

    public String getTextureLoc() {
        return textureLoc;
    }
//    public void setTextureFromFile(String filename) {
//        try {
//            texture = ImageIO.read(new File(filename));
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//            System.err.println("Error with loading texture to unit.");
//        }
//    }
}
