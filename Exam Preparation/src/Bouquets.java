import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums1 = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> daffodilsStack = new ArrayDeque<>();
        ArrayDeque<Integer> tulipsQueue = new ArrayDeque<>();

        for (int i = 0; i < nums1.length; i++) {
            daffodilsStack.push(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            tulipsQueue.add(nums2[i]);
        }


        int bouquets = 0;
        int storedSum = 0;

        while (!daffodilsStack.isEmpty() && !tulipsQueue.isEmpty()) {

            int currentTulip = tulipsQueue.poll();
            int currentDaffodil = daffodilsStack.pop();

            while (currentTulip + currentDaffodil > 15) {
                currentTulip -= 2;
            }

            int sum = currentTulip + currentDaffodil;

            if (sum == 15) {
                bouquets++;
            } else {
                storedSum += sum;
            }


        }

        int flowersToAdd = storedSum / 15;
        bouquets = bouquets + flowersToAdd;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }


    }
}
