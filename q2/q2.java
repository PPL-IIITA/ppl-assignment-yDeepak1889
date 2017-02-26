import utility.*;

/**
* <h1>PPL Assignment Q2</h1>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/

public class q2 {
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        
        utils alloc = new utils();
        alloc.formCouples(); // Forms couples 
        alloc.allocateGifts(); // Allocates Gifts
        alloc.k_mostHappyCouples(10); // Writes k Most Happy Couples to file k_MostHappy.txt
        alloc.k_mostCompatibleCouples(10); // Writes k Most Compatible Couples to file k_MostCompatible.txt
        alloc.getAllGiftingDetails(); // Writes gift list to file Gifting.txt fir each couple
    }    
}
