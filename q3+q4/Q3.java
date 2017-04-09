/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import model.Boys;
import model.Gifts;
import model.Girls;
import utility.getDataFromFile;
import utility.utils;
import model.Couples;
/**
*<h1> Main Class </h1>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public class Q3 {

    private static ArrayList<Boys> boys = null;
    private static ArrayList<Girls> girls = null;
    private static ArrayList<Gifts> gifts = null;
    private static getDataFromFile getData = null;
    private static ArrayList<Couples> couples = null;    
    /**
     * <p> Driver Method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       getData = new getDataFromFile();
       boys = getData.getBoys();
       girls = getData.getGirls();
       gifts = getData.getGifts();
        
        utils alloc = new utils(boys, girls, gifts);
        couples = new ArrayList<>();
        alloc.formCouples(couples); // Forms couples 
        
        alloc.allocateGifts(couples); // Allocates Gifts
        alloc.k_mostHappyCouples(couples, 10); // Writes k Most Happy Couples to file k_MostHappy.txt
        alloc.k_mostCompatibleCouples(couples, 10); // Writes k Most Compatible Couples to file k_MostCompatible.txt
        alloc.getAllGiftingDetails(couples); // Writes gift list to file Gifting.txt fir each couple
        alloc.breakUp(couples, 3);
    }
    
}
