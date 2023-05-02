public class Fridge extends Appliances{
    private boolean HasFreezer;
    public Fridge(double p, int q, int w, String c, String b, boolean has){
        super(p, q, w, c, b);
        HasFreezer = has;
    }
    public String toString(int i){
        if (HasFreezer){
            return i + ". " + brand + " Fridge with Freezer (" + color + ", " + wattage + " watts) (" +
                    price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
        else{
            return i + ". " + brand + " Fridge (" + color + ", " + wattage + " watts) (" +
                    price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
        }
    }

}
