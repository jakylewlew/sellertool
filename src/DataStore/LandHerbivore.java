package DataStore;

import java.util.*;
import java.io.*;

public class LandHerbivore extends LandDinosaur {

    public double gait;

    public LandHerbivore(int bone_id_, float price_, int bought_, double y, double x) {
        super(bone_id_, price_, bought_, y, x);
        this.gait = 4;
    }

    public LandHerbivore(double y, double x, float price_) {
        super(y, x, price_);
        gait = System.currentTimeMillis() % 4;
    }
}
