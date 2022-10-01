package CarInfo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");
            String brand = tokens[0];
            String model = tokens[1];
            String horsePower = tokens[2];

            Car car = new Car(brand, model, horsePower);

            System.out.println(car.toString());

        }
    }


}
