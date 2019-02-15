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
    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }
    public String toString(){
        return String.format("%s Gears: %d Production date: %s", super.toString(), this.getGears(), sdf.format(productionDate.getTime()));
    }
}