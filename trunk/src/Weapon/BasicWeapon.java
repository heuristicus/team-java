package Weapon;

import Projectile.BasicProjectile;
import java.awt.Graphics2D;

/**
 *
 * @author Jere
 */
public class BasicWeapon extends Weapon {

    public BasicWeapon()
    {
        super(new BasicProjectile(), 20);
    }

    @Override
    public void fire(Graphics2D g, int x, int y) {
        for(int i = 0; i < super.range*10;i++)
        {
            projectile.move(x,y-i);
            projectile.draw(g);
        }
    }

}
