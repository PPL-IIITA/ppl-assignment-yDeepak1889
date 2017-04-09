/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.Random;

/**
* <h1>RandomK Class</h1>
* <p> This class contains method to provide random item from ArrayList of items of any type (generic)</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class RandomK {
        
        /**
         * <p> Provides random item from ArrayList of all item
         * @param <Temp> type of item
         * @param source ArrayList of item of type Temp
         * @return object of type Temp
         */
        
	public <Temp> Temp selectRandom (ArrayList<Temp> source) {
		Random rand = new Random();
		int index = rand.nextInt(source.size());
		return source.get(index);
        }
}
