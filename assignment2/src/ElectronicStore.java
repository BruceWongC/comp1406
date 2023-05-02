import java.util.Scanner;  // Import the Scanner class
public class ElectronicStore {
    final int MAX_PRODUCTS = 10;
    private String name;
    private double revenue = 0;
    Product[] array = new Product[MAX_PRODUCTS];
    private int arrCount = 0;// keeps count of the count of prods in each store

    public ElectronicStore(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public boolean addProduct(Product p) {
        if (arrCount != MAX_PRODUCTS) {
            array[arrCount] = p;
            arrCount++;
            return true;
        } else {
            return false;
        }
    }

    public boolean sellProducts() {
        printStock();

        Scanner user = new Scanner(System.in);  // make scanner object
        System.out.println("Please enter a product ID: ");
        int prodID = user.nextInt();  // read input from user
        System.out.println();

        System.out.println("Please enter the quantity to sell: ");
        int quantity = user.nextInt();  // read input from user
        System.out.println();

        if (arrCount > prodID){
            if (array[prodID].getStockQuantity() >= quantity && quantity > 0){
                revenue += array[prodID].sellUnits(quantity);
                return true;
            }
        }

        return false;
    }

    public boolean sellProducts(int prod, int q) {// prod to sell, then quantity
        if (prod >= array.length || q <= 0 || array[prod] == null) {

            return false;
        } else {
            if (array[prod].getStockQuantity() < q) {
                return false;
            }
            revenue += array[prod].sellUnits(q);
            return true;
        }
    }

    public double getRevenue() {
        return revenue;
    }

    public void printStock() {
        for (int i = 0; i < arrCount; i++) {
            if (array[i] instanceof Desktop) {
                System.out.println(((Desktop) array[i]).toString(i));

            } else if (array[i] instanceof Laptop) {
                System.out.println(((Laptop) array[i]).toString(i));

            } else if (array[i] instanceof Fridge) {
                System.out.println(((Fridge) array[i]).toString(i));

            } else {
                System.out.println(((Oven) array[i]).toString(i));
            }
        }
    }
}