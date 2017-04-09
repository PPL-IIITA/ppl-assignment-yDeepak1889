/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
* <h1>Normal Girls Class</h1>
* <p> This class contains basic information about Normal Girl and methods to retrieve those information .</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class normalGirl extends Girls{
    
    /**
     * <p>Constructor to initialise attributes for Normal Girl's Object by calling super class constructor</p>
     * @param name Girl's Name
     * @param type Girl's Type 0, 1 or 2
     * @param attractiveness Girl's attractiveness on scale of 1-10
     * @param intelligence Girl's intelligence on scale of 1-10
     * @param maintenance total maintenance cost
     * @param  criterion 0 for Most Attractive , 1 for Most Rich and 2 for Most intelligence  
     */
    
    public normalGirl (String name, int type,  int attractiveness, int intelligence, int maintenance, int criterion) {
       super(name, type, attractiveness, intelligence, maintenance, criterion);
    }
    
    /**
     * Calculates Happiness Value according to algirithm given in question
     * @return int happiness Value 
     */
    
    public double calHappiness () {
        return getTotalGiftCostAchieved() / getMaintenance();
    }
}
