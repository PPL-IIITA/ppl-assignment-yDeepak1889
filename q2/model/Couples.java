package model;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.text.DecimalFormat;
/**
* <h1>Couples Class</h1>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/

public final class Couples {
    
    private Boys bf;
    private Girls gf;
    private double happiness;
    private int compatibility;
    private ArrayList<Gifts> gifts;
    
    /**
     * Initialises couple object
     * @param b boyfriend
     * @param g girlfriend
     */
    
    public Couples (Boys b, Girls g) {
        this.bf = b;
        this.gf = g;
        gifts = new ArrayList<>();
    }
    
    /**
     * Method to get ArrayList of Gifts
     * @return ArrayList of Gifts 
     */
    
    public ArrayList<Gifts> getGifts() {
        return this.gifts;
    }
    
    /**
     * Method to get Object of type Boys
     * @return Boys 
     */
    
    public Boys getBF() {
        return this.bf;
    }
    
    /**
     * Method to get Object of type Girls
     * @return Girls
     */
    
    public Girls getGF() {
        return this.gf;
    }
    
    /**
     * Method to Set Happiness Value for Couple using getBoyHappiness() and getGirlHappiness()
     */
    
    private void setHappiness() {
        this.happiness = getBoyHappiness() + getGirlHappiness();
    }
    
    
    /**
     * Method to get Happiness of couples
     * @return double happiness value
     */
    
    public double getHappiness() {
        return this.happiness;
    }
    
    /**
     * Method to get happiness value for boyFriend
     * @return double Happiness value for boyfriend
     */
    
    private double getBoyHappiness () {
       double happiness = 0;
       
       switch (bf.getType()) {
           case 0:
               happiness = bf.getBudget() - bf.getSpentMoney();
               break;
           case 1:
               happiness = gf.getHappiness();
               break;
           case 2:
               happiness = bf.getIntelligence();
               break;
       }
       bf.setHappiness(happiness);
       return happiness;
    }
    
    /**
     * Method to get Girlfriend's Happiness value 
     * @return double girlfriend's happiness value
     */
    
    private double getGirlHappiness () {
        double happiness = 0;
        switch (gf.getType()) {
            case 0:
                happiness =  Math.log((double)(gf.getTotalGiftCostAchieved() / gf.getMaintenance()));
                break;
            case 1:
                happiness = gf.getTotalGiftCostAchieved() / gf.getMaintenance();
                break;
            case 2:
                happiness =  Math.exp((double)(gf.getTotalGiftCostAchieved() / gf.getMaintenance()));
                break;
        }
        gf.setHappiness(happiness);
        return happiness;
    }
    
    /**
     * Add gift to giftBucket (ArrayList)
     * @param gift new gift object
     */
    
    public void addGift (Gifts gift) {
        this.gifts.add(gift);
    }
    
    /**
     * Set compatibility value of couple, according to algorithm given in question
     */
    
    private void setCompatibility() {
        this.compatibility += Math.abs(bf.getBudget() - gf.getMaintenance());
        
        this.compatibility += Math.abs(bf.getAttractiveness() - gf.getAttractiveness());
        
        this.compatibility += Math.abs(bf.getIntelligence() - gf.getIntelligence());
    }
    
    /**
     * Get calculated compatibility value for couple
     * @return int compatibility value
     */
    
    public int getCompatibility () {
        return this.compatibility;
    }
    
    /**
     * Method to be called on Finishing Gifting to calculate happinness ans compatibility value
     */
    
    public void onGiftingFinish() {
        int totalGiftCostForBF = 0;
        int totalGiftCostForGF = 0;
        boolean flagC = (gf.getType() == 0);
        boolean flagN = (gf.getType() == 1);
        
        for (Gifts g : gifts) {
            totalGiftCostForBF += g.getPrice();
            totalGiftCostForGF += g.getPrice();
            if (flagC && g.getType() == 1) {
                totalGiftCostForGF += g.getPrice();
            }else if (flagN) {
                 totalGiftCostForGF += g.getValue();
            }
        }
        gf.setTotalGiftCostAchieved(totalGiftCostForGF);
        bf.setSpentMoney(totalGiftCostForBF);
        
        setHappiness();
        setCompatibility();
    }
}
