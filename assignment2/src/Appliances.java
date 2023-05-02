public abstract class Appliances extends Product{ //oven and fridge have similar attributes and are types of appliances
    protected int wattage;
    protected String color;
    protected String brand;
    public Appliances(double p, int q, int w, String c, String b){
        super(p, q);
        wattage = w;
        color = c;
        brand = b;
    }


}
