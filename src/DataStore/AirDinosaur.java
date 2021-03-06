package DataStore;

import java.util.*;
import java.io.*;

public class AirDinosaur extends Dinosaur {

    public double wingspan;

    public AirDinosaur(int bone_id_, float price_, int bought_, double y, double x) {
        super(bone_id_, price_, bought_, y, x);
        Random rn = new Random();
        int rn1 = rn.nextInt(50 - 10 + 1) + 10;
        this.wingspan = (double) rn1;
    }

    public AirDinosaur(double latitude, double longitude, float price) {
        super(latitude, longitude, price);
        wingspan = (double) System.currentTimeMillis() % 50;
        if (wingspan < 10.0) {
            wingspan = 10.0;
        }
    }
}
