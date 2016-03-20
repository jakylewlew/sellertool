package DataStore;
import java.util.*;
import java.io.*;


public class LandCarnivore extends LandDinosaur{
	//atrributes
	public double ground_speed;
        
	
	//constructor
	public LandCarnivore(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
		
		super(bone_id_, price_, bought_, y, x); 
                this.ground_speed = this.speed;
	}
        
        public LandCarnivore(double y, double x, float price_ ){
            
            super( y, x, price_);
            long seed = System.currentTimeMillis();
            this.ground_speed =  seed%45;
       
        }
        
        public float pricing() {
            Random rn = new Random();
            int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
            float res = (float)temp;

            return res;
}
}










