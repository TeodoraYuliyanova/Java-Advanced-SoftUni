package GenericCountMethodString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box <T> {

    private List<String> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(String element){
        this.values.add(element);
    }

  public long countGreaterThan(String element){
        return this.values.stream().filter(itemFromBox -> itemFromBox.compareTo(element) > 0).count();
  }
}
