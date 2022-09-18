import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {

        try (Scanner scannerForWordsToCount = new Scanner(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));
             Scanner scannerForText = new Scanner(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
             PrintWriter printWriter = new PrintWriter("outputForWordCount")) {
            Map<String, Integer> wordsMap = new LinkedHashMap<>();
            Arrays.stream(scannerForWordsToCount.nextLine().split(" ")).forEach(word -> wordsMap.put(word, 0));

            while (scannerForText.hasNext()) {
                String textInput = scannerForText.next();
                if (wordsMap.containsKey(textInput)) {
                    wordsMap.put(textInput, wordsMap.get(textInput) + 1);
                }


            }

            wordsMap.entrySet().stream().forEach(entry -> printWriter.printf("%s - %d%n" , entry.getKey(), entry.getValue()));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
