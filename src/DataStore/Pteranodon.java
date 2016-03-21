package DataStore;
import java.util.*;
import java.io.*;

public class Pteranodon extends AirCarnivore{
	//atrributes
	public boolean saddle_available;
	public static double saddle_cost = 1000;
	
	//constructor
	public Pteranodon(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		int temp = rn.nextInt(2-1+1) + 1; //from 1 to 2
		
		if(temp == 1) {
			this.saddle_available = false;
		}else{
			this.saddle_available = true;
		}
		this.name = "Pteranodon";
		

	}
        public Pteranodon(double latitude, double longitude, float price){
            
            super(latitude, longitude, price);
            bought = 0;
            name = "Pteranodon";
            Random rn = new Random();
            int temp = rn.nextInt(2-1+1) + 1; //from 1 to 2
		
		if(temp == 1) {
			this.saddle_available = false;
		}else{
			this.saddle_available = true;
		}
        }
		
	public void specialOffer(){
		this.adjusted_price += (float)this.saddle_cost;
	}
        
	
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(150000 - 40000 + 1) - 40000; 
		float res = (float)temp;
		
		return res;
	}        
	
}



