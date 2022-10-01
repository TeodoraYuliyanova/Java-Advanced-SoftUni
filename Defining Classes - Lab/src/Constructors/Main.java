package Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String brand = tokens[0];
            if (tokens.length == 1) {

                Car car = new Car(brand);
                System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsePower());
            } else {

                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);

                Car car = new Car(brand, model, horsePower);
                System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsePower());
            }

        }
    }
}
