package DataStore;
import java.util.*;
import java.io.*;


public class LandCarnivore extends LandDinosaur{
	//atrributes
	public double ground_speed;
        long seed = System.currentTimeMillis();
	
	//constructor
	public LandCarnivore(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
		
		super(bone_id_, price_, bought_, y, x); 
                this.ground_speed = this.speed;
	}
        
        public LandCarnivore(double y, double x, float price_ ){
            super( y, x, price_);
            this.ground_speed =  seed%45;
       
        }
        
}







