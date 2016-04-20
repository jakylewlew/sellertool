package DataStore;

import java.util.*;
import java.io.*;

public class Velociraptor extends LandCarnivore {

    public int size;

    public Velociraptor(int bone_id_, float price_, int bought_, double y, double x) {
        super(bone_id_, price_, bought_, y, x);
        Random rn = new Random();
        this.size = rn.nextInt(3 - 1 + 1) + 1;
        this.name = "Velociraptor";
    }

    public Velociraptor(double latitude, double longitude, float price) {
        super(latitude, longitude, price);
        name = "Velociraptor";
        bought = 0;
        size = (int) System.currentTimeMillis() % 3;
    }

    public String getSizeLabel() {
        String result = "";
        switch(this.size) {
            case 1:
                result = "Small";
                break;
            case 2:
                result = "Medium";
                break;
            case 3:
                result = "Large";
                break;
            default:
                result = "Large";
                break;
        }
        return result;
    }

    public float pricing() {
        Random rn = new Random();
        int temp = rn.nextInt(100000 - 20000 + 1) - 20000;
        float res = (float) temp;
        return res;
    }
}
