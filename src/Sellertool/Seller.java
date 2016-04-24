/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sellertool;

import DataStore.Coordinates;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob
 */
public class Seller {    
    public String name;
    public Coordinates coordinate = new Coordinates();
    public ArrayList<Seller> masterlist = new ArrayList();
    Scanner input =new Scanner(System.in);
    Formatter output = new Formatter(System.out);
    Double latitude;
    Double longitude;
    public Seller(int a){//blank seller object for use in operation to call menu in seller class
        
    }
    public Seller(String name, Double inpLatitude,Double inpLongitude){
        System.out.printf("|%f|", inpLatitude);
        this.name = name.toLowerCase();//makes all case lowercase to find easily
        
          while((inpLatitude>90) || (inpLatitude<-90)){
                try{
                   inpLatitude = Double.valueOf(JOptionPane.showInputDialog("Bad input", inpLatitude));
               }catch(NumberFormatException | InputMismatchException e){

               }                           
        }
        
            while((inpLongitude>180.0)||(inpLongitude<-180.0)){
               try{
                   inpLongitude = Double.valueOf(JOptionPane.showInputDialog("Bad input", inpLongitude));
               }catch(NumberFormatException | InputMismatchException e){

               }
           
        }
        coordinate.latit = inpLatitude;
        coordinate.longi = inpLongitude;
        coordinate.updatecoordinates();
            
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
                        //temp = new Seller();//make new
                        //masterlist.add(temp);//adds person to masterlist
                        writesellerfile();//rewrites sellerfile
                        break;
                      
                    }
                    case 2:{    //search for seller, find, delete from masterlist; 
                                //rewrites sellerfile;
                        printsellerlist();
                        //removeseller();
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
                filewriter.format("%s,%d,%d\n", temp.name,temp.coordinate.x,temp.coordinate.y);
              
            }
          filewriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }//addsellertofile
    
    public void removeseller(Sellertool GUISellertool){
        String name;
        Seller temp = null;
        int i; 
        Boolean found = false;
        if(GUISellertool.masterlist.isEmpty()){
            return;
        }
        output.format("\nWho do you ant to remove?\n", 0);
        name = input.nextLine();
        name = name.toLowerCase();
        
        for(i=0; i < GUISellertool.masterlist.size(); i++){//check for valid name of seller get that item
            temp = masterlist.get(i);
            if(name.matches(masterlist.get(i).name)){
                found = true;
                GUISellertool.masterlist.remove(i);//removes all users with that name from the masterlist
            }
            if(found){
            writesellerfile();//write updated masterlist to list
            }//if item was found rewrites file
            else{
                System.out.print("\nSeller does not exsist\n");
            }
                    
                    
        }
        
        
    }
    
    public void updateseller(){//upfdates seller information
        String name = null;
        String value = null;
        Seller temp = null;
        int i; int selected;
        Boolean found = false;
        if(masterlist.isEmpty()){
            return;
        }
        output.format("\nWho do you want to update?\n", 0);
        name = input.nextLine();
        name = name.toLowerCase();
        
        for(i=0; i < masterlist.size(); i++){//check for valid name of seller get that item
            temp = masterlist.get(i);
            if(name.matches(masterlist.get(i).name)){
                
                while(!found){//while t
                    output.format("New Latitude\n");
                    
                    try{
                        value = input.nextLine().trim();
                        temp.coordinate.latit = Double.valueOf(value);
                        found = true;
                        if((temp.coordinate.latit>90) || (temp.coordinate.latit<-90)){                        
                            output.format("Enter a valid Latitude values%n");
                            found = false;
                            //if found found id true
                            }
                    }catch(InputMismatchException |NumberFormatException e){
                        output.format("Enter a valid Latitude values%n");
                        found = false;
                    }
                }//executes while not valid
                //reset value for longitude'
                found = false; //starts false
                while(!found){
                    try{
                       output.format("New Longitude\n");
                       value = input.nextLine().trim();
                       temp.coordinate.longi = Double.valueOf(value);
                       found = true;
                    if((temp.coordinate.longi>180) || (temp.coordinate.longi<-180)){
                        output.format("Enter a valid Longitude value!%n");
                        found = false;
                    }
                    }catch(InputMismatchException |NumberFormatException e){
                        output.format("Enter a valid Longitude coordinates%n");
                        found = false;
                    }
                }
                temp.coordinate.updatecoordinates();
               //exit loops
            }          
           //function adjusts map coordinates
            if(found){
            writesellerfile();//write updated masterlist to list
            }                   //if item was found rewrites file
          
          }
        
   }//updateseller*/
    
    public void printsellerlist(){//print seller list
        int i;
        if(masterlist.isEmpty()){
            output.format("\nNo sellers in the list\n");
        }
        else{
            for(i=0; i <masterlist.size();i++){    //prints sll in the list if there is anyhting there
                output.format("\nName:%s \nLocation:Lat->%f Long->%f\n",masterlist.get(i).name,masterlist.get(i).coordinate.latit, masterlist.get(i).coordinate.longi);
                output.format("MapCoorinates: Lat %d: Long %d\n", masterlist.get(i).coordinate.x,masterlist.get(i).coordinate.y);
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
       
       
        
        
            
  
    
    

