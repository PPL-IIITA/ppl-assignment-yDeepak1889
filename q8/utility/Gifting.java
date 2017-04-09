/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import model.Couples;
import model.Gifts;

/**
* <h1>Gifting Class</h1>
* <p> This abstract class contains method to allocate gifts </p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public abstract class Gifting {
    
    /**
     * abstract method to allocate gifts to couples
     * @param couples
     * @param gifts 
     */
    
    public abstract void allocateGift (ArrayList<Couples> couples, ArrayList<Gifts> gifts);
    
    /**
     * For every couple write all gifts to file Gifting.txt
     * @param couples ArrayList of formed Couples
     * @param method method 1 or method 2
     */
            
    public void getAllGiftingDetails(ArrayList<Couples> couples, int method) {
        ArrayList<Gifts> gift;
        setPrintStream ("Gifting.txt");
        System.out.println("***Allocating Gifts Using method "+method+"***\n");
        int ctr;
        for (Couples c : couples) {
            
            System.out.println ("Following Gifts are given by " + c.getBF().getName() + " to " + c.getGF().getName());
            gift = c.getGifts();
            ctr = 1;
            for (Gifts g : gift) {
                System.out.println (ctr + ":   " + "Gift Type -: " + Gifts.GIFT_TYPE[g.getType()] + ",    Price -: " + g.getPrice() + ",    Value -: " + g.getValue());
                ctr++;
            }
            System.out.println();
        }
    }
    /**
     * Helper Method to change Print Stream from console to file
     * @param fileName fileName in witch output should be redirected
     */
    
    private void setPrintStream (String fileName) {
         try{
            PrintStream o = new PrintStream(new File(fileName));
            PrintStream console = System.out;
            System.setOut(o);
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }
    }
}
