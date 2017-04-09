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
     * Preform Break Ups for t days of valentine for couples having happiness value less than t
     * @param t value of t as mentioned in question
     * @param couples ArrayList of formed Couples
     * @param boys ArrayList of all boys
     * @param girls ArrayList of all girls
     * @param gifts ArrayList of all gifts 
     */
    
    public void breakUpT (int t, ArrayList<Couples> couples, ArrayList<Boys> boys, ArrayList<Girls> girls, ArrayList<Gifts> gifts) {
       Girls g;
       ArrayList<Couples> tempCouplesArr = new ArrayList<>();
       Couples c;
        while (t != 0) { 
            couples.sort(Comparator.comparing(Couples::getHappiness));
            while(couples.size() > 0 && couples.get(0).getHappiness() < t) {
                c =  couples.get(0);
                System.out.println(c.getGF().getName() + " Broke Up With " + c.getBF().getName() + " On " + LocalTime.now());
                c.getBF().setCommited(false);
                c.getGF().setCommited(false);
                g = c.getGF();
                getBoyForSweetGirl(tempCouplesArr, g, boys);
                couples.remove(0);
            }
            allocateGifts(tempCouplesArr, gifts);
            couples.addAll(tempCouplesArr);
            t--;
        }
    }
}
