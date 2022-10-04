package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String personName;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parent> parents;
    private List<Child> child;
    private Car car;

    public Person(String personName) {
        this.personName = personName;
        this.company = null;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.child = new ArrayList<>();
        this.car = null;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChild() {
        return child;
    }

    public void setChild(List<Child> child) {
        this.child = child;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return  this.personName + System.lineSeparator() +
                "Company:" + System.lineSeparator() +
                (company == null ? "" : company + System.lineSeparator()) +
                "Car:" + System.lineSeparator() +
                (car == null ? "" : car + System.lineSeparator()) +
                "Pokemon:" + System.lineSeparator() +
                ((pokemon.isEmpty()) ? "" : pokemon.stream().map(Pokemon::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Parents:" + System.lineSeparator() +
                ((parents.isEmpty()) ? "" : parents.stream().map(Parent::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Children:" + System.lineSeparator() +
                ((child.isEmpty()) ? "" : child.stream().map(Child::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator());
    }

}
