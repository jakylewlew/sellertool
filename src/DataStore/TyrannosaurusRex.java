package DataStore;

import java.util.*;
import java.io.*;

public class TyrannosaurusRex extends LandCarnivore {

    public int smelling_range;

    public TyrannosaurusRex(int bone_id_, float price_, int bought_, double y, double x) {
        super(bone_id_, price_, bought_, y, x);
        Random rn = new Random();
        this.smelling_range = rn.nextInt(100 - 20 + 1) + 20;
        this.name = "TyrannosaurusRex";
    }

    public TyrannosaurusRex(double latitude, double longitude, float price) {
        super(latitude, longitude, price);
        int smellRange = -1 * (int) System.currentTimeMillis() % 100;
        if (smelling_range < 20) {
            smelling_range = 20;
        }
        name = "TyrannosaurusRex";
        bought = 0;
    }

    public int howScary() {
        Random rn = new Random();
        int result = rn.nextInt(5 - 1 + 1) + 1;
        return result;
    }

    public float pricing() {
        Random rn = new Random();
        int temp = rn.nextInt(100000 - 20000 + 1) - 20000;
        float res = (float) temp;
        return res;
    }
}
