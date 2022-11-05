import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numberOfIngredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessOfIngredientsStack = new ArrayDeque<>();

        for (int i = 0; i < nums1.length; i++) {
            numberOfIngredientsQueue.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            freshnessOfIngredientsStack.push(nums2[i]);
        }

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!numberOfIngredientsQueue.isEmpty() && !freshnessOfIngredientsStack.isEmpty()) {

            int currentQueue = numberOfIngredientsQueue.poll();
            int currentStack = freshnessOfIngredientsStack.pop();

            int result = currentQueue * currentStack;

            if (currentQueue == 0) {
                freshnessOfIngredientsStack.push(currentStack);
                continue;
            }

            switch (result) {

                case 150:
                    cocktails.putIfAbsent("Pear Sour", 0);
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    break;

                case 250:
                    cocktails.putIfAbsent("The Harvest", 0);
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    break;

                case 300:
                    cocktails.putIfAbsent("Apple Hinny", 0);
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    break;

                case 400:
                    cocktails.putIfAbsent("High Fashion", 0);
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    break;

                default:
                    numberOfIngredientsQueue.add(currentQueue + 5);
                    break;


            }
        }

        if (cocktails.size() != 4) {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        } else {
            System.out.println("It's party time! The cocktails are ready!");
        }

        if (!numberOfIngredientsQueue.isEmpty()) {
            int sum = numberOfIngredientsQueue.stream().mapToInt(integer -> integer).sum();
            System.out.println("Ingredients left: " + sum);
        }

        cocktails.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()));
    }
}
