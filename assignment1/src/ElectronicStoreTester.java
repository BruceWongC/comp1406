import java.util.Scanner;  // Import the Scanner class

public class ElectronicStoreTester {
    public static void main(String[] args){
        ElectronicStore store;
        store = new ElectronicStore("store");

        store.printStock();

        Scanner input = new Scanner(System.in);

        String user;
        System.out.println();

        boolean flag;
        flag = true;

        while (flag){
            System.out.println("Enter a term to search for: ");

            user = input.nextLine();

            if (store.searchStock(user)) {
                System.out.println("A matching item is contained in the store's stock.");
            }
            else if (user.equals("quit")) {//quit if user input quit
                flag = false;
            }
            else {
                System.out.println("No items in the store's stock match that term.");
            }
        }
    }
}
