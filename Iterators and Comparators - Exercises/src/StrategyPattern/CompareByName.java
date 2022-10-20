package StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class CompareByName implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {

        if (person1.getName().length() == person2.getName().length()) {
            char p1Letter = person1.getName().toLowerCase(Locale.ROOT).charAt(0);
            char p2Letter = person2.getName().toLowerCase(Locale.ROOT).charAt(0);
            if (p1Letter == p2Letter) {
                return 0;
            }
            return Integer.compare(p1Letter, p2Letter);
        }

        return Integer.compare(person1.getName().length(), person2.getName().length());
    }
}
