package utility;
import model.Girls;
import model.Boys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;
/**
* <h1>Utils Class</h1>
* <p> This class contains method to form couples.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/
public class utils {
    
    private ArrayList<Boys> boys = null;
    private ArrayList<Girls> girls = null;
    private getDataFromFile getData = null;
    
    /**
     * <p>Initialises Boys ArrayList and Girls ArrayList</p>
     */
    
    public utils() {
        getData = new getDataFromFile();
        boys = getData.getBoys();
        girls = getData.getGirls(); 
    }
    
    /**
     * Forms couples according to algorithm mentioned in question
     */
    
    public void formCouples() {
        int i, j;
        Boys b;
        Girls g;
        
        try{
            PrintStream o = new PrintStream(new File("Log1.txt"));
            PrintStream console = System.out;
            System.setOut(o);
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }
        
      
        
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
   
                    System.out.println(g.getName() + " got committed to " + b.getName() + " on "+ LocalDate.now()+" "+LocalTime.now());
                    
                    break;
                }
            }
        }
       
    }
    
    
    
}
