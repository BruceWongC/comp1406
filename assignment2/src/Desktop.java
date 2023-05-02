public class Desktop extends Computer{
    private String profile;
    public Desktop(double p, int q, double c, int r, boolean s, int st, String pro){
        super(p, q, c, r, s ,st);
        profile = pro;
    }
    public String toString(int i){
        if (ssd){
            return i + ". " + profile + " Desktop PC with " + cpuSpeed +
            "ghz CPU, " + ram + "GB ram, " + storage + "GB SSD drive (" + price + " dollars each, " +
                    stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
        else{
            return i + ". " + profile + " Desktop PC with " + cpuSpeed +
            "ghz CPU, " + ram + "GB ram, " + storage + "GB HDD drive (" + price + " dollars each, " +
            stockQuantity + " in stock, " + soldQuantity + " sold)";
        }

    }
}
