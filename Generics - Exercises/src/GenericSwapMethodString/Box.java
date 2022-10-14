package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box {

    private List<String> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(String element){
        this.values.add(element);
    }

    public void swap(Integer firstIndex,Integer secondIndex){
        Collections.swap(values, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String value : this.values) {
            sb.append(String.format("%s: %s%n" , value.getClass().getName() , value.toString()));
        }
        return sb.toString().trim();
    }
}
