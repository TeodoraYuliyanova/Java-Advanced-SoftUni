import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] line = scanner.nextLine().split("\\s+");
            String continent = line[0];
            String country = line[1];
            String city = line[2];

            continentsMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentsMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsMap.get(continent).get(country).add(city);
        }


        for (var entry : continentsMap.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (var country : entry.getValue().entrySet()) {
                String separatorForCities = String.join(", " , country.getValue());
                System.out.printf("%s -> %s%n" , country.getKey() , separatorForCities);
            }
        }
    }
}
