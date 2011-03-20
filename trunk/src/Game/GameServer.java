/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GUIComponents.BaseFrame;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class GameServer {

    ArrayList<Socket> clients;
    private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 600);

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ownIP = InetAddress.getLocalHost();
        System.out.println("ServerIP: " + ownIP);
        BaseFrame baseFrame = new BaseFrame(DEFAULT_WINDOW_SIZE);
        BufferedReader in = null;
        PrintStream out = null;




        GameServer g = new GameServer();
        int port = g.findUsablePort(2000, 3000);


        try {
            Socket s;

            s = new Socket(ownIP, port);

            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintStream(s.getOutputStream());




        } catch (Exception e) {
        }
    }

    public void ServerStuff(ArrayList list) throws UnknownHostException {
        InetAddress ownIP = InetAddress.getLocalHost();
        System.out.println("ServerIP: " + ownIP);
        BaseFrame baseFrame = new BaseFrame(DEFAULT_WINDOW_SIZE);
        BufferedReader in = null;
        PrintStream out = null;




        GameServer g = new GameServer();
        int port = g.findUsablePort(2000, 3000);


        try {
            Socket s;

            s = new Socket(ownIP, port);

            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintStream(s.getOutputStream());




        } catch (Exception e) {
        }
    }

    public GameServer() {
    }

    /**
     * Try and find a port that is not in use within the specified range of ports.
     * @param rangeStart
     * @param rangeEnd
     * @return
     */
    public int findUsablePort(int rangeStart, int rangeEnd) {
        if (!validRange(rangeStart, rangeEnd)) {
            rangeStart = 2000;
            rangeEnd = 3000;
            System.err.printf("Invalid range entered. using the range %d to %d instead.\n", rangeStart, rangeEnd);
        }
        int usablePort = Integer.MIN_VALUE;
        ServerSocket testSock = null;
        for (int i = rangeStart; i <= rangeEnd; i++) {
            try {
                testSock = new ServerSocket(i);
                usablePort = i;
                System.out.printf("Port %d is available.\n", usablePort);
                break;
            } catch (IOException ex) {
                System.out.printf("Port %d in use.\n", i);
            } finally {
                try {
                    testSock.close();
                } catch (IOException ex) {
                    System.err.printf("Unable to close the test socket at port %d\n", i);
                } catch (Exception ex) {
                    System.err.println("Some other error ocurred while trying to close the test socket. "
                            + "The connection was probably null. This shouldn't be a problem.");
                }
            }
        }
        return usablePort;
    }

    /**
     * Checks whether a port range specified is valid.
     * @param rangeStart
     * @param rangeEnd
     * @return
     */
    private boolean validRange(int rangeStart, int rangeEnd) {
        int diff = rangeEnd - rangeStart;
        if (diff > 0 && rangeEnd > rangeStart && rangeStart > 0 && rangeEnd <= 65535) {
            return true;
        }
        return false;
    }
}
