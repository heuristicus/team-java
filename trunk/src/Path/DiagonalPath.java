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
public class DiagonalPath extends Path implements Serializable {

    private final Direction vertDirection;

    public enum Direction {

        LEFT, RIGHT, UP, DOWN
    }
    public Direction sideDirection;

    /**
     * Default constructor. Chooses a random direction for the path to go in.
     */
    public DiagonalPath() {
        // Goes left if the random value is less than 0.5, otherwise goes right.
        sideDirection = Math.random() < 0.5 ? Direction.LEFT : Direction.RIGHT;
        vertDirection = Math.random() < 0.5 ? Direction.UP : Direction.DOWN;
    }

    /**
     * Constructor which allows specification of direction of movement
     * @param direction
     */
    public DiagonalPath(Direction sideDirection, Direction vertDirection) {
        this.sideDirection = sideDirection;
        this.vertDirection = vertDirection;
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
        if (sideDirection == Direction.LEFT) {
            return new Point(curX - 1, curY + (vertDirection == Direction.UP ? -3 : +3));
        } else {
            return new Point(curX + 1, curY + (vertDirection == Direction.UP ? -3 : +3));
        }
    }
}
