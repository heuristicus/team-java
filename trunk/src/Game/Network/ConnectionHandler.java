/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author michal
 */
public class ConnectionHandler implements Runnable {

    GameServer server;
    int maxConnections;
    int numConnections;

    public ConnectionHandler(GameServer server, int maxConnections) {
        this.server = server;
        this.maxConnections = maxConnections;
        this.numConnections = 0;
    }

    public void connectSockets() {
        while (numConnections < maxConnections) {
            System.out.println("Waiting for a connection.");
            try {
                Socket s = server.servSock.accept();
                System.out.printf("Client at %s connected.\n", s.getInetAddress());
                numConnections++;
                System.out.println("added socket.");
                GServerSocket sock = new GServerSocket(s);
                Thread t = new Thread(sock);
                t.start();
                server.addClient("Client" + numConnections, sock);
            } catch (IOException ex) {
                System.out.println("IO Exception while attempting to connect a socket.");
                ex.printStackTrace();
            }
        }
    }


    public void run() {
        connectSockets();
    }
}
