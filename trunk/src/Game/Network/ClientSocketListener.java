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
public class ClientSocketListener extends Thread{

    Socket sock;

    public ClientSocketListener(Socket s){
        sock = s;
    }

    @Override
    public void run() {
    }


}
