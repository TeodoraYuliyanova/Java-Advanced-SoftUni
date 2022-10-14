package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box {
    List<Integer> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(Integer integer){
        this.values.add(integer);
    }

    public void swap(Integer firstIndex, Integer secondIndex){
        Collections.swap(values, firstIndex,secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer value : this.values) {
            sb.append(String.format("%s: %s%n" , value.getClass().getName(),value.toString()));
        }
        return sb.toString().trim();
    }
}
