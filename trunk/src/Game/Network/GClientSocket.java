/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author michal
 */
public class GClientSocket {

    public static void main(String[] args) {
        GClientSocket s = new GClientSocket();
    }

    public GClientSocket() {
        try {
            Socket s = new Socket("localhost", 2000);
            ObjectOutputStream t = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream n = new ObjectInputStream(s.getInputStream());
            while (true){
                t.writeObject("TEEST");
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
