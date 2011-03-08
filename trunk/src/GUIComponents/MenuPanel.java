/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

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

/**
 *
 * @author Dave
 */
public class MenuPanel extends JPanel implements ActionListener {

    Map buttons;
    boolean switchReq = false;

    public MenuPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setFocusable(true);
        initButtons();
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
    }

    public void actionPerformed(ActionEvent e) {

        String pressed = e.getActionCommand();
        if (pressed.equals("Resume")) {
            switchReq = true;
        } else if (pressed.equals("Single Player")) {
            System.out.println("sp");
        } else if (pressed.equals("Multiplayer")) {
            JOptionPane.showMessageDialog(this, "Haha, you must be joking.");
        } else if (pressed.equals("Quit")) {
            System.exit(0);
        }


    }

    /**
     * Sets the menu to be in a certain state - either a game is in place, or
     * there is no game in place. This will disable certain buttons.
     */
    public void setState() {
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
