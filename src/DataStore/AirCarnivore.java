package DataStore;

import java.util.*;
import java.io.*;

public class AirCarnivore extends AirDinosaur {

    public int teeth;

    public AirCarnivore(int bone_id_, float price_, int bought_, double y, double x) {
        super(bone_id_, price_, bought_, y, x);
        Random rn = new Random();
        this.teeth = rn.nextInt(60 - 10 + 1) + 10;
    }

    public AirCarnivore(double latitude, double longitude, float price) {
        super(latitude, longitude, price);
        teeth = (int) System.currentTimeMillis() % 60;
        if (teeth < 10) {
            teeth = 10;
        }
    }
}
