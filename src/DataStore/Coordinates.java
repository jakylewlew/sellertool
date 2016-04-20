package DataStore;

public class Coordinates {

    public Double latit;

    public Double longi;

    public int x;

    public int y;

    public Coordinates() {
    }

    public Coordinates(Double latitude, Double longitude) {
        latit = latitude;
        longi = longitude;
        x = latit.intValue();
        y = longi.intValue();
        if (y >= 0) {
            if (y == 0) {
                y = y + 30;
            } else {
                y = y / 6;
                y = y + 29;
            }
            if (y > 59) {
                y = 59;
            }
        } else {
            y = y / 6 + 30;
        }
        if (y < 0) {
            y = 0;
        }
        if (x >= 0) {
            if (x == 0) {
                x = x + 10;
            } else {
                x = x / 10;
                x = 9 - x;
            }
            if (x > 19) {
                x = 19;
            }
        } else {
            x = x * -1;
            x = x / 10;
            x = x + 10;
        }
        if (x < 0) {
            x = 0;
        }
    }

    public void updatecoordinates() {
        x = latit.intValue();
        y = longi.intValue();
        if (y >= 0) {
            if (y == 0) {
                y = y + 30;
            } else {
                y = y / 6;
                y = y + 29;
            }
            if (y > 59) {
                y = 59;
            }
        } else {
            y = y / 6 + 30;
        }
        if (y < 0) {
            y = 0;
        }
        if (x >= 0) {
            if (x == 0) {
                x = x + 10;
            } else {
                x = x / 10;
                x = 9 - x;
            }
            if (x > 19) {
                x = 19;
            }
        } else {
            x = x * -1;
            x = x / 10;
            x = x + 10;
        }
        if (x < 0) {
            x = 0;
        }
    }
}
