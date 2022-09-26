import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //NE E RESHENA PRAVILNO , DAVA 60/100

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());


        String line = scanner.nextLine();
        while (!line.equals("Party!")) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "Remove":

                    if (tokens[1].equals("StartsWith")) {
                        Predicate<String> toStay = name -> !name.startsWith(tokens[2]);
                        names = names.stream().filter(toStay).collect(Collectors.toList());
                    } else if (tokens[1].equals("EndsWith")) {
                        Predicate<String> toStay = name -> !name.endsWith(tokens[2]);
                        names = names.stream().filter(toStay).collect(Collectors.toList());
                    }


                    break;


                case "Double":

                    if (tokens[1].equals("StartsWith")){
                        Predicate<String> toStay = name -> name.startsWith(tokens[2]);
                        List<String> newNames = names.stream().filter(toStay).collect(Collectors.toList());
                        names.addAll(newNames);

                    }else if (tokens[1].equals("EndsWith")){
                        Predicate<String> toStay = name -> name.endsWith(tokens[2]);
                        List<String> newNames = names.stream().filter(toStay).collect(Collectors.toList());
                        names.addAll(newNames);

                    }else if (tokens[1].equals("Length")) {

                        Predicate<String> toStay = name -> name.length() == Integer.parseInt(tokens[2]);

                        List<String> newNames = names.stream().filter(toStay).collect(Collectors.toList());
                        names.addAll(newNames);

                    }
                    break;


            }


            line = scanner.nextLine();
        }


        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.println(names.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!");
        }


    }
}
