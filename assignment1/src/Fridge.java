public class Fridge {
    double size;
    boolean freezer;//true = has freezer
    String color;

    public Fridge(double s, boolean f, String c){
        size = s;
        freezer = f;
        color = c;
    }

    public String toString(){
        if (freezer){//freezer or none
            return size + " cubic foot Fridge with Freezer (" + color + ")";
        }
        else{
            return size + " cubic foot Fridge (" + color + ")";
        }
    }
}
