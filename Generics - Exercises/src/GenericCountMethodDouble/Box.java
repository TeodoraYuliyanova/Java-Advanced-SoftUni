package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box <T> {
    private List<Double> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(Double number){
        this.values.add(number);
    }

    public long countGreaterThan(Double number){
        return this.values.stream().filter(d -> d.compareTo(number) > 0).count();
    }

}
