package Background;

import GUIComponents.BaseFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jere
 */
public class Background {

    private ArrayList<Star> stars;
    int amount, height, width;

    public Background(int amount) {
        this.amount = amount;
        stars = new ArrayList<Star>();

        width = BaseFrame.getWindowSize().width;
        height = BaseFrame.getWindowSize().height;

        addRandomStars(amount);
    }

    private void addRandomStars(int amount) {
        for (int i = 0; i < amount; i++)
        {
            stars.add(new Star(new Point2D.Double(getRandom(width),getRandom(height))));
        }
    }
    private int getRandom(int max)
    {
        Random r = new Random();
        return r.nextInt(max);
    }
    public void draw(Graphics2D g2)
    {
        for (int j = 0; j < stars.size(); j++)
        {
            Star star = (Star)stars.get(j);          
            g2.setColor(star.getColor());
            g2.fill(star.getShape());
        }
    }
    public void tick()
    {
        for (int k = 0; k < stars.size(); k++)
        {
            Star star = (Star)stars.get(k);
            star.setCoords(new Point2D.Double(star.getCoords().getX(),star.getCoords().getY()+5));
            if (star.getCoords().getY() > height)
            {
                star.setCoords(new Point2D.Double(getRandom(width),0));
            }
        }
      //  System.out.println(stars.size());

    }




    public void removeStars(int width, int height){{
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, width, height);
        ArrayList<Star> toRemove = new ArrayList<Star>();
        for (Star st : stars) {
            if (!bounds.contains(st.getCoords())) {
                toRemove.add(st);
            }
        }
        stars.removeAll(toRemove);
    }
    }

    
}
