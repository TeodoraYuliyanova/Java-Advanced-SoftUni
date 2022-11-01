package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Basket {

    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Egg> getData() {
        return data;
    }

    public String getMaterial() {
        return material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity){
            data.add(egg);
        }
    }


    public Egg getEgg(String color) {
        for (Egg egg : data){
            if (color.equals(egg.getColor())){
                return egg;
            }
        }
        return null;
    }

    public boolean removeEgg(String color) {
        boolean isRemoved = false;

        if (data.contains(getEgg(color))){
            data.remove(getEgg(color));
            isRemoved = true;
        }
        return isRemoved;
    }

    public Egg getStrongestEgg() {

        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public int getCount(){
        return data.size();
    }

    public String report() {

        //Red egg, with 10 strength and oval shape.
        // Green egg, with 9 strength and pointy shape.
       StringBuilder sb = new StringBuilder();
       sb.append(String.format("%s basket contains:%n" , getMaterial()));
       data.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));

       return sb.toString().trim();
    }
}
