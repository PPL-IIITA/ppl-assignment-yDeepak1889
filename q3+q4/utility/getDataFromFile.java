package utility;

import model.*;
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
        int type;
        Boys b;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader (fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                b = null;
                dataArray = line.split("\\s+");
                type = Integer.parseInt(dataArray[1]);
                if(type == 0) {
                    b =  new MiserBoy (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5]));
                }else if (type == 1) {
                    b = new GenerousBoy (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5]));
                }else {
                    b = new GeekBoy (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5]));
                }
                boysArray.add(b);
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
        int type;
        Girls g;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader (fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                g = null;
                dataArray = line.split("\\s+");
                type = Integer.parseInt(dataArray[1]);
                switch(type){
                    case 0:
                        g = new choosyGirl (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5])); 
                        break;
                    case 1:
                        g = new normalGirl (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5]));
                        break;
                    case 2:
                        g = new desperateGirl (dataArray[0], Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]), Integer.parseInt(dataArray[5]));
                }
                girlsArray.add(g);
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
    
    /**
     * <p>This method retrieves Gifts information from gifts.dat file and stores info in an ArrayList of Gifts object</p>
     * @return ArrayList of Gifts Object
     */
    
    public ArrayList<Gifts> getGifts() {
        ArrayList<Gifts> giftsArray = new ArrayList<>();
        fileName = "gifts.dat";
        
        String line;
        String [] dataArray;
        
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader (fileReader);
            int type;
            Gifts g = null;
            while ((line = bufferedReader.readLine()) != null) {
                dataArray = line.split("\\s+");
                type = Integer.parseInt(dataArray[0]);
                switch(type) {
                    case 0:
                        g = new EssentialGift(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]));
                        break;
                    case 1:
                        g = new LuxuryGift(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]));
                        break;
                    case 2:
                        g = new UtilityGift(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4]));
                        break;
                }
                
                giftsArray.add(g);
             }
            
            bufferedReader.close();
        }catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        
        return giftsArray;
    }
}
