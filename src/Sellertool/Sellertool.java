/*Jacob Lewis
1325-001
jacobalewis@mavs.uta.edu

*/
package Sellertool;


import DataStore.Amargasaurus;
import DataStore.Dakosaurus;
import DataStore.MapO;
import DataStore.Dinosaur;
import DataStore.Giganotosaurus;
import DataStore.Hylaeosaurus;
import DataStore.Pteranodon;
import DataStore.Pterodactyl;
import DataStore.Shastasaurus;
import DataStore.Spinosaurus;
import DataStore.Triceratops;
import DataStore.TyrannosaurusRex;
import DataStore.Velociraptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;



public class Sellertool{
     
    ArrayList<Dinosaur> bonelist = new ArrayList<>();
    ArrayList<MapO> MapNode = new ArrayList<>();
    ArrayList<Dinosaur> Dinolist = new ArrayList<>();
    char map[][];
    Scanner input;
    Formatter output;
    Dinosaur temp = null;
    Scanner scanstream; 
    public boolean maploaded;
    public boolean filesloaded;
    public boolean createdBone;
    Seller sellerop;
   
    
            public Sellertool(){
            sellerop = new Seller(0);
            output = new Formatter(System.out);
            input = new Scanner(System.in);    
            map = new char[60][20]; 
            filesloaded = false;
            maploaded= false;
           
        }
      public void mainmenu(){
          
            //download new bone file there you go   
            
            MapO Bone = new MapO();
            int i;int x;
            output.format("\nBUYING BONES FROM MARY JONES DINO BONE SHOP\n1:Load the Map\n"
                    +"2:Handle Bone\n"
                    +"3:Show the world map with Bones\n"
                    +"4:Save Files\n5"
                    +":Load Files\n"
                    + "6:Create Seller\n"+
                    "7:Make Specailty\n"
                    + "8:Exit\n");
            int choice = getI();
                   
            switch(choice)
            {
            case(1):{//loads the map             
               if(!MapNode.isEmpty()){//if there is nothing in the MapNodes
                   MapNode.clear();
               } 
               LoadMap();
               maploaded = true;
               output.format("\nMap is Loaded\n");//email this to me 
               break;
            }
            case(2):{//calls displays all bones in the bonlist the prompts how to handle anybone or add a bone to bone list
                    bonehandle();
                    }//outercase2
           
            case(3):
            {
                show_map();
                 break; 
            }
                     
            
            case(4):
            { 
                try {//sends to file
                    File Bonetext = new File("Bones.txt");
                    Formatter filewriter = new Formatter(Bonetext);
                    
                    for(i=0;i<bonelist.size();i++){
                        temp = bonelist.get(i);
                        filewriter.format( "%d,%d,%f,%f,%d,%f,%f,%f,%f,%f,%d,%s,%s,%s,%s%n",temp.boneid,temp.age,temp.price,temp.weight,temp.bought,temp.globe_longitude,temp.globe_latitude,temp.length,temp.width,temp.height,temp.buyer_id,temp.name,temp.condition,temp.country,temp.prospector );
                        
                        
                    }
                    output.format("\nFiles are saved...\n");
                    filewriter.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Sellertool.class.getName()).log(Level.SEVERE, null, ex); 
                }
                
                
            }   break;
                
            case(5):
            {//load files
                if(!bonelist.isEmpty())
                {//if bones array is empty clear it to so not to stack it
                    bonelist.clear();
                }
                makeabonefromfiles();
                LoadMap();
                filesloaded = true;
                maploaded = true;
                output.format("\n Files are Loaded...\n");
    
                break;
            }        
                
            case(6):{
                sellerop.changesellermenu();//calls sellermenu in seller class
                break;
            } 
            
            case(7):{
                    String[] line;
                    boolean notfound = false;
                    
                    do{
                    
                     try{
                         System.out.print("Enter Bone with this format\n"+
                            "Latitude,Longitude,Bone Type,Price\n");
                         
                    String buffer = input.nextLine();
                    line = buffer.split(",");
                   
                    Double vertical = Double.parseDouble(line[0]);
                    Double horizontal = Double.parseDouble(line[1]);
                    String bonety = line[2];
                    float price = Float.parseFloat(line[3]);
                   
                        if(getspecialbone(vertical,horizontal,bonety, price)==null){
                            notfound = true; //if method returns null;
                            }  
                     }catch(ArrayIndexOutOfBoundsException e){
                         output.format("Enter Valid Input!!!\n");
                         notfound = true;
                         
                    }catch(NumberFormatException e){
                        output.format("Enter Valid Input!!!\n");
                         notfound = true;
                        
                    }
                    }while(notfound);  //will not break creating loop until valid bone is entered//not found == true
                   
                    
                        break;
                
            }case(8):{
                System.exit(0);
                break;
                
        }default:{
            output.format("\nTry Again...\n");
            }//catch bad choices
            
            }//end switch1
            
            }//mainmenu
            
        //construct new bone temp from file
        public void makeabonefromfiles()
        {   
            File BoneFile;
            Scanner scanstream;
            
            try {
            BoneFile = new File("Bones.txt");
            scanstream = new Scanner(BoneFile);
            
            while(scanstream.hasNextLine()){
                scanstream.useDelimiter(",");
              
                String buffer = scanstream.nextLine();
                
                if(buffer.isEmpty()) {
                    break;
                }
                //split string and strip white space
                String[] data = buffer.split(",");
                
               // temp = new DinosaurBone();
                
                temp.boneid = Integer.parseInt(data[0].trim());
                //output.format(":got here");
                temp.age = Integer.parseInt(data[1].trim());
                temp.price = Float.parseFloat(data[2].trim());
                temp.weight = Float.parseFloat(data[3].trim());
                temp.bought = Integer.parseInt(data[4].trim());
                temp.globe_longitude = Double.parseDouble(data[5].trim());
                temp.globe_latitude = Double.parseDouble(data[6].trim());
                temp.length = Float.parseFloat(data[7].trim());
                temp.width = Float.parseFloat(data[8].trim());
                temp.height = Float.parseFloat(data[9].trim());
                temp.buyer_id = Integer.parseInt(data[10].trim());
                temp.name = data[11].trim();
                temp.condition = data[12].trim();
                temp.country = data[13].trim();
                temp.prospector  = data[14].trim();
                temp.Location.latit = temp.globe_latitude;
                temp.Location.longi = temp.globe_longitude;
                temp.Location.updatecoordinates();
               //bonelist.add(temp);
                //output.format("%s", temp.prospector);
                //scanstream.nextLine();
            }//while
            
            
            
            scanstream.close();
        } //makeabonefrom files
        catch (FileNotFoundException ex) {
            Logger.getLogger(Sellertool.class.getName()).log(Level.SEVERE, null, ex);
        }
     }//make bone from files
        
        //loads the map from a text doc of csv file 1,0,0
        public void LoadMap() {
                        File MapFile;
                        Scanner ScanFile;
                        String Buffer;
                        Scanner ScanBuffer;

                        try {
                            MapFile = new File("Map.txt");
                            ScanFile = new Scanner(MapFile);
                            MapO TempMap;

                            while(ScanFile.hasNextLine()) {
                                Buffer = ScanFile.nextLine();
                                ScanBuffer = new Scanner(Buffer).useDelimiter(",");
                                TempMap = new MapO();

                                int x = 0; int y = 0; int z = 0;

                                x = ScanBuffer.nextInt();
                                y = ScanBuffer.nextInt();
                                z = ScanBuffer.nextInt();

                                TempMap.MapX = x;
                                TempMap.MapY = y;
                                TempMap.MapZ = z;
                                

                                MapNode.add(TempMap);
                                ScanBuffer.close();
                            }//whileloop
                            
                            this.maploaded = true;
                            ScanFile.close();
                        }/*try*/ catch (Exception e) {
                        }//catach exception
                   }//load map
       
        public int getI()//Int input mismatch 
        {
           
            String intbuffer;
            int result=0; 
            while(true)
            {
            try {
                intbuffer = input.nextLine();
                
                result = (Integer.valueOf(intbuffer));
                break;
            } catch(NumberFormatException e) {
                output.format("Please try again\n");
                continue;
            }/*){
            }*/
            
            }
            return result;
        }//getI
        
        public float getF()//float input mismatch
        {   String buffer;
            float result;
            while(true)
            {
                
                
                try {
                    buffer = input.nextLine();
                    result = Float.valueOf(buffer);
                    break;
                } catch (NumberFormatException e) 
                    {
                    output.format("Please try again\n");
                   //input.nextLine();
                    continue;
                    }
               /* catch(){
                    
                }*/
              
            }  
            return result;
                
        }//getf()
        public void makeBone(){//makes new bone calls boneediting for coord and id price yada puts in bone list
                        //temp = new DinosaurBone();
                        temp.boneediting(temp);
                        Random rn = new Random();
                        temp.boneid = rn.nextInt(15000 -1 + 1);
                        output.format("\nAge:");
                        temp.age = getI();
                        //temp.price = scanstream.nextFloat();
                        output.format("\nWeight:");
                        temp.weight = getF();
                        temp.bought = 0;
                        output.format("\nLength:");
                        temp.length = getF();
                        output.format("\nWidth:");
                        temp.width = getF();
                        output.format("\nHeight:");
                        temp.height = getF();
                        //output.format("\nId#:");
                        //temp.buyer_id = getI();
                        output.format("\nBone Name:");
                        temp.name = input.nextLine();
                        output.format("\nCondition:");
                        temp.condition = input.nextLine();
                        output.format("\nCountry of Orgin:");
                        temp.country = input.nextLine();
                        output.format("\nWho found it:");
                        temp.prospector  = input.nextLine();
                        temp.Location.updatecoordinates();            
                        //bonelist.add(temp); 
                         
    
    }   //import bones to bonelist return list for decifer with dollar signs
     
        
    public void show_map() {
        int j;
        int i;
        int x;
        int y;
        if(!this.maploaded) {
            //if map not loaded, give error message
            output.format("\nPlease load map first..\n\n");
        }else {
           //load map from arraylist to 2D char array
           
            for(i=0; i<MapNode.size(); i++) {
                //output.format("%d:%d\n", MapNode.get(i).MapX,MapNode.get(i).MapY);
                 x = MapNode.get(i).MapX;
                 y = MapNode.get(i).MapY;
                 
                this.map[x][y] = get_map_symbol(MapNode.get(i).MapZ);
                
            }
                    
            //if files loaded, load bones into map
            if(filesloaded || createdBone) {
                //load bones into map
                for( i=0; i<bonelist.size(); i++) {
                     //output.format("%s%d:%d|\n",bonelist.get(i).name, bonelist.get(i).Location.x,bonelist.get(i).Location.y);
                    //get map info from bone arraylist
                    int bought = bonelist.get(i).bought;
                     x = bonelist.get(i).Location.x;
                     y = bonelist.get(i).Location.y;
                   
                    this.map[y][x] = get_bone_map_symbol(bought);
                    
                }
                
            }
            else{
                //give error message for bone files not loaded
                output.format("\nNOTE: This map does not show bones!\n");
                output.format("NOTE: Please load files to see bones!\n\n");
            }
            
            //Display Map
            output.format("\n");
            for(i = 0; i<20; ++i) {
                for(j = 0; j<60; ++j) {
                    output.format("%c", this.map[j][i]);
                }
                output.format("\n");
            }
            output.format("\nPress Enter to return to main menu\n");
            input.nextLine();
        
        }
    
    }
        
         public char get_map_symbol(int input) {
        char symbol = '.';
        switch(input) {
            case 0: 
                symbol = '.';
                break;
            case 1:
                symbol = '*';
                break;
        }
    
        return symbol;
    }  

        public char get_bone_map_symbol(int input) {
        char symbol = 'X';
        switch(input) {
            case 0: 
                symbol = 'X';
                break;
            case 1:
                symbol = '$';
                break;
        }
    
        return symbol;
    }
        
        public void bonehandle(){//operates on the bones
                int i;
                int x;
                for(i=0;i<bonelist.size(); i++)
                        {   temp = bonelist.get(i);//prints the Current in bone list 
                            output.format("\nID:%d, Bonename:%s, Lat->%f, Long->%f  (%d:%d) Price:%f\n",temp.boneID,temp.name,temp.coordinates.latit,temp.coordinates.longi, temp.coordinates.x,temp.coordinates.y,temp.price);
                        }
                        output.format("\nHow would you like to handle your bone Handler\n"+
                                "1:Make bonez"
                                +"\n2:Sell a bone\n"+
                                "3:Modify a bone on the bone list\n"
                                +"4:Remove bone\n5:Exit\n");
                        int selection = getI();
                        
                        switch(selection)//handle handling
                        {
                            case(1):
                                    {   
                                            
                                        //make a bone from scratch
                                        makeBone();//will add to bonelist on its own
                                        createdBone = true;
                                        break;
                                    }    

                            case(2):{if(bonelist.isEmpty()){
                                     output.format("\nNo bones are loaded yet....\n");
                                     break;}
                                     boolean found = false;
                                     output.format("\nEnter ID number of the bone you would like to Sell:");
                                     x = input.nextInt();
                                     input.nextLine();
                                     for(i=0; i<bonelist.size(); i++) 
                                     {
                                        if (bonelist.get(i).boneid == x ) //goes through sellablebonelist and checks if that id number exsists
                                        {
                                             found = true;
                                        }
                                     }//forloop for id verification
                                         if(found == false)
                                         {
                                          output.format("\nIncorrect Id number...\n");
                                          break;
                                         }
                                        if(found == true)
                                        {
                                            
                                            for(i=0; i<bonelist.size(); i++) 
                                            {  
                                              if((x == bonelist.get(i).boneid) && (bonelist.get(i).bought == 0))
                                                  
                                              {
                                                  bonelist.get(i).bought = 1;
                                              }
                                              
                                            }          
                                          break;
                                        }
                                    }break;
                            case(3):{  //Modify bones
                                    if(bonelist.isEmpty())//make sure that the has bones
                                    {
                                    output.format("\nNo bones are loaded yet....\n\n");
                                    break;
                                    }
                                       boolean found = false;
                                       output.format("Enter ID number of the bone you would like to modify or press 4 to exit\nID number:");
                                       x = input.nextInt();
                                       input.nextLine();
                                       int bone_index = 0;
                                                for(i=0; i<bonelist.size(); i++) 
                                                {
                                                    if (bonelist.get(i).boneid == x ) //goes through bonelist and checks if that id number exsists
                                                    {
                                                       bone_index = i;
                                                       found = true;
                                                       break;
                                                    }

                                                }//forloop check id 
                                        if(found)
                                        {
                                            temp = bonelist.get(bone_index);//use of temp could interfear//can change to edit only your own bones
                                            temp.boneediting(temp);//cool bone is editng itself//change info for coord
                                        }
                                        else{
                                            output.format("\nBone Not Found...\n");
                                        }

                                        break;
                                    }
                            case (4):{
                                boolean found = false;
                                
                                if(bonelist.isEmpty()){
                                output.format("\nNo bones in the bonelist...\n");
                                break;
                                 }
                                
                                
                                output.format("\nEnter ID of removed bone:");
                                int remove_ID = getI();
                                int bone_index = 0;//gets the  bone index to remove said bone
                                for (int iter = 0; iter <bonelist.size(); iter++)
                                {
                                    if (bonelist.get(iter).boneid == remove_ID)
                                    {
                                        bone_index = iter;
                                        found = true;
                                        break;
                                    }
                                }

                                if (found)
                                {
                                    bonelist.remove(bone_index);
                                    output.format("\nRemoved....\n");
                                }
                                else
                                {
                                    output.format("\nTry again!\nMake sure that you have entered the correct id number...\n");
                                }
                            }//remove bone
                            case (5):
                            {
                                break;
                            }          
                        }//inner switch
                        
            
            
        }
        
 public Dinosaur getspecialbone(double latitude,double longitude,String bonety, float price ){
        Dinosaur temp = null;
        String[] specialbones = {"Spinosaurus","TyrannosaurusRex","Gigantosaurus","Velociraptor","Triceratops","Hylaeosaurus","Amargasaurus","Dakosaurus","Shastasaurus","Pterodactyl","Pterosaurs","Pteranodon"};
        boolean inarray = false;//starts false

        for(int i=0; i < specialbones.length; i++){//checks for valid dinosaur
            
            if(bonety.equals(specialbones[i])){
                inarray = true;
            }
        }    
    if(inarray){
    
    switch(bonety){//uses the 3rd string from super as a switch to make that typ of dinosaur
    
        case("Spinosaurus"): {
            
            temp = new Spinosaurus(latitude, longitude, price);//(x,y,price)
            bonelist.add(temp);
            break;
            
        } 
        case("TyrannosaurusRex"):{
        
            temp = new TyrannosaurusRex(latitude,longitude,  price);//(x,y,price)
            bonelist.add(temp);
            break;
        
        }
        case("Gigantosaurus"):{
            temp = new Giganotosaurus(latitude, longitude, price);//(x,y,price)
            bonelist.add(temp);
            break;
        
        }
        case("Velociraptor"):{
            temp = new Velociraptor(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;
        }
        case("Triceratops"):{ 
            temp = new Triceratops(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;
        }
        case("Hylaeosaurus"):{ 
            temp = new Hylaeosaurus(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;
        }
        case("Amargasaurus"):{
            temp = new Amargasaurus(latitude, longitude, price);//(x,y, price
            temp.coordinates.updatecoordinates();
            bonelist.add(temp);
            break;
           
        }case("Dakosaurus"):{
            temp = new Dakosaurus(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;
        }case("Shastasaurus"):{
            temp = new Shastasaurus(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;
        }case("Pterodactyl"):{
            temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;
        }case("Pterosaurs"):{
            temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;
        }case("Pteranodon"):{
            temp = new Pteranodon(latitude, longitude, price);//(x,y, price
            bonelist.add(temp);
            break;            
        }default:{
            System.out.print("Not a valid bone please select one of the following types\nSpinosaurus\nTyrannosaurusRex"+
                    "\nGigantosaurus\nVelociraptor\nTriceratops\nHylaeosaurus\nAmargasaurus\n");
        }//default
    }//switch    
     
    return temp;    
    }
    else{
        return null; 
    }
 }//Super  
         
        
        
     public static void main(String[] args){
        
        Sellertool seller = new Sellertool();        
            while(true){
                seller.mainmenu();
            }
                    
                
       
        
           }//main
}
                   
                    
                                   
            
            
         
           
            

   