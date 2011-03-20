package Projectile;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.io.Serializable;

/**
 * Basic projectile, as in just a line that will be shot.
 * @author Jere
 */
public class BasicProjectile extends Projectile implements Serializable {

    final int HEIGHT = 5;
    final int WIDTH = 1;

    public BasicProjectile(int x, int y, String imageReference) {
        // FIXME Need to check the values for speed, damage, etc.
        super(x, y, 20, 100, false, new Line2D.Double(x, y, x, y + 10), Color.RED, imageReference);
    }

    @Override
    public void move(int x, int y) {
        super.setX(x);
        super.setY(y);
        super.setShape(new Line2D.Double(x, y, x, y + 10));
    }

    @Override
    public void doMove() {
        move(super.getX(), super.getY() - 10);
    }
//    @Override
//    public void draw(Graphics2D g2, Map m) {
//        g2.drawImage((BufferedImage) m.get(super.projectileType), getX(), getY(), null);
//    }
}
