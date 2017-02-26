package model;
/**
* <h1>Gifts Class</h1>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/
public final class Gifts{
    
    public static final String[] GIFT_TYPE = {"Essential", "Luxury", "Utility"};
    private final String[] UTIL_CLASS = {"A", "B", "C"};
    private int type;
    private int price;
    private int value;
    private int luxuryRating;
    private int difficulty;
    private int utilityValue;
    private int utilityClass;
    
    /**
     * Initialises Gift Object
     * @param type Type of Gift 0 for Essential, 1 for Luxury and 2 for Utility
     * @param value value of gift on scale of 1 - 20
     * @param price price of gift maximum value 130 and minimum value 30 
     */
    
    public Gifts (int type, int value, int price) {
       this.type = type;
       this.value = value;
       this.price = price;
       
    }
    
    
    /**
     * Initialises Gift Object
     * @param type Type of Gift 0 for Essential, 1 for Luxury and 2 for Utility
     * @param value value of gift on scale of 1 - 20
     * @param price price of gift maximum value 130 and minimum value 30 
     * @param opt1 opt1 can be luxuryRating or utilityValue depending upon type of gift
     * @param opt2 opt2 can be difficulty or utilityClass depending upon type of gift
     */
    
    public Gifts (int type, int value, int price, int opt1, int opt2) {
        
        this(type, value, price);
        
        if (type == 1) {
           luxuryRating = opt1;
           difficulty = opt2;
       }else if (type == 2) {
           utilityValue = opt1;
           utilityClass = opt2;
       }
    }
    
    /**
     * 
     * @return int returns price of gift
     */
    
    public int getPrice() {
        return this.price;
    }
    
    /**
     * 
     * @return int returns value of gift 
     */
    
    public int getValue() {
        return this.value;
    }
     
    /**
     * 
     * @return int returns type of gift 0 , 1 or 2
     */
    
    public int getType() {
        return this.type;
    } 
}
