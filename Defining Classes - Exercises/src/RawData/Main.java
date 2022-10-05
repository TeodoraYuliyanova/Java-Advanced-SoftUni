package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());
        List<Tire> tires = new ArrayList<>();
        List<Car> cars = new ArrayList<>();


        for (int i = 0; i < countCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);


            for (int j = 5; j < tokens.length; j = j + 2) {

                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }


            Car car = new Car(model, engine, tires, cargo);
            cars.add(car);


        }

        String cargoType = scanner.nextLine();
        switch (cargoType) {

            case "fragile":
                cars.stream().filter(car -> car.getCargo().getCargoType().equals("fragile"))
                        .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                        .forEach(car -> System.out.println(car.getModel()));

                break;

            case "flamable":
                cars.stream().filter(car -> car.getCargo().getCargoType().equals("flamable"))
                        .filter(car -> car.getEngine().getEnginePower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));
                break;


        }


    }
}
