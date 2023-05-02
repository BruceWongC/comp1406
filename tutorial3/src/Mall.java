public class Mall {
    public static final int MAX_STORES = 100;
    private String name;
    private Store[] stores;
    private int storeCount;
    public Mall(String n) {
        name = n;
        stores = new Store[MAX_STORES];
        storeCount = 0;
    }
    public void addStore(Store s) {
        if (storeCount < MAX_STORES) {
            stores[storeCount++] = s;
        }
    }
    public boolean shoppedAtSameStore(Customer c1, Customer c2) {
        int count = 0;
        boolean visitC1, visitC2;
        Customer[] var;
        for (int i = 0; i < stores.length; i++) {
            visitC1 = false;
            visitC2 = false;
            if (stores[i] != null) {
                count = stores[i].getCustomerCount();
                var = stores[i].getCustomers();
                for (int j = 0; j < count; j++){
                    if (var[j] == c1){
                        visitC1 = true;
                    }
                    else if (var[j] == c2) {
                        visitC2 = true;
                    }
                }
                if (visitC1 && visitC2){
                    return true;
                }
            }
        }
        return false;
    }




}
