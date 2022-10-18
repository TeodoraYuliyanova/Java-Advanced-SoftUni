package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] peopleInfo =line.split(" ");
            String name = peopleInfo[0];
            int age = Integer.parseInt(peopleInfo[1]);
            String town = peopleInfo[2];

            Person person = new Person(name, age, town);
            personList.add(person);


            line = scanner.nextLine();
        }

        int nThPerson = Integer.parseInt(scanner.nextLine());

        Person personToCompare = personList.get(nThPerson - 1);
        int equalPeople = 0;
        int differentPeople = 0;

        for (Person person : personList) {
            if (personToCompare.compareTo(person) == 0) {
                equalPeople++;
            }else {
                differentPeople++;
            }
        }

        if (equalPeople == 1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d" , equalPeople , differentPeople , personList.size());
        }
    }
}
