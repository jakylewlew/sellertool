package DataStore;
import java.util.*;
import java.io.*;


public class Continent{
	//attributes
	public boolean arr[][];
	public String descriptor;
	public float price;
	
	//constructor
	public Continent(String FileName, String descriptor_) {
		this.arr = new boolean[60][20];
		this.load(FileName);
		this.descriptor = descriptor_;
		this.setPrice(descriptor_);
	}
	
	//member functions
	public boolean IsInContinent(Coordinates coordinate) {
		int temp_x = coordinate.y;
		int temp_y = coordinate.x;
		boolean result = arr[temp_x][temp_y];
		
		return result;
	} 
	
	public void load(String fileName) {
		try {
			File ScanFile = new File(fileName);
			Scanner s = new Scanner(ScanFile);
			int row = 0;
			while (s.hasNextLine()) {
				String tempString = s.nextLine();
				
				if(tempString.trim().isEmpty()) {
					break;
				}
				
				for (int i = 0; i < tempString.length(); i++) {
					switch(tempString.charAt(i)) {
						case '0':
							this.arr[i][row] = false;
							break;
						case '1':
							this.arr[i][row] = true;
							break;
						default:
							this.arr[i][row] = false;
							break;
					}
				}
				row++;
			}
		} 
		catch (FileNotFoundException fnfe) {
			System.out.printf("Error\n");
		}
	}
	
	public void setPrice(String descriptor_) {
		
		
		switch(descriptor_) {
			case "North America":
				this.price = 1000;
				break;
			case "South America":
				this.price = 3000;
				break;	
			case "Europe":
				this.price = 1000;
				break;
			case "Africa":
				this.price = 3000;
				break;	
			case "Asia":
				this.price = 4000;
				break;
			case "Antarctica":
				this.price = 100000;
				break;
			case "Australia":
				this.price = 5000;
				break;
			default:
				this.price = 1000;
				break;
		}
		
	}
	
	final float getPrice(Continent temp) {
		return temp.price;
	}
	
	final String getContinent(Continent temp) {
		return temp.descriptor;
	}

}


