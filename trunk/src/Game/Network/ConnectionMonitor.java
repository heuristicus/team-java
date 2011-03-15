/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.util.Set;

/**
 *
 * @author michal
 */
public class ConnectionMonitor implements Runnable {

    private final GameServer server;

    public ConnectionMonitor(GameServer server) {
        this.server = server;
    }

    public void monitorConnections() {
        while (true) {
            System.out.println(server.clients);
            try {
                Thread.sleep(5000);
                Set clients = server.clients.keySet();
                for (Object key : clients) {
                    GServerSocket client = (GServerSocket) server.clients.get(key);
                    if (client != null) {
                        // FIXME would be nice to take this out, do proper threading
                        if (client.sock.isClosed()) {
                            System.out.println("socket was closed.");
                            server.clients.remove(key);
                        }
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted in monitorConnections");
                ex.printStackTrace();
            }
        }
    }

    public void run() {
        monitorConnections();


    }
}
