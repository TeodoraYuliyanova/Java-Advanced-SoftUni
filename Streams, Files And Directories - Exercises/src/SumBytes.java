import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        int sum = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"))) {

            String line = bufferedReader.readLine();
            while (line != null) {

                char[] charactersFromText = line.toCharArray();
                for (char c : charactersFromText) {
                    sum += c;
                }


                line = bufferedReader.readLine();
            }


        }

        System.out.println(sum);
    }
}
