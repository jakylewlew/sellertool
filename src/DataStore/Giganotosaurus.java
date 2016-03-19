package DataStore;
import java.util.*;
import java.io.*;


public class Giganotosaurus extends LandCarnivore{
	//constructor
	public Giganotosaurus(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{	
		super(bone_id_, price_, bought_, y, x); 
                this.name = "Giganotosaurus";
	}
        
        public Giganotosaurus(double latitude, double longitude, float price){
            
            super(latitude, longitude, price);
            boneID = -1 * (int) System.currentTimeMillis()%99999;
            buyer = null;
            seller = null;
            bought = 0;
            name = "Gigantosaurus";
        }
        
	public void poorLittleMe() {
		System.out.printf("Bigger than T.Rex, but not as cool\n");
	}
        
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
		float res = (float)temp;
		
		return res;
	}        
	
}


