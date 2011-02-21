/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Spawn;

import GUIComponents.BaseFrame;
import Weapon.*;
import Unit.*;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author danielcecil
 */
public class Spawn {

    private static Enemy spawnEnemy;
    private static Enemy spawn2;
    private static int width = 800;
    
    public Spawn(){
        spawnEnemy = new Enemy(100, 100, new BasicWeapon(), 100, 50, 10, Color.GREEN);
        try{
            width = BaseFrame.getWindowSize().width;
        } catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * newSpawn method creates a new enemy at a random X coordinate on-screen
     * @return new Enemy
     */
    public Enemy newSpawn(){
        Enemy en;
        Random r = new Random();
        int rand = r.nextInt(width);    // random number between 0 and frame width
        spawnEnemy.setX(rand);
        en = spawnEnemy;
        return en;
    }

}
