public class ElectronicStore {
    String name;
    Desktop[] desktop = new Desktop[3];
    Laptop[] laptop = new Laptop[3];
    Fridge[] fridge = new Fridge[3];

    public ElectronicStore(String Store){//making objects in arrays
        name = Store;
        desktop[0] = new Desktop(4.3,3,400,true);
        desktop[1] = new Desktop(3.3,8,800,false);
        desktop[2] = new Desktop(2.3,6,1200,false);

        laptop[0] = new Laptop(4.1,8,400,false,20);
        laptop[1] = new Laptop(3.0,3,600,true,10);
        laptop[2] = new Laptop(5.6,2,200,true,30);

        fridge[0] = new Fridge(6.2,true, "Red");
        fridge[1] = new Fridge(14.3,false,"Pink");
        fridge[2] = new Fridge(8.1,true,"Blue");
    }

    public void printStock(){//print all toStings in arrays
        for (int i = 0; i < 3; i++){
            System.out.println(desktop[i]);
        }

        for (int i = 0; i < 3; i++){
            System.out.println(laptop[i]);
        }

        for (int i = 0; i < 3; i++){
            System.out.println(fridge[i]);
        }
    }

    public boolean searchStock(String s){
//for loop all arrays to check .contains the string s, then return true
        s = s.toLowerCase(); //lowercase for caps
        for (int i = 0; i < 3; i++) {
            if (desktop[i].toString().toLowerCase().contains(s)
                || laptop[i].toString().toLowerCase().contains(s)
                || fridge[i].toString().toLowerCase().contains(s)){

                return true;
            }
        }
        return false;
    }


}
