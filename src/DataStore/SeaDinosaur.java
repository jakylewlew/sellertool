package DataStore;
import java.util.*;
import java.io.*;


//SEA DINOSAURS
public class SeaDinosaur extends Dinosaur{
	//atrributes
	public boolean salt_water;
	public boolean fresh_water;
	
	//constructor
	public SeaDinosaur(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		int rn1 = rn.nextInt(2-1+1) + 1; //from 1 to 2
		
		if(rn1 == 1) {
			salt_water = true;
			fresh_water = false;
		}else{
			fresh_water = true;
			salt_water = false;
		}
		
		 
		
	}
        public SeaDinosaur(double latitude, 
	double longitude, float price){
            
            super(latitude, longitude, price);
               
		int rn1 = (int) System.currentTimeMillis()%2 *-1;
		if(rn1 == 1) {
			salt_water = true;
			fresh_water = false;
		}else{
			fresh_water = true;
			salt_water = false;
		}
            
        }
	
	
	
}












