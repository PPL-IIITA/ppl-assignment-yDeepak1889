/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import model.Boys;
import model.Couples;

/**
* <h1>FindMyGirlUsingHash Class</h1>
* <p> This class defines method to find Girlfriend of given boy using Hash table</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class FindMyGirlUsingHash extends MyGfFinder{
 
    private ArrayList<Couples> couples = null;
    /**
     * constructor to initialise couples attribute
     * @param c ArrayList of Couples
     */
    public FindMyGirlUsingHash (ArrayList<Couples> c) {
        this.couples = c;
    }
    
     /**
    * Override method to find girlfriend of given boy using Hash Table
    * @param arr ArrayList of String name of Boys
    */
    
    @Override
    public void findMySweety (ArrayList<String> arr) {
        Boys[] boys  = new Boys[100];
        int hash;
        setPrintStream("FindLog.txt");
        System.out.println("***Finding Using Hash Table***\n");
        for (Couples c : couples) {
            hash = Integer.parseInt(c.getBF().getName().replaceAll("[^0-9]", ""));
            boys[hash] = c.getBF();
        }
        
        for (String name : arr) {
            hash = Integer.parseInt(name.replaceAll("[^0-9]", ""));
            if (boys[hash] != null) {
                System.out.println(name + "'s GirlFriend is " + boys[hash].getGF().getName());
            }else {
                System.out.println (name + " doesn't have any GirlFriend ");
            }
        }
    }
}
