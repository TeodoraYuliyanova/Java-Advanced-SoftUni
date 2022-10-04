package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engineMap = new HashMap<>();

        int numbersOfEngines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbersOfEngines; i++) {
            //{Model} {Power} {Displacement} {Efficiency}
            String[] tokens = scanner.nextLine().split("\\s+");
            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);
            int engineDisplacement = 0;
            String engineEfficiency = "n/a";

            if (tokens.length == 3) {

                if (tokens[2].matches("\\d+")) {
                    //if it has only displacement
                    engineDisplacement = Integer.parseInt(tokens[2]);

                } else {
                    //if it has only efficiency
                    engineEfficiency = tokens[2];

                }
            } else if (tokens.length == 4) {
                //if it has both displacement and efficiency
                engineDisplacement = Integer.parseInt(tokens[2]);
                engineEfficiency = tokens[3];

            }
            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);

            engineMap.putIfAbsent(engineModel, engine);


        }


        int numbersOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();


        for (int i = 0; i < numbersOfCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            //{Model} {Engine} {Weight} {Color}
            String carModel = tokens[0];
            String carEngine = tokens[1];
            Engine engineTemp = engineMap.get(carEngine);

            int carWeight = 0;  //optional
            String carColor = "n/a";  //optional

            if (tokens.length == 3) {

                if (tokens[2].matches("\\d+")) {
                    //if it has only weight
                    carWeight = Integer.parseInt(tokens[2]);
                } else {
                    //if it has only color
                    carColor = tokens[2];
                }


            } else if (tokens.length == 4) {
                //if it has both weight and color
                carWeight = Integer.parseInt(tokens[2]);
                carColor = tokens[3];

            }

            Car car = new Car(carModel, engineTemp, carWeight, carColor);
            cars.add(car);
        }

        cars.forEach(System.out::println);


    }
}
