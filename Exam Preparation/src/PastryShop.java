import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int i = 0; i < nums1.length; i++) {
            liquidsQueue.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            ingredientsStack.push(nums2[i]);
        }

        Map<Integer, String> foodRes = new HashMap<>();
        foodRes.put(25, "Biscuit");
        foodRes.put(50, "Cake");
        foodRes.put(75, "Pastry");
        foodRes.put(100, "Pie");

        Map<String, Integer> food = new TreeMap<>();


        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int currentQueue = liquidsQueue.poll();
            int currentStack = ingredientsStack.pop();

            int sum = currentQueue + currentStack;

            if (foodRes.containsKey(sum)) {
                String current = foodRes.get(sum);
                food.putIfAbsent(current, 0);
                food.put(current, food.get(current) + 1);
            } else {
                ingredientsStack.push(currentStack + 3);
            }


        }

        if (food.size() == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
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

        System.out.println("Biscuit: " + (food.getOrDefault("Biscuit", 0)));
        System.out.println("Cake: " + (food.getOrDefault("Cake", 0)));
        System.out.println("Pie: " + (food.getOrDefault("Pie", 0)));
        System.out.println("Pastry: " + (food.getOrDefault("Pastry", 0)));
    }
}
