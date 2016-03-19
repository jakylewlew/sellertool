package DataStore;

import Sellertool.Seller;

import java.util.*;
import java.io.*;

//DINOSAUR CLASSES
public class Dinosaur extends DinosaurBone{
    public int boneID; 
    public float price;
    public float adjusted_price;
    public Coordinates coordinates;
    public Buyer buyer;
    public Seller seller;
    public int bought; 
    
    public String name;
            

    public Dinosaur(int bone_id, float price_, 
                        int bought_,double y , double x) 
    {
        this.boneID = bone_id; 
        this.price = price_; 
	this.adjusted_price = price_;
        this.coordinates = new Coordinates(x,y);
        this.bought = bought_;
               
    }
    
     public Dinosaur( double x, double  y, float price){
         this.price = price;
         this.adjusted_price = price;
         this.coordinates = new Coordinates(x,y);
         bought = 0;
        
    }
    
    
    
}












