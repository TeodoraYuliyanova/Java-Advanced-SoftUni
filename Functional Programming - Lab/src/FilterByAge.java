import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = IntStream.range(0, n).mapToObj(i -> readPerson(scanner)).collect(Collectors.toList());


        String condition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();

        people = filterByCondition(people, getPredicate(condition, ageFilter));

        Consumer<Person> printer = getPrinter(outputFormat);
        people.forEach(printer);

    }

    private static Consumer<Person> getPrinter(String outputFormat) {
        switch (outputFormat){
            case "name":
                return p -> System.out.println(p.name);

            case "age":
                return p -> System.out.println(p.age);

            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);

            default: throw new IllegalArgumentException("Unknown format " + outputFormat);
        }
    }


    private static Predicate<Person> getPredicate(String condition, int ageFilter) {
        switch (condition){
            case "younger":
                return p -> p.age <= ageFilter;

            case "older":
                return  p -> p.age >= ageFilter;

            default: throw  new IllegalArgumentException("Invalid parameters for age predicate " + condition + " " + ageFilter);
        }
    }

    private static List<Person> filterByCondition(List<Person> people, Predicate<Person> predicate) {
        return people.stream().filter(predicate).collect(Collectors.toList());
    }

    public static Person readPerson(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(", ");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);

        Person person = new Person(name, age);
        return person;
    }


}

