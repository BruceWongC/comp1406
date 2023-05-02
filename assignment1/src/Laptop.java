public class Laptop {
    double CPU;
    int RAM;
    int storage;
    boolean SSD; //true = ssd, false = hdd
    int screen;

    public Laptop(double c, int r, int s, boolean s_type, int size){
        CPU = c;
        RAM = r;
        storage = s;
        SSD = s_type;
        screen = size;
    }

    public String toString(){
        if (SSD){//if ssd or hhd
            return screen + " inch Laptop PC with " + CPU + "ghz CPU, " + RAM + "GB RAM, " + storage + "GB SSD drive";
        }
        else{
            return screen + " inch Laptop PC with " + CPU + "ghz CPU, " + RAM + "GB RAM, " + storage + "GB HDD drive";
        }
    }
}
