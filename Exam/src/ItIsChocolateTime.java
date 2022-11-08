import java.util.*;

public class ItIsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] nums1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double[] nums2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        ArrayDeque<Double> milkQuantityQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoQuantityStack = new ArrayDeque<>();

        for (int i = 0; i < nums1.length; i++) {
            milkQuantityQueue.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            cacaoQuantityStack.push(nums2[i]);
        }

        Map<Double, String> allChocolates = new HashMap<>();
        allChocolates.put(30.0, "Milk Chocolate");
        allChocolates.put(50.0, "Dark Chocolate");
        allChocolates.put(100.0, "Baking Chocolate");

        Map<String, Integer> madeChocks = new TreeMap<>();


        while (!milkQuantityQueue.isEmpty() && !cacaoQuantityStack.isEmpty()) {

            double currentQueue = milkQuantityQueue.poll();
            double currentStack = cacaoQuantityStack.pop();

            double sumOfTheStack = 0.0;

            double cacaoPercentage = (currentStack / (currentQueue + currentStack) * 100);


            if (allChocolates.containsKey(cacaoPercentage)) {
                String chockName = allChocolates.get(cacaoPercentage);
                madeChocks.putIfAbsent(chockName, 0);
                madeChocks.put(chockName, madeChocks.get(chockName) + 1);
            } else {
                milkQuantityQueue.add(currentQueue + 10);
            }

        }

        if (madeChocks.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        madeChocks.forEach((key, value) -> System.out.println("# " + key + " --> " + value));

    }
}
