package university;

public class Student {

    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s" , getFirstName() , getLastName() , getBestSubject());
    }
}
