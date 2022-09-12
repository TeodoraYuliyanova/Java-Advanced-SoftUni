import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileReader("04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt"));
             PrintWriter printWriter = new PrintWriter("04. Java-Advanced-Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt")) {

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {
                    printWriter.println(scanner.nextInt());
                } else {
                    scanner.next();
                }


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
