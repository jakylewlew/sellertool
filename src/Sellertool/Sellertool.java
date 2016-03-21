/*Jacob Lewis
1325-001
jacobalewis@mavs.uta.edu

*/
package Sellertool;


import DataStore.Amargasaurus;
import DataStore.Continent;
import DataStore.Coordinates;
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




public class Sellertool{
     
    ArrayList<Dinosaur> bonelist = new ArrayList<>();
    ArrayList<MapO> MapNode = new ArrayList<>();
    public ArrayList<Continent> Continents = new ArrayList<>();
    char map[][];
    Scanner input;
    Formatter output;
    Dinosaur temp = null;
    Scanner scanstream; 
    public boolean maploaded;
    public boolean filesloaded;
    public boolean createdBone;
    public boolean moved;
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
            create_continents();
            MapO Bone = new MapO();
            int i;int x;
            output.format("\nBUYING BONES FROM MARY JONES DINO BONE SHOP\n1:Load the Map\n"
                    +"2:Handle Bone\n"
                    +"3:Show the world map with Bones\n"
                    +"4:Save Files\n5"
                    +":Load Files\n"
                    + "6:Create Seller\n"+
                    "7:Scramble\n"
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
                    break;
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
                       // filewriter.format( "%d,%d,%f,%f,%d,%f,%f,%f,%f,%f,%d,%s,%s,%s,%s%\n",temp.boneID,temp.age,temp.price,temp.weight,temp.bought,temp.globe_longitude,temp.globe_latitude,temp.length,temp.width,temp.height,temp.buyer_id,temp.name,temp.condition,temp.country,temp.prospector );
                       //output.format("%d,%f,%f,%f,%d,%s\n", temp.boneID, temp.price, temp.coordinates.longi, temp.coordinates.latit,temp.buyer.ID,temp.name);
                       filewriter.format("%d,%f,%d,%f,%f,%d,%s\n", temp.boneID, temp.price,temp.bought,temp.coordinates.longi, temp.coordinates.latit,temp.buyer.ID,temp.name);
                        
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
                    get_a_bone();
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
                
                 Dinosaur temp = new Dinosaur();
                
                temp.boneID = Integer.parseInt(data[0].trim());
                        //temp.age = Integer.parseInt(data[1].trim());
                temp.price = Float.parseFloat(data[1].trim());
                        //temp.weight = Float.parseFloat(data[3].trim());
                temp.bought = Integer.parseInt(data[2].trim());
                temp.coordinates.longi= Double.parseDouble(data[3].trim());
                temp.coordinates.latit= Double.parseDouble(data[4].trim());
                        //temp.length = Float.parseFloat(data[7].trim());
                        //temp.width = Float.parseFloat(data[8].trim());
                        //temp.height = Float.parseFloat(data[9].trim());
                temp.buyer.ID = Integer.parseInt(data[5].trim());
                temp.name = data[6].trim();
                        //temp.condition = data[12].trim();
                        //temp.country = data[13].trim();
                        //temp.prospector  = data[14].trim();
                        //temp.Location.latit = temp.globe_latitude;
                        //temp.Location.longi = temp.globe_longitude;
                        //temp.Location.updatecoordinates();
                temp.coordinates.updatecoordinates();
                change_suggested_price(temp,moved); //moved is false//goes to new bone price change piece line 815
                bonelist.add(temp);
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
                       temp = null; 
                       Double latit;
                       Double longi;
                       output.format("Latitude\n");
                       try{
                            latit = input.nextDouble();
                       
                        }catch(NumberFormatException e){
                            latit = 50.00;//default for people too stupid
                        }
                        try{
                            output.format("Longitude\n");
                            longi = input.nextDouble();
                        }catch(NumberFormatException e){
                            longi = 100.00;//default for people too stupid
                        }
                        input.nextLine();//clear
                        output.format("Price\n");
                        Float price = getF();
                        temp = go_pick_type(latit,longi,price);
                        change_suggested_price(temp,moved); //make new adjusted price // new bone piece line 815
                        sugg_price_function(temp);
                        
                       // Random rn = new Random();
                       // temp.boneid = rn.nextInt(15000 -1 + 1);
                       //output.format("\nAge:");
                       //temp.age = getI();
                       //temp.price = scanstream.nextFloat();
                       // output.format("\nWeight:");
                       // temp.weight = getF();
                        temp.bought = 0;
                        //output.format("\nLength:");
                        //temp.length = getF();
                        //output.format("\nWidth:");
                        //temp.width = getF();
                        //output.format("\nHeight:");
                        //temp.height = getF();
                        //output.format("\nId#:");
                        //temp.buyer_id = getI();
                        //output.format("\nBone Name:");
                        //temp.name = input.nextLine();
                        //output.format("\nCondition:");
                        //temp.condition = input.nextLine();
                        //output.format("\nCountry of Orgin:");
                        //temp.country = input.nextLine();
                        //output.format("\nWho found it:");
                        //temp.prospector  = input.nextLine();
                        //temp.coordinates.updatecoordinates();            
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
                     x = bonelist.get(i).coordinates.x;
                     y = bonelist.get(i).coordinates.y;
                   
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
                            change_suggested_price(temp,!moved);  //changes pricing according to continent //!moved is true// line 818 should execute
                            output.format("\nID:%d, Bonename:%s, Lat->%f, Long->%f  (%d:%d) Price:%f\n",temp.boneID,temp.name,temp.coordinates.latit,temp.coordinates.longi, temp.coordinates.x,temp.coordinates.y,temp.price);
                        }
                        output.format("\nHow would you like to handle your bone Handler\n"+
                                "1:Make bone\n"
                                +"2:Sell a bone\n"+
                                "3:Modify a bone on the bone list\n"
                                +"4:Remove bone\n"
                                +"5:See Suggested price for a bone\n"+
                                "6:Make Bone with Comma separated string\n"+
                                "7:Exit\n");
                        int selection = getI();
                        
                        switch(selection)//handle handling
                        {
                            case(1):
                                    {   makeBone();   //make bone from string                                     
                                        
                                        //makeBone();//will add to bonelist on its own
                                        createdBone = true;
                                        break;
                                    }    

                            case(2):{
                                if(bonelist.isEmpty()){
                                output.format("\nNo bones are loaded yet....\n");
                                break;
                            }
                                     boolean found = false;
                                     output.format("\nEnter ID number of the bone you would like to Sell:");
                                     x = input.nextInt();
                                     input.nextLine(); //clear
                                     for(i=0; i<bonelist.size(); i++) 
                                     {
                                        if (bonelist.get(i).boneID == x ) //goes through sellablebonelist and checks if that id number exsists
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
                                              if((x == bonelist.get(i).boneID) && (bonelist.get(i).bought == 0))
                                                  
                                              {
                                                  bonelist.get(i).bought = 1;
                                              }
                                              if((x == bonelist.get(i).boneID) && (bonelist.get(i).bought == 1)){//changes back to usold
                                                  bonelist.get(i).bought = 0;
                                              }
                                              
                                            }   break;       
                                          
                                        }break;
                                    }
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
                                                    if (bonelist.get(i).boneID== x ) //goes through bonelist and checks if that id number exsists
                                                    {
                                                       bone_index = i;
                                                       found = true;
                                                       break;
                                                    }

                                                }//forloop check id 
                                        if(found)
                                        {
                                            temp = bonelist.get(bone_index);
                                            boneediting(temp);          //change coord
                                            moved = true;
                                            change_suggested_price(temp,!moved);//change Suggested price//moved bone will execute 818
                                        }
                                        else{
                                            output.format("\nBone Not Found...\n");
                                        }

                                        break;
                                    }
                            case (4):{//removes bone form bone list
                                boolean found = false;
                                
                                if(bonelist.isEmpty()){
                                output.format("\nNo bones in the bonelist...\n");
                                break;
                                 }
                                
                                
                                output.format("\nEnter ID of removed bone:");
                                int remove_ID = getI();
                                int bone_index = 0; //gets the  bone index to remove said bone
                                for (int iter = 0; iter <bonelist.size(); iter++)
                                {
                                    if (bonelist.get(iter).boneID == remove_ID)
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
                                
                            {   boolean found = false;
                                output.format("Suggested Price\nEnter ID number:\n");
                                int see_adj_price = getI();
                                int bone_index = 0;     //gets the  bone index to remove said bone
                                for (int iter = 0; iter <bonelist.size(); iter++)
                                {
                                    if (bonelist.get(iter).boneID == see_adj_price)
                                    {
                                        bone_index = iter;
                                        found = true;
                                        break;
                                    }
                                }

                                if (found){
                                    change_suggested_price(bonelist.get(bone_index),!moved);//moved is true// execute 818// 
                                    output.format("Suggested Price: %f\n",bonelist.get(bone_index).adjusted_price);
                                    break;
                                }
                                break;
                                
                            }case(6):{
                                get_a_bone();
                                createdBone = true;
                                break;
                                
                            }
                            case(7):{
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
            change_suggested_price(temp,moved);//moved is false
            System.out.print(temp.adjusted_price);
            bonelist.add(temp);
            break;
            
        } 
        case("TyrannosaurusRex"):{
        
            temp = new TyrannosaurusRex(latitude,longitude,price);//(x,y,price)
            change_suggested_price(temp,moved); //moved is false
            System.out.print(temp.adjusted_price);
            bonelist.add(temp);
            
            break;
        
        }
        case("Gigantosaurus"):{
            temp = new Giganotosaurus(latitude, longitude, price);//(x,y,price)
            change_suggested_price(temp,moved);
            System.out.print(temp.adjusted_price);
            bonelist.add(temp);
            break;
        
        }
        case("Velociraptor"):{
            temp = new Velociraptor(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }
        case("Triceratops"):{ 
            temp = new Triceratops(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }
        case("Hylaeosaurus"):{ 
            temp = new Hylaeosaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }
        case("Amargasaurus"):{
            temp = new Amargasaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);            
            bonelist.add(temp);
            break;
           
        }case("Dakosaurus"):{
            temp = new Dakosaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Shastasaurus"):{
            temp = new Shastasaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Pterodactyl"):{
            temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Pterosaurs"):{
            temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Pteranodon"):{
            temp = new Pteranodon(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;            
        }default:{
            System.out.print("Not a valid bone please select one of the following types\nSpinosaurus\nTyrannosaurusRex"+
                    "\nGigantosaurus\nVelociraptor\nTriceratops\nHylaeosaurus\nAmargasaurus\n");
        }//default
    }//switch    
     
       
    }
    return temp; 
    
 }
 
    public void get_a_bone(){
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
                   
    }   
        
    public void boneediting(Dinosaur x){//bone editing for new file format Dinosuarclass
        
        
           do{ output.format("\nEnter the coordinate Latitude:");
               x.coordinates.latit = input.nextDouble();
           }while ((x.coordinates.latit < -90.0) || (x.coordinates.latit > 90.0));
            if(x.coordinates.latit > 84.0){//take care of array ob because of trucation
                x.coordinates.latit = 90.00;
            }
            if(x.coordinates.latit<-90.0){
                x.coordinates.latit = -90.0;//take care array ob
            }
        output.format("\nEnter the coordinate Longitude:");
        do{
            x.coordinates.longi = input.nextDouble();
        }while((x.coordinates.longi < -180.0) || (x.coordinates.longi > 180.0));
        
            if(x.coordinates.longi < -174){
                x.coordinates.longi = -180.0;//must adjust because trunctation round value to 60,not 59 and causes a outo bounds error}
            }
            if (x.coordinates.longi>174){
                x.coordinates.longi= 180.0;//array ob adjustment
            }
            x.coordinates.updatecoordinates();
            
    }
         
        public void create_continents() {
        String[] continent_name = new String[7];
        continent_name[0] = "North America";
        continent_name[1] = "South America";
        continent_name[2] = "Europe";
        continent_name[3] = "Africa";
        continent_name[4] = "Asia";
        continent_name[5] = "Antarctica";
        continent_name[6] = "Australia";
        
        String[] continent_files = new String[7];
        continent_files[0] = "northamerica.txt";
        continent_files[1] = "southamerica.txt";
        continent_files[2] = "europe.txt";
        continent_files[3] = "africa.txt";
        continent_files[4] = "asia.txt";
        continent_files[5] = "antarctica.txt";
        continent_files[6] = "australia.txt";

        
        for(int i=0; i<continent_name.length; ++i) {
            Continent temp = new Continent(continent_files[i],continent_name[i]);
            Continents.add(temp);
        }
         
      }//load continents
        
      
    public void change_suggested_price(Dinosaur item, Boolean change){
            for(int j=0; j<this.Continents.size(); ++j) {
                if(this.Continents.get(j).IsInContinent(item.coordinates)) {
                    if(change == false){ //if current value for change is false; is created/has 
                        if(item.adjusted_price>0){
                            return;//if value exsits, bone exsists
                        }
                        else{ // if new bone
                        item.adjusted_price = Continents.get(j).price +item.price;
                        }
                    }
                    if(!change == true){ //if current value for change true; it has moved
                        //item.adjusted_price = item.adjusted_price - item.price;//equals difference of prices
                        item.adjusted_price = item.price + Continents.get(j).price; //adds new value to contine
                        
                    }
               
                }
                
            moved = false; //always change to false to create new bones; // feed in true for bones that are moved
                    
            }
    }        
    public void sugg_price_function(Dinosaur temp){
            float newprice;
            output.format("Suggest price for this location id:$%.2f\n"
                    + "Would you like to set your own price?\n"
                    + "Select 1 for Yes\n"
                    + "Select 2 for No\n",temp.adjusted_price);
           
            int choice = getI(); //will not quit until int is selected
            switch(choice){
                case (1):
                {
                    temp.price = temp.adjusted_price; //changes price to suggested
                    break;
                }
                case (2):
                {
                    output.format("Enter you price\n"); //user changes
                    try{
                        newprice = input.nextFloat();
                        temp.price = newprice;
                    }catch( NumberFormatException e){
                         output.format("Pease enter a dollar value-> 400.00\n");
                    }
                    
                                                 
                    break;
                    
                }
               

            }//switch
           
    }
    
    
    
     public Dinosaur go_pick_type(Double latitude, Double longitude, float price){
        temp = null;
        String[] specialbones = {"Spinosaurus","TyrannosaurusRex","Gigantosaurus","Velociraptor","Triceratops","Hylaeosaurus","Amargasaurus","Dakosaurus","Shastasaurus","Pterodactyl","Pterosaurs","Pteranodon"};
        boolean inarray = false;//starts false
        String bonety;
        
        output.format("Select a type of Dinosaur Bone from the list below\n");
        output.format(  "Spinosaurus TyrannosaurusRex Pteranodon\n"+ //list all types
                        "Gigantosaurus Velociraptor Triceratops\n"+
                        "Hylaeosaurus Amargasaurus Dakosaurus\n"+
                        "Shastasaurus Pterodactyl Pterosaurs\n");
                      
        bonety = input.nextLine().trim();
        while(!inarray){
             
             bonety = bonety.trim();
            
            for(int i=0; i < specialbones.length; i++){ //checks for valid dinosaur
            
                if(bonety.equals(specialbones[i])){
                    inarray = true;
                }   
            }
            if(inarray == false){  //only prints when not found
                output.format("No such Dinosaur available\n"
                        + "Try again\n");
                bonety = input.nextLine();
            }
        }

        
            
    if(inarray){
    
    switch(bonety){//uses the 3rd string from super as a switch to make that typ of dinosaur
    
        case("Spinosaurus"): {
            
            temp = new Spinosaurus(latitude, longitude, price);//(x,y,price)
            change_suggested_price(temp, moved);//moved is false new bone
            bonelist.add(temp);
            break;
            
        } 
        case("TyrannosaurusRex"):{
        
            temp = new TyrannosaurusRex(latitude,longitude,price);//(x,y,price)
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            
            break;
        
        }
        case("Gigantosaurus"):{
            temp = new Giganotosaurus(latitude, longitude, price);//(x,y,price)
            change_suggested_price(temp,moved);
            System.out.print(temp.adjusted_price);
            bonelist.add(temp);
            break;
        
        }
        case("Velociraptor"):{
            temp = new Velociraptor(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }
        case("Triceratops"):{ 
            temp = new Triceratops(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }
        case("Hylaeosaurus"):{ 
            temp = new Hylaeosaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }
        case("Amargasaurus"):{
            temp = new Amargasaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);            
            bonelist.add(temp);
            break;
           
        }case("Dakosaurus"):{
            temp = new Dakosaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Shastasaurus"):{
            temp = new Shastasaurus(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Pterodactyl"):{
            temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Pterosaurs"):{
            temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;
        }case("Pteranodon"):{
            temp = new Pteranodon(latitude, longitude, price);//(x,y, price
            change_suggested_price(temp,moved);
            bonelist.add(temp);
            break;            
        }default:{
            System.out.print("Not a valid bone please select one of the following types\nSpinosaurus\nTyrannosaurusRex"+
                    "\nGigantosaurus\nVelociraptor\nTriceratops\nHylaeosaurus\nAmargasaurus\n");
            break;
        }//default
    }//switch    
     return temp;
       
    }
    else{
        return null;
    }
 }
         
     public static void main(String[] args){
        
        Sellertool seller = new Sellertool();        
            while(true){
                seller.mainmenu();
            }
                    
                
       
        
           }//main
}
                   
                    
                                   
            
            
         
           
            

   