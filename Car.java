import java.util.Calendar;
public class Car extends Vehicle{
    private int power;
    private Calendar productionDate;

    Car(){
        productionDate = Calendar.getInstance();
    }

    Car(String name, String color, int price, int model, String serialNr, int direction, int power){
        super(name, color, price, model, serialNr, direction);
        this.power = power;
        productionDate = Calendar.getInstance();
    }

    public void setAllFields(){
        super.setAllFields();
        System.out.printf("Power:");
        this.setPower(input.nextInt());
    }

    @Override
    public void accelerate(double speedFactor) {
        double speed = this.getSpeed();
        double newSpeed = speed;
        if (speed == 0) {
            newSpeed = 0.5 * speedFactor;
        } else {
            newSpeed = speed * speedFactor;
        }
        if (newSpeed <= MAX_SPEED_CAR) {
            this.setSpeed(newSpeed);
        }
        System.out.println("Vehicle accelerated to: " + newSpeed + "km/h");
    }

    @Override
    public void breaks(double speedFactor) {
        double speed = this.getSpeed();
        if (speed > 0) {
            double newSpeed = speed / speedFactor;
            this.setSpeed(newSpeed);
            System.out.println("Vehicle slowed down to: " + newSpeed + "km/h");
        }
    }


    public void turnRight(int degrees){
        if(degrees < 360 && degrees > 0) {
            this.setDirection(this.getDirection() + degrees);
            if(this.getDirection() < 0) {
                this.setDirection(this.getDirection() + 360);
            }
            else if(this.getDirection() > 360){
                this.setDirection(this.getDirection() - 360);
            }
        }
    }
    public void turnLeft(int degrees){
        if(degrees < 360 && degrees > 0) {
            this.setDirection(this.getDirection() - degrees);
            if(this.getDirection() < 0) {
                this.setDirection(this.getDirection() + 360);
            }
            else if(this.getDirection() > 360){
                this.setDirection(this.getDirection() - 360);
            }
        }
    }

    public int getPower() {
        return power;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car c = (Car) super.clone();
        c.productionDate = (Calendar) productionDate.clone();
        return c;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public String toString(){
        return String.format("%s Power: %d Production date: %s", super.toString(), this.getPower(), sdf.format(productionDate.getTime()));
    }
}
