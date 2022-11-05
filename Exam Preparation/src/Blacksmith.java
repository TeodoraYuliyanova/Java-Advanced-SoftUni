import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        for (int i = 0; i < firstNumbers.length; i++) {
            steel.add(firstNumbers[i]);
        }

        for (int i = 0; i < secondNumbers.length; i++) {
            carbon.push(secondNumbers[i]);
        }

        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        int counter = 0;
        String sword;


        while (!steel.isEmpty() && !carbon.isEmpty()) {

            int currentSteel = steel.poll();
            int currentCarbon = carbon.pop();
            int sum = currentSteel + currentCarbon;

            switch (sum) {

                case 70:

                    sword = "Gladius";
                    swords.putIfAbsent(sword, 0);
                    addSword(sword,swords);
                    counter++;

                    break;

                case 80:

                    sword = "Shamshir";
                    swords.putIfAbsent(sword, 0);
                    addSword(sword,swords);
                    counter++;

                    break;

                case 90:

                    sword = "Katana";
                    swords.putIfAbsent(sword, 0);
                    addSword(sword,swords);
                    counter++;

                    break;

                case 110:

                    sword = "Sabre";
                    swords.putIfAbsent(sword, 0);
                    addSword(sword,swords);
                    counter++;

                    break;

                default:
                    int newValueCarbon = currentCarbon + 5;
                    carbon.push(newValueCarbon);


            }
        }

        int swordsValueSum = swords.values().stream().mapToInt(e -> e).sum();
        if (swordsValueSum == 0) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.printf("You have forged %d swords.%n", counter );
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.println("Steel left: " + steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.println("Carbon left: " + carbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }


        swords.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));


    }

    private static void addSword(String sword, Map<String, Integer> swords) {

        swords.put(sword, swords.get(sword) + 1);
    }
}
