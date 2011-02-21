/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Spawn;

import GUIComponents.BaseFrame;
import Weapon.*;
import Unit.*;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danielcecil
 */
public class Spawn {

    private static int width = 800;
    private static int height = 600;
    private static int maxX, maxY;

    
    public Spawn(){
        try{
            width = BaseFrame.getWindowSize().width;
            height = BaseFrame.getWindowSize().height;
            maxX = width;
            maxY = height/3;
        } catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * setRandPosition method sets the Unit's x/y coordinates to a random position
     * within set bounds.
     * @param unit the Unit class to be modified
     * @return enemy at random location
     */
    public Point setRandPosition(){
        Random r = new Random();
        int randX = r.nextInt(maxX);
       // int randY = r.nextInt(maxY);
        int randY = r.nextInt(maxY);
        Point p = new Point(randX, randY);
        return p;
    }
    
    /**
     * newEnemy creates a new default unit at a random position
     * @return unit at random position
     */
    public Unit newDefaultUnit(){
        Unit en = new DefaultUnit(setRandPosition().x,setRandPosition().y);
        return en;
    }

    public Unit newEnemyUnit(){
        Unit en = new Enemy(100,100, new BasicWeapon(), 100, setRandPosition().x,
                setRandPosition().y, Color.cyan);
        return en;
    }

        public Unit newPlayerUnit(){
        Unit en = new Player(100,100, new BasicWeapon(), 100, setRandPosition().x,
                setRandPosition().y, Color.white);
        return en;
    }
    
    /**
     * spawnN method creates an Arraylist of n number of enemies.
     * @param n number of enemies to be spawned
     * @return Arraylist of new enemies
     */
    public ArrayList<Unit> spawnN(int n, int type){
        ArrayList<Unit> arr = new ArrayList();
        for(int i = 0; i < n; i++){
            if(type==0){arr.add(newDefaultUnit());} // 0 = Default Unit
            if(type==1){arr.add(newEnemyUnit());}   // 1 = Enemy Unit
            if(type==2){arr.add(newPlayerUnit());}  // 2 = Player Unit
            else{System.err.println("Type out of range");}
        }
        return arr;
    }



}
