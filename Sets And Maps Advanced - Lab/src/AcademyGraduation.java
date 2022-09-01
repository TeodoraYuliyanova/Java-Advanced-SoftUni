import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsInfo = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {

            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
            studentsInfo.put(studentName, grades);
        }


        for (var entry : studentsInfo.entrySet()) {
            double avgGrade = 0;

            for (double grade : entry.getValue()) {
                avgGrade += grade;
            }

            DecimalFormat df = new DecimalFormat("#.###############");
            double result = avgGrade / entry.getValue().size();
            System.out.printf("%s is graduated with %s%n", entry.getKey(), df.format(result));
        }
    }
}
