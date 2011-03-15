/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;

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
            monitorSockets(false);
            if (Thread.interrupted()) {
                System.out.println("Handler thread interrupted in connection monitoring.");
                return;
            }
            System.out.println(server.clients);
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
        monitorSockets(true);
    }

    /**
     * Similar to checksockets, but monitors sockets continuously rather than checking once
     * checks the sockets every 0.5 seconds to see if they have been killed, and if so,
     * removes them from the server's list.
     *
     * Pass true to this method to loop constantly and check, false will check
     * once and then exit the method.
     */
    public void monitorSockets(boolean continuous) {
        System.out.println(server.clients);
        if (continuous) {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("handler thread interrupted in socket monitoring.");
                    // thread was interrupted, so stop the method.
                    return;
                }

                try {
                    Thread.sleep(500); // wait a bit so we're not spamming a mass of requests.
                    if (checkSockets()) {
                        break;
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Thread interrupted in monitorConnections");
                    ex.printStackTrace();
                }
            }
        } else {
            checkSockets();
            return;
        }
        connectSockets();
    }

    /**
     * Checks if sockets have been killed and removes them from the server's list
     * returns true if some have been removed.
     * @return
     */
    public boolean checkSockets() {
        boolean sockRemoved = false;
        ArrayList<String> toRemove = new ArrayList<String>();
        Set clients = server.clients.keySet();
        for (Object key : clients) {
            GServerSocket client = (GServerSocket) server.clients.get(key);
            if (client != null) { // FIXME would be nice to take this out
                if (client.killed) {
                    System.out.println("socket was closed." + client.hashCode());
                    toRemove.add(key.toString());
                    numConnections--;
                    sockRemoved = true;
                }
            }
        }
        for (String key : toRemove) {
            server.clients.remove(key);
        }
        return sockRemoved;
    }

    public void run() {
        connectSockets();
    }
}
