package utility;
import model.Couples;
import model.Boys;
import model.Girls;
import model.Gifts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.*;
/**
* <h1>Utils Class</h1>
* <p> This class contains method to form couples, to allocate gifts and to get k most happy and k most compatible couples.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/
public class utils {
    
    private ArrayList<Boys> boys = null;
    private ArrayList<Girls> girls = null;
    private ArrayList<Gifts> gifts = null;
    private getDataFromFile getData = null;
    private ArrayList<Couples> couples = null;
    
    /**
     * <p>Initialises Boys ArrayList , Girls ArrayList and Gifts ArrayList</p>
     */
    
    public utils() {
        getData = new getDataFromFile();
        boys = getData.getBoys();
        girls = getData.getGirls();
        gifts = getData.getGifts();
    }
   
    /**
     * Forms couples according to algorithm mentioned in question
     */
    
    public void formCouples() {
        int i, j;
        Boys b;
        Girls g;
        setPrintStream("Log1.txt");
        
        couples = new ArrayList<>();
        
        for (i = 0; i < girls.size(); i++) {
            g = girls.get(i);
            
            switch(g.getCriterion()) {
                case 0:
                    boys.sort(Comparator.comparing(Boys::getAttractiveness)); 
                    break;
                case 1:
                    boys.sort(Comparator.comparing(Boys::getIntelligence));
                    break;
                case 2:
                    boys.sort(Comparator.comparing(Boys::getBudget));
                    break;
            }
            
            for (j = 0; j < boys.size(); j++) {
                b = boys.get(j);
         
                if (b.getCommited() == false && b.getBudget() >= g.getMaintenance() && g.getAttractiveness() >= b.getMinAttractiveness()) {
                    b.setCommited(true);
                    g.setCommited(true);
                    b.setGF(g);
                    g.setBF(b);
                    couples.add(new Couples(b, g));
         
                    System.out.println(g.getName() + " got committed to " + b.getName() + " on "+ LocalDate.now()+" "+LocalTime.now());
                    
                    break;
                }
            }
        }
       
    }
    
    /**
     * This method allocates Gifts to couples according to their requirement
     */
    
    public void allocateGifts() {
        int totalCost = 0;
        int capacity = 0;
        gifts.sort(Comparator.comparing(Gifts::getPrice));  
        for (Couples c : couples) {
            capacity = c.getBF().getBudget();
            totalCost = 0;
            for (Gifts g : gifts) {
                if (totalCost + g.getPrice() <= capacity) {
                    c.addGift(g);
                    totalCost = totalCost + g.getPrice();
                }else if (totalCost < c.getGF().getMaintenance()){
                    totalCost+=g.getPrice();
                    c.getBF().increaseBudget(totalCost);
                    c.addGift(g);
                    break;
                }else {
                    break;
                }
            }
            
            c.onGiftingFinish();
        }
        
    }
    
    /**
     * This method writes k most  HAPPY COUPLES to file K_MostHappy.txt
     * @param n value of k
     */
    
    public  void k_mostHappyCouples (int n) {
        DecimalFormat df = new DecimalFormat("#.0000"); 
        df.setRoundingMode(RoundingMode.CEILING);
        setPrintStream ("K_MostHappy.txt");
        couples.sort(Comparator.comparing(Couples::getHappiness));
         int last = couples.size();
         for (int i = 0; i < n; i++) {
             System.out.println((i+1) + ": " + couples.get(last-1-i).getGF().getName() + " And "+ couples.get(last-1-i).getBF().getName() +" , Happiness Value " + df.format(couples.get(last-1-i).getHappiness()));
         }
    }
    
    /**
     * This method writes k most  COMPATIBLE COUPLES to file K_MostCompatible.txt
     * @param n value of k
     */
    
    public  void k_mostCompatibleCouples (int n) {
         setPrintStream ("K_MostCompatible.txt");
         couples.sort(Comparator.comparing(Couples::getCompatibility));
         int last = couples.size();
         for (int i = 0; i < n; i++) {
             System.out.println((i+1) + ": " + couples.get(last-1-i).getGF().getName() + " And "+ couples.get(last-1-i).getBF().getName() +" , Compatibility Value " + couples.get(last-1-i).getCompatibility());
         }
    }
    
    /**
     * Helper Method to change Print Stream from console to file
     * @param fileName fileName in witch output should be redirected
     */
    
    private void setPrintStream (String fileName) {
         try{
            PrintStream o = new PrintStream(new File(fileName));
            PrintStream console = System.out;
            System.setOut(o);
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }
        
    }
    
    
    /**
     * Method to write gifts' List for each couple
     */
    
    public void getAllGiftingDetails() {
        ArrayList<Gifts> gift;
        setPrintStream ("Gifting.txt");
        int ctr;
        for (Couples c : couples) {
            
            System.out.println ("Following Gifts are given by " + c.getBF().getName() + " to " + c.getGF().getName());
            gift = c.getGifts();
            ctr = 1;
            for (Gifts g : gift) {
                System.out.println (ctr + ":   " + "Gift Type -: " + Gifts.GIFT_TYPE[g.getType()] + ",    Price -: " + g.getPrice() + ",    Value -: " + g.getValue());
                ctr++;
            }
            System.out.println();
        }
    }
}
