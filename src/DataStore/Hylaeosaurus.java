package DataStore;
import java.util.*;
import java.io.*;


public class Hylaeosaurus extends LandHerbivore{
	//attributes
	public int armor_left;
	public int armor_right;
	
	//constructor
	public Hylaeosaurus(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{	
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		this.armor_right = rn.nextInt(3-1 +1) + 1;
		this.armor_left = rn.nextInt(3-1 +1) + 1;
                this.name = "Hylaeosaurus";
		 
	}
        public Hylaeosaurus(double latitude, double longitude, float price){
            
            super(latitude, longitude, price);
            bought = 0;
            name = "Hylaeosaurus";
            armor_left = (int) System.currentTimeMillis()%3;
            armor_right = (int) System.currentTimeMillis()%3;
            
        }
        
        public float pricing() {
            Random rn = new Random();
            int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
            float res = (float)temp;

            return res;
	}        
}










