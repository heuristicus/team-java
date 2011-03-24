/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIComponents;

import GUIComponents.Menu.MenuState;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
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
    Menu menu;
    MenuState Type; // 1 for single, 2 for server, 3 for client
    private boolean start;

    enum Panels {

        SINGLE, MENU, MULTIS, MULTIC, RESUME
    }
    // TODO change this to start from the menu. Will require a change in the init methods as well.
    Panels currentPanel = Panels.MENU;

    public BaseFrame(Dimension windowSize) {
        _windowSize = windowSize;
        setSize(windowSize);
//        Single = new GamePanel(this.getWidth(), this.getHeight(), "localhost", 2000); // client
//        this.setTitle("client");
//       Single = new GamePanel(this.getWidth(), this.getHeight(), 2000, 4); //server
//        this.setTitle("server");
        //       Single = new GamePanel(this.getWidth(), this.getHeight()); //single player
//        this.setTitle("Single Player");
//        menuPanel = new MenuPanel();
        menu = new Menu();
        //       Single.initialize();
        music();
        initCardLayoutPanel();
        initFrame();
        setResizable(false);
        setEnabled(true);
    }

    private void music() {
        try {
            // From file
            Sequence sequence = MidiSystem.getSequence(new File(".//src//GUIComponents//Europe-FinalCountdown.mid"));
            // Create a sequencer for the sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            // Start playing
            sequencer.start();
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (MidiUnavailableException e) {
        } catch (InvalidMidiDataException e) {
        }
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setEnabled(true);
        add("Center", cardPanel);
        //Single.initialize();
        setVisible(true);
        waitForPanelChangeRequest();
    }

    private void initCardLayoutPanel() {
        cardPanel = new JPanel(new CardLayout());
        cardPanel.add(menu, "Menu");
        //      cardPanel.add(menu, "Menu");
        //cardPanel.add(Single, "Single");
        //       cardPanel.add(Server, "Server");
//        cardPanel.add(Client, "Client");
    }

    /**
     * Waits for a boolean in the game to be switched to a state in which it wants
     * the panel changed.
     */
    private void waitForPanelChangeRequest() {

        Thread td = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    Type = menu.getState();
                    switch (currentPanel) {
                        case SINGLE:
                            System.out.println("single");
                            boolean Temp1 = Single.getPanelSwitchRequest();
                            System.out.println(Temp1);
                            if (Single.switchPanel == true) {
                                currentPanel = currentPanel.RESUME;
                                break;
                            }
//                    if (menu.getState() == menu.getState().SP) {
//                        System.out.println("menstatesp");
//                        Temp1 = true;
//                    }
                            if (Temp1 == true) {
                                switchPanels();
                            }
                            break;
                        case MULTIC:
                            boolean Temp2 = Client.getPanelSwitchRequest();
                            System.out.println("client");
                            System.out.println(Temp2);
                            if (Temp2 == true) {
                                switchPanels();
                            }
                            break;

                        case MULTIS:
                            boolean Temp3 = Server.getPanelSwitchRequest();
                            System.out.println("serv");
                            System.out.println(Temp3);
                            if (Temp3 == true) {
                                switchPanels();
                            }
                            break;
                        case MENU:
                            System.out.println("menu");
                            boolean Temp4 = menu.getPanelSwitchRequest();
                            if (Single != null) {
                                boolean Temp5 = Single.getPanelSwitchRequest();
                                if (Temp5) {
                                    currentPanel = currentPanel.SINGLE;
                                    switchPanels();
                                }
                            }
                            System.out.println(Temp4);
                            if (Temp4 == true) {
                                switchPanels();
                            }
                            break;
                        case RESUME:

                            if (Type == menu.getState().RESUME) {

                                switchPanels();
                            }
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        System.out.printf("Thread interrupted at %s, method %s\n", this.getClass().toString(), "waitforpanelchangerequest");
                        ex.printStackTrace();
                    }
                }
            }
        });
        td.start();
    }

    /**
     * Switches the panel to the next panel. The frame starts off in the
     * first panel added to the cardlayout in the initcardlayoutpanel method.
     *
     * !!!!!!!!!This method assumes that there are only two panels!!!!!!!!!!!!!!
     */
    public void switchPanels() {
        Type = menu.getState();
        CardLayout l = (CardLayout) cardPanel.getLayout();

        switch (currentPanel) {
            case SINGLE:
                l.next(cardPanel);
                Single.regainFocus();
                currentPanel = Panels.MENU;
                break;
            case MENU:
                /* TODO set any variables that need setting or
                 * methods that need executing (in the menu) when the menu is quit here.
                 * !!!!!Also use this to pass things from the menu to the game !!!!
                 */
                l.next(cardPanel);
                if (menu.gameAlreadyRunning == false) {
                    System.out.println("running");
                    if (Type == menu.getState().SP) {
                        Single.regainFocus();
                        Single.setRun(false);
                        currentPanel = Panels.SINGLE;

                    } else if (Type == menu.getState().HOST) {
                        Server.regainFocus();
                        Server.setRun(true);
                        currentPanel = Panels.MULTIS;

                    } else if (Type == menu.getState().CLIENT) {
                        Client.regainFocus();
                        Client.setRun(true);
                        currentPanel = Panels.MULTIC;

                    }
                }
                if (menu.gameAlreadyRunning == true) {
                    System.out.println("running");
                    if (Type == menu.getState().SP) {
                        Single = new GamePanel(this.getWidth(), this.getHeight());
                        cardPanel.add(Single, "Single");
                        Single.initialize();
                        Single.regainFocus();
                        Single.setRun(true);
//                        currentPanel = Panels.SINGLE;

                    } else if (Type == menu.getState().HOST) {
                        Server = new GamePanel(this.getWidth(), this.getHeight(), 2000, 4);
                        cardPanel.add(Server, "Server");
                        Server.initialize();
                        Server.regainFocus();
                        Server.setRun(true);

                        currentPanel = Panels.MULTIS;
                        l.next(cardPanel);
                    } else if (Type == menu.getState().CLIENT) {
                        Client = new GamePanel(this.getWidth(), this.getHeight(), menu.getResponse(), 2000);
                        cardPanel.add(Client, "Client");
                        Client.initialize();
                        Client.regainFocus();
                        Client.setRun(true);
                        currentPanel = Panels.MULTIC;
                        l.next(cardPanel);
                    }
                }

                break;

            case MULTIS:
                if (Server.switchPanel == true) {
                    l.next(cardPanel);
                    currentPanel = Panels.MENU;
                }
                break;
            case MULTIC:
                if (Client.switchPanel == true) {
                    l.next(cardPanel);
                    currentPanel = Panels.MENU;
                }
                break;

        }
    }

    public static Dimension getWindowSize() {
        return _windowSize;
    }
}
