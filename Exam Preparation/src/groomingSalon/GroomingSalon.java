package groomingSalon;

import java.util.ArrayList;
import java.util.List;


public class GroomingSalon {

    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }


    public void add(Pet pet) {
        if (this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }


    public boolean remove(String name) {
      return   this.data.removeIf(pet -> pet.getName().equals(name));
    }


    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner)).findFirst().orElse(null);
    }


    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The grooming salon has the following clients:%n"));
        for (Pet pet : this.data) {
            sb.append(String.format("%s %s" , pet.getName() , pet.getOwner()));
            sb.append(String.format("%n"));
        }

        return sb.toString().trim();
    }
}
