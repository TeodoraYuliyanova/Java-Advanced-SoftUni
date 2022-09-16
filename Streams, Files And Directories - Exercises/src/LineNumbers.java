import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));
             PrintWriter printWriter = new PrintWriter("outputForLineNumbers.txt")) {

            int counter = 1;
            String line = bufferedReader.readLine();
            while (line != null) {

                printWriter.println(counter + "." + " " + line);
                counter++;

                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
