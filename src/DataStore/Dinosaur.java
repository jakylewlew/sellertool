package DataStore;

import java.util.*;
import java.io.*;

public class Dinosaur {

    public int boneID;

    public float price;

    public float adjusted_price;

    public Coordinates coordinates;

    public Buyer buyer;

    public Seller seller;

    public int bought;

    public String name;

    public Dinosaur(int bone_id, float price_, int bought_, double y, double x) {
        this.boneID = bone_id;
        this.price = price_;
        this.adjusted_price = price_;
        this.coordinates = new Coordinates(x, y);
        this.bought = bought_;
    }

    public Dinosaur(double x, double y, float price) {
        this.price = price;
        this.adjusted_price = 0;
        this.coordinates = new Coordinates(x, y);
        boneID = -1 * (int) System.currentTimeMillis() % 99999;
        buyer = new Buyer("Your Name", ((int) boneID % 999), 0, 0);
        seller = new Seller(0);
        seller.name = "Jacob Lewis";
        bought = 0;
    }

    public Dinosaur() {
        this.coordinates = new Coordinates();
        boneID = -1 * (int) System.currentTimeMillis() % 99999;
        buyer = new Buyer("Your Name", ((int) boneID % 999), 0, 0);
        seller = new Seller(0);
        seller.name = "Jacob Lewis";
    }

    public float pricing(Dinosaur x) {
        return ((float) ((x.price) * System.currentTimeMillis() % 9999));
    }
}
