package RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;


    public Car(String model, Engine engine, List<Tire> tires, Cargo cargo) {
        this.model = model;
        this.engine = engine;
        this.tires = new ArrayList<>();
        this.cargo = cargo;
        this.tires.addAll(tires);
    }

    public String getModel() {
        return model;
    }


    public Engine getEngine() {
        return engine;
    }


    public Cargo getCargo() {
        return cargo;
    }


    public List<Tire> getTires() {
        return tires;
    }


}
