package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    private int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();

    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }


    public int getStudentCount() {
        return this.students.size();
    }


    public String registerStudent(Student student) {

        if (this.students.size() < this.capacity) {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getFirstName());
        } else {
            for (Student s : this.students) {
                if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())) {
                    return "Student is already in the university";
                }
            }
        }

        return "No seats in the university";
    }


    public String dismissStudent(Student student) {

        boolean isFound = false;

        for (Student s : this.students) {
            if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());

        } else {
            return "Student not found";
        }


    }


    public Student getStudent(String firstName, String lastName) {

        return this.students.stream().filter(s -> s.firstName.equals(firstName) && s.lastName.equals(lastName)).findFirst().orElse(null);
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : this.students) {
            sb.append("==Student: First Name = ").append(student.getFirstName()).append(", Last Name = ")
                    .append(student.getLastName()).append(", Best Subject = ").append(student.getBestSubject());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
