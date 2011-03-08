/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author michal
 */
public class PlayerDeathException extends Throwable{

    int deadPlayer;

    /**
     * Thrown when a player is removed by collision detection. 
     * @param message
     */
    public PlayerDeathException(int deadPlayer) {
        this.deadPlayer = deadPlayer;
    }

    public int getDeadPlayer(){
        return deadPlayer;
    }



}
