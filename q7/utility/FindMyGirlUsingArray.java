/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;
import java.util.ArrayList;
import model.*;
/**
* <h1>FindMyGirlUsingArray Class</h1>
* <p> This class defines method to find Girlfriend of given boy using linear search</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class FindMyGirlUsingArray extends MyGfFinder{
   
    private ArrayList<Couples> couples = null;
    
    /**
     * constructor to initialise couples attribute
     * @param c ArrayList of Couples
     */
    public FindMyGirlUsingArray (ArrayList<Couples> c) {
        this.couples = c;
    }
    
   /**
    * Override method to find girlfriend of given boy using linear search
    * @param arr ArrayList of String name of Boys
    */
    
    @Override
    public void findMySweety (ArrayList<String> arr) {
        ArrayList<Boys> boys = new ArrayList<>();
        for (Couples c : couples) {
            boys.add(c.getBF());
        }
        boolean flag = false;
        setPrintStream("FindLog.txt");
        System.out.println("***Finding Using Simple Array***\n");
        for (String name : arr) {
            flag = false;
            for (Boys b : boys) {
                if (name.equals(b.getName())) {
                    System.out.println(name + "'s GirlFriend is " + b.getGF().getName());
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                System.out.println (name + " doesn't have any GirlFriend ");
            }
        }
    }
}
