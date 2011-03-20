/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Path;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.Timer;


/**
 *
 * @author Dave
 */
public class ZigZagPath extends Path implements Serializable{

    public Direction direction;
Timer t;
    public enum Direction {

        LEFT, RIGHT
    }

    public ZigZagPath(Direction direct) {
        this.direction = direct;
        t = new Timer(1000, new ActionListener() {
            

            public void actionPerformed(ActionEvent e) {
                if (direction == Direction.LEFT){
                   // System.out.println("change to right");
                    direction = Direction.RIGHT;
                }else{
                      // System.out.println("change to left");
                    direction = Direction.LEFT;
                }
            }
        });
       t.start(); 
    }

    @Override
    public Point getNextLocation(int curX, int curY) {
        if (direction == Direction.LEFT) {
            //System.out.println("left");
            return new Point(curX - 1, curY + 3);
            
        } else {//System.out.println("right");
            return new Point(curX + 1, curY + 3);
        }
    }
}
