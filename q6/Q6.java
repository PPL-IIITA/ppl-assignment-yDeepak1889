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
 *
 * @author ydeepak
 */
public class Q6 {

    private static ArrayList<Boys> boys = null;
    private static ArrayList<Girls> girls = null;
    private static ArrayList<Gifts> gifts = null;
    private static getDataFromFile getData = null;
    private static ArrayList<Couples> couples = null;    
    /**
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
      
        alloc.breakUpT(1, couples, boys, girls, gifts);
    }
    
}
