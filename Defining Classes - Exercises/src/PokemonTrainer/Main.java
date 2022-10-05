package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        while (!line.equals("Tournament")) {
            String[] pokemonParts = line.split("\\s+");

            String trainerName = pokemonParts[0];
            String pokemonName = pokemonParts[1];
            String pokemonElement = pokemonParts[2];
            int pokemonHealth = Integer.parseInt(pokemonParts[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            List<Pokemon> pokemonList = new ArrayList<>();
            pokemonList.add(pokemon);
            Trainer trainer = new Trainer(trainerName, pokemonList);

            if (trainerMap.containsKey(trainerName)) {
                trainerMap.get(trainerName).getPokemon().add(pokemon);

            } else {
                trainerMap.put(trainerName, trainer);
            }


            line = scanner.nextLine();
        }


        line = scanner.nextLine();
        while (!line.equals("End")) {
            String element = line;
            trainerMap.values().forEach(s -> s.applyCommand(element));

            line = scanner.nextLine();
        }

        trainerMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().getNumberOfBadges() - a.getValue().getNumberOfBadges())
                .forEach(entry -> {
                    System.out.println(entry.getValue().toString());
                });
    }
}
