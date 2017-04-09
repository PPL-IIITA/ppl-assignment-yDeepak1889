package model;
/**
* <h1>Gifts Class</h1>
* <p>This abstract class contains attributes and method to manipulate those attributes of gift</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-04-10
*/
public abstract class Gifts{
    
    public static final String[] GIFT_TYPE = {"Essential", "Luxury", "Utility"};
    private final String[] UTIL_CLASS = {"A", "B", "C"};
    private int type;
    private int price;
    private int value;

    
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
