package Weapon;

import Projectile.*;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 *
 * @author Jere
 */
public class BasicWeapon extends Weapon implements Serializable{

    public BasicWeapon()
    {
        super(10);
        super.setTextureFromFile(".//src//Weapon//proton.png");
        super.setProjectile(new BasicProjectile(10,10,texture));
    }

    @Override
    public void fire(Graphics2D g, int x, int y) {
        for(int i = 0; i < super.range*10;i++)
        {
            projectile.move(x,y-i);
            projectile.draw(g); // Not working
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
