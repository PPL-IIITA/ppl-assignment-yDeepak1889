/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
* <h1>UtilityGift Class</h1>
* <p> This class contains basic information and methods to retrieve information about Utility Gift.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class UtilityGift extends Gifts{
    
   private int utilityValue;
   private int utilityClass;
   
    /**
     * Initialises Utility Object Gift by calling super class constructor and assigning value to attributes
     * @param type Type of Gift 0 for Essential, 1 for Luxury and 2 for Utility
     * @param value value of gift on scale of 1 - 20
     * @param price price of gift maximum value 130 and minimum value 30 
     * @param utilityValue opt1 can be luxuryRating or utilityValue depending upon type of gift
     * @param utilityClass opt2 can be difficulty or utilityClass depending upon type of gift
     */
    
    public UtilityGift (int type, int value, int price, int utilityValue, int utilityClass) {
        
        super(type, value, price);
        
        this.utilityValue = utilityValue;
        this.utilityClass = utilityClass;
     }
    
    /**
     * Initialises utilityValue attribute
     * @return int utility value of Utility Gift
     */
    
    public int getUtilityValue() {
        return utilityValue;
    }
    /**
     * Initialises utilityClass attribute
     * @return int utility Class of Utility Gift
     */
    public int getUtilityClass() {
        return utilityClass;
    }
}
