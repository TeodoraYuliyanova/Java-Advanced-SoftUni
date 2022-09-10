import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

      List<String> sortedLines = Files.readAllLines(Paths.get(path)).stream()
              .sorted().collect(Collectors.toList());

        Path output = Path.of("outputForSortedLines");
        Path write = Files.write(output , sortedLines);

    }
}
