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
import java.time.*;
import java.util.Collections;
/**
* <h1>Utils Class</h1>
* <p> This class contains method to form couples and to allocate gifts </p>
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
    * <p> Finds Boyfriend for a girl according to algorithm mentioned in question
    * @param couples ArrayList of couples
    * @param g girl for which boyfriend to be searched
    * @param boys ArrayList of all boys
    * @param k value of k to select best k items
    */
    
    private  void getBoyForSweetGirl (ArrayList<Couples> couples, Girls g, ArrayList<Boys> boys, int k) {
        KBestItems kbest = new KBestItems();
        ArrayList<Boys> kBoys = new ArrayList<>();
        ArrayList<Integer> cmp = new ArrayList<>();
         switch(g.getCriterion()) {
                case 0:
                    for (Boys bb : boys){
                        if (!bb.getCommited()){
                            cmp.add(bb.getAttractiveness());
                        }
                    }
                    kBoys = kbest.findKBest(boys, cmp, k);
                    kBoys.sort(Comparator.comparing(Boys::getBudget)); 
                    break;
                case 1:
                    for (Boys bb : boys){
                        if (!bb.getCommited()){
                            cmp.add(bb.getIntelligence());
                        }
                    }
                    kBoys = kbest.findKBest(boys, cmp, k);
                    kBoys.sort(Comparator.comparing(Boys::getAttractiveness)); 
                    break;
                case 2:
                    for (Boys bb : boys){
                        if (!bb.getCommited()){
                            cmp.add(bb.getBudget());
                        }
                    }
                    kBoys = kbest.findKBest(boys, cmp, k);
                    kBoys.sort(Comparator.comparing(Boys::getIntelligence)); 
                    break;
            }
         
         Collections.reverse(kBoys);
         for (Boys bb : kBoys) {
             if (bb.getCommited() == false && g.getCommited() == false && bb.getBudget() >= g.getMaintenance() && g.getAttractiveness() >= bb.getMinAttractiveness() && (g.getBF() == null || !g.getBF().getName().equals(bb.getName()))) {
                    bb.setCommited(true);
                    g.setCommited(true);
                    bb.setGF(g);
                    g.setBF(bb);
                    couples.add(new Couples(bb, g));
                    System.out.println(g.getName() + " got committed to " + bb.getName() + " on "+ LocalDate.now()+" "+LocalTime.now()); 
                    break;
                }
         }
    }
    
     /**
    * 
    *<p> Forms couples according to algorithm  mentioned for question</p>
    * @param couples empty ArrayList of Couples to be filled with formed couples
    * @param k k to select best items
    * @param girls ArrayList of Girls
    * @param boys ArrayList of Boys
    */
    
    public void formCouplesByMethod (ArrayList<Couples> couples, int k, ArrayList<Girls> girls, ArrayList<Boys> boys) {
        int i;
        Girls g;
        setPrintStream("Log1.txt");
        
        for (i = 0; i < girls.size(); i++) {
            g = girls.get(i);
            getBoyForSweetGirl(couples, g, boys, k);
        }
    }
    
    /**
     * Allocates Gift from all available gifts to a couple
     * @param c couple object
     */
    
    private void allocateGiftForSingleCouple (Couples c) {
        int totalCost = 0;
        int capacity = 0;
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
    
    /**
     * This method allocates Gifts to couples according to their budget
     * @param couples ArrayList of formed couples
     * @param gifts ArrayList of gifts
     */
    public void allocateGifts(ArrayList<Couples> couples, ArrayList<Gifts> gifts) {
       
        gifts.sort(Comparator.comparing(Gifts::getPrice));  
        for (Couples c : couples) {
            allocateGiftForSingleCouple(c);
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
}
