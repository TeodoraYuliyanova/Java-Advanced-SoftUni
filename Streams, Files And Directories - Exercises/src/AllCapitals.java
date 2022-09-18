import java.io.*;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Programirane\\Java Advanced\\Streams, Files And Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))) {
            PrintWriter printWriter = new PrintWriter("outputForAllCapitals.txt");
            String line = bufferedReader.readLine();
            while (line != null) {

                printWriter.println(line.toUpperCase(Locale.ROOT));


                line = bufferedReader.readLine();
            }

            printWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
