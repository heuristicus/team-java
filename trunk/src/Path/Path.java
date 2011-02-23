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
public abstract class Path {

    public abstract Point getNextLocation(int curX, int curY);

}
