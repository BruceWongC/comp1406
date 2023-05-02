public class Desktop {
    double CPU;
    int RAM;
    int storage;
    boolean SSD; //true = ssd, false = hdd

    public Desktop(double c, int r, int s, boolean s_type){
        CPU = c;
        RAM = r;
        storage = s;
        SSD = s_type;
    }

    public String toString(){
        if (SSD){//if ssd or hdd
            return "Desktop PC with " + CPU + "ghz CPU, " + RAM + "GB RAM, " + storage + "GB SSD drive";
        }
        else{
            return "Desktop PC with " + CPU + "ghz CPU, " + RAM + "GB RAM, " + storage + "GB HDD drive";
        }
    }
}
