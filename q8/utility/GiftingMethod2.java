/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.Comparator;
import model.Couples;
import model.Gifts;
/**
* <h1>GiftingMethod2 Class</h1>
* <p> This class contains method to allocate gifts</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class GiftingMethod2 extends Gifting{
    
      
    /**
     * Allocate gifts to couples according to algorithm 2
     * @param couples ArrayList of formed couples
     * @param gifts ArrayList of all gifts
     */
    @Override
    public  void allocateGift (ArrayList<Couples> couples, ArrayList<Gifts> gifts) {
        gifts.sort(Comparator.comparing(Gifts::getPrice));  
        for (Couples c : couples) {
            allocateGiftForSingleCouple(c, gifts);
        }
        getAllGiftingDetails(couples, 2);
    }   
    
    
     /**
     * Allocates gift to a couple
     * @param c couple object
     * @param gifts ArrayList of all gifts
     */
    
     private void allocateGiftForSingleCouple (Couples c, ArrayList<Gifts> gifts) {
        int totalCost = 0;
        int capacity = 0;
        capacity = c.getBF().getBudget();
            totalCost = 0;
            
            for (Gifts g : gifts) {
                if (g.getType() == 0) {
                    if (g.getPrice() > c.getBF().getBudget()) {
                        c.getBF().increaseBudget(g.getPrice());
                    }
                    totalCost += g.getPrice();
                    c.addGift(g);
                    break;
                }
            }
            
            for (Gifts g : gifts) {
                if (g.getType() == 1) {
                    totalCost += g.getPrice();
                    if (totalCost > c.getBF().getBudget()) {
                        c.getBF().increaseBudget(totalCost);
                    }
                    c.addGift(g);
                    break;
                }
            }
            
            for (Gifts g : gifts) {
                if (g.getType() == 2) {
                    totalCost += g.getPrice();
                    if (totalCost > c.getBF().getBudget()) {
                        c.getBF().increaseBudget(totalCost);
                    }
                    c.addGift(g);
                    break;
                }
            }
            
            for (Gifts g : gifts) {
                if (totalCost + g.getPrice() <= capacity) {
                    c.addGift(g);
                    totalCost = totalCost + g.getPrice();
                }else if (totalCost < c.getGF().getMaintenance()){
                    totalCost+=g.getPrice();
                    c.getBF().increaseBudget(totalCost);
                    c.addGift(g);
                    break;
                }else {
                    break;
                }
            }
            
            c.onGiftingFinish();
    } 
}
