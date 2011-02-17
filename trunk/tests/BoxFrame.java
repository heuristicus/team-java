/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class BoxFrame extends JPanel implements KeyListener {

    JFrame mFrame = null;
    JPanel mPanel = null;
    int cur_x = 50, cur_y = 50;
    int width = 20, height = 20;
    int rotation = 0;
    Rectangle2D box = new Rectangle2D.Double(cur_x, cur_y, width, height);
    Line2D pointer = new Line2D.Double(box.getX(), box.getY(), box.getX(), box.getY() - 5);
    Point2D movePoint = new Point2D.Double(pointer.getX2(), pointer.getY2());

    public static void main(String[] args) {
        BoxFrame b = new BoxFrame();
    }

    public BoxFrame() {
        mFrame = new JFrame("Box that moves");
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrameBits();
        MouseListener m = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicky");
                System.out.println(mPanel.hasFocus());
            }
        };

        addMouseListener(m);
        //pointer = new Line2D.Double(box.getCenterX(), box.getCenterY(), box.getCenterX(), box.getCenterY() + 30);

        mFrame.setSize(600, 600);
        mFrame.setEnabled(true);
        mFrame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        normaliseRotation();
        normaliseCoordinates();
        normaliseMovePoint();
        updateMovingParts();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println(box);
        System.out.println(movePoint);
        AffineTransform rt = new AffineTransform();
        rt.translate(box.getCenterX(), box.getCenterY());
        rt.rotate(Math.toRadians(rotation));
        rt.translate(-box.getCenterX(), -box.getCenterY());
        g2.setTransform(rt);
        g2.draw(box);
        g2.draw(pointer);

    }

    /**
     * Updates the locations of the box and pointer based on the new values of
     * cur_x and so forth.
     */
    public void updateMovingParts() {
        box = new Rectangle2D.Double(movePoint.getX(), movePoint.getY(), width, height);
        pointer = new Line2D.Double(box.getX(), box.getY(), box.getX(), box.getY() - 5);
    }

    private void addFrameBits() {
        mPanel = new JPanel();
        mFrame.addKeyListener(this);
        mFrame.add(this);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int typed = e.getKeyCode();
        switch (typed) {
            case 40: // Down
                break;
            case 38: // Up
                movePoint.setLocation(movePoint.getX(), movePoint.getY() - 5);
                break;
            case 37: // Left
                rotation += 5;
                break;
            case 39: // Right
                rotation -= 5;
                break;

        }
        repaint();
    }

    /**
     * Ensures that the angle of rotation remains between 0 and 360
     */
    public void normaliseRotation() {
        if (rotation >= 360) {
            /*
             * Takes into account that you could be at 360 degrees or more
             * e.g 364deg normalised = 4deg.
             */
            rotation -= 360;
        } else if (rotation < 0) {
            /*
             * Since you're at less than zero degrees, to get the correct angle,
             * you have to add 360.  e.g. -7deg = 353deg normalised.
             */
            rotation += 360;
        }
    }

    /**
     * Makes sure that the coordinates of the box are always within the bounds
     * of the frame.
     */
    public void normaliseCoordinates() {
        if (cur_y >= mFrame.getHeight()) {
            cur_y = 0;
        } else if (cur_y < 0) {
            cur_y = mFrame.getHeight();
        }

        if (cur_x >= mFrame.getWidth()) {
            cur_x = 0;
        } else if (cur_x < 0) {
            cur_x = mFrame.getWidth();
        }
    }

    public void normaliseMovePoint() {
        if (movePoint.getY() >= mFrame.getHeight()) {
            movePoint.setLocation(movePoint.getX(), 0);
        } else if (movePoint.getY() < 0) {
            movePoint.setLocation(movePoint.getX(), mFrame.getHeight());
        }

        if (movePoint.getX() >= mFrame.getWidth()) {
            movePoint.setLocation(0, movePoint.getY());
        } else if (movePoint.getX() < 0) {
            movePoint.setLocation(mFrame.getWidth(), movePoint.getY());
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
