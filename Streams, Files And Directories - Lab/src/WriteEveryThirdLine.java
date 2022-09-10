import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt"));
            PrintWriter printWriter = new PrintWriter("04. Java-Advanced-Files-and-Streams-Lab-Resources/05.WriteEveryThirdLineOutput.txt")){


            String line = bufferedReader.readLine();
            int counter = 0;
            while (line != null){
                counter++;
                if (counter % 3 == 0){
                    printWriter.println(line);
                }

                line = bufferedReader.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
