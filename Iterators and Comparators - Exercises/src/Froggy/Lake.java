package Froggy;


import java.util.Iterator;
import java.util.List;


public class Lake implements Iterable<Integer> {

    private List<Integer> elements;

    public Lake(List<Integer> numbers) {
        this.elements = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public class Frog implements Iterator<Integer> {
        int index = 0;
        boolean firstRoundFinishes = false;

        @Override
        public boolean hasNext() {
            return this.index < elements.size();
        }

        @Override
        public Integer next() {
            int currentIndex = index;
            index += 2;


            if (index >= elements.size() && !firstRoundFinishes) {
                index = 1;
                firstRoundFinishes = true;

            }
            return elements.get(currentIndex);
        }


    }
}
