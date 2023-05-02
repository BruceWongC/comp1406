public abstract class Computer extends Product{ //desktop and laptops have similar attributes and are types of computers
    protected double cpuSpeed;
    protected int ram;
    protected boolean ssd;
    protected int storage;
    public Computer(double p, int q, double c, int r, boolean s, int st){
        super(p, q);
        cpuSpeed = c;
        ram = r;
        ssd = s;
        storage = st;
    }
}
