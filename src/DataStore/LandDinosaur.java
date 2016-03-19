package DataStore;
import java.util.*;
import java.io.*;


//LAND DINOSAURS
public class LandDinosaur extends Dinosaur{
	//atrributes
	public double speed = 15.0;
	
	//constructor
	public LandDinosaur(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
		super(bone_id_, price_, bought_, y, x); 	
	}	
	
        public LandDinosaur(double y, double x, float price_ ){
        
                super( y,x,price_);
        }
	
}











