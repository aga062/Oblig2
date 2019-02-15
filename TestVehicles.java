import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestVehicles {
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) throws CloneNotSupportedException {
        TestVehicles vtest = new TestVehicles();


        try {
            vtest.menuLoop();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException!");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void menuLoop() throws InputMismatchException, CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        Vehicle vehicle;

        vehicles.add(new Car("Volvo 740", "blue", 85000, 1985, "1010-11", 0, 120));
        vehicles.add(new Car("Ferrari Testarossa", "red", 1200000, 1996, "A112", 0, 350));
        vehicles.add(new Bicycle("Monark 1", "yellow", 4000, 1993, "BC100", 0, 10));
        vehicles.add(new Bicycle("DBS 2", "pink", 5000, 1994, "42", 0, 10));

        while (true) {
            System.out.println("1...................................New car");
            System.out.println("2...............................New bicycle");
            System.out.println("3......................Find vehicle by name");
            System.out.println("4..............Show data about all vehicles");
            System.out.println("5.......Change direction of a given vehicle");
            System.out.println("6.........................Test clone method");
            System.out.println("7...............................Exit program ");
            System.out.print(".................................Your choice ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Input car data:");
                    vehicle = new Car();
                    vehicle.setAllFields();
                    vehicles.add(vehicle);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Input bicycle data:");
                    vehicle = new Bicycle();
                    vehicle.setAllFields();
                    vehicles.add(vehicle);
                    System.out.println();
                    break;
                case 3:

                    System.out.println();
                    System.out.printf("Name of vehicle: ");
                    input.nextLine();
                    String vehicleName = input.nextLine();
                    for(int i = 0; i < vehicles.size(); i++) {
                        Vehicle V = vehicles.get(i);

                        if(V.getName().equals(vehicleName)) {
                            System.out.printf(V.toString());
                        }
                    }
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    for(int i = 0; i < vehicles.size(); i++) {
                        Vehicle V = vehicles.get(i);
                        System.out.printf("%s ", V.toString());
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.printf("Name of vehicle: ");
                    input.nextLine();
                    String vehicleName2 = input.nextLine();
                    for(int i = 0; i < vehicles.size(); i++) {
                        Vehicle V = vehicles.get(i);
                        if(V.getName().equals(vehicleName2)) {
                            System.out.printf("Direction [R/L]: ");
                            String directionString = input.nextLine();

                            System.out.printf("Degrees [0-360]: ");
                            int degreesToTurn = input.nextInt();

                            if(directionString.equals("R"))
                                V.turnRight(degreesToTurn);
                            else
                                V.turnLeft(degreesToTurn);
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.println(" Test your clone: ");

                    Car c = new Car("Volvo 740", "blue", 85000, 1985, "1010-11", 0, 120);
                    Car c2 = (Car) c.clone();
                    Calendar newCalendar = Calendar.getInstance();
                    newCalendar.set(2018, 01, 29);
                    c2.setBuyingDate(newCalendar);

                    System.out.printf("%tF\n", c.getBuyingDate());
                    System.out.printf("%tF\n", c2.getBuyingDate());

//                    Car c = new Car();
//                    Calendar newCalendar = Calendar.getInstance();
//                    newCalendar.set(2018,01,29);
//                    System.out.println();
                    break;


                case 7:
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
