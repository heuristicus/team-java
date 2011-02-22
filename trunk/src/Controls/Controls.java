/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author michal & David
 */
public class Controls implements KeyListener, MouseListener, MouseMotionListener {

    /**
     * Fields to hold the current control information such as mouse position
     */
    int currentKey; // Current key pressed
    boolean up = false; // True if the ship is to move up
    boolean down = false; // True if the ship is to move down
    boolean left = false; // True if the ship is to move left
    boolean right = false; // True if the ship is to move right
    boolean space = false; // True if the ship is to fire
    int mouseX; // Current mouse X position
    int mouseY; // Currrent Mouse Y position
    boolean mouse = false;//if mouse is being used or not

    /**
     * Sout in constructor to inform if the controls are enabled
     */
    public Controls() {
        System.out.println("controls enabled");
    }

//    public void IntiliseControls(){
//
//    }
    /**
     * Part of key listener that will change the booleans to true for what key direction has been pressed
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        // System.out.println(e.getKeyCode());
        // System.out.println("press");
        if (e.getKeyCode() == 40) {//down
            down = true;
            currentKey = 40;
            System.out.println("down");
        }
        if (e.getKeyCode() == 37) {//left
            left = true;
            currentKey = 37;
            System.out.println("left");
        }
        if (e.getKeyCode() == 38) {//up
            up = true;
            currentKey = 38;
            System.out.println("up");
        }
        if (e.getKeyCode() == 39) {//right
            right = true;
            currentKey = 39;
            System.out.println("right");
        }
        if (e.getKeyCode() == 32) {//space
            space = true;
            currentKey = 32;
            System.out.println("space");
        }
    }

    /**
     * Part of Key listener that sets the relevant boolean to false once the key is released
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        mouse = false;
        if (e.getKeyCode() == 40) {//down
            down = false;

        }
        if (e.getKeyCode() == 37) {//left
            left = false;
        }
        if (e.getKeyCode() == 38) {//up
            up = false;
        }
        if (e.getKeyCode() == 39) {//right
            right = false;
        }
        if (e.getKeyCode() == 32) {//space
            space = false;
        }
    }

    /**
     * Not used
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * PArt of mouse listener that checks when the mouse button is pressed and
     * sets the boolean to indicate the ship is to fire to true
     * @param e
     */
    public void mousePressed(MouseEvent e) {
        space = true;
        System.out.println("space");
    }

    /**
     * PArt of mouse listener that checks when the mouse button is released and
     * sets the boolean to indicate the ship is to fire to false
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
        space = false;
    }

    /**
     * Part of mouse listener that will get the co-ordinate of the mouse pointe once it enters the frame
     * @param e
     */
    public void mouseEntered(MouseEvent e) {
        mouse = true;
        mouseX = e.getX();
        mouseY = e.getY();
    }

    /**
     * Not used
     * @param e
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Part of mouse listener that will get the co-ordinate of the mouse pointe while the mouse button is held down
     * @param e
     */
    public void mouseDragged(MouseEvent e) {
        mouse = true;
        space = true;
        mouseX = e.getX();
        mouseY = e.getY();
    }

        /**
     * Part of mouse listener that will get the co-ordinate of the mouse pointer while the mouse is moved around in the frame
     * @param e
     */
    public void mouseMoved(MouseEvent e) {
        mouse = true;
        mouseX = e.getX();
        mouseY = e.getY();
       // System.out.println("x= " + mouseX);
       // System.out.println("Y= " + mouseY);
    }

    /**
     * Not used
     * @param e
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Getters below this point
     * @return
     */
    public int getCurrentKey() {
        return currentKey;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isSpace() {
        return space;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isMouse() {
        return mouse;
    }
}
