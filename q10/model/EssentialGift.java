/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
* <h1>Essential Gift Class</h1>
* <p> This class contains basic information and methods to retrieve information about Essential Gift.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class EssentialGift extends Gifts{
    
    /**
     * Initialises Essential Gift object by calling super class constructor
     * @param type
     * @param value
     * @param price 
     */
    
     public EssentialGift (int type, int value, int price) {
       super(type, value, price);
    }
}
