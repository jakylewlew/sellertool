package DataStore;

public class Coordinates {

    public double latit;
    public double longi;
    public int x;
    public int y;

    public Coordinates() {
    }

    public Coordinates(double latitude, double longitude) {
        this.latit = latitude;
        this.longi = longitude;
        this.setMapCoordinates(longitude, latitude);   
    }

    public void setMapCoordinates(double temp_long_1, double temp_lat_1) {
        double temp_long_ = temp_long_1;
        double temp_lat_ = temp_lat_1;
        
        if(temp_long_ < -180) {
            temp_long_ = -180;
            this.longi = -180;
        }else if(temp_long_ > 180) {
            temp_long_ = 180;
            this.longi = 180;
        }
        if(temp_lat_ < -90) {
            temp_lat_ = -90;
            this.latit = -90;
        }else if(temp_lat_ > 90) {
            temp_lat_ = 90;
            this.latit = 90;
        }
        
        int long_ = (int) temp_long_;
        int lat_ = (int) temp_lat_;
        this.y = ((3600/360) * long_) + 1800;
        this.x = ((-1800/180) * lat_) + 900;
        if(this.x < 0) {
            this.x = 0;
        }
        else if(this.x >= 1800) {
            this.x = 1799;
        }
        if(this.y < 0) {
            this.y = 0;
        }
        else if(this.y >= 3600) {
            this.y = 3599;
        }
    }
    
    public void updatecoordinates() {
        if(this.longi < -180) {
            this.longi = -180;
        }else if(this.longi > 180) {
            this.longi = 180;
        }
        if(this.latit < -90) {
            this.latit = -90;
        }else if(this.latit > 90) {
            this.latit = 90;
        }
        
        int long_ = (int) this.longi;
        int lat_ = (int) this.latit;
        this.y = (3600/360) * long_ + 1800;
        this.x = (1800/180) * lat_ + 900;
        if(this.x < 0) {
            this.x = 0;
        }
        else if(this.x >= 1800) {
            this.x = 1799;
        }
        if(this.y < 0) {
            this.y = 0;
        }
        else if(this.y >= 3600) {
            this.y = 3599;
        }
    }
}
