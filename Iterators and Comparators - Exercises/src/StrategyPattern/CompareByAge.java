package StrategyPattern;

import java.util.Comparator;

public class CompareByAge implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {

        if (person1.getAge() == person2.getAge()) {
            return 0;
        }
        return Integer.compare(person1.getAge(), person2.getAge());
    }
}
