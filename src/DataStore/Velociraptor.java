package DataStore;
import java.util.*;
import java.io.*;


public class Velociraptor extends LandCarnivore{
	//atrributes
	public int size;
	
	//constructor
	public Velociraptor(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		this.size = rn.nextInt(3 - 1 + 1) + 1; //from 1-3
		this.name = "Velociraptor";
	}
        public Velociraptor(double latitude, double longitude, float price){
            
            super(latitude, longitude,price);
            boneID = (int) System.currentTimeMillis()%99999 *-1;
            name = "Velociraptor";
            buyer = null;
            seller = null;
            bought = 0;
            size = (int)System.currentTimeMillis()%3;
            String result = "";
            switch(size) {
			case 1:
				result = "Small";
				break;
			case 2:
				result = "Medium";
				break;
			case 3:
				result = "Large";
				break;
			default:
				result = "Large";
				break;
             }
        }
	
	public String getSizeLabel() {
		String result = "";
		switch(this.size) {
			case 1:
				result = "Small";
				break;
			case 2:
				result = "Medium";
				break;
			case 3:
				result = "Large";
				break;
			default:
				result = "Large";
				break;
		}
		
		return result;
	}
	
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
		float res = (float)temp;
		
		return res;
	}
        
}












