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
public abstract class Path implements Serializable{

    public abstract Point getNextLocation(int curX, int curY);

}
