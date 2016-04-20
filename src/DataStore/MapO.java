package DataStore;

import java.util.ArrayList;
import java.util.Formatter;

public class MapO {

    public int MapX;

    public int MapY;

    public int MapZ;

    Formatter output;

    public MapO() {
        MapX = MapX;
        MapY = MapY;
        MapZ = MapZ;
    }
   public MapO(int x, int y, int z){
       this.MapX = x;
       this.MapY = y;
       this.MapZ = z;
   }
   
public void LoadMapNode(ArrayList<MapO> x) {
        int i;
        int counter = 0;
        int condition;
        output = new Formatter(System.out);
        for (i = 0; i < x.size(); i++) {
            if (counter == 60) {
                System.out.print("\n");
                counter = 0;
        }
    }
   }
}

