import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws FileNotFoundException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"))) {

            String line = bufferedReader.readLine();
            while (line != null){
                int sum = 0;
                char[] charactersFromLine = line.toCharArray();
                for (char c : charactersFromLine) {
                    sum += c;
                }

                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
