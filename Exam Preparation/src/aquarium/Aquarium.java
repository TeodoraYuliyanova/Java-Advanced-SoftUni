package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }


    public void add(Fish fish) {
        if (getCapacity() > this.fishInPool.size() && !this.fishInPool.contains(fish)) {
            this.fishInPool.add(fish);
        }
    }


    public boolean remove(String name) {

        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }

        return false;
    }


    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }


    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium Info:%n"));
        sb.append(String.format("Aquarium: %s ^ Size: %d", getName(), getSize()));
        sb.append("\n");
        for (Fish fish : this.fishInPool) {
            sb.append(fish).append("\n");

        }
        return sb.toString().trim();

    }
}
