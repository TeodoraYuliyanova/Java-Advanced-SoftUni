import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources");

        Deque<File> files = new ArrayDeque<>();
        files.offer(folder);
        int folderSizeSum = 0;

        while (!files.isEmpty()) {
            File currentFile = files.poll();
            File [] nestedFiles = currentFile.listFiles();
            for (File file : nestedFiles) {
                if (file.isDirectory()){
                    files.offer(file);
                }else {
                    folderSizeSum += file.length();
                }
            }


        }

        System.out.println("Folder size: " + folderSizeSum);
    }
}
