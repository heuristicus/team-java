/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import Background.Background;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Dave
 */
public class MenuPanel extends JPanel implements ActionListener {

    Map buttons;
    boolean switchReq = false;
    int buttonPress;
    private boolean Start;
    Background background;
    Timer timer;

    public MenuPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setFocusable(true);
        initButtons();
        setBackground(Color.BLACK);

//        timer = new Timer(20, new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                background.tick();
//            }
//        });
//        timer.start();
    }

    private void initButtons() {
        buttons = new HashMap<String, JButton>();

        JButton res = new JButton("Resume");
        JButton sp = new JButton("Single Player");
        JButton mp = new JButton("Multiplayer");
        JButton quit = new JButton("Quit");

        buttons.put("res", res);
        buttons.put("sp", sp);
        buttons.put("mp", mp);
        buttons.put("quit", quit);
        Set keys = buttons.keySet();
//        this.add(Box.createHorizontalStrut(300));
        for (Object object : keys) {
            JButton curButton = (JButton) buttons.get(object);
            curButton.setAlignmentX(5);
            this.add(curButton);
            this.add(Box.createVerticalStrut(20));
            curButton.addActionListener(this);
        }
        background = new Background(40);
    }

    public void actionPerformed(ActionEvent e) {

        String pressed = e.getActionCommand();
        if (pressed.equals("Resume")) {

            switchReq = true;
        } else if (pressed.equals("Single Player")) {
            Start = true;
            buttonPress = 1;
            switchReq = true;
            System.out.println("sp");
        } else if (pressed.equals("Multiplayer")) {
            Start = true;
            buttonPress = 2;
            JOptionPane.showMessageDialog(this, "Haha, you must be joking.");
        } else if (pressed.equals("Quit")) {
            System.exit(0);
        }


    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        //  background.draw(g2);
//    }

    /**
     * Sets the menu to be in a certain state - either a game is in place, or
     * there is no game in place. This will disable certain buttons.
     */
    public void setState() {
    }

    public int getButtonPress() {
        return buttonPress;
    }

    public boolean isStart() {
        return Start;
    }

    public void setStart(boolean Start) {
        this.Start = Start;
    }

    /**
     * Checks if the switchpanel variable is true. this indicates that the user
     * has pressed escape and so the frame should switch to the game.
     * @return
     */
    public boolean getPanelSwitchRequest() {
        System.out.println("switch req menu");
        if (switchReq == true) {
            System.out.println("switch true");
            switchReq = false;
            return true;
        }
        return false;
    }
}
