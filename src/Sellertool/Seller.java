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
    Coordinates location = new Coordinates();
    Scanner input =new Scanner(System.in);
    Formatter output = new Formatter(System.out);
    
    public Seller(int x){//blank seller object for use in file
        
    }
    public Seller(){
        float horizontal;
        float vertical;
        output.format("\nName:\n");
        name = input.nextLine();
        name = name.toLowerCase();//makes all case lowercase to find easily
        output.format("\nLatitude:\n");
        horizontal = input.nextFloat();
        output.format("\nLongitude:\n");
        vertical = input.nextFloat();
        location.latit = horizontal;
        location.longi = vertical;
        location.updatecoordinates();
       input.nextLine();//clearScanner
       }
    
    //writesellers to file for storage
 
    
    public void changesellermenu(){
        int choice = 0;
        Seller temp;
        
            while(choice != 5){
                printmenu();
                choice = getI();
                switch(choice){
                    
                    case 1:{
                        temp = new Seller();//make new
                        masterlist.add(temp);//adds person to masterlist
                        writesellerfile();//rewrites sellerfile
                        break;
                      
                    }
                    case 2:{    //search for seller, find, delete from masterlist; 
                                //rewrites sellerfile;
                        printsellerlist();
                        removeseller();
                        break;
                        
                    }
                    case 3:{//search seller with name, update info;//funciton;
                        printsellerlist();
                        updateseller();
                        break;
                    }
                    case 4:{//prints list of all sellers
                        printsellerlist();
                        break;
                        
                    }
                    case 5:{
                        ///is a boolean case to break while loop and return to main seller program
                        break;
                        
                    }
                    default:{
                        break;
                    }
      
                }//switch
               

            }//while loop to stay in create seller program
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
      
    public void writesellerfile(){//writes new seller file
       File sellerlist = new File("Sellerfile.txt");
       int i;
       Seller temp;
        try {
            Formatter filewriter = new Formatter(sellerlist);
            for(i = 0; i< masterlist.size(); i++){
                temp = masterlist.get(i);
                filewriter.format("%s,%d,%d\n", temp.name,temp.location.x,temp.location.y);
              
            }
          filewriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }//addsellertofile
    
    public void removeseller(){
        String name;
        Seller temp = null;
        int i; 
        Boolean found = false;
        
        output.format("\nWho do you ant to remove?\n", 0);
        name = input.nextLine();
        name = name.toLowerCase();
        
        for(i=0; i < masterlist.size(); i++){//check for valid name of seller get that item
            temp = masterlist.get(i);
            if(name.matches(masterlist.get(i).name)){
                found = true;
                masterlist.remove(i);//removes all users with that name from the masterlist
            }
            if(found){
            writesellerfile();//write updated masterlist to list
            }//if item was found rewrites file
            else{
                System.out.print("\nSeller does not exsist\n");
            }
                    
                    
        }
        
        
    }//remove seller
    
    public void updateseller(){
        String name = null;
        Seller temp = null;
        int i; int selected;
        Boolean found = false;
        
        output.format("\nWho do you want to update?\n", 0);
        name = input.nextLine();
        name = name.toLowerCase();
        
        for(i=0; i < masterlist.size(); i++){//check for valid name of seller get that item
            temp = masterlist.get(i);
            if(name.matches(masterlist.get(i).name)){
                found = true;
                output.format("New Latitude\n");
                temp.location.latit = getF();
                output.format("New Longitude\n");
                temp.location.longi = getF();
                temp.location.updatecoordinates();//function adjusts map coordinates
            }
            if(found){
            writesellerfile();//write updated masterlist to list
            }                   //if item was found rewrites file
          
          }
        if(found==false){//if the name is not in the list
            System.out.print("\nSeller not found\n");
        }
    }//updateseller
    
    public void printsellerlist(){//print seller list
        int i;
        if(masterlist.isEmpty()){
            output.format("\nNo sellers in the list\n");
            
        }
        else{
            for(i=0; i <masterlist.size();i++){    //prints sll in the list if there is anyhting there
                output.format("\nName:%s \nLocation:Lat->%f Long->%f\n",masterlist.get(i).name,masterlist.get(i).location.latit, masterlist.get(i).location.longi);
                output.format("MapCoorinates: Lat %d: Long %d\n", masterlist.get(i).location.x,masterlist.get(i).location.y);
            }
        }
    }
    
    public void printmenu(){
         output.format("\nWhat would you like to do?\n"+
                "1:Create a Seller\n"+
                "2:Delete a Seller\n"+
                "3:Update a seller\n"+
                "4:See list of sellers\n"+
                "5:Exit\n");
    }//prints the menu in for seller operations
    
   
    
    
}//Seller class   
        
       
        
        
            
  
    
    

