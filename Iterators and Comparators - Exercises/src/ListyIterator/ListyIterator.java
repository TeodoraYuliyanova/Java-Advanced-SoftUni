package ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {

    private List<String> elements;
    private int index;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        this.index = 0;
    }

    public boolean HasNext() {
        return this.index < this.elements.size() - 1;
    }

    public boolean Move() {
        if (HasNext()) {
            index++;
            return true;
        }
        return false;

    }

    public void Print() {
        if (this.elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(index));
        }

    }


}
