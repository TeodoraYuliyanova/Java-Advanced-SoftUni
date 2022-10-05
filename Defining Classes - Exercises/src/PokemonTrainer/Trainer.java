package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemon = new ArrayList<>();

    public Trainer(String name, List<Pokemon> pokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemon = pokemon;

    }

    public boolean hasElement(String element){
        return pokemon.stream().anyMatch(s -> s.getElement().equals(element));
    }

    public void applyCommand(String element){
        if (hasElement(element)){
            this.numberOfBadges++;
        }else {
            this.pokemon.forEach(Pokemon::looseHealth);
            this.pokemon.removeIf(Pokemon::isDead);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;


    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;

    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        //Peter 2 2
        //George 0 1
        //{TrainerName} {Badges} {NumberOfPokemon}
        return String.format("%s %d %d" , this.name , this.numberOfBadges , pokemon.size());
    }
}
