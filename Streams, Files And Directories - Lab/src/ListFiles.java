import java.io.File;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Deque;

public class ListFiles {
    public static void main(String[] args) {

        File folder = new File("04. Java-Advanced-Files-and-Streams-Lab-Resources");
        Deque<File> files = new ArrayDeque<>();
        files.offer(folder);

        while (!files.isEmpty()) {

            File currentFile = files.pop();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile : nestedFiles) {
                if (!nestedFile.isDirectory()){
                    System.out.println(nestedFile + ": " + nestedFile.length());
                }
            }


        }
    }
}
