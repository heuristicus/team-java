/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.Network;

/**
 *
 * @author michal
 */
public class ConnectionHandler {

    GameServer server;
    int maxConnections;

    public ConnectionHandler(GameServer server, int maxConnections){
        this.server = server;
        this.maxConnections = maxConnections;
    }

    public void connectSockets(){

    }

}
