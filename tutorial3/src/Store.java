public class Store {
    public static final int MAX_CUSTOMERS = 500;
    private String name;
    private Customer[] customers;
    private int customerCount;
    private static int Latest_ID = 100000;
    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }
    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMERS) {
            customers[customerCount] = c;
            customers[customerCount++].set(Latest_ID++);
        }
    }
    public void listCustomers() {
        for (int i=0; i<customerCount; i++)
            System.out.println(customers[i]);
    }

    public int averageCustomerAge(){
        int total = 0, count = 0;
        for (int i = 0; i < customers.length; i++){
            if (customers[i] == null){
                break;
            }
            total += customers[i].getAge();
            count++;
        }
        return total/count;
    }

    public Customer richestCustomer(){
        int index = 0;
        for (int i = 0; i < customers.length; i++){
            if (customers[i] != null) {
                if (!customers[index].hasMoreMoneyThan(customers[i])) {
                    index = i;
                }
            }
            else{
                break;
            }
        }
        return customers[index];
    }
    public Customer[] getCustomers() {
        return customers;
    }
    public int getCustomerCount() {
        return customerCount;
    }

    public Customer[] friendsFor(Customer lonelyCustomer){
        Customer[] arr = new Customer[7];
        int count = 0, ageValue = 0;
        for (int i = 0; i < customers.length; i++){
            if (customers[i] != null && customers[i] != lonelyCustomer){
                ageValue = customers[i].getAge() - lonelyCustomer.getAge();
                if (ageValue >= -3 && ageValue <= 3){
                    arr[count++] = customers[i];
                }
            }
        }
        return arr;
    }

}