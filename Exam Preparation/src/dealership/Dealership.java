package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {

    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }


    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(c -> c.manufacturer.equals(manufacturer) && c.getModel().equals(model));
    }


    public Car getLatestCar() {

        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }


    public Car getCar(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.manufacturer.equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n" , this.name));

        for (Car car : this.data) {
            sb.append(car.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
