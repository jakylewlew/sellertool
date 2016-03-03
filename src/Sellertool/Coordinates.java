/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open th6mplate in the editor.
 */
package Sellertool;

/**
 *
 * @author Jacob
 */
public class Coordinates {
    
    float latit;
    float longi;
    int x;
    int y;
    
    public Coordinates(){//takes care of out bound coordinate and will place coordinates
      
      
    }
     public void updatecoordinates(){//a function for updating the xy coordinates when moved
        
        x = (int) (this.latit);
        y = (int) (this.longi);
        
         if( y >= 0) {
            if( y == 0) {
                y = y + 30;
            }else {
                y = y / 6;
                y = y + 29 ;
            }
        }else {
            
            y = y/6 + 30;
         }
        if(x >= 0) {
            if(x == 0) {
                x = x + 10;
            }else {
                x = x / 10;
                x = 9 - x;
            }
        }else {
            x = x * -1;
            x = x/10;
            x = x + 10;
        } 
        
    }
}

        
