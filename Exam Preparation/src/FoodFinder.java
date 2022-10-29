import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] letters1 = scanner.nextLine().split(" ");
        String[] letters2 = scanner.nextLine().split(" ");

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        vowelsQueue.addAll(Arrays.asList(letters1));
        for (int i = 0; i < letters2.length; i++) {
            consonantsStack.push(letters2[i]);
        }

        String pear = "pear";
        String flour = "flour";
        String pork = "pork";
        String olive = "olive";


        List<String> wordsFound = new ArrayList<>();

        Set<String> pearSet = new HashSet<>();
        Set<String> flourSet = new HashSet<>();
        Set<String> porkSet = new HashSet<>();
        Set<String> oliveSet = new HashSet<>();


        while (!consonantsStack.isEmpty()) {

            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();

            for (int i = 0; i < pear.length(); i++) {
                String letter = String.valueOf(pear.charAt(i));


                containsVowelOrConsonants(vowelsQueue, pearSet, vowel, consonant, letter);
            }

            for (int i = 0; i < flour.length(); i++) {
                String letter = String.valueOf(flour.charAt(i));

                containsVowelOrConsonants(vowelsQueue, flourSet, vowel, consonant, letter);
            }

            for (int i = 0; i < pork.length(); i++) {
                String letter = String.valueOf(pork.charAt(i));

                containsVowelOrConsonants(vowelsQueue, porkSet, vowel, consonant, letter);
            }

            for (int i = 0; i < olive.length(); i++) {
                String letter = String.valueOf(olive.charAt(i));

                containsVowelOrConsonants(vowelsQueue, oliveSet, vowel, consonant, letter);

            }
        }


        if (pearSet.size() == 4) {
            wordsFound.add("pear");
        }

        if (flourSet.size() == 5) {
            wordsFound.add("flour");
        }

        if (porkSet.size() == 4) {
            wordsFound.add("pork");
        }

        if (oliveSet.size() == 5) {
            wordsFound.add("olive");
        }

        System.out.println("Words found: " + wordsFound.size());
        wordsFound.forEach(System.out::println);


    }

    private static void containsVowelOrConsonants(ArrayDeque<String> vowelsQueue, Set<String> set, String vowel, String consonant, String letter) {
        if (letter.equals(vowel)) {
            set.add(vowel);
            vowelsQueue.add(vowel);
        }

        if (letter.equals(consonant)) {
            set.add(consonant);
        }
    }
}
