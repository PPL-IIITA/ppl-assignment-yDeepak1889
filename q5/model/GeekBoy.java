/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
* <h1>Geek Boy Class</h1>
* <p> This class contains basic information about Geek Boys and methods to retrieve those information.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class GeekBoy extends Boys{
    
     
    /**
     * <p>Constructor to initialise attributes for Geek Boys Object by Calling Super class construtor</p>
     * @param name Boy's Name
     * @param type Boy's Type 0, 1 or 2
     * @param attractiveness Boy's attractiveness on scale of 1-10
     * @param intelligence Boy's intelligence on scale of 1-10
     * @param budget budget for girlfriend
     * @param  minAttractiveness Minimum requirement for GF's attractiveness
     */
    
    
    public GeekBoy (String name, int type, int attractiveness, int intelligence,  int budget,  int minAttractiveness) {
        super(name, type, attractiveness, intelligence, budget, minAttractiveness);
    }
    
    /**
     * Calculates Happiness Value according to algirithm given in question
     * @param gf Geek Boy's GirlFriend
     * @return int happiness Value 
     */
    
    public double calHappiness (Girls gf) {
        return gf.getIntelligence();
    }
}
