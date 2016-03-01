/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sellertool;

import java.util.ArrayList;
import java.util.Formatter;

/*Jeff Pinkos*/
public class MapO{
    public int MapX;
    public int MapY;
    public int MapZ;//printable item

    Formatter output;
    public MapO(){
        MapX = MapX;
        MapY = MapY;
        MapZ = MapZ;
     
                }
    
    
    public void LoadMapNode(ArrayList<MapO> x){
        int i;
        int counter=0;
        int condition;
        output = new Formatter(System.out);
        for (i=0;i<x.size();i++){
            
            if (counter == 60) {
                System.out.print("\n");
                counter = 0;
            } 
            condition = x.get(i).MapZ;
            if(condition == 0){       
            output.format("%s",",");    
            }
            if(condition == 1){
               output.format("%s", "*");
            }
         counter++; 
            
        }
            
     
                    
        }//loadmap
                    
        

    

}