/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.io.IOException;

/**
 *
 * @author michal
 */
public class ServerSocketListener implements Runnable{

    GServerSocket sock;
    GameServer server;

    public ServerSocketListener(GServerSocket sock, GameServer server) {
        this.sock = sock;
        this.server = server;
    }

    public void listen() {
        while (!Thread.interrupted()) {
//            System.out.println("listening");
            try {
                String s = (String) sock.readObject();
                if (s.equals("disconnect")){
                    System.out.println("disconnect request from client");
                    sock.disconnect(false);
                }
                if (s.equals("clientstate")){
//                    System.out.println("client sending state");
                    // read the state from the client. need to give the name
                    // due to the way the server stores stuff.
                    server.readState(sock.sockName);
                }
            } catch (IOException ex) {
                System.out.println("IO exception while getting a string from the stream.");
//                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Could not find the class definition while converting object.");
//                ex.printStackTrace();
            }
        }
        System.out.println("Listener thread interrupted " + this.hashCode());
    }

    public void run() {
        listen();
    }
}
