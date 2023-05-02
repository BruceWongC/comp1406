public class Customer {
    String name;
    int age;
    float money;
    boolean admitted;
    public Customer(String initName) {
        name = initName;
        age = 1;
        money = 0.1f;
        admitted = false;
    }

    public Customer(String initName, int initAge) {
        name = initName;
        age = initAge;
        money = 10.2f;
        admitted = false;

    }

    public Customer(String initName, int initAge, float initMoney) {
        name = initName;
        age = initAge;
        money = initMoney;
        admitted = false;

    }

    public Customer(){
        name = "Customer 4";
        age = 9;
        money = 0.91f;
        admitted = false;

    }

    public float computeFee() {
        if (age < 4){
            return 0;
        }
        else if (age > 64) {
            return 6.38f;
        }
        else if (age < 18){ // age > 3 not required as code has check age < 4
            return 8.50f;
        }
        else{
            return 12.75f;
        }
    }

    public boolean spend(float spending){
        if (spending <= money && spending >= 0) {
            money -= spending;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasMoreMoneyThan(Customer c){
        if (money > c.money){
            return true;
        }
        return false;
    }

    public void payAdmission(){
        //spend(computeFee());
        if (spend(computeFee())){
            admitted = true;
        }

    }

    public String toString(){
        if (admitted == true){
            return "Customer " + name + ": a " + age + " year old with $" + money + " who has been admitted";
        }
        else{
            return "Customer " + name + ": a " + age + " year old with $" + money + " who has not been admitted";
        }
    }


}

