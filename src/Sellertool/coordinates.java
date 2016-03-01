/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sellertool;

/**
 *
 * @author Jacob
 */
public class coordinates {
    
    float latit;
    float longi;
    int x;
    int y;
    
    public coordinates(float latx, float laty){//takes care of out bound coordinate and will place coordinates
      
        this.latit = latx;
        this.longi = laty;
        x = (int) (latit);
        y = (int) (longi);
        
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
        
