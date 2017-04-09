/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Boys;
import model.Couples;
import model.Gifts;

/**
* <h1>FindMyGirlUsingSortedArray Class</h1>
* <p> This class defines method to find Girlfriend of given boy using Binary Search</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class FindMyGirlUsingSortedArray extends MyGfFinder{
    private ArrayList<Couples> couples = null;
    
     /**
     * constructor to initialise couples attribute
     * @param c ArrayList of Couples
     */
    
    public FindMyGirlUsingSortedArray (ArrayList<Couples> c) {
        this.couples = c;
    }
    
    /**
     * Binary Search Algorithm
     * @param name name of boy 
     * @param boys sorted ArrayList of boys
     * @return null or Boys object found for given name
     */
    
    private Boys binarySearch (String name, ArrayList<Boys> boys) {
        
        int l, r, mid, cmp;
        l = 0; r = boys.size()-1;
        while (l <= r) {
            mid = l + (r-l)/2;
            cmp = name.compareTo(boys.get(mid).getName());
            if (cmp == 0) {
                return boys.get(mid);
            }else if (cmp < 0) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        
        return null;
    }
    
     /**
    * Override method to find girlfriend of given boy using Binary Search
    * @param arr ArrayList of String name of Boys
    */
    
    @Override
    public void findMySweety (ArrayList<String> arr) {
        
        ArrayList<Boys> boys = new ArrayList<>();
        for (Couples c : couples) {
            boys.add(c.getBF());
        }
        
        boys.sort(Comparator.comparing(Boys::getName));  
        setPrintStream("FindLog.txt");
        System.out.println("***Finding Using Sorted Array***\n");
        Boys b;
        for (String name : arr) {
            b = binarySearch(name, boys);
            if (b != null){
                System.out.println(name + "'s GirlFriend is " + b.getGF().getName());
            }else {
                System.out.println (name + " doesn't have any GirlFriend ");
            }
        }
    }   
}
