/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MovingBox;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
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
        mFrame.setSize(600, 600);
        mFrame.setEnabled(true);
        mFrame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        updateBox();
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform rot = new AffineTransform();
        rot.rotate(rotation);
        g2.transform(rot);
        g2.draw(box);
    }
    
    public void updateBox(){
        box = new Rectangle2D.Double(cur_x, cur_y, width, height);
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
            case 40:
                System.out.println("down");
                cur_y += 5;
                break;
            case 38:
                System.out.println("up");
                cur_y -= 5;
                break;
            case 37:
                System.out.println("left");
                rotation += 5;
                break;
            case 39:
                System.out.println("right");
                rotation -= 5;
                break;

        }
        repaint();
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


    public void keyReleased(KeyEvent e) {
    }
}
