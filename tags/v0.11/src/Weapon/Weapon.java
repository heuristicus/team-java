package Weapon;

import Projectile.Projectile;
import java.awt.Graphics2D;

/**
 *
 * @author Jere
 */
public abstract class Weapon {

    // range = pixels*10. So 1 range is 10 pixels moved up.
    protected int range;
    protected Projectile projectile;

    public Weapon(Projectile projectile, int range)
    {
        this.projectile = projectile;
        this.range = range;
    }

    // Accessory methods
    public int getRange() { return range; }
    public int getDamage() { return projectile.getDamage(); }
    public Projectile getProjectile() { return projectile; }

    // Abstract methods.
    public abstract void fire(Graphics2D g, int x, int y);

}
