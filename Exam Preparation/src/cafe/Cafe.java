package cafe;


import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }


    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            employees.add(employee);
        }
    }


    public boolean removeEmployee(String name) {
        Employee employeeToRemove = this.employees.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (employeeToRemove != null) {
            this.employees.remove(employeeToRemove);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {

        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }


    public Employee getEmployee(String name) {
        return this.employees.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
//        for (Employee employee : this.employees) {
//            if (employee.getName().equals(name)){
//                return employee;
//            }
//        }
//        return null;
    }


    public int getCount() {
        return this.employees.size();
    }


    public String report() {

        return "Employees working at Cafe " + this.name + ":" + System.lineSeparator() +
                this.employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator()));
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(String.format("Employees working at Cafe %s:%n" , this.name));
//        this.employees.forEach(employee -> sb.append(employee.toString()).append(String.format("%n")));
//
//
//        return sb.toString().trim();
    }
}
