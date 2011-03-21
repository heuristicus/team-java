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
public class ClientSocketListener implements Runnable {

    GClientSocket sock;
    GameClient client;

    public ClientSocketListener(GClientSocket sock, GameClient client) {
        this.sock = sock;
        this.client = client;
    }

    public void listen() {
        while (!Thread.interrupted()) {
//            System.out.println("listening");
            try {
                String s = (String) sock.readObject();
//                System.out.println(s);
                if (s.equals("disconnect")) {
//                    System.out.println("got disconnect message.");
                    sock.disconnect(false);
                }
                if (s.equals("sockname")) {
//                    System.out.println("got set name message.");
                    client.readName();
                }
                if (s.equals("gamestate")){
//                    System.out.println("got sending game state message");
                    client.readServerGameState();
                }
            } catch (IOException ex) {
                System.out.println("IO exception while getting a string from the stream.");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Could not find the class definition while converting object.");
                ex.printStackTrace();
            }
        }
    }

    public void run() {
        System.out.println("running listener thread");
        listen();
    }
}
