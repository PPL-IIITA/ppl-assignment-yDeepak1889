/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
/**
* <h1>MyGfFinder Class</h1>
* <p> This abstract class defines abstract method to find Girlfriend of given boy</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/
public abstract class MyGfFinder {
   
   /**
    * abstract method to find girlfriend of given boy
    * @param arr ArrayList of String name of Boys
    */
   public abstract void findMySweety (ArrayList<String> arr);
    
   /**
    * Helper method to change current print stream
    * @param fileName filename in which output should be redirected
    */
   protected void setPrintStream (String fileName) {
         try{
            PrintStream o = new PrintStream(new File(fileName));
            PrintStream console = System.out;
            System.setOut(o);
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }
    }
}
