import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Map<String, Double>> shopsAndProductsMap = new TreeMap<>();


        while (!line.equals("Revision")) {
            String[] tokens = line.split(", ");
            //{shop}, {product}, {price}
            String shop = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);


            Map<String, Double> productAndPrice = new LinkedHashMap<>();
            productAndPrice.putIfAbsent(product, price);

            if (shopsAndProductsMap.containsKey(shop)) {
                shopsAndProductsMap.get(shop).putAll(productAndPrice);
            } else {
                shopsAndProductsMap.put(shop, productAndPrice);
            }


            line = scanner.nextLine();
        }

       for (var shop : shopsAndProductsMap.entrySet()){
           System.out.printf("%s->%n" , shop.getKey());
           for(var element : shop.getValue().entrySet() )
           System.out.printf("Product: %s, Price: %.1f%n" , element.getKey() , element.getValue());
       }
    }
}
