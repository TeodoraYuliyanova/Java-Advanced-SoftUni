package parrots;


import java.util.ArrayList;
import java.util.List;


public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }


    public void add(Parrot parrot) {

        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }


    public boolean remove(String parrotName) {

        if (this.data.removeIf(parrot -> parrot.getName().equals(parrotName))) {
            return true;
        }

        return false;

    }


    public Parrot sellParrot(String name) {

        Parrot toReturn = null;

        for (Parrot p : data) {

            if (p.getName().equals(name)) {
                p.setAvailable(false);
                toReturn = p;
            }
        }

        return toReturn;
    }


    public List<Parrot> sellParrotBySpecies(String species) {

        List<Parrot> toReturn = new ArrayList<>();

        this.data.stream().forEach(p -> {
            if (p.getSpecies().equals(species)) {
                p.setAvailable(false);
                toReturn.add(p);
            }
        });

        return toReturn;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:%n", getName()));

        this.data.forEach(parrot -> sb.append(parrot.toString()));

        return sb.toString().trim();

    }
}
