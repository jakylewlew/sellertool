package DataStore;
import java.util.*;
import java.io.*;

public class AirCarnivore extends AirDinosaur {
	//atrributes
	public int teeth;
	
	//constructor
	public AirCarnivore(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		this.teeth = rn.nextInt(60-10+1) + 10; //from 10 to 60
		
		 	
	}	
       
        public AirCarnivore(double latitude, double longitude, float price)
        {
            super(latitude, longitude, price);
            teeth = (int)System.currentTimeMillis()%60;
            if(teeth<10)
            {
                teeth = 10;//min teeth
            }
            
        }
	
}
