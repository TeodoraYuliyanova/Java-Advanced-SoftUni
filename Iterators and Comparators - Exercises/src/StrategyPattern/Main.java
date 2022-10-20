package StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> sortedByName = new TreeSet<>(new CompareByName());
        TreeSet<Person> sortedByAge = new TreeSet<>(new CompareByAge());

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] peopleInfo = scanner.nextLine().split(" ");
            String name = peopleInfo[0];
            int age = Integer.parseInt(peopleInfo[1]);

            Person person = new Person(name, age);
            sortedByName.add(person);
            sortedByAge.add(person);

        }

        sortedByName.forEach(System.out::println);
        sortedByAge.forEach(System.out::println);


    }
}
