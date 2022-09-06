import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("JOKER")) {

            String[] tokens = line.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }

            for (String card : cards) {
                players.get(name).add(card);
            }


            line = scanner.nextLine();
        }

        for (var player : players.entrySet()) {
            String playerName = player.getKey();
            int points = calculatePoints(player.getValue());
            System.out.printf("%s: %d%n", playerName, points);
        }
    }

    private static int calculatePoints(HashSet<String> cards) {

        int points = 0;
        for (var card : cards) {
            String power = card.substring(0, card.length() - 1);
            char type = card.charAt(card.length() - 1);
            points += getPower(power) * getType(type);
        }

        return points;

    }

    private static int getType(char type) {

        switch (type) {

            case 'S':
                return 4;

            case 'H':
                return 3;

            case 'D':
                return 2;

            case 'C':
                return 1;

            default:
                return 0;
        }
    }

    private static int getPower(String power) {

        switch (power) {

            case "J":
                return 11;

            case "Q":
                return 12;

            case "K":
                return 13;

            case "A":
                return 14;

            default:
                return Integer.parseInt(power);
        }
    }
}
