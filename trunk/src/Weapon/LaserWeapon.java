package Weapon;

import Projectile.*;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 *
 * @author Jere
 */
public class LaserWeapon extends Weapon implements Serializable{

    public LaserWeapon()
    {
        super(10);
        super.setTextureFromFile(".//src//Weapon//laser.png");
        super.setProjectile(new BasicProjectile(10,10,texture));
    }

    @Override
    public void fire(Graphics2D g, int x, int y) {
        for(int i = 0; i < super.range*10;i++)
        {
            projectile.move(x+15,y-i);
            projectile.draw(g);
        }
    }
    // Mostly for testing purposes.
    public void fire(int x, int y) {
        for(int i = 0; i <= super.range*10;i++)
        {
            if(y-i > 0)
            projectile.move(x,y-i);
        }
    }

}
