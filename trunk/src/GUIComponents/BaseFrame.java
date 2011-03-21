/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Seems like somewhere in here we need to have the keylisteners and
 * mouselisteners, since the frame is what is focused when you're clicking and
 * pressing keys. This means that the mousecontrol and keyboardcontrol classes
 * should be instances of keylistener and mouselistener so that we can just
 * pass those to the addlistener methods. Of couse, this is only guesswork, since
 * i've not done it before. Many problems here. I suggest for the time being we do
 * it the simple way and just make listeners in here to listen for things.
 * But there's another problem! If we're using this frame as the main thing, and
 * we're swapping panels, then listeners have to do different things based on game
 * state - might be solvable if we reference the panel and get the game state.
 * 
 * @author michal
 */
/**
 * Constructor sets up the frame by adding the listeners required and creates a new controls object
 * @author Dave
 */
public class BaseFrame extends JFrame {

    private static Dimension _windowSize;
    JPanel cardPanel;
    GamePanel Single;
    GamePanel Server;
    GamePanel Client;
    MenuPanel menuPanel;

    enum Panels {

        SINGLE, MENU, MULTIS, MULTIC
    }
    // TODO change this to start from the menu. Will require a change in the init methods as well.
    Panels currentPanel = Panels.SINGLE;

    public BaseFrame(Dimension windowSize) {
        _windowSize = windowSize;
        setSize(windowSize);
//        Client = new GamePanel(this.getWidth(), this.getHeight(), "localhost", 2000); // client
////        this.setTitle("client");
//        Server = new GamePanel(this.getWidth(), this.getHeight(), 2000, 4); //server
////        this.setTitle("server");
        Single = new GamePanel(this.getWidth(), this.getHeight());
        this.setTitle("Single Player");
        menuPanel = new MenuPanel();
        initCardLayoutPanel();
        initFrame();
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setEnabled(true);
        add("Center", cardPanel);
        Single.initialize();
        setVisible(true);
        waitForPanelChangeRequest();
    }

    private void initCardLayoutPanel() {
        cardPanel = new JPanel(new CardLayout());
        cardPanel.add(Single, "Single");
        cardPanel.add(Server, "Server");
        cardPanel.add(Client, "Client");
        cardPanel.add(menuPanel, "Menu");
    }

    /**
     * Waits for a boolean in the game to be switched to a state in which it wants
     * the panel changed.
     */
    private void waitForPanelChangeRequest() {
        while (true) {
            switch (currentPanel) {
                case SINGLE:
                    boolean Temp1 = Single.getPanelSwitchRequest();
                    if (Temp1 == true) {
                        switchPanels();
                    }
                    break;
                case MULTIC:
                    boolean Temp2 = Client.getPanelSwitchRequest();
                    if (Temp2 == true) {
                        switchPanels();
                    }
                    break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.printf("Thread interrupted at %s, method %s\n", this.getClass().toString(), "waitforpanelchangerequest");
                ex.printStackTrace();
            }
        }
    }

    /**
     * Switches the panel to the next panel. The frame starts off in the
     * first panel added to the cardlayout in the initcardlayoutpanel method.
     *
     * !!!!!!!!!This method assumes that there are only two panels!!!!!!!!!!!!!!
     */
     public void switchPanels() {
        CardLayout l = (CardLayout) cardPanel.getLayout();
        switch (currentPanel) {
            case SINGLE:
                l.next(cardPanel);
                currentPanel = Panels.MENU;
                break;
            case MENU:
                /* TODO set any variables that need setting or
                 * methods that need executing (in the menu) when the menu is quit here.
                 * !!!!!Also use this to pass things from the menu to the game !!!!
                 */
                l.next(cardPanel);
                Single.regainFocus();
                Single.setRun(true);
                currentPanel = Panels.SINGLE;
                break;
        }
    }

    public static Dimension getWindowSize() {
        return _windowSize;
    }
}
