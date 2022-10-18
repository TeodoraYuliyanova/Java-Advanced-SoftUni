package Collection;

import java.util.Iterator;
import java.util.List;


public class ListyOperator implements Iterable<String> {

    private List<String> elements;
    int index;

    public ListyOperator(String... elements) {
        this.elements = List.of(elements);
    }

    public boolean HasNext() {
        return this.index < this.elements.size() - 1;
    }

    public boolean Move() {
        if (HasNext()) {
            index++;
            return true;
        } else {
            return false;
        }
    }

    public void Print() {
        if (this.elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(index));
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
           private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(index);
                index++;
                return element;
            }
        };
    }


}
