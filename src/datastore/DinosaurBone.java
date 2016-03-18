package datastore;


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
            public int boneid ;
            public int age;
            public float price;           
            public float weight; 
            public String condition ;
            public int bought;
            public Double globe_longitude;
            public Double globe_latitude; 
            public float length;
            public float width;        
            public float height; 
            public int buyer_id;
            public String name ;
           
            public String country; 
            public String prospector;
            public Demensions perspective;
            public Coordinates Location = new Coordinates();
            
    
    public DinosaurBone(){
      input = new Scanner(System.in);
      output = new Formatter(System.out);
      
     
    }//constructor

    //sets thename of the bones
  public void boneediting(DinosaurBone x){
        
        
           do{ output.format("\nEnter the coordinate Latitude:");
               x.globe_latitude = input.nextDouble();
           }while ((x.globe_latitude < -90) || (x.globe_latitude > 90));
            if(x. globe_latitude > 84){//take care of array ob because of trucation
                x.globe_latitude = 84.0;
            }
            if(x.globe_latitude<-90){
                x.globe_latitude = -90.0;//take care array ob
            }
        output.format("\nEnter the coordinate Longitude:");
        do{
            x.globe_longitude = input.nextDouble();
        }while((x.globe_longitude < -90) || (x.globe_longitude > 90));
        
            if(globe_longitude < -174){
                x.globe_longitude = -174.0;//must adjust because trunctation round value to 60,not 59 and causes a outo bounds error}
            }
            if (globe_longitude>174){
                x.globe_longitude= 174.0;//array ob adjustment
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
    public DinosaurBone Super(double vertical, double horizontal, String bonety, float price ){
        DinosaurBone temp = null;
        String[] specialbones = {"Spinosaurus","TyrannosaurusRex","Gigantosaurus","Velociraptor","Triceratops","Hylaeosaurus","Amargasaurus"};
        boolean inarray = false;

        for(int i=0; i < specialbones.length; i++){
            
            if(bonety.equals(specialbones[i])){
                inarray = true;
            }
        }    
    if(inarray){
    
    switch(bonety){//uses the 3rd string from super as a switch to make that typ of dinosaur
    
        case("Spinosaurus"): {
            
            temp = new Spinosaurus();
            temp.Location.longi = vertical;
            temp.Location.latit = horizontal;
            temp.price = this.price;
            temp.Location.updatecoordinates();
            break;
            
        } 
        case("TyrannosaurusRex"):{
        
            temp = new TyrannosaurusRex();
            temp.Location.longi = vertical;
            temp.Location.latit = horizontal;
            temp.price = this.price;
            temp.Location.updatecoordinates();
            break;
        
        }
        case("Gigantosaurus"):{
            temp = new Gigantosaurus();
            temp.Location.longi = vertical;
            temp.Location.latit = horizontal;
            temp.price = this.price;
            temp.Location.updatecoordinates();
            break;
        
        }
        case("Velociraptor"):{
            temp = new Velociraptor();
            temp.Location.longi = vertical;
            temp.Location.latit = horizontal;
            temp.price = this.price;
            temp.Location.updatecoordinates();
            break;
        }
        case("Triceratops"):{ 
            temp = new Triceratops();
            temp.Location.longi = vertical;
            temp.Location.latit = horizontal;
            temp.price = temp.price + this.price;
            temp.Location.updatecoordinates();
            break;
        }
        case("Hylaeosaurus"):{ 
            temp = new Velociraptor();
            temp.Location.longi = vertical;
            temp.Location.latit = horizontal;
            temp.price = this.price;
            temp.Location.updatecoordinates();
            break;
        }
    case("Amargasaurus"):{
            temp = new Velociraptor();
            temp.Location.longi = vertical;
            temp.Location.latit = horizontal;
            temp.price = this.price;
           
    }
    default:{       
        break;
    }//default
    }//switch    
        return temp;    
     }//if in array
    else return null; 
 }//Super           
                
}//class constructor  
  
            
    

