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
public class ClientSocketListener {

    GClientSocket sock;

    public ClientSocketListener(GClientSocket sock) {
        this.sock = sock;
    }

    public void listen() {
        while (!sock.sock.isInputShutdown()) {
            try {
                String s = (String) sock.readObject();
                if (s.equals("disconnect")){
                    sock.disconnect(false);
                }
                System.out.println(s);
            } catch (IOException ex) {
                System.out.println("IO exception while getting a string from the stream.");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Could not find the class definition while converting object.");
                ex.printStackTrace();
            }
        }
    }
}
