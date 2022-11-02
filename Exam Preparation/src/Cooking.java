import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int i = 0; i < num1.length; i++) {
            liquidsQueue.add(num1[i]);
        }
        for (int i = 0; i < num2.length; i++) {
            ingredientsStack.push(num2[i]);
        }

        Map<Integer, String> givenFoods = new HashMap<>();
        givenFoods.put(25, "Bread");
        givenFoods.put(50, "Cake");
        givenFoods.put(75, "Pastry");
        givenFoods.put(100, "Fruit Pie");

        Map<String, Integer> cookedFoods = new TreeMap<>();


        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int currentQueue = liquidsQueue.poll();
            int currentStack = ingredientsStack.pop();

            int sum = currentQueue + currentStack;

            if (givenFoods.containsKey(sum)) {
                String name = givenFoods.get(sum);
                cookedFoods.putIfAbsent(name, 0);
                cookedFoods.put(name, cookedFoods.get(name) + 1);
            } else {
                ingredientsStack.push(currentStack + 3);
            }
        }

        if (cookedFoods.size() == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println("Bread: " + (cookedFoods.getOrDefault("Bread", 0)));
        System.out.println("Cake: " + (cookedFoods.getOrDefault("Cake", 0)));
        System.out.println("Fruit Pie: " + (cookedFoods.getOrDefault("Fruit Pie", 0)));
        System.out.println("Pastry: " + (cookedFoods.getOrDefault("Pastry", 0)));

    }
}
