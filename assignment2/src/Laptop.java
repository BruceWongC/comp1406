public class Laptop extends Computer{
    private double screenSize;
    public Laptop(double p, int q, double c, int r, boolean s, int st, double ss){
        super(p, q, c, r, s ,st);
        screenSize = ss;
    }
    public String toString(int i){
        if (ssd){
            return i + ". " + screenSize + " inch Laptop PC with " + cpuSpeed +
                    "ghz CPU, " + ram + "GB ram, " + storage + "GB SSD drive (" + price + " dollars each, " +
                    stockQuantity + " in stock," + soldQuantity + " sold)";
        }
        else{
            return i + " ." + screenSize + " inch Laptop PC with " + cpuSpeed +
                    "ghz CPU, " + ram + "GB ram, " + storage + "GB HDD drive (" + price + " dollars each, " +
                    stockQuantity + " in stock," + soldQuantity + " sold)";
        }

    }

}
