/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Spawn;

import Weapon.*;
import Unit.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author danielcecil
 */
public class Spawn {

    private static Enemy spawn1;
    private static Enemy spawn2;
    Graphics g;
    
    public Spawn(){
        spawn1 = new Enemy(100, 100, new BasicWeapon(), 100, 200, 50, Color.GREEN);
        spawn2 = new Enemy(100, 100, new BasicWeapon(), 100, 600, 50, Color.GREEN);

    }

    public Enemy newSpawn(){
        Enemy en;
        Random r = new Random();
        int rand = r.nextInt(2);
        if(rand == 0){
            en = spawn1;
        } else {
            en = spawn2;
        }
        return en;
    }

}
