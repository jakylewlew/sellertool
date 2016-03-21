package DataStore;
import java.util.*;
import java.io.*;


public class Amargasaurus extends LandHerbivore{
	//attributes
	public String DLC = "SYNTHETICFURY603";
	
	//constructor
	public Amargasaurus(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
		super(bone_id_, price_, bought_, y, x); 
                this.name = "Amargasaurus";
	}
        public Amargasaurus(double latitude,double longitude,float price){
            
            super(latitude, longitude, price);
            bought = 0;
            name = "Amargasaurus";
        }
        
        public float pricing() {
            Random rn = new Random();
            int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
            float res = (float)temp;

            return res;
	}        
}











