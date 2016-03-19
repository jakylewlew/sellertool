package DataStore;
import java.util.*;
import java.io.*;


public class Spinosaurus extends LandCarnivore{
	//atrributes
	public int spines;
	
	//constructor
	public Spinosaurus(int bone_id_, float price_, int bought_, 
						double y, double x){	
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		this.spines = rn.nextInt(20 - 4 + 1) + 4;
		this.name = "Spinosaurus";
	}
        
        public float pricing() {
            Random rn = new Random();
            int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
            float res = (float)temp;

            return res;
	}
        
        
        public Spinosaurus(double y, double x, float price_) {
            
            
                super(y,x,price_);
                boneID = (int) System.currentTimeMillis()%99999 *-1;
                spines = (int)(System.currentTimeMillis()%8);//fins bw  0 and 8;
		name = "Spinosaurus";
                buyer = null;
                seller = null;
                bought = 0;
        }
}
        
         
        

