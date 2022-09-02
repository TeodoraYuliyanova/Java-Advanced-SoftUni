import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String line = scanner.nextLine();
        while (!line.equals("END")) {

            String[] tokens = line.split(", ");

            String direction = tokens[0];
            String regNumber = tokens[1];

            switch (direction) {

                case "IN":
                    cars.add(regNumber);
                    break;

                case "OUT":
                    cars.remove(regNumber);
                    break;
            }


            line = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
