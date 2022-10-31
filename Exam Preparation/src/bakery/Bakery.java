package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {

    public String name;
    public int capacity;
    public List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }


    public void add(Employee employee) {
        if (this.employees.size() < this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }


    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }


    public int getCount() {
        return this.employees.size();
    }


    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:" , this.name));
        sb.append(System.lineSeparator());

        for (Employee employee : this.employees) {
            sb.append(employee.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
