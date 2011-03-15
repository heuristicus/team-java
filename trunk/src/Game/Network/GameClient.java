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
public class GameClient {
    
    private final String serverHost;
    private final int serverPort;
    GClientSocket sock;

    public static void main(String[] args) {
        GameClient c = new GameClient("localhost", 2000);
        c.connectToServer();
        c.disconnect();
    }

    public GameClient(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void connectToServer(){
        sock = new GClientSocket(serverHost, serverPort);
    }

    public void disconnect(){
        sock.disconnect();
    }

    public void sendOwnGameState(GameState currentState){
        try {
            sock.sendObject(currentState);
        } catch (IOException ex) {
            System.out.println("Failed to send the game state to the server.");
            ex.printStackTrace();
        }
    }

    public GameState getServerGameState(){
        try {
            GameState nG = (GameState) sock.readObject();
            return nG;
        } catch (IOException ex) {
            System.out.println("IO exception while attempting to get server game state.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find class of object to convert to.");
            ex.printStackTrace();
        }
        return null;
    }

}
