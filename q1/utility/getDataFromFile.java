package utility;

import model.Boys;
import model.Girls;
import java.io.*;
import java.util.ArrayList;
/**
* <h1>Get Data From File</h1>
* <p> This class contains methods to get information stored in files about Girls and Boys
* and make an ArrayList of retrieved information.</p>
* @author Deepak Kumar Yadav (IIT2015124)
* @version 1.0
* @since   2017-02-27
*/

public class getDataFromFile {
    
    private String fileName;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String singleLineData;
    
    
    /**
     * <p>This method retrieves Boys information from boys.dat file and stores info in an ArrayList of Boys object</p>
     * @return ArrayList of Boys Object
     */
    public  ArrayList<Boys> getBoys() {
        ArrayList<Boys> boysArray = new ArrayList<>();
        fileName = "boys.dat";
        String line;
        String [] dataArray;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader (fileReader);
            while ((line = bufferedReader.readLine()) != null) {
              
                dataArray = line.split("\\s+");
              
                boysArray.add(new Boys (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5])));
            }
            
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        
        return boysArray;
    }
    
    /**
     * <p>This method retrieves Girls information from girls.dat file and stores info in an ArrayList of Girls object</p>
     * @return ArrayList of Girls Object
     */
    
    public  ArrayList<Girls> getGirls() {
        ArrayList<Girls> girlsArray = new ArrayList<>();
        fileName = "girls.dat";
        String line;
        String [] dataArray;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader (fileReader);
            while ((line = bufferedReader.readLine()) != null) {
              
                dataArray = line.split("\\s+");
              
                girlsArray.add(new Girls (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5])));
            }
            
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        
        return girlsArray;
    }
   
}
