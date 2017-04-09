/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.Collections;

/**
* <h1>KBestItems Class</h1>
* <p> This class contains method provide k best item of any type (generic) </p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class KBestItems {
    
    /**
     * Provides k best items from ArrayList of items
     * @param <Temp> type of item
     * @param source ArrayList from which k best items to be fetched
     * @param cmp ArrayList used to get k best items
     * @param k value of k for k best items
     * @return ArrayList of k best items
     */
    
    public <Temp> ArrayList<Temp> findKBest(ArrayList<Temp> source, ArrayList<Integer> cmp, int k) {
		int i,j;
		for(i=0;i<cmp.size()-1;i++) {
			for(j=i+1;j<cmp.size();j++) {
				if(cmp.get(j) < cmp.get(i)) {
					Collections.swap(cmp, i, j);
					Collections.swap(source, i, j);
				}
			}
		}
		if(k>source.size())
			k = source.size();
		ArrayList<Temp> res = new ArrayList<Temp>(source.subList(0, k-1));
		return res;
    }
    
}
