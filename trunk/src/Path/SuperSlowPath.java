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
public class SuperSlowPath extends Path implements Serializable {

    int xIncrement = 1;
    int yIncrement = 1;

    @Override
    public Point getNextLocation(int curX, int curY) {
        if(curX > 500){
            xIncrement = -1;
        } else if(curX < 20){
            xIncrement = +1;
        }
        if(curY < 50){
            yIncrement = +1;
        } else if (curY > 50){
            yIncrement = -1;
        } else {
            yIncrement = 0;
        }
        return new Point(curX + xIncrement, curY + yIncrement);
    }
}
