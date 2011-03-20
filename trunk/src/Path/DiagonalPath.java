/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Path;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author michal
 */
public class DiagonalPath extends Path implements Serializable{

    public enum Direction {

        LEFT, RIGHT
    }
    public Direction direction;

    /**
     * Default constructor. Chooses a random direction for the path to go in.
     */
    public DiagonalPath() {
        // Goes left if the random value is less than 0.5, otherwise goes right.
        direction = Math.random() < 0.5 ? Direction.LEFT : Direction.RIGHT;
    }

    /**
     * Constructor which allows specification of direction of movement
     * @param direction
     */
    public DiagonalPath(Direction direction) {
        this.direction = direction;
    }

    /**
     * Gets the next location a ship on this path should be at given its current
     * position on the path.
     * @param curX Current x position of object.
     * @param curY Current y position of object.
     * @return Next point that the object should be at.
     */
    @Override
    public Point getNextLocation(int curX, int curY) {
        if (direction == Direction.LEFT) {
            return new Point(curX - 1, curY + 3);
        } else {
            return new Point(curX + 1, curY + 3);
        }
    }
}
