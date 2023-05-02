public abstract class Product {//interface wasn't used as there were no methods in other classes (besides toString)
    protected double price;
    protected int stockQuantity;
    protected int soldQuantity;
    public Product(double p, int q){ //assuming soldQ will be 0
        price = p;
        stockQuantity = q;
        soldQuantity = 0;

    }
    public double sellUnits(int amount){
        if (getStockQuantity() < amount){
            return 0;
        }
        else{
            setStockAndSoldQuantity(amount);
            return price * amount;
        }
    }
    public void setStockAndSoldQuantity(int amount){
        this.stockQuantity -= amount;
        this.soldQuantity += amount;
    }
    public int getStockQuantity(){
        return stockQuantity;
    }

}
