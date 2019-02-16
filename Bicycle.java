import java.util.Calendar;


public class Bicycle extends Vehicle{
    private int gears;
    private Calendar productionDate;

    public Bicycle(){
        productionDate = Calendar.getInstance();
    }
    public Bicycle(String name, String color, int price, int model, String serialNr, int direction, int gears){

        super(name, color, price, model, serialNr, direction);
        this.gears = gears;
        productionDate = Calendar.getInstance();
    }
    public void setAllFields(){
        super.setAllFields();
        System.out.printf("Gears: ");
        this.setGears(input.nextInt());
    }

    @Override
    public void accelerate(double speedFactor) {
        double speed = this.getSpeed();
        double newSpeed = speed;
        if (speed == 0) {
            newSpeed = 0.3 * speedFactor;

        } else {
            newSpeed = Math.round(speed * 0.5 * speedFactor);

        }
        if (newSpeed <= MAX_SPEED_BIKE) {
            this.setSpeed(newSpeed);
            System.out.println("Bicycle accelerated to: " + newSpeed + " km/h");
        }
    }

    @Override
    public void breaks(double speedFactor) {
        double speed = this.getSpeed();
        if (speed > 0) {
            double newSpeed = speed / (speedFactor * 0.5);
            this.setSpeed(newSpeed);
            System.out.println("Bicycle slowed down to: " + newSpeed + "km/h");
        }
    }

    public void turnRight(int degrees){
        System.out.println(degrees);
    }
    public void turnLeft(int degrees){
        System.out.println(degrees);
    }
    public int getGears() {
        return gears;
    }
    public Calendar getProductionDate() {
        return productionDate;
    }
    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Bicycle b = (Bicycle) super.clone();
        b.productionDate = (Calendar) productionDate.clone();
        return b;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }
    public String toString(){
        return String.format("%s Gears: %d Production date: %s", super.toString(), this.getGears(), sdf.format(productionDate.getTime()));
    }
}