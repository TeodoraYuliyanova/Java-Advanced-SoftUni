import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsInfoMap = new TreeMap<>();

        for (int i = 0; i < numbersOfStudents; i++) {

            String[] studentInfo = scanner.nextLine().split(" ");
            String studentName = studentInfo[0];
            double studentGrade = Double.parseDouble(studentInfo[1]);

            studentsInfoMap.putIfAbsent(studentName, new ArrayList<>());
            studentsInfoMap.get(studentName).add(studentGrade);


        }

        for (var studentsNameList : studentsInfoMap.entrySet()) {
            double avgGrade = 0.0;

            for (double grade : studentsNameList.getValue()) {
                avgGrade += grade;
            }

            avgGrade /= studentsNameList.getValue().size();
            List<String> grades = studentsNameList.getValue().stream().map(e -> String.format("%.2f", e)).collect(Collectors.toList());
            String finalGrade = String.join(" ", grades);
            System.out.printf("%s -> %s (avg: %.2f)%n", studentsNameList.getKey(), finalGrade, avgGrade);
        }

    }
}
