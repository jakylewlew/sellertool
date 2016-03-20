package DataStore;
import java.util.*;
import java.io.*;


public class Buyer {
    public String name;
    public Coordinates coordinate;
    public int ID;
    
    public Buyer(String name_, int ID_, double longitude_, double latitude_) {
        ID = ID_;
        name = name_;
	this.coordinate = new Coordinates(latitude_,longitude_);
    }
    
}

