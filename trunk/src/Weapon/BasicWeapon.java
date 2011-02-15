package Weapon;

import Projectile.*;
import java.awt.Graphics2D;

/**
 *
 * @author Jere
 */
public class BasicWeapon extends Weapon {

    public BasicWeapon()
    {
        super(new BasicProjectile(10,10), 10);
    }

    @Override
    public void fire(Graphics2D g, int x, int y) {
        for(int i = 0; i < super.range*10;i++)
        {
            projectile.move(x,y-i);
            projectile.draw(g);
        }
    }
    // Mostly for testing purposes.
    public void fire(int x, int y) {
        System.out.println("Fired!");
        System.out.println(super.range*10);
        for(int i = 0; i <= super.range*10;i++)
        {
            if(y-i > 0)
            projectile.move(x,y-i);
        }
    }

}
