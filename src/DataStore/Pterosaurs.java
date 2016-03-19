package DataStore;
import java.util.*;
import java.io.*;

public class Pterosaurs extends AirCarnivore{
	//atrributes
	public String crest;
	
	//constructor
	public Pterosaurs(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		int temp = rn.nextInt(2-1+1) + 1; //from 1 to 2
		
		if(temp == 1) {
			crest = "Red with white polka-dots";
		}else{
			crest = "Green with yellow stripes";
		}
                this.name = "Pterosaurs";
		
		 	
	}
        public Pterosaurs(double latitude, double longitude, float price){
            super(latitude, longitude, price);
            boneID = -1 * (int) System.currentTimeMillis()%99999;
            buyer = null;
            seller = null;
            bought = 0;
            name = "Pterosaurs";
            Random rn = new Random();
		int temp = rn.nextInt(2-1+1) + 1; //from 1 to 2
		
		if(temp == 1) {
			crest = "Red with white polka-dots";
		}else{
			crest = "Green with yellow stripes";
		}
        }
        
	
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(150000 - 40000 + 1) - 40000; 
		float res = (float)temp;
		
		return res;
	}        
}

