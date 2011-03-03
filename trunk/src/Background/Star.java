package Background;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Jere
 */
public class Star {

    private Point2D coords;
    private Color color;

    public Star(Point2D coords, Color color)
    {
        this.coords = coords;
        this.color = color;

    }
    public Star(Point2D coords)
    {
        this.coords = coords;
        color = Color.WHITE;
    }

    public Color getColor()
    {
        return color;
    }
    public Point2D getCoords()
    {
        return coords;
    }
    public Shape getShape()
    {
        Shape shape = new Ellipse2D.Double(coords.getX(),coords.getY(),2,2);
        return shape;
    }
    public void setCoords(Point2D newCoords)
    {
        coords = newCoords;
    }

}
