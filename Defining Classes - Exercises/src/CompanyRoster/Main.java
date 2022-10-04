package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//The name, salary, position, and department are mandatory while the rest are optional

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> employeesMap = new LinkedHashMap<>();


        Employee employee = null;

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];


            //no age,no email
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);


                //has age or email
            } else if (tokens.length == 5) {


                //has only age
                if (tokens[4].matches("\\d+")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);


                } else {
                    //has only email
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);


                }

            } else {
                //has age and email
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);


            }

            employeesMap.putIfAbsent(department, new Department(department));
            employeesMap.get(department).getEmployees().add(employee);

        }

        Department highestPaidDepartment = employeesMap.entrySet().stream().
                max(Comparator.comparingDouble(e -> e.getValue().calculateSalary())).get().getValue();

        System.out.println("Highest Average Salary: " + highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).
                forEach(System.out::println);


    }


}
