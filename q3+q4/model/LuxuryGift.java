/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
* <h1>LuxuryGift Class</h1>
* <p> This class contains basic information and methods to retrieve information about Luxury Gift.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class LuxuryGift extends Gifts{
    
    private int luxuryRating;
    private int difficulty;
    
    /**
     * Initialises Luxury Gift Object by calling super class constructor and assigning value to attributes
     * @param type Type of Gift 0 for Essential, 1 for Luxury and 2 for Utility
     * @param value value of gift on scale of 1 - 20
     * @param price price of gift maximum value 130 and minimum value 30 
     * @param luxuryRating opt1 can be luxuryRating or utilityValue depending upon type of gift
     * @param difficulty opt2 can be difficulty or utilityClass depending upon type of gift
     */
    
    public LuxuryGift (int type, int value, int price, int luxuryRating, int difficulty) {
        
        super(type, value, price);
        
        this.luxuryRating = luxuryRating;
        this.difficulty = difficulty;
       
    }
    
    /**
     * Initialises luxuryRating attribute
     * @return int luxury Rating of Luxury Gift
     */
    
    public int getLuxuryRating(){
        return luxuryRating;
    }
    /**
     * Initialises difficulty attribute
     * @return int difficulty to obtain Luxury Gift
     */
    public int getDifficulty() {
        return difficulty;
    }
}
