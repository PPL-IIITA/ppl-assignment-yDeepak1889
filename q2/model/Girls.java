
package model;

/**
* <h1>Girls Class</h1>
* <p> This class contains basic information and methods to retrieve those information about Girls.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/

public final class Girls {
    
    public static final String [] GF_TYPE = {"Choosy", "Normal", "Desperate"};
    public static final String [] CRITERION = {"Most Attractive", "Most Rich", "Most intelligent"};
    private String name;
    private int attractiveness;
    private int intelligence;
    private int maintenance;
    private int type;
    private boolean commited;
    private int totalGiftCostAchieved;
    private double happiness;
    private int criterion;
    private Boys bf;
    
     /**
     * <p>Constructor to initialise attributes for Girl's Object</p>
     * @param name Girl's Name
     * @param type Girl's Type 0, 1 or 2
     * @param attractiveness Girl's attractiveness on scale of 1-10
     * @param intelligence Girl's intelligence on scale of 1-10
     * @param maintenance total maintenance cost
     * @param  criterion 0 for Most Attractive , 1 for Most Rich and 2 for Most intelligence  
     */
    
    public Girls (String name, int type,  int attractiveness, int intelligence, int maintenance, int criterion) {
        this.attractiveness = attractiveness;
        this.name = name;
        this.type = type;
        this.maintenance = maintenance;
        this.intelligence = intelligence;
        this.criterion = criterion;
        this.commited = false;
        this.bf = null;
        this.happiness = 0.0;
        this.totalGiftCostAchieved = 0;
        
    }
    
   /**
     * @return String  returns Girl's name
     */
    
    public String getName() {
        return this.name;
    }
    
     
    /**
     * @return int returns Girl's attractiveness
     */
    
    public int getAttractiveness() {
        return this.attractiveness;
    }
    
     /**
     * @return int returns Girl's intelligence
     */
    
    public int getIntelligence() {
        return this.intelligence;
    }
    
    
     /**
     * @return int returns Girl's maintenanse cost
     */
    
    public int getMaintenance() {
        return this.maintenance;
    }
    
    
    /**
     * @return int returns Girl's type
     */
    
    public int getType() {
        return this.type;
    }
    
    
    /**
     * @return boolean returns true if Commited else returns false
     */
    
    public boolean getCommited(){
        return this.commited;
    }
    
    /**
     * @return Girls returns boyFriend
     */
    
    public Boys getBF(){
        return this.bf;
    }
    
    /**
     * @param commited set true when girl got committed
     */
    
    public void setCommited(boolean commited){
        this.commited = commited;
    }
    
     /**
     * @param bf set new allocated boyfriend
     */
    
    public void setBF (Boys bf){
        this.bf = bf;
    }
    
    
     /**
     * @param money set total spent Money for buying gifts by boyfriend 
     */
    
    public void setTotalGiftCostAchieved (int money) {
        this.totalGiftCostAchieved = money;
    } 
    
    /**
     * @return int returns total money spent on gifts by boyfriend
     */
    
    public int getTotalGiftCostAchieved () {
        return this.totalGiftCostAchieved;
    }
    
    /**
     * @param h set calculated happiness value
     */
    
    public void setHappiness (double h) {
        this.happiness = h;
    }
    
    
     /**
     * @return double return happiness value
     */
    
    public double getHappiness () {
        return this.happiness;
    }
    
      /**
     * @return int return criterion for choosing boyfriend
     */
    
    public int getCriterion () {
        return this.criterion;
    }
}
