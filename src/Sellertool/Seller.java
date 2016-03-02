/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sellertool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class Seller {
    ArrayList<Seller> masterlist = new ArrayList();
    String name;
    Coordinates location;
    Scanner input =new Scanner(System.in);
    Formatter output = new Formatter(System.out);
    
    public Seller(){
        float horizontal;
        float vertical;
        output.format("\nName:\n");
        name = input.next();
        output.format("\nLatitude:\n");
        horizontal = input.nextFloat();
        output.format("\nLongitude:\n");
        vertical = input.nextFloat();
        location = new Coordinates(horizontal, vertical);//feeds all coordinates
       input.nextLine();//clearScanner
       }
    
    //writesellers to file for storage
 
    
    public void changesellermenu(){
        int choice;
        Seller temp;
        output.format("\nWhat would you like to do?\n"+
                "1:Create a Seller\n"+
                "2:Delete a Seller\n"+
                "3:Update a seller"+
                "4:Exit");
                choice = getI();
                switch(choice){
                    case 1:{
                        temp = new Seller();//make new
                        addsellerfile(temp);//adds person to masterlist
                      
                    }
                    case 2:{//search for seller with naem remove line from file and 
                          //and from masterlist ;
                        
                    }
                    case 3:{//search seller with name, update info;//funciton;
                    }
                    case 4:{
                        
                    }
                    default:{
                        
                    }
      
                }//switch
        
    }//changesellermenu
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
                
        }//getf()
        
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
        }//getI
      
    public void addsellerfile(Seller newperson){//adds seller to seller file
       File sellerlist = new File("Sellerfile.txt");
       int i;
       Seller temp;
        try {
            Formatter filewriter = new Formatter(sellerlist);
            for(i = 0; i< masterlist.size(); i++){
                temp = masterlist.get(i);
                filewriter.format("%s,%d,%d\n", temp.name,temp.location.x,temp.location.y);
              
            }
            masterlist.add(newperson);//adds
          filewriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }//addsellertofile
  
    public void updateinfo(){
        
        
    }
    
    
    
}//Seller class   
        
       
        
        
            
  
    
    

