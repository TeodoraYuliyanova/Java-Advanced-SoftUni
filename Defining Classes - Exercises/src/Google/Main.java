package Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personInfoMap = new HashMap<>();


        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            Company company = null;
            Car car = null;
            Pokemon pokemon = null;
            Parent parent = null;
            Child child = null;

            personInfoMap.putIfAbsent(personName, new Person(personName));

            //can have multiple parents, children, and pokemons

            if (line.contains("company")) {

                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                company = new Company(companyName, department, salary);
                personInfoMap.get(personName).setCompany(company);


            } else if (line.contains("car")) {

                String carModel = tokens[2];
                int carSpeed = Integer.parseInt(tokens[3]);
                car = new Car(carModel, carSpeed);
                personInfoMap.get(personName).setCar(car);


            } else if (line.contains("pokemon")) {

                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                pokemon = new Pokemon(pokemonName, pokemonType);
                personInfoMap.get(personName).getPokemon().add(pokemon);


            } else if (line.contains("parents")) {

                String parentName = tokens[2];
                String parentBDay = tokens[3];
                parent = new Parent(parentName, parentBDay);
                personInfoMap.get(personName).getParents().add(parent);


            } else if (line.contains("children")) {

                String childName = tokens[2];
                String childBDay = tokens[3];
                child = new Child(childName, childBDay);
                personInfoMap.get(personName).getChild().add(child);

            }


            line = scanner.nextLine();
        }

        String nameToPrint = scanner.nextLine();
        System.out.println(personInfoMap.get(nameToPrint));


    }
}
