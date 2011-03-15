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
public class ServerSocketListener {

    GServerSocket sock;

    public ServerSocketListener(GServerSocket sock) {
        this.sock = sock;
    }

    public void listen() {
        while (!Thread.interrupted()) {
            try {
                String s = (String) sock.readObject();
                if (s.equals("disconnect")){
                    sock.disconnect(false);
                } else {
                    sock.printString(s);
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
}
