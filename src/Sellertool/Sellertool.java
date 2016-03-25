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
import java.util.InputMismatchException;
import java.util.Random;
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
    Dinosaur temp = new Dinosaur();
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
            create_continents();   //creates all continent arrays; line 803
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
            case(2):{               //calls displays all bones in the bonlist the prompts how to handle anybone or add a bone to bone list
                    bonehandle(); //calls bone handele menu line 434
                    break;
                    }//outercase2
            case(3):
            {
                show_map();//show map line 355
                 break; 
            }
            case(4)://gets the files written//including different formats
            {   if(!bonelist.isEmpty()){
                try {//sends to file
                        File Bonetext = new File("Bones.txt");
                        Formatter filewriter = new Formatter(Bonetext);

                        for(i=0;i<bonelist.size();i++){
                            temp = bonelist.get(i);
                           // filewriter.format( "%d,%d,%f,%f,%d,%f,%f,%f,%f,%f,%d,%s,%s,%s,%s%\n",temp.boneID,temp.age,temp.price,temp.weight,temp.bought,temp.globe_longitude,temp.globe_latitude,temp.length,temp.width,temp.height,temp.buyer_id,temp.name,temp.condition,temp.country,temp.prospector );
                           //output.format("%d,%f,%f,%f,%d,%s\n", temp.boneID, temp.price, temp.coordinates.longi, temp.coordinates.latit,temp.buyer.ID,temp.name);
                           filewriter.format("%d,%f,%d,%f,%f,%d,%s%n", temp.boneID, temp.price,temp.bought,temp.coordinates.longi, temp.coordinates.latit,temp.buyer.ID,temp.name);
                        }
                        output.format("\nFiles are saved...\n");
                        filewriter.close();

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Sellertool.class.getName()).log(Level.SEVERE, null, ex); 
                    }
                }else{
                output.format("No Bones to save%n");
                } break;
            }  
            case(5):
            {//load files
                if(!bonelist.isEmpty())
                {                   //if bones array is empty clear it to so not to stack it
                    bonelist.clear();
                }
                makeabonefromfiles();//calls line 164 make bones fron bone,txt
                LoadMap();          // then shows the map
                filesloaded = true; //makes bool value true for out of sequenced malfunctions
                maploaded = true;
                output.format("\n Files are Loaded...\n");
                break;
            }      
            case(6):{
                sellerop.changesellermenu();//calls sellermenu in seller class
                break;
            } 
            case(7):{  //calls scramble line 1018
                    scramble();
                    show_map();
                    break;
            }case(8):{
                System.exit(0);5
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
                change_continent_price(temp,moved); //moved is false//goes to new bone price change piece line 815
                bonelist.add(temp);
                        //output.format("%s", temp.prospector);
                        //scanstream.nextLine();
            }//while
            scanstream.close();//close the stream
        } //makeabonefrom files
        catch (FileNotFoundException ex) {
            Logger.getLogger(Sellertool.class.getName()).log(Level.SEVERE, null, ex);
        }
     }//make bone from files
        
    public void LoadMap() { //loads the map from a text doc of csv file 1,0,0
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
       
    public int getI(){//Int input mismatch function for getting INT
        String intbuffer;
        int result=0; 
        while(true)
        {   
        try {
           intbuffer = input.nextLine();
           result = (Integer.valueOf(intbuffer));
           break;
        } catch (NumberFormatException | InputMismatchException e){ 
                output.format("Please try again\n");
                continue;
            } 
        }  
        return result;
    }
            
      
        
    public float getF()//float input mismatch for Ffloats
    {   String buffer;
        float result;
        while(true)
        {
            try {
                buffer = input.nextLine();
                result = Float.valueOf(buffer);
                break;

            }catch (NumberFormatException | InputMismatchException e){ 
                output.format("Please try again\n");
                continue;
            }   
        }return result;
    }//getf()
        
    public void makeBone(){//makes new bone calls boneediting for coord and id price yada puts in bone list//make bone from prompt
            temp = null; 
            Double latit = 0.0;
            Double longi = 0.0;
            Boolean test = true;
            //while input is not valid
            do{ output.format("Latitude\n");
                try{ 
                 String buffer = input.nextLine().trim();// get item lat
                 latit = Double.valueOf(buffer);
                 test = false;
                }catch(NumberFormatException | InputMismatchException e){ 
                    output.format("Please enter a Number:%n");
                }
                if((latit>90) || (latit<-90)){//valid bonds for map
                    output.format("Enter a valid Latitude value!(-90,90)%n");
                    test = true;
                }
            }while(test);
            test = true;
            do{
                try{
                    output.format("Longitude\n");
                    String buffer = input.nextLine().trim();
                    longi = Double.valueOf(buffer);
                    test = false;
                    }catch(NumberFormatException | InputMismatchException e){
                   //default for people too stupid
                    output.format("Please enter a Number:%n");
                     //because the value will true now
                    }
                if((longi>180) || (latit<-180)){///valid bonds for map
                    output.format("Enter a valid Longitude value!(-180,180)%n");
                    test = true;
                }
            }while(test);
            
             int price  = 1;//set a price to feed into function to one for error alleviations should wrong vlaue be put
             temp = make_bone_prompt(latit,longi,price); //make bone prompt line 880
             temp.coordinates.updatecoordinates();      //changes the array values
             change_continent_price(temp,moved); //make new adjusted price // new bone piece line 815
             sugg_price_function(temp);  //suggest price randomly for bone //line 813
             //all of these items are not used  for phase 2
            // Random rn = new Random();
            // temp.boneid = rn.nextInt(15000 -1 + 1);
            //output.format("\nAge:");'
            //temp.age = getI();
            //temp.price = scanstream.nextFloat();
            // output.format("\nWeight:");
            // temp.weight = getF();
             temp.bought = 0;    ///bought varaible is zerp
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


    }   
    
    public void show_map() { //show the map on the output
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
            
        }
    }//showmap
        
    public char get_map_symbol(int input) {
        char symbol = '.';
        switch(input){
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
    
    
    public void bonehandle(){//operates on the bones calll bone operation menu
    int i;
    int x;
    int selection = 0;
    show_map();
    while(selection!=7){
        for(i=0;i<bonelist.size(); i++)
            {   temp = bonelist.get(i);     //prints the Current bones in bone list 
                change_continent_price(temp,!moved);  //changes pricing according to continent //!moved is true// line 818 should execute
                output.format("\nID:%-6dBonename:%-18sLat->%7.2f  Long->%7.2f  Row:Column (%2d:%2d)  Price:$%13.2f  ContinentPrice:$%13.2f%n",temp.boneID,temp.name,temp.coordinates.latit,temp.coordinates.longi, temp.coordinates.x,temp.coordinates.y,temp.price, temp.adjusted_price);
            }
            output.format("\nHow would you like to handle your bone Handler\n"+
                    "1:Make bone\n"
                    +"2:Sell a bone\n"+
                     "3:Modify a bone on the bone list\n"
                    +"4:Remove bone\n"
                    +"5:See Suggested price for a bone\n"+
                    "6:Make Bone with Comma separated string\n"+
                    "7:Exit\n");
                        
                        
            selection = getI();

            switch(selection)//handle handling
            {
                case(1):
                        {   makeBone();   //make bone from string                                     
                            show_map();
                            //makeBone();//will add to bonelist on its own
                            createdBone = true;
                            break;
                        }    

                case(2):{
                        if(bonelist.isEmpty()){//if no bones
                            output.format("\nNo bones are loaded yet....\n");
                            break;
                        }
                         boolean found = false;
                         output.format("\nEnter ID number of the bone you would like to Sell:\n");
                         x = getI();//line 260 getI()

                         for(i=0; i<bonelist.size(); i++) //goes through sellablebonelist and checks if that id number exsists
                         {
                            if (bonelist.get(i).boneID == x ) 
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
                                    break;
                                }
                                if((x == bonelist.get(i).boneID) && (bonelist.get(i).bought == 1)){//changes back to usold
                                    bonelist.get(i).bought = 0;
                                    break;
                                }
                            }          

                        }show_map();
                        break;
                }case(3):{  //Modify bones
                        if(bonelist.isEmpty())//make sure that the has bones
                        {
                        output.format("\nNo bones are loaded yet....\n\n");
                        break;
                        }
                        //prompt
                        boolean found = false;
                        output.format("Enter ID number of the bone you would like to modify or press 4 to exit\nID number:");
                        x = getI();
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
                            change_continent_price(temp,!moved);//change Suggested price//moved bone will execute 818
                        }
                        else{
                            output.format("\nBone Not Found...\n");
                        }show_map();
                        break;
                }case (4):{//removes bone form bone list
                    boolean found = false;

                    if(bonelist.isEmpty()){
                    output.format("\nNo bones in the bonelist...\n");
                    break;
                     }
                    output.format("\nEnter ID of removed bone:");
                    int remove_ID = getI();
                    int bone_index = 0;         //gets the  bone index to remove said bone
                    for (int iter = 0; iter <bonelist.size(); iter++)//gets the  bone index to remove said bone
                    {
                        if (bonelist.get(iter).boneID == remove_ID)
                        {
                            bone_index = iter;
                            found = true;
                            break;
                        }
                    }//end of find and test
                    //if found int list
                    if (found)
                    {
                        bonelist.remove(bone_index);//take out
                        output.format("\nRemoved....\n");
                    }
                    else//else tell usser bone not found
                    {
                        output.format("\nTry again!\nMake sure that you have entered the correct id number...\n");
                     }
                    show_map();
                    break;//remove bone
                }case (5):{//displays suggested bone price
                    boolean found = false;
                    output.format("Suggested Price\nEnter ID number:\n");
                    int see_adj_price = getI();

                    int bone_index = 0;     //gets the  bone index to remove said bone
                    for (int iter = 0; iter <bonelist.size(); iter++)//could make a function***later
                    {
                        if (bonelist.get(iter).boneID == see_adj_price)
                        {
                            bone_index = iter;
                            found = true;
                            break;
                        }
                    }
                    if (found){//if found run continent price with true value for move
                        change_continent_price(bonelist.get(bone_index),moved);//moved is false// execute 818// 
                        output.format("Suggested Price: %f\n",bonelist.get(bone_index).adjusted_price);
                        break;
                    }
                    System.out.print("No files loaded\n");
                    break;

                }case(6):{//comma separatebne
                    Sellertool.this.get_bone_string();//enter comma separated bone714
                    createdBone = true;
                    show_map();
                    break;

                }
                case(7):{
                        selection = 7;
                        break;
                }

            }//inner switch
        }//while
    }//Bonehandle end
       
    
 public Dinosaur get_special_bone(double latitude,double longitude,String bonety, float price ){//read from a string of 4 strings lat, long, Type, price
        Dinosaur temp = null;
        String[] specialbones = {"Spinosaurus","TyrannosaurusRex",//next
            "Gigantosaurus","Velociraptor","Triceratops","Hylaeosaurus",//next
            "Amargasaurus","Dakosaurus","Shastasaurus","Pterodactyl"//next
            ,"Pterosaurs","Pteranodon"};//list of valid bones
        
        boolean inarray = false;//starts false

        for(int i=0; i < specialbones.length; i++){//checks for valid dinosaur
            if(bonety.equals(specialbones[i])){
                inarray = true;//if in == True 
            }
        }
        if(check_lat_long(latitude,longitude) == false){//if not in bounds
            return temp;
        }
        if(inarray){    //if false retunr null line 716
           
    
            switch(bonety){//uses the 3rd string from super as a switch to make that typ of dinosaur

            case("Spinosaurus"): {

                temp = new Spinosaurus(latitude, longitude, price);//(x,y,price)
                change_continent_price(temp,moved);//moved is false
                //System.out.print(temp.adjusted_price);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            } 
            case("TyrannosaurusRex"):{

                temp = new TyrannosaurusRex(latitude,longitude,price);//(x,y,price)
                change_continent_price(temp,moved); //moved is false
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }
            case("Gigantosaurus"):{

                temp = new Giganotosaurus(latitude, longitude, price);//(x,y,price)
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }
            case("Velociraptor"):{

                temp = new Velociraptor(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }
            case("Triceratops"):{ 

                temp = new Triceratops(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }
            case("Hylaeosaurus"):{ 

                temp = new Hylaeosaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }
            case("Amargasaurus"):{

                temp = new Amargasaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;

            }case("Dakosaurus"):{

                temp = new Dakosaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }case("Shastasaurus"):{

                temp = new Shastasaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }case("Pterodactyl"):{

                temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }case("Pterosaurs"):{

                temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
                bonelist.add(temp);
                break;
            }case("Pteranodon"):{

                temp = new Pteranodon(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                sugg_price_function(temp);
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
 
    public void get_bone_string(){//gets bone from string
        String[] line;
        float price;
        boolean notfound = true;
        do{//while bone not found  repeat
             try{
                 System.out.print("Enter Bone with this format\n"+
                    "Latitude,Longitude,Bone Type,Price\n");
                //splitting the string
                String buffer = input.nextLine();
                line = buffer.split(",");
                Double vertical = Double.parseDouble(line[0]);
                Double horizontal = Double.parseDouble(line[1]);
                String bonety = line[2];
                price = Float.parseFloat(line[3]);

                if(get_special_bone(vertical,horizontal,bonety, price)!=null){//when bone is not made == null imple 616
                   notfound = false; //if method returns null line 722;
                }
                else{
                    output.format("Try again%n");
                    notfound = true;
                }
             }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
                 output.format("Enter Valid Input!!!\n");
            }
             
        }while(notfound);  //will not break creating loop until valid bone is entered//not found == true
    } 
//get_bone_string  
        
    public void boneediting(Dinosaur x){//bone editingpromt and check for valid coord for new file format Dinosuar class
        String value;
        Boolean valid = false;
        do{ output.format("\nEnter the coordinate Latitude:");//while not valid latit
            
            try{
                value = input.nextLine();
                x.coordinates.latit = Double.valueOf(value);
                valid = true;
                 //clear
             }catch(NumberFormatException | InputMismatchException e)
             {
                output.format("Enter Again\n");
                valid = false;  
                 
             }
         }while (!valid);
          
        if(x.coordinates.latit > 84.0){//take care of array ob because of trucation
              x.coordinates.latit = 90.00;
          }
          if(x.coordinates.latit<-90.0){
              x.coordinates.latit = -90.0;//take care array ob
          }
          valid = false;
       
        do{ output.format("\nEnter the coordinate Longitude:");
            try{
                 
                 value = input.nextLine();
                 x.coordinates.longi = Double.valueOf(value);
                 valid = true;
                
             }catch(NumberFormatException | InputMismatchException e)
             {
                 output.format("Enter Again\n");
                  valid = false;
             }
        }while(!valid);
            if(x.coordinates.longi < -174){
                x.coordinates.longi = -180.0;//must adjust because trunctation round value to 60,not 59 and causes a outo bounds error}
            }
            if (x.coordinates.longi>174){
                x.coordinates.longi= 180.0;//array ob adjustment
            }
             //clear
            x.coordinates.updatecoordinates();//ensure x,y is updated for the array Class Coordinates
            
    }
         
        public void create_continents() {// makes all continent arrrays
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
        
      
    public void change_continent_price(Dinosaur item, Boolean change){//change price according to the continent bone is on
            for(int j=0; j<this.Continents.size(); ++j) {
                if(this.Continents.get(j).IsInContinent(item.coordinates)) {
                    if(change == false){ //if current value for change is false; is created/has 
                        if(item.adjusted_price>0){
                            return;//if value exsits, bone exsists
                        }
                        else{ // if new bone
                        item.adjusted_price = Continents.get(j).price +item.price;
                        break;
                        }
                    }
                    if(change == true){ //if current value for change true; it has moved
                        //item.adjusted_price = item.adjusted_price - item.price;//equals difference of prices
                        item.adjusted_price = item.price + Continents.get(j).price; //adds new value to contine
                        break;
                    }
                }
                if(!this.Continents.get(j).IsInContinent(item.coordinates))//if not on land
                {
                    item.adjusted_price = item.price;
                }
            moved = false; //always change to false to create new bones; // feed in true for bones that are moved
            }
    }  
    
    public void sugg_price_function(Dinosaur tochange){//suggests price for make bone from scratch line 327
        float newprice;
        boolean invalid = true;
        newprice = temp.pricing(tochange);
        output.format("Suggest price for this location id:$%.2f\n"
                + "Would you like to set your own price?\n"
                + "Select 1 for Yes\n"
                + "Select 2 for No\n",newprice);
        while(invalid){
        int choice = getI(); //will not quit until int is selected
        switch(choice){
            case (1):
            {   tochange.price = newprice;
                 invalid = false;//changes price to suggested price
                break;
            }
            case (2):
            {   boolean notnumber = true;
                while(notnumber){
                output.format("Enter you price\n"); //user changes
                try{
                    newprice = input.nextFloat();
                    tochange.price = newprice;
                    notnumber = false; 
                }catch( NumberFormatException | InputMismatchException e){
                     output.format("Pease enter a dollar value-> 400.00\n");
                     input.nextLine();//clear
                 }
                }//while bot a number
                invalid = false;
                input.nextLine();//clear
                break;
            }
            default:
            {
                output.format("Enter valid selection%n");//catch all invalid
               
            }
        }//switch
        }//while loop  
    }
    
     public Dinosaur make_bone_prompt(Double latitude, Double longitude,float price){//makes a bone from scratch, one piece at a time
        temp = null;
        String[] specialbones = {"Spinosaurus","TyrannosaurusRex","Gigantosaurus",
            "Velociraptor","Triceratops","Hylaeosaurus","Amargasaurus","Dakosaurus",
            "Shastasaurus","Pterodactyl","Pterosaurs","Pteranodon"};
        
        boolean inarray = false;//starts false
        String bonety;
        output.format("Select a type of Dinosaur Bone from the list below\n");
        output.format(  "Spinosaurus TyrannosaurusRex Pteranodon\n"+ //list all valid types for the user
                        "Gigantosaurus Velociraptor Triceratops\n"+
                        "Hylaeosaurus Amargasaurus Dakosaurus\n"+
                        "Shastasaurus Pterodactyl Pterosaurs\n");
        bonety = input.nextLine().trim();//get string
        
        while(!inarray){
                 bonety = bonety.trim();//trim again??
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
        }//while valid string is not input
        if(inarray){//when valis is input
        switch(bonety){//uses bonety as a switch to make that typ of dinosaur

            case("Spinosaurus"): {

                temp = new Spinosaurus(latitude, longitude, price);//(x,y,price)
                change_continent_price(temp, moved);//moved is false new bone
                bonelist.add(temp);
                break;
            } 
            case("TyrannosaurusRex"):{

                temp = new TyrannosaurusRex(latitude,longitude,price);//(x,y,price)
                change_continent_price(temp,moved);
                bonelist.add(temp);
            }
            case("Gigantosaurus"):{

                temp = new Giganotosaurus(latitude, longitude, price);//(x,y,price)
                change_continent_price(temp,moved);
                System.out.print(temp.adjusted_price);
                bonelist.add(temp);
                break;
            }
            case("Velociraptor"):{

                temp = new Velociraptor(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;
            }
            case("Triceratops"):{ 

                temp = new Triceratops(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;
            }
            case("Hylaeosaurus"):{ 

                temp = new Hylaeosaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;
            }
            case("Amargasaurus"):{

                temp = new Amargasaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);            
                bonelist.add(temp);
                break;           
            }
            case("Dakosaurus"):{

                temp = new Dakosaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;
            }
            case("Shastasaurus"):{

                temp = new Shastasaurus(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;
            }
            case("Pterodactyl"):{

                temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;
            }
            case("Pterosaurs"):{
                temp = new Pterodactyl(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;
            }case("Pteranodon"):{

                temp = new Pteranodon(latitude, longitude, price);//(x,y, price
                change_continent_price(temp,moved);
                bonelist.add(temp);
                break;            
            }
             default:{
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
         //Scramble function
    public void scramble() {
        //check if there is anything to scramble
        if(this.bonelist.isEmpty() && this.sellerop.masterlist.isEmpty()) {
            this.output.format("\nNo data to scramble..\n\n");
        }
        else if(!this.maploaded) { 
            //if map not loaded
            this.output.format("\nPlease Load Map First!!\n\n");
        }
        else{
            //correct data, scramble it
            if(!this.sellerop.masterlist.isEmpty()) {
                //scramble buyers
                for(int i=0; i<this.sellerop.masterlist.size(); ++i) {
                    
                    Random rn = new Random();
                    double temp_long = rn.nextInt((180 - (-180) + 1)) + (-180);
                    double temp_lat = rn.nextInt((90 - (-90) + 1)) + (-90);
                    Coordinates tempCoord = new Coordinates(temp_lat,temp_long);
                    this.sellerop.masterlist.get(i).coordinate = tempCoord;

                }
                
            }
            //scramble bones
            if(!this.bonelist.isEmpty()) {
                //create temporary map
                int[][] temp_map = new int[60][20];
                for(int i=0; i<this.MapNode.size(); ++i) {
                    int tempX = this.MapNode.get(i).MapX;
                    int tempY = this.MapNode.get(i).MapY;
                    int tempZ = this.MapNode.get(i).MapZ;
                    temp_map[tempX][tempY] = tempZ;
                }
                
                //scramble each bone
                for(int i=0; i<this.bonelist.size(); ++i) {
                    while(true) {
                        //create random coordinates
                        Random rn = new Random();
                        double temp_long = rn.nextInt((180 - (-180) + 1)) + (-180);
                        double temp_lat = rn.nextInt((90 - (-90) + 1)) + (-90);
                        Coordinates tempCoord = new Coordinates(temp_lat,temp_long);
                        int temp_x = tempCoord.y;
                        int temp_y = tempCoord.x;
                        
                        //if bone is on land, set new bone coordinate
                        if(temp_map[temp_x][temp_y] == 1) {
                            this.bonelist.get(i).coordinates = tempCoord;
                            break; //from while loop
                        }
                    } 
                }
            }
        }
    }       
        
         
    public boolean check_lat_long(double latitude, double longitude){ //checks for valid lat and long in the make_bone_string
        boolean inbounds = true;
        if(( latitude>90) || (latitude<-90)){
                        output.format("Enter a valid Latitude value!(-90,90)%n");
                        inbounds = false;
                        
        }     
        if(( longitude>180) || (longitude<-180)){
                        output.format("Enter a valid Longitude value!(-180,180)%n");
                        inbounds = false;
                       
        }
        return inbounds; //coordinates in bounds for string input in get_special_bone, returns zero if not in bounds will nake user redo string
         
       
        
        
    }
     public static void main(String[] args){
        
        Sellertool seller = new Sellertool();        
            while(true){
                seller.mainmenu();
            }
           }//main
}
                   
                    
                                   
            
            
         
           
            

   