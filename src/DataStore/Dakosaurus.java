package DataStore;
import java.util.*;
import java.io.*;


public class Dakosaurus extends SeaCarnivore{
	
	public Dakosaurus(int bone_id_, float price_, int bought_,
						double y, double x) 
	{
		super(bone_id_,price_,bought_,y,x);
                this.name = "Dakosaurus";
	}
	
        public Dakosaurus(double latitude,double longitude,float price){
            super(latitude, longitude, price);
            boneID = -1 * (int) System.currentTimeMillis()%99999;
            buyer = null;
            seller = null;
            bought = 0;
            name = "Dakosaurus";
            
        }
	public void print_saying() {
		System.out.printf("I survived the Dako!\n");
	}

        
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(120000 - 30000 + 1) - 30000; 
		float res = (float)temp;
		
		return res;
	}        
}

