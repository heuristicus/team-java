/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Path;

import java.awt.Point;

/**
 *
 * @author michal
 */
public class StraightPath extends Path {

    public enum Direction {

        UP, DOWN
    }
    public Direction direction;

    /**
     * Constructor which allows specification of direction of movement
     * @param direction
     */
    public StraightPath(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Point getNextLocation(int curX, int curY) {
        if (direction == Direction.DOWN) {
            return new Point(curX, curY - 10);
        } else if (direction == Direction.UP){
            return new Point(curX, curY + 10);
        } else {
            System.err.println("ERROR: Direction not provided for StraightPath.");
            return new Point(curX, curY);
        }


    }
}
