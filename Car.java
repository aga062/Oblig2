
import java.util.*;
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

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public String toString(){
        return String.format("%s Power: %d Production date: %s", super.toString(), this.getPower(), sdf.format(productionDate.getTime()));
    }
}
