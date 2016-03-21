package DataStore;
import java.util.*;
import java.io.*;

public class Shastasaurus extends SeaCarnivore{
	public static int teeth = 0;
	
	public Shastasaurus(int bone_id_, float price_, int bought_,
						double y, double x) 
	{
		super(bone_id_,price_,bought_,y,x);
                this.name = "Shastasaurus";
	}
	
        public Shastasaurus(double latitude,double longitude,float price){
            super(latitude, longitude, price);
            bought = 0;
            name = "Shastasaurus";
        }
        
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(120000 - 30000 + 1) - 30000; 
		float res = (float)temp;
		
		return res;
	}
        
}

