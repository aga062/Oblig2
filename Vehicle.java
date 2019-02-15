
import java.util.*;
import java.text.*;

public abstract class Vehicle {
    private String colour, name, serialNr;
    private int model, price, direction = 0;
    private double speed;
    protected Scanner input;
    public static final DateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public Vehicle(){
        input = new Scanner(System.in);
    }
    public Vehicle(String name, String color, int price, int model, String serialNr, int direction){
        this.name = name;
        this.colour = color;
        this.serialNr = serialNr;
        this.model = model;
        this.price = price;
        this.direction = direction;
        input = new Scanner(System.in);
    }

    public void setAllFields(){
        System.out.printf("Name: ");
        this.setName(input.nextLine());

        System.out.printf("Colour: ");
        this.setColour(input.nextLine());

        System.out.printf("Serial #: ");
        this.setSerialNr(input.nextLine());

        System.out.printf("Price: ");
        this.setPrice(input.nextInt());

        System.out.printf("Model: ");
        this.setModel(input.nextInt());
    }
    public abstract void turnLeft(int degrees);
    public abstract void turnRight(int degrees);

    public String getColour() {
        return colour;
    }

    public String getName() {
        return name;
    }

    public String getSerialNr() {
        return serialNr;
    }

    public int getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNr(String serialNr) {
        this.serialNr = serialNr;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toString() {
        return String.format("Name: %s Colour: %s Price: %d Model: %d Serial#: %s Direction: %d Speed: %.2f", this.getName(), this.getColour(), this.getPrice(), this.getModel(), this.getSerialNr(), this.getDirection(), this.getSpeed());
    }
}

