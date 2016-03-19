package DataStore;
import java.util.*;
import java.io.*;


public class SeaCarnivore extends SeaDinosaur{
	public int propulsion;

	public SeaCarnivore(int bone_id_, float price_, int bought_,
						double y, double x) 
	{
                        super(bone_id_, price_, bought_, y, x);
			Random rn2 = new Random();
			propulsion = rn2.nextInt(3-1+1) + 1; //from 1 to 3
			
			
	}
        public SeaCarnivore(double latitude,double longitude, float price){
            
            super(latitude, longitude, price);
            propulsion = (int) System.currentTimeMillis()%3 *-1;
            
                    
        }
	
	public String getPropulsion() {
		String result = "";
		
		switch(this.propulsion) {
			case 1:
				result = "Flippers";
				break;
			case 2:
				result = "Tails";
				break;
			case 3:
	
				result = "Feet";
				break;
			default:
				result = "Flippers";
				break;
		}
		
		return result;
	
	}
        
        
   
   
	
}

