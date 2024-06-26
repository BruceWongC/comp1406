public class Ball extends MovableObject implements Harmful{
    private boolean 	isBeingHeld;

    public Ball(Point2D loc) {
        super(0,0,loc);
        isBeingHeld = false;
    }
    public void draw(){
        System.out.println("Ball is at " + location + " facing " + direction + " degrees moving at " + speed + " pixels per second");
    }
    public void update(){
        if (speed > 0){
            location = location.add((int) (Math.cos(Math.toRadians(direction)) * speed), (int) (Math.sin(Math.toRadians(direction)) * speed));
            speed += -1;

        }
        draw();
    }
    public int getDamageAmount(){
        return -200;
    }

    // The get/set methods
    public boolean isBeingHeld() {
        return isBeingHeld;
    }
    public void setIsBeingHeld(boolean newHoldStatus) {
        isBeingHeld = newHoldStatus;
    }

    public String toString() {
        return "Ball" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction +
                " degrees going " + speed + " pixels per second";
    }
}