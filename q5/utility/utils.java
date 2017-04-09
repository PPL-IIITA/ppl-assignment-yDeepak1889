package utility;
import model.Couples;
import model.Boys;
import model.Girls;
import model.Gifts;
import java.util.ArrayList;
import java.util.Comparator;
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
* @since   2017-04-10
*/
public class utils {
    
    private ArrayList<Boys> boys = null;
    private ArrayList<Girls> girls = null;
    private ArrayList<Gifts> gifts = null;    
    /**
     * <p>Initialises Boys ArrayList , Girls ArrayList and Gifts ArrayList</p>
     * @param boys ArrayList Boys
     * @param girls ArrayList Girls
     * @param gifts ArrayList Gifts
     */
    
    public utils(ArrayList<Boys> boys, ArrayList<Girls> girls, ArrayList<Gifts> gifts) {
        this.boys = boys;
        this.girls = girls;
        this.gifts = gifts;
    }
   
   /**
    * <p> Finds Boyfriend for a girl
    * @param couples ArrayList of couples
    * @param g girl for which boyfriend to be searched
    * @param boys ArrayList of all boys
    */
    
    private  void getBoyForSweetGirl (ArrayList<Couples> couples, Girls g, ArrayList<Boys> boys) {
        int j;
        Boys b;
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
         
                if (b.getCommited() == false && g.getCommited() == false && b.getBudget() >= g.getMaintenance() && g.getAttractiveness() >= b.getMinAttractiveness() && (g.getBF() == null || !g.getBF().getName().equals(b.getName()))) {
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
    
     /**
    * 
    *<p> Forms couples according to algorithm  mentioned for question1</p>
    * @param couples empty ArrayList of Couples to be filled with formed couples
    */
    
    public void formCouplesByMethod1 (ArrayList<Couples> couples) {
        int i;
        Girls g;
        setPrintStream("Log1.txt");
        
        for (i = 0; i < girls.size(); i++) {
            g = girls.get(i);
            getBoyForSweetGirl(couples, g, boys);
        }
    }
    
    /**
     * This method allocates Gifts to couples according to their budget
     * @param couples ArrayList of formed couples
     */
    
    public void allocateGifts(ArrayList<Couples> couples) {
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
    
    public  void k_mostHappyCouples (ArrayList<Couples> couples, int n) {
        DecimalFormat df = new DecimalFormat("#.0000"); 
        df.setRoundingMode(RoundingMode.CEILING);
        setPrintStream ("K_MostHappy.txt");
        couples.sort(Comparator.comparing(Couples::getHappiness));
         int last = couples.size();
         for (int i = 0; i < n; i++) {
            // System.out.println(i);
             System.out.println((i+1) + ": " + couples.get(last-1-i).getGF().getName() + " And "+ couples.get(last-1-i).getBF().getName() +" , Happiness Value " + df.format(couples.get(last-1-i).getHappiness()));
         }
    }
    
    /**
     * This method writes k most  COMPATIBLE COUPLES to file K_MostCompatible.txt
     * @param n value of k
     */
    
    public  void k_mostCompatibleCouples (ArrayList<Couples> couples, int n) {
         setPrintStream ("K_MostCompatible.txt");
         couples.sort(Comparator.comparing(Couples::getCompatibility));
         int last = couples.size();
         for (int i = 0; i < n; i++) {
            // System.out.println(i);
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
    * @param couples ArrayList of formed couples
    */
    public void getAllGiftingDetails(ArrayList<Couples> couples) {
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
    
    /**
     * Search girlfriend for a boy
     * @param couples ArrayList of couples
     * @param b boy for which girlfriend to be searched
     * @param girls ArrayList of Girls
     */
    
    private void getGirlForBoy (ArrayList<Couples> couples, Boys b, ArrayList<Girls> girls) {
        int j;
        Girls g;
        for (j = 0; j < girls.size(); j++) {
                g = girls.get(j);
         
                if (b.getCommited() == false && g.getCommited() == false && b.getBudget() >= g.getMaintenance() && g.getAttractiveness() >= b.getMinAttractiveness() && (g.getBF() == null || !g.getBF().getName().equals(b.getName()))) {
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
    
      /**
    * 
    *<p> Forms couples according to algorithm  mentioned for question4</p>
    * @param couples empty ArrayList of Couples to be filled with formed couples
    */
    
    public void formCouplesByMethod4 (ArrayList<Couples> couples) {
      
         setPrintStream("Log2.txt");
         
         boys.sort(Comparator.comparing(Boys::getAttractiveness)); 
         girls.sort(Comparator.comparing(Girls::getMaintenance));
         
         ArrayList<Girls> tempArrGirl = new ArrayList<>();
         ArrayList<Boys> tempArrBoy = new ArrayList<>();
         tempArrGirl.addAll(girls);
         tempArrGirl.sort(Comparator.comparing(Girls::getAttractiveness));
         tempArrBoy.addAll(boys);
         
         int size = girls.size();
         int i;
         Girls g;
         Boys b;
         
         boolean flagBoyTurn = false;
         
         for (i = 0; i < size; ) {
             g = null;
             b = null;
             if (flagBoyTurn) {
                 int j;
                 for (j = 0; j < boys.size(); j++) {
                     b = boys.get(j);
                     if (!b.getCommited()) {
                         break;
                     }
                 }
                 if(j!=boys.size())
                    getGirlForBoy(couples, b,  tempArrGirl);
                 flagBoyTurn = false;
             }else {
                 int j = 0;
                 for (j = 0; j < girls.size(); j++) {
                     g = girls.get(j);
                     if (!g.getCommited()) {
                         break;
                     }
                 }
                 if(j != girls.size()) {
                     getBoyForSweetGirl(couples, g, tempArrBoy);
                 }
                 i++;
                 flagBoyTurn = true;
             }
             
         }
    }
    
}
