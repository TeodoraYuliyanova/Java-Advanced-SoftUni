package CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;

    private String email;
    private int age;


    // //няма нито години,нито имейл
    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = -1;
        this.email = "n/a";
    }

   //има само имейл
    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;

    }

    //има само години
    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;

    }


    //има и години и имейл
    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department, email);
        this.age = age;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d" , this.name , this.salary , this.email , this.age);
    }
}
