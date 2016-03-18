/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastore;

/**
 *
 * @author jacob
 */




class LandDinosaur extends DinosaurBone {
    double speed = 15.0;
}

class LandCarnivore extends LandDinosaur {//land Carn has spped maximum of 45 mph
    long seed = System.currentTimeMillis();
    int groundspeed = (int)seed %45 ;
  
}

class Gigantosaurus extends LandCarnivore {
    void poorLittleMe() { System.out.printf("Bigger than T-Rex, but not as cool\n"); }
    
    public Gigantosaurus(){  
    boneid = -1 * (int) System.currentTimeMillis()%999999;//6 digitid
    age = 0;
    price = 0;
    weight = 0;
    condition = "N/A";
    bought = 0;//unsold
    length = 0;
    height = 0;
    name = "Gigantosaurus#"+ boneid;
        
    }
    
}

class TyrannosaurusRex extends LandCarnivore {
    int smellRange = 4;
    int scary = (int) System.currentTimeMillis()%4;
    void scary() { 
        System.out.printf("%d\n", scary); }
    public TyrannosaurusRex(){
        
    price = 0;
    boneid = -1 * (int) System.currentTimeMillis()%99999;
    age = 0;
    price = 0;
    weight = 0;
    condition = "N/A";
    bought = 0;//unsold
    length = 0;
    height = 0;
    name = "TyrannosaurusRex#"+ boneid;
        
    }
}

class Velociraptor extends LandCarnivore {
    int size = (int) System.currentTimeMillis() % 3;
    public Velociraptor() {  
        price = 0;
        boneid = -1 * (int) System.currentTimeMillis()%99999;
        age = 0;
        price = 0;
        weight = 0;
        condition = "N/A";
        bought = 0;//unsold
        length = 0;
        height = 0;
        name = "Velociraptor#"+ boneid; 
    }
    void size()
    {
        String result = "";
        switch (this.size) {
            case 0: result = "Small"; break;
            case 1: result = "Medium"; break;
            case 2: result = "Large"; break;
        }
        result += "\n";
        System.out.printf(result);
     
    }
    
}

class Spinosaurus extends LandCarnivore {
    public Spinosaurus(){
    
    int spines = (int)(System.currentTimeMillis()%8);//fins bw  0 and 8;
    price = 0;
    boneid = -1 * (int) System.currentTimeMillis()%99999;
    age = 0;
    price = 0;
    weight = 0;
    condition = "N/A";
    bought = 0;//unsold
    length = 0;
    height = 0;
    name = "Spinosaurus#"+ boneid;
    }//constructor
}//spinosaurus

class LandHerbivore extends LandDinosaur {
    double gait = System.currentTimeMillis()%4;//largest gait 4 
}

class Triceratops extends LandHerbivore {
    protected int added_price = 2500;
    public Triceratops(float price)
    {
    this.price = add_total(price);  //direction want it to be a double but our DinoCLass def as float
    boneid = (int) System.currentTimeMillis()%99999 *-1;
    age = 0;
    weight = 0;
    condition = "N/A";
    bought = 0;//unsold
    length = 0;
    height = 0;
    name = "Triceratops#"+ boneid;
    }
    public float add_total(float price)
    {       
        return added_price + price;
    }
}

class Hylaeosaurus extends LandHerbivore {
    int left = (int) System.currentTimeMillis()%3;
    int right = (int) System.currentTimeMillis()%3;
    public Hylaeosaurus() {     
        price = 0;
        boneid = -1 * (int) System.currentTimeMillis()%99999;
        age = 0;
        price = 0;
        weight = 0;
        condition = "N/A";
        bought = 0;//unsold
        length = 0;
        height = 0;
        name = "Hylaeosaurus#"+ boneid; 
    
    }
}

class Amargasaurus extends LandHerbivore {
    static String dlc = "EF02059517ABB1DA";
    Amargasaurus() {
        price = 0;
        boneid = -1 * (int) System.currentTimeMillis()%99999;
        age = 0;
        price = 0;
        weight = 0;
        condition = "N/A";
        bought = 0;//unsold
        length = 0;
        height = 0;
        name = "Amargasaurus#"+ boneid; 
    }
}

class SeaDinosaur extends DinosaurBone {
    boolean fresh; boolean salt;
    void tf()
    {
        switch ( (int) (Math.random()) ) {
            case 0:
                fresh = false;
                salt = true;
            default:
                fresh = true;
                salt = false;
        }    
    }
    SeaDinosaur () { super(); tf(); }
    
} 