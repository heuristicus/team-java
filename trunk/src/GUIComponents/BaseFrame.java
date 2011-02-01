/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class BaseFrame {

    JFrame bFrame;
    int width, height;

    public BaseFrame(int width, int height) {
        this.width = width;
        this.height = height;
        initFrame();
    }

    /*
     * Initialises the frame. Sets the default close operation to exit.
     * Sets the width and height of the frame to the value passed in to
     * the constructor. Sets the frame to be enabled and sets it to be visible.
     */
    private void initFrame() {
        bFrame = new JFrame("ShootyThing");
        bFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bFrame.setSize(width, height);
        bFrame.setEnabled(true);
        bFrame.setVisible(true);
    }

    /**
     * Adds a panel to the frame.
     * @param addPanel Panel to add to the frame.
     */
    public void addPanel(JPanel addPanel) {
        bFrame.add(addPanel);
    }
    /**
     * Replaces the current panel in the frame with a new panel.
     * @param repPanel Panel to put into the frame.
     */
    public void replacePanel(JPanel repPanel) {
        bFrame.removeAll();
        bFrame.add(repPanel);
    }

}
