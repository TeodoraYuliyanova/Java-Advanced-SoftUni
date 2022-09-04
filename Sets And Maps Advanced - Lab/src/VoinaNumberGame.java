import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstCards = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        for (int card : firstCards) {
            firstPlayerCards.add(card);
        }

        int[] secondCards = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        for (int card : secondCards) {
            secondPlayerCards.add(card);
        }


        int round = 1;
        while (!firstPlayerCards.isEmpty() || !secondPlayerCards.isEmpty()) {
            round++;
            if (round == 50) {
                break;
            }

            int firstCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstCard);

            int secondCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }

        }

        if (firstPlayerCards.size() == secondPlayerCards.size()) {
            System.out.println("Draw!");
        } else if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
