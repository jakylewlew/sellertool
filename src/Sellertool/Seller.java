/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sellertool;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class Seller {
    
    Coordinates location;
    String name;
    Scanner input =new Scanner(System.in);
    Formatter output = new Formatter(System.out);
    
    public Seller(){
        
        output.format("\nName:\n");
        name = input.next();
        output.format("\nLatitude:\n");
        location.latit = input.nextFloat();
       output.format("\nLongitude:\n");
       location.longi = input.nextFloat();
       input.nextLine();//clearScanner
       
    
    }
    
    
    public void sellerfile(){
        File sellerlist = new File("Sellerfile.txt");
        
        while()
        
        
    }
    
    
   
       }   
        
       
        
        
            
  
    
    

