
package model;

/**
* <h1>Boys Class</h1>
* <p> This class contains basic information and methods to retrieve those information about Boys.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/
public final class Boys {
    
    public static final String [] BF_TYPE = {"Miser", "Generous", "Geeks"};
    private String name; // Boy's Name like B0, B1 ect.
    private int attractiveness; // on scale of 1-10
    private int intelligence; // on scale of 1-10
    private int budget; // Max value 1000
    private int type; // 0 -> Miser , 1-> Generous, 2 -> Generous
    private int minAttractiveness; // Minimum requirement of attractiveness
    private boolean commited; // True -> Commited 
    private double happiness;
    private int spentMoney;
    private Girls gf; // Allocated GirlFriend
     
     
    /**
     * <p>Constructor to initialise attributes for Boys Object</p>
     * @param name Boy's Name
     * @param type Boy's Type 0, 1 or 2
     * @param attractiveness Boy's attractiveness on scale of 1-10
     * @param intelligence Boy's intelligence on scale of 1-10
     * @param budget budget for girlfriend
     * @param  minAttractiveness Minimum requirement for GF's attractiveness
     */
    
    public Boys (String name, int type, int attractiveness, int intelligence,  int budget,  int minAttractiveness) {
        this.attractiveness = attractiveness;
        this.name = name;
        this.type = type;
        this.budget = budget;
        this.intelligence = intelligence;
        this.minAttractiveness = minAttractiveness;
        this.commited = false;
        this.gf = null;
        this.happiness = 0.0;
        this.spentMoney = 0;
    }
    
   /**
     * @return String  returns Boy's name
     */
    
    public String getName() {
        return this.name;
    }
    
    
    /**
     * @return int returns Boy's attractiveness
     */
    
    public int getAttractiveness() {
        return this.attractiveness;
    }
    
    
    /**
     * @return int returns Boy's intelligence
     */
    
    public int getIntelligence() {
        return this.intelligence;
    }
    
     /**
     * @return int returns Boy's budget
     */
    
    
    public int getBudget() {
        return this.budget;
    }
    
    /**
     * @return int returns Boy's type
     */
    
    public int getType() {
        return this.type;
    }
    
    /**
     * @return int returns Boy's minAttractiveness
     */
    
    public int getMinAttractiveness() {
        return this.minAttractiveness;
    }
    
    /**
     * @return boolean returns true if Commited else returns false
     */
    
    public boolean getCommited(){
       return this.commited;
    }
    
    /**
     * @return Girls returns girlFriend
     */
    
    public Girls getGF(){
        return this.gf;
    }
    
    /**
     * @param commited set true of boy got commited
     */
    
    public void setCommited(boolean commited){
        this.commited = commited;
    }
    
     /**
     * @param gf set new allocated girlfriend
     */
    
    public void setGF (Girls gf){
        this.gf = gf;
    }
    
     /**
     * @param value increase budget if current budget is not sufficient to meet girlfriend's desires
     */
    
    public void increaseBudget(int value) {
        this.budget = value;
    }
    
     /**
     * @param money set total spent Money for buying gifts for girlfriend 
     */
    
    public void setSpentMoney (int money) {
        this.spentMoney = money;
    }
    
    /**
     * @return int returns total money spent on gifts 
     */
    
    public int getSpentMoney () {
        return this.spentMoney;
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
}
