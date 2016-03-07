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
            int bought;
            float globe_longitude;//set to zero to overwrite when made
            float globe_latitude; 
            float length;
            float width;        
            float height; 
            int buyer_id;
            String name ;
            String condition ;
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
        
        do{ output.format("\nEnter the coordinate Latitude:");
             x.globe_latitude = getF();
        }while(x.globe_latitude>90 || x.globe_latitude<-90);     
        
        do{output.format("\nEnter the coordinate Longitude:");//gets number in specified coordinates
                x.globe_longitude = getF();
        }while((x.globe_longitude >180) || (x.globe_longitude<-180));
  
        output.format("\nEnter the price");
            x.price = getF();   
      
            x.Location.latit = x.globe_latitude;//set the Location lat and long
            x.Location.longi = x.globe_longitude;
            
            x.Location.updatecoordinates();//update and converts values for the 20 60 array using float values
      
        
    }//boneediting
  
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
    public void bonedoublecheck(DinosaurBone x){
            if(globe_latitude > 90){//take care of array ob because of trucation
                x.globe_latitude = 84;
            }
            if(globe_latitude<-90){
                x.globe_latitude = -90;//take care array ob
            }
             
        
            if(globe_longitude < -174){
                x.globe_longitude = -174;//must adjust because trunctation round value to 60,not 59 and causes a outo bounds error}
            }
            if (globe_longitude>174){
                x.globe_longitude= 174;//array ob adjustment
            }
    }
      
    /*8public void updatelocation(DinosaurBone x, float lat, float lon){
                x.Location = new Coordinates(lat,lon);*/
    
             
                
}//class constructor  
  
            
    

