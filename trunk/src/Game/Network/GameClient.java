/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Network;

import Unit.Player;
import java.io.IOException;

/**
 *
 * @author michal
 */
public class GameClient {

    private final String serverHost;
    private final int serverPort;
    GClientSocket sock;
    String name;
    GameState serverState;
    GameState ownState;
    boolean connected;
    int playerNumber;

    public static void main(String[] args) {
        GameClient c = new GameClient("localhost", 2000);
        c.connectToServer();
    }

    public GameClient(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        ownState = new GameState(); // init state with nothing in it to avoid null pointers.
        serverState = new GameState();
    }

    public void connectToServer() {
        sock = new GClientSocket(serverHost, serverPort, this);
        connected = true;
    }

    public void disconnect() {
        sock.disconnect(true);
        connected = false;
        Thread.currentThread().interrupt();
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public void setPlayerNumber(int number){
        this.playerNumber = number;
    }

    public void setOwnState(GameState state){
        ownState = state;
    }

    public GameState getCurrentServerState() {
        return serverState;
    }

    public void readName() {
        try {
            String clName = (String) sock.readObject();
            System.out.println(clName);
            this.name = clName;
        } catch (IOException ex) {
            System.out.println("IO exception while attempting to set the name of the client.");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found while setting client name.");
            ex.printStackTrace();
        }
    }

    /**
     * Sets the game state inside this object to the state most recently received
     * from the server.
     */
    public void readServerGameState() {
        try {
            GameState readState = (GameState) sock.readObject();
//            System.out.println(nG);
            serverState = readState;
        } catch (IOException ex) {
            System.out.println("IO exception while attempting to get server game state.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find class of object to convert to.");
            ex.printStackTrace();
        }
    }

    /**
     * Sends a game state to the server to show updates made. Some operations
     * are performed on the state passed to get only the changed objects, most likely
     * added projectiles and the player location. damage to enemies should also be
     * carried over.
     * @param currentState
     */
    public void sendGameState(GameState currentState) {
        try {
            ownState = currentState;
            GameState trimmedState = getStateChanges(currentState);
            sock.sendObject("clientstate");
            sock.sendObject(trimmedState);
        } catch (IOException ex) {
            System.out.println("Failed to send the game state to the server.");
            ex.printStackTrace();
        }
    }

    /**
     * returns a game state containing the changed objects between the latest game
     * state and the state passed to the object. the state passed should be the
     * state created by the game panel.
     * @param state
     * @return
     */
    public GameState getStateChanges(GameState state) {
        GameState updateState = state.clone();
//        System.out.println(ownState);
//        System.out.println(serverState);
        updateState.removeDuplicates(serverState, playerNumber);
//        for (Projectile p : updateState.getProjectiles()) {
//            System.out.println(serverState.getProjectiles().contains(p));
//        }
        return updateState;
    }

    public boolean isConnected() {
        return connected;
    }
}
