package DataStore;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Continent {

    public boolean arr[][];

    public String descriptor;

    public float price;

    public Continent(String FileName, String descriptor_) {
        this.arr = new boolean[3600][1800];
        this.load(FileName);
        this.descriptor = descriptor_;
        this.setPrice(descriptor_);
    }

    public boolean IsInContinent(Coordinates coordinate) {
        int temp_x = coordinate.y;
        int temp_y = coordinate.x;
        boolean result = arr[temp_x][temp_y];
        return result;
    }

    public void load(String fileName) {
        try{
            //open world map file
            File wm = new File(fileName);
            //create worldmap image
            BufferedImage map_ = ImageIO.read(wm);
            for(int i=0; i<1800; ++i) {
                for(int j=0; j<3600; ++j) {
                    Color c = new Color(map_.getRGB(j, i));
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    if(red == 255 && green == 255 && blue == 255) {
                        //its black
                        this.arr[j][i] = false;
                }
                    else{
                        //its white
                        this.arr[j][i] = true;
                    }
                }
            }
            
        }
        catch(IOException ex) {
            //do something
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
