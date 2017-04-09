/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Random;
import model.Boys;
import model.Gifts;
import model.Girls;
import utility.getDataFromFile;
import utility.utils;
import model.Couples;
import utility.FindMyGirlUsingArray;
import utility.FindMyGirlUsingHash;
import utility.FindMyGirlUsingSortedArray;
import utility.MyGfFinder;
/**
 * <h1> Main Class </h1>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class Q7 {

    private static ArrayList<Boys> boys = null;
    private static ArrayList<Girls> girls = null;
    private static ArrayList<Gifts> gifts = null;
    private static getDataFromFile getData = null;
    private static ArrayList<Couples> couples = null;    
    /**
     * <p> Driver method</p>
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        getData = new getDataFromFile();
        boys = getData.getBoys();
        girls = getData.getGirls();
        gifts = getData.getGifts();
        
        utils alloc = new utils(boys, girls, gifts);
        couples = new ArrayList<>(); 
        
        alloc.formCouplesByMethod1(couples); // Forms couples 
       
        alloc.allocateGifts(couples, gifts); // Allocates Gifts
        
        MyGfFinder finder;
        ArrayList<String> arr = new ArrayList<>();
        arr.add("B1");
        arr.add("B2");
        arr.add("B10");
        arr.add("B13");
        
        Random rand = new Random();
        int num = rand.nextInt(3) + 1;// k=1 for Simple Array, k=2 for Sorted Array, k=3 for hash Map
		
        switch(num) {
            case 1 : finder = new FindMyGirlUsingArray(couples);
            			 break;
            case 2 : finder = new FindMyGirlUsingHash(couples);
				 break;
            case 3 : finder = new FindMyGirlUsingSortedArray(couples);
				 break;
            default : finder = new FindMyGirlUsingArray(couples);
	}
		
        finder.findMySweety(arr);
    }
    
}
