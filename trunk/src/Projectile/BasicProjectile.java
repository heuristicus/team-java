package Projectile;

import java.awt.Color;
import java.awt.geom.Line2D;

/**
 * Basic projectile, as in just a line that will be shot.
 * @author Jere
 */
public class BasicProjectile extends Projectile{

    final int HEIGHT = 5;
    final int WIDTH = 1;
    int x;
    int y;

    public BasicProjectile()
    {
        // FIXME Need to check the values for speed, damage, etc.
        super (20,20,10, 100, false,
                new Line2D.Double(0,0,1,5),
                Color.RED);
    }

    @Override
    public void move(int x, int y) {
        super.setShape(new Line2D.Double(x, y, WIDTH, HEIGHT));
    }
}
