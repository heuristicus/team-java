package GUIComponents;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 *
 * @author Jere
 */
public class Menu extends JPanel implements MouseListener, MouseMotionListener {

    JFrame frame;
    Rectangle2D firstRect, secondRect, thirdRect, fourthRect;
    Graphics2D g2;
    Boolean onFirst, onSecond, onThird, onFourth;
    Boolean gameAlreadyRunning;
    Boolean multiplayer;
    String IP;

    public Menu(Boolean gameAlreadyRunning) {
        this.gameAlreadyRunning = gameAlreadyRunning;
        /*  frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.getContentPane().addMouseListener(this);
        frame.getContentPane().addMouseMotionListener(this);
        frame.setResizable(false); */

        onFirst = false;
        onSecond = false;
        onThird = false;
        onFourth = false;

        multiplayer = false;
    }

    public Menu() {
        
        this(false);
            addMouseListener(this);
        addMouseMotionListener(this);
        
    }

    @Override
    protected void paintComponent(Graphics g) {

        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int height = 30;
        int width = 125;

        firstRect = new Rectangle2D.Double(320, 80, width, height);
        secondRect = new Rectangle2D.Double(320, 180, width, height);
        thirdRect = new Rectangle2D.Double(320, 280, width, height);
        fourthRect = new Rectangle2D.Double(320, 380, width, height);

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, 800, 600);

        drawStrings(g2);
        drawRectOutlines(g2);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        if (gameAlreadyRunning) {
            if (firstRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.RESUME;
               
            } else if (secondRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.NEWGAME;
                repaint();
            } else if (thirdRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.MAINMENU;
                repaint();
            } else if (fourthRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.QUIT;
                System.exit(0);
            }
        } else if (State.state == State.MenuState.MP) {
            if (secondRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.CLIENT;
                repaint();
            } else if (thirdRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.HOST;
                repaint();
            } else if (fourthRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.MAINMENU;
                repaint();
            }
        } else {
            if (secondRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.SP;
              //  repaint();
            } else if (thirdRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.MP;
                repaint();
            } else if (fourthRect.contains(e.getX(), e.getY())) {
                State.state = State.MenuState.QUIT;
                System.exit(0);
            }
        }

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        if (firstRect.contains(e.getX(), e.getY())) {
            onFirst = true;
        } else if (secondRect.contains(e.getX(), e.getY())) {
            onSecond = true;
        } else if (thirdRect.contains(e.getX(), e.getY())) {
            onThird = true;
        } else if (fourthRect.contains(e.getX(), e.getY())) {
            onFourth = true;
        } else {
            onFirst = false;
            onSecond = false;
            onThird = false;
            onFourth = false;
        }
        repaint();
    }

    private void drawStrings(Graphics2D g2) {
        g2.setColor(Color.ORANGE);
        if (gameAlreadyRunning) {
            g2.drawString("Resume", 360, 100);
            g2.drawString("New Game", 355, 200);
            g2.drawString("Main Menu", 355, 300);
            g2.drawString("Quit", 370, 400);
        } else if (State.state == State.MenuState.MP) {
            g2.drawString("Client", 370, 200);
            g2.drawString("Host", 370, 300);
            g2.drawString("Main Menu", 355, 400);
        } else {
            g2.drawString("Singleplayer", 350, 200);
            g2.drawString("Multiplayer", 355, 300);
            g2.drawString("Quit", 370, 400);
        }
    }

    private void drawRectOutlines(Graphics2D g2) {

        g2.setColor(Color.DARK_GRAY);

        if (onFirst && gameAlreadyRunning) {
            g2.setColor(Color.ORANGE);
        }
        if (gameAlreadyRunning) {
            g2.draw(firstRect);
            g2.setColor(Color.DARK_GRAY);
        }

        if (onSecond) {
            g2.setColor(Color.ORANGE);
        }
        g2.draw(secondRect);
        g2.setColor(Color.DARK_GRAY);

        if (onThird) {
            g2.setColor(Color.ORANGE);
        }
        g2.draw(thirdRect);
        g2.setColor(Color.DARK_GRAY);

        if (onFourth) {
            g2.setColor(Color.ORANGE);
        }
        g2.draw(fourthRect);

    }

    public void setRunning(Boolean running) {
        gameAlreadyRunning = running;
    }

    public Boolean getRunning() {
        return gameAlreadyRunning;
    }
}
