/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author michal
 */
public class GameServer {

    Map clients;
    int maxConnections;
    int port;
    ServerSocket servSock; // server socket
    ConnectionHandler connHandler;

    public static void main(String[] args) {
        GameServer g = new GameServer();
    }

    public GameServer(int port, int maxConnections) {
        this.port = port;
        this.maxConnections = maxConnections;
        clients = new HashMap<String, Socket>();
        listenForConnections();
    }

    public GameServer() {
        this(findUsablePort(2000, 4000), 4);
    }

    private void listenForConnections(){
        try {
            servSock = new ServerSocket(port);
            System.out.printf("Server listening on port %d\n", port);
            connHandler = new ConnectionHandler(this, maxConnections);
            Thread t = new Thread(connHandler);
            t.start();
        } catch (IOException ex) {
            System.out.println("Error while attempting to listen for connections.");
            ex.printStackTrace();
        }
    }

    public void addClient(String name, GServerSocket clientSocket){
        clients.put(name, clientSocket);
    }

    // <editor-fold defaultstate="collapsed" desc="port utils">

    /**
     * Try and find a port that is not in use within the specified range of ports.
     * @param rangeStart
     * @param rangeEnd
     * @return
     */
    public static int findUsablePort(int rangeStart, int rangeEnd) {
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
    private static boolean validRange(int rangeStart, int rangeEnd) {
        int diff = rangeEnd - rangeStart;
        if (diff > 0 && rangeEnd > rangeStart && rangeStart > 0 && rangeEnd <= 65535) {
            return true;
        }
        return false;
    }
    // </editor-fold>
}
