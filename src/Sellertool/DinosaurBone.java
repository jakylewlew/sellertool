package Sellertool;


import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;


/*;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class DinosaurBone {
    
            Scanner input;
            Formatter output;
            int boneid;
            int age;
            float price;           
            float weight; 
            String condition ;
            int bought;
            float globe_longitude;
            float globe_latitude; 
            float length;
            float width;        
            float height; 
            int buyer_id;
            String name ;
           
            String country; 
            String prospector;
            Demensions perspective;
            Coordinates Location = new Coordinates();
            
    
    public DinosaurBone(){
      input = new Scanner(System.in);
      output = new Formatter(System.out);
     
    }//constructor

    //sets thename of the bones
  public void boneediting(DinosaurBone x){
        
        output.format("\nEnter the coordinate Latitude:");
        x.globe_latitude = getF();
            if(globe_latitude > 90){//take care of array ob because of trucation
                x.globe_latitude = 84;
            }
            if(globe_latitude<-90){
                x.globe_latitude = -90;//take care array ob
            }
        output.format("\nEnter the coordinate Longitude:");
        x.globe_longitude = getF();
        
            if(globe_longitude < -174){
                x.globe_longitude = -174;//must adjust because trunctation round value to 60,not 59 and causes a outo bounds error}
            }
            if (globe_longitude>174){
                x.globe_longitude= 174;//array ob adjustment
            }
  
        output.format("\nEnter the price");
            x.price = getF();
                                        
      
            x.Location.latit = x.globe_latitude;//set the Location lat and long
            x.Location.longi = x.globe_longitude;
            
            x.Location.updatecoordinates();//update and converts values for the 20 60 array using float values
      
        
    }//bone making menu
          public int getI()//Int input mismatch 
        {
           
            String intbuffer;
            int result=0; 
            while(true)
            {
            try {
                intbuffer = input.nextLine();
                
                result = (Integer.valueOf(intbuffer));
                break;
            } catch(NumberFormatException e) {
                output.format("Please try again\n");
                continue;
            }/*){
            }*/
            
            }
            return result;
        }
    public float getF()//float input mismatch
        {   String buffer;
            float result;
            while(true)
            {
                
                
                try {
                    buffer = input.nextLine();
                    result = Float.valueOf(buffer);
                    break;
                } catch (NumberFormatException e) 
                    {
                    output.format("Please try again\n");
                    //input.nextLine();
                    continue;
                    }
               /* catch(){
                    
                }*/
              
            }  
            return result;
                
        }      
      
    /*8public void updatelocation(DinosaurBone x, float lat, float lon){
                x.Location = new Coordinates(lat,lon);*/
    
             
                
}//class constructor  
  
            
    

