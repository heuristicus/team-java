/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import java.net.Socket;

/**
 *
 * @author michal
 */
public class GServerSocket {

    Socket sock;
    int port;

    public GServerSocket(int port) {
        this.port = port;
    }
}
