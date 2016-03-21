package DataStore;
import java.util.*;
import java.io.*;


public class Triceratops extends LandHerbivore{
	//attributes
	public double added_cost = 2500;
	
	//constructor
	public Triceratops(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{	
		super(bone_id_, price_, bought_, y, x); 
		this.adjusted_price += (float)this.added_cost;
                this.name = "Triceratops";
	}
         public Triceratops(double latitude, double longitude, float price){
            
             super(latitude, longitude, price);
            bought = 0;
            name = "Triceratops";
            this.adjusted_price += (float)this.added_cost;
         }
         
       
        public float pricing() {
            Random rn = new Random();
            int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
            float res = (float)temp;

            return res;
	}        
}








