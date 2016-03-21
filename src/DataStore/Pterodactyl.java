package DataStore;
import java.util.*;
import java.io.*;

public class Pterodactyl extends AirCarnivore{
	//atrributes
	public boolean coconut;
	
	//constructor
	public Pterodactyl(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		int temp = rn.nextInt(2-1+1) + 1; //from 1 to 2
		
		if(temp == 1) {
			this.coconut = false;
		}else{
			this.coconut = true;
		}
		this.name = "Pterodactyl";
		 	
	}	
        public Pterodactyl(double latitude, double longitude, float price){
            super(latitude, longitude, price);
            bought = 0;
            name = "Pterodactyl";
            Random rn = new Random();
		int temp = rn.nextInt(2-1+1) + 1; //from 1 to 2
		
		if(temp == 1) {
			this.coconut = false;
		}else{
			this.coconut = true;
		}
            
        }
		
	public boolean carryAcoconut(){
		return coconut;
	}
        
	
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(150000 - 40000 + 1) - 40000; 
		float res = (float)temp;
		
		return res;
	}        
	
}

