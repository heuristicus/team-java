/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michal
 */
public class GServerSocket implements Runnable {

    Socket sock;
    ObjectOutputStream objOut;
    ObjectInputStream objIn;
    ServerSocketListener listener;
    boolean killed;

    public GServerSocket(Socket sock) {
        this.sock = sock;
        killed = false;
        getStreams();
    }

    private void getStreams() {
        try {
            objIn = new ObjectInputStream(sock.getInputStream());
            objOut = new ObjectOutputStream(sock.getOutputStream());
        } catch (IOException ex) {
            System.err.println("Server socket unable to get streams.");
            ex.printStackTrace();
        }
    }

    public void disconnect(boolean sendMessage) {
        try {
            if (sendMessage) {
                sendObject("disconnect");
            }
            objOut.close();
            objIn.close();
            sock.close();
            killed = true;
            Thread.currentThread().interrupt();
            System.out.println("Client disconnected.");
        } catch (IOException ex) {
            System.out.println("Error while disconnecting socket." + this.hashCode());
            ex.printStackTrace();
        }
    }

    public void printString(String s) {
        System.out.println(s + this.hashCode());
    }

    public void sendObject(Object o) throws IOException {
        objOut.writeObject(o);
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        return objIn.readObject();
    }

    public void run() {
        listener = new ServerSocketListener(this);
        listener.listen();
    }
}
