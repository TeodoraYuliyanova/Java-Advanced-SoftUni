package CarInfo;

public class Car {

    public String brand;
    public String model;
    public String horsePower;


    public Car(String brand, String model, String horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {

        return String.format("The car is: %s %s - %s HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
