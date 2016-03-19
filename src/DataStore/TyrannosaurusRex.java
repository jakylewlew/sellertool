package DataStore;
import java.util.*;
import java.io.*;


public class TyrannosaurusRex extends LandCarnivore{
	//atrributes
	public int smelling_range;
	
	//constructor
	public TyrannosaurusRex(int bone_id_, float price_, int bought_, 
						double y, double x) 
	{	
                super(bone_id_, price_, bought_, y, x);
		Random rn = new Random();
		this.smelling_range = rn.nextInt(100 - 20 + 1) + 20; //from 20-100
		this.name = "TyrannosaurusRex"; 	
	}
        
        public TyrannosaurusRex(double latitude,double longitude, float price){//jakes constructor
            super(latitude, longitude,price);
            boneID = (int) System.currentTimeMillis()%99999 *-1;
            int smellRange = -1 *(int) System.currentTimeMillis()%100;//ramd number by time less than 100
            if (smelling_range<20)    //if less than 20, make twnty for min smellrange
            {smelling_range = 20;
            } name = "TyrannosaurusRex";
            buyer = null;
            seller = null;
            bought = 0;
        }
	 
	public int howScary() {
		Random rn = new Random();
		int result = rn.nextInt(5 - 1 + 1) + 1; //from 1 to 5
		return result;
	}
        
	public float pricing() {
		Random rn = new Random();
		int temp = rn.nextInt(100000 - 20000 + 1) - 20000; 
		float res = (float)temp;
		
		return res;
	}        
	
}











