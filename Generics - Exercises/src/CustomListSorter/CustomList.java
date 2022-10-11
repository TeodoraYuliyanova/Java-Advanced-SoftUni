package CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void remove(int index) {
        this.values.remove(index);
    }

    public boolean contains(T element) {
        for (T value : this.values) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }

    public long countGreaterThan(T element) {
        return this.values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.values.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return this.values.stream().min(Comparator.naturalOrder()).get();
    }

    public int size() {
        return values.size();
    }

    public T get(int index) {
        return this.values.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb.append(String.format("%s%n", value.toString()));
        }
        return sb.toString().trim();
    }

}
