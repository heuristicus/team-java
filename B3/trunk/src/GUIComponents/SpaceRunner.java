/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trunk.src.GUIComponents;

import java.awt.Dimension;

/**
 * Runs the whole bloody game, right from the top.
 * @author michal
 */
public class SpaceRunner {

    private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 600);

    public static void main(String[] args) {
        new SpaceRunner();
    }

    public SpaceRunner() {
        BaseFrame baseFrame = new BaseFrame(DEFAULT_WINDOW_SIZE);
    }



}
