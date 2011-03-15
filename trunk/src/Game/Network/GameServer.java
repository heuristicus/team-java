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
import java.util.Set;

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
    GameState currentState;
    Thread handlerThread;

    public static void main(String[] args) {
        GameServer g = new GameServer();
    }

    /**
     * Initialises with a specific port and number of connections
     * @param port
     * @param maxConnections
     */
    public GameServer(int port, int maxConnections) {
        this.port = port;
        this.maxConnections = maxConnections;
        clients = new HashMap<String, GServerSocket>();
        manageConnections();
    }

    /*
     * Connects to a default port range and initalises with a default player number.
     */
    public GameServer() {
        this(findUsablePort(2000, 4000), 4);
    }

    /**
     * Disconnects the server completely.
     */
    public void killServer(){
        Set clientKeys = clients.keySet();
        for (Object client : clientKeys) {
            GServerSocket s = (GServerSocket) clients.get(client);
            s.disconnect(true);
        }
        handlerThread.interrupt();
    }

    /**
     * Gets connections to the server from the connection handler. Runs in a separate thread.
     * the handler should also deal with when clients disconnect.
     */
    private void manageConnections() {
        try {
            servSock = new ServerSocket(port);
            System.out.printf("Server listening on port %d\n", port);
            connHandler = new ConnectionHandler(this, maxConnections);
            handlerThread = new Thread(connHandler);
            handlerThread.start();
        } catch (IOException ex) {
            System.out.println("Error while attempting to listen for connections.");
            ex.printStackTrace();
        }
    }

    public void addClient(String name, GServerSocket clientSocket) {
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
