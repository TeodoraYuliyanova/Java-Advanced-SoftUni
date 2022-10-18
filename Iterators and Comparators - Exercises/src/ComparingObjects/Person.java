package ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }


    @Override
    public int compareTo(Person person) {

        if (getName().equals(person.name)) {
            if (getAge() == person.age) {
                return getTown().compareTo(person.town);
            }
            return Integer.compare(getAge(), person.age);
        }
        return getName().compareTo(person.name);
    }
}

