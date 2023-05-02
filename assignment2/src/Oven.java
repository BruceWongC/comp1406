public class Oven extends Appliances{
    private boolean convection;
    public Oven(double p, int q, int w, String c, String b, boolean conv){
        super(p, q, w, c, b);
        convection = conv;
    }
    public String toString(int i){
        if (convection){
            return i + ". " + brand + " Oven with convection (" + color + ", " + wattage + " watts) (" +
            price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
        else{
            return i + ". " + brand + " Oven (" + color + ", " + wattage + " watts) (" +
            price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
    }

}
