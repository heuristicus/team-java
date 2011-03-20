package Projectile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Basic projectile, as in just a line that will be shot.
 * @author Jere
 */
public class BasicProjectile extends Projectile implements Serializable {

    final int HEIGHT = 5;
    final int WIDTH = 1;

    public BasicProjectile(int x, int y, String textureLoc) {
        // FIXME Need to check the values for speed, damage, etc.
        super(x, y, 20, 100, false,
                new Line2D.Double(x, y, x, y + 10),
                Color.RED, textureLoc);
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

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(getTexture(), getX(), getY(), null);
    }
}
