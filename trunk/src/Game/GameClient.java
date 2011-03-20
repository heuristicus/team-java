/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GUIComponents.BaseFrame;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.sound.sampled.Port;

/**
 *
 * @author michal
 */
public class GameClient {

    private final String serverIP;
    private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 600);

    public GameClient(String serverIP) {
        this.serverIP = serverIP;
    }

    public void connectToServer() {
    }

    public static void main(String[] args) throws UnknownHostException {

        InetAddress ownIP = InetAddress.getLocalHost();
        System.out.println("ClientIP: " + ownIP);
        BaseFrame baseFrame = new BaseFrame(DEFAULT_WINDOW_SIZE);
        BufferedReader in = null;
        PrintStream out = null;

        int testPort = 2000;


        try {
            Socket s;

            s = new Socket(ownIP, testPort);

            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintStream(s.getOutputStream());


        } catch (Exception e) {
        }

        //Set methods below here


    }

    public void clientStuff(ArrayList list) throws UnknownHostException {
        InetAddress ownIP = InetAddress.getLocalHost();
        System.out.println("ClientIP: " + ownIP);
        BaseFrame baseFrame = new BaseFrame(DEFAULT_WINDOW_SIZE);
        BufferedReader in = null;
        PrintStream out = null;

        int testPort = 2000;


        try {
            Socket s;

            s = new Socket(ownIP, testPort);

            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintStream(s.getOutputStream());


        } catch (Exception e) {
        }
    }
}
